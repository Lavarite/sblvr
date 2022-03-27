package me.lavarite.pluginsb.Items.ItemStorage;

import me.lavarite.pluginsb.Items.PluginSB;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

public class AOTE {
    public static ItemStack ASPECT_OF_THE_END;
    public static void initAOTE() {
        iAOTE();
    }
    private static void iAOTE() {
        ItemStack END = new ItemStack(Material.DIAMOND_SWORD, 1);
        ItemMeta metaE = END.getItemMeta();
        metaE.setDisplayName("§9Aspect Of The End");
        List<String> lore = new ArrayList<>();
        lore.add("§7Damage: §c+100");
        lore.add("§7Strength: §c+100");
        lore.add("");
        lore.add("§6Ability: Instant Transmission §e§lRIGHT CLICK");
        lore.add("§7Teleport §a5 blocks §7ahead of");
        lore.add("§7you and gain §a+50 §f✦ Speed");
        lore.add("§7for §a5 seconds§7.");
        lore.add("");
        lore.add("§9§lRARE SWORD");
        metaE.setLore(lore);
        metaE.setUnbreakable(true);
        metaE.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        metaE.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        NamespacedKey Damage = new NamespacedKey(PluginSB.plugin, "Damage");
        NamespacedKey Strength = new NamespacedKey(PluginSB.plugin, "Strength");
        NamespacedKey Rarity = new NamespacedKey(PluginSB.plugin, "Rarity");
        metaE.getPersistentDataContainer().set(Damage, PersistentDataType.DOUBLE, 100.0);
        metaE.getPersistentDataContainer().set(Strength, PersistentDataType.DOUBLE, 100.0);
        metaE.getPersistentDataContainer().set(Rarity, PersistentDataType.INTEGER, 3);
        END.setItemMeta(metaE);
        ASPECT_OF_THE_END = END;
    }
}
