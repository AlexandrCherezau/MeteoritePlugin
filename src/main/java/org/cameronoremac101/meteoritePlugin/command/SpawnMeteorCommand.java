package org.cameronoremac101.meteoritePlugin.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.cameronoremac101.meteoritePlugin.MeteoritePlugin;
import org.cameronoremac101.meteoritePlugin.item.StaffItem;
import org.cameronoremac101.meteoritePlugin.service.MeteorService;
import org.jetbrains.annotations.NotNull;

public class SpawnMeteorCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String @NotNull [] strings) {

        Player player = (Player) commandSender;

        player.getInventory().addItem(MeteoritePlugin.getStaffItem().CreateStaffItem());

        return false;
    }
}
