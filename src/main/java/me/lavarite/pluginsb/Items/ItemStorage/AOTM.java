package me.lavarite.pluginsb.Items.ItemStorage;

import me.lavarite.pluginsb.Items.PluginSB;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;

public class AOTM {
    public static ItemStack MODIFIED_ASPECT_OF_THE_VOID;
    public static void initAOTM() {
        iAOTM();
    }
    private static void iAOTM() {
        ItemStack MVOID = new ItemStack(Material.DIAMOND_SHOVEL, 1);
        ItemMeta metaM = MVOID.getItemMeta();
        metaM.setDisplayName("§5Aspect Of The Void");
        List<String> lore = new ArrayList<>();
        lore.add("§7Damage: §c+120");
        lore.add("§7Strength: §c+100");
        lore.add("");
        lore.add("§6Ability: Instant Transmission §e§lRIGHT CLICK");
        lore.add("§7Teleport §a10 blocks §7ahead of");
        lore.add("§7you and gain §a+50 §f✦ Speed");
        lore.add("§7for §a5 seconds§7.");
        lore.add("");
        lore.add("§6Ability: Ether Transmission §e§lSHIFT RIGHT CLICK");
        lore.add("§7Teleport to your targeted block");
        lore.add("§7up to §a60 blocks §7away.");
        lore.add("");
        lore.add("§5§lEPIC SWORD");
        metaM.setLore(lore);
        metaM.setUnbreakable(true);
        metaM.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        metaM.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        NamespacedKey Damage = new NamespacedKey(PluginSB.plugin, "Damage");
        NamespacedKey Strength = new NamespacedKey(PluginSB.plugin, "Strength");
        NamespacedKey Rarity = new NamespacedKey(PluginSB.plugin, "Rarity");
        NamespacedKey ManaCost = new NamespacedKey(PluginSB.plugin, "ManaCost");
        metaM.getPersistentDataContainer().set(Damage, PersistentDataType.DOUBLE, 120.0);
        metaM.getPersistentDataContainer().set(Strength, PersistentDataType.DOUBLE, 100.0);
        metaM.getPersistentDataContainer().set(Rarity, PersistentDataType.INTEGER, 4);
        metaM.getPersistentDataContainer().set(ManaCost, PersistentDataType.DOUBLE, 45.0);
        MVOID.setItemMeta(metaM);
        MODIFIED_ASPECT_OF_THE_VOID = MVOID;
    }
}
