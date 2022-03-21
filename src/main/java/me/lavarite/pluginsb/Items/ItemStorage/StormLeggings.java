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

public class StormLeggings {
    public static ItemStack STORM_LEGS;
    public static void initSL() {
        SL();
    }
    private static void SL() {
        ItemStack SL = new ItemStack(Material.LEATHER_LEGGINGS,1);
        LeatherArmorMeta metaSL = (LeatherArmorMeta) SL.getItemMeta();
        assert metaSL != null;
        metaSL.setColor(Color.fromBGR(255,128,0));
        metaSL.setDisplayName("§6Storm Leggings");
        List<String> loreSL = new ArrayList<>();
        loreSL.add("§7Health: §a+230");
        loreSL.add("§7Defense: §a+105");
        loreSL.add("§7Intelligence: §a+250");
        loreSL.add("");
        loreSL.add("§6§l§ks§7 §6§lLEGENDARY LEGGINGS §6§l§ks");
        metaSL.setUnbreakable(true);
        metaSL.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        metaSL.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        metaSL.setLore(loreSL);
        SL.setItemMeta(metaSL);
        STORM_LEGS = SL;

        ShapedRecipe slc = new ShapedRecipe(new ItemStack(StormLeggings.STORM_LEGS));
        slc.shape("yyy","y y","y y");
        slc.setIngredient('y', new RecipeChoice.ExactChoice(strgDrag.STORM_FRAG));
        Bukkit.getServer().addRecipe(slc);
    }
    public static int health = 230;
    public static int defense = 105;
    public static int intelligence = 250;
    public static int rarity = 5;
}
