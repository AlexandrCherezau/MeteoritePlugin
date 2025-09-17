package org.cameronoremac101.meteoritePlugin.service;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.*;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Transformation;
import org.bukkit.util.Vector;
import org.cameronoremac101.meteoritePlugin.MeteoritePlugin;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.TNTPrimed;

public class MeteorService {

    private static MeteorService instance;

    private MeteorService(){}

    public static MeteorService getInstance(){
        if (instance == null) instance = new MeteorService();

        return instance;
    }

    public void createMeteor(Player player) {
        Block targetBlock = player.getTargetBlockExact(100);
        if (targetBlock == null) return;

        Location spawnLoc = targetBlock.getLocation().clone().add(0, 30, 0);

        BlockData blockData = Bukkit.createBlockData(Material.MAGMA_BLOCK);
        BlockDisplay display = spawnLoc.getWorld().spawn(spawnLoc, BlockDisplay.class);
        display.setBlock(blockData);

        Transformation transform = display.getTransformation();
        transform.getScale().set(3.5f, 3.5f, 3.5f);
        display.setTransformation(transform);

        new BukkitRunnable() {
            double speed = 1; // скорость падения

            @Override
            public void run() {
                Location current = display.getLocation();
                current.subtract(0, speed, 0); // опускаем метеорит
                display.teleport(current);

                if (current.getBlock().getType().isSolid() || current.getY() <= targetBlock.getY()) {
                    World world = player.getWorld();
                    TNTPrimed tnt = world.spawn(display.getLocation(), TNTPrimed.class);
                    tnt.setFuseTicks(0);
                    tnt.setYield(4.0f);
                    tnt.setIsIncendiary(true);

                    display.remove();
                    this.cancel();
                }
            }
        }.runTaskTimer(MeteoritePlugin.getInstance(), 0L, 1L);
    }



}
