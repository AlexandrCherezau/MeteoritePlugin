package org.cameronoremac101.meteoritePlugin.listener;

import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.util.Vector;
import org.cameronoremac101.meteoritePlugin.MeteoritePlugin;
import org.cameronoremac101.meteoritePlugin.service.MeteorService;

public class PlayerListener implements Listener {

    NamespacedKey key = new NamespacedKey(MeteoritePlugin.getInstance(), "id");

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event){
        Player player = event.getPlayer();

        ItemStack mainHand = player.getInventory().getItemInMainHand();
        ItemMeta mainMeta = mainHand.getItemMeta();

        if(mainHand == null) return;

        PersistentDataContainer persistentDataContainer = mainMeta.getPersistentDataContainer();

        if (!persistentDataContainer.has(key, PersistentDataType.STRING)) return;

        MeteorService.getInstance().createMeteor(player);

    }
}
