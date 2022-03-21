package me.lavarite.pluginsb.Items.ItemStorage;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.LeatherArmorMeta;

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
        GB.setItemMeta(metaGB);
        GOLDOR_BOOTS = GB;

        ShapedRecipe gbc = new ShapedRecipe(new ItemStack(GoldorBoots.GOLDOR_BOOTS));
        gbc.shape("   ","j j","j j");
        gbc.setIngredient('j', new RecipeChoice.ExactChoice(strgDrag.GOLDOR_FRAG));
        Bukkit.getServer().addRecipe(gbc);
    }
    public static int health = 190;
    public static int defense = 175;
    public static int intelligence = 20;
    public static int rarity = 5;
}
