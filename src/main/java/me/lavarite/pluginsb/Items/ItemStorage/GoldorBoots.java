package me.lavarite.pluginsb.Items.ItemStorage;

import me.lavarite.pluginsb.Items.PluginSB;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;

public class GoldorBoots {
    public static ItemStack GOLDOR_BOOTS;
    public static void initGB() {
        GB();
    }
    private static void GB() {
        ItemStack GB = new ItemStack(Material.LEATHER_BOOTS,1);
        LeatherArmorMeta metaGB = (LeatherArmorMeta) GB.getItemMeta();
        assert metaGB != null;
        metaGB.setColor(Color.fromBGR(0,102,0));
        metaGB.setDisplayName("§6Goldor Boots");
        List<String> loreGB = new ArrayList<>();
        loreGB.add("§7Health: §a+190");
        loreGB.add("§7Defense: §a+165");
        loreGB.add("§7Intelligence: §a+20");
        loreGB.add("");
        loreGB.add("§6§l§ks§7 §6§lLEGENDARY BOOTS §6§l§ks");
        metaGB.setUnbreakable(true);
        metaGB.setLore(loreGB);
        metaGB.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        metaGB.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        NamespacedKey Health = new NamespacedKey(PluginSB.plugin, "Health");
        NamespacedKey Defence = new NamespacedKey(PluginSB.plugin, "Defence");
        NamespacedKey Intelligence = new NamespacedKey(PluginSB.plugin, "Intelligence");
        NamespacedKey Rarity = new NamespacedKey(PluginSB.plugin, "Intelligence");
        metaGB.getPersistentDataContainer().set(Health, PersistentDataType.DOUBLE, 190.0);
        metaGB.getPersistentDataContainer().set(Defence, PersistentDataType.DOUBLE, 175.0);
        metaGB.getPersistentDataContainer().set(Intelligence, PersistentDataType.DOUBLE, 20.0);
        metaGB.getPersistentDataContainer().set(Rarity, PersistentDataType.INTEGER, 5);
        GB.setItemMeta(metaGB);
        GOLDOR_BOOTS = GB;

        ShapedRecipe gbc = new ShapedRecipe(new ItemStack(GoldorBoots.GOLDOR_BOOTS));
        gbc.shape("   ","j j","j j");
        gbc.setIngredient('j', new RecipeChoice.ExactChoice(strgDrag.GOLDOR_FRAG));
        Bukkit.getServer().addRecipe(gbc);
    }
}
