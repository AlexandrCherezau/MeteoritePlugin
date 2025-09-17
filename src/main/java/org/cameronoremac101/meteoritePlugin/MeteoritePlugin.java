package org.cameronoremac101.meteoritePlugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.cameronoremac101.meteoritePlugin.command.SpawnMeteorCommand;
import org.cameronoremac101.meteoritePlugin.item.StaffItem;
import org.cameronoremac101.meteoritePlugin.listener.PlayerListener;

public final class MeteoritePlugin extends JavaPlugin {

    private static MeteoritePlugin instance;
    private static StaffItem staffItem;
    @Override
    public void onEnable() {
        instance = this;
        staffItem = new StaffItem();
        Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);
        getCommand("createmeteor").setExecutor(new SpawnMeteorCommand());
    }

    @Override
    public void onDisable() {
    }

    public static MeteoritePlugin getInstance(){
        return instance;
    }

    public static StaffItem getStaffItem(){
        return staffItem;
    }

}
