package org.cameronoremac101.meteoritePlugin.item;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.cameronoremac101.meteoritePlugin.MeteoritePlugin;

import java.util.Map;

public class StaffItem {

    public ItemStack CreateStaffItem() {
        ItemStack itemStack = new ItemStack(Material.STICK);
        ItemMeta meta = itemStack.getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "ПАЛКА-КАПАЛКА"));
        applyPersitingData(meta, itemStack);
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    public void applyPersitingData(ItemMeta meta, ItemStack itemStack) {
        NamespacedKey key = new NamespacedKey(MeteoritePlugin.getInstance(), "id");
        meta.getPersistentDataContainer().set(key, PersistentDataType.STRING, "id");
        itemStack.setItemMeta(meta);
    }
}
