package me.lavarite.pluginsb.Items.ItemStorage;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
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
        loreSL.add("§7Damage: §c+260");
        loreSL.add("§7Strength: §c+150");
        loreSL.add("§7Intelligence: §a+350");
        loreSL.add("§7Ferocity: §a+30");
        loreSL.add("");
        loreSL.add("§6§l§ks§7 §6§lLEGENDARY LEGGINGS §6§l§ks");
        metaSL.setUnbreakable(true);
        metaSL.setLore(loreSL);
        SL.setItemMeta(metaSL);
        STORM_LEGS = SL;

        ShapedRecipe slc = new ShapedRecipe(new ItemStack(StormLeggings.STORM_LEGS));
        slc.shape("yyy","y y","y y");
        slc.setIngredient('y', new RecipeChoice.ExactChoice(strgDrag.STORM_FRAG));
        Bukkit.getServer().addRecipe(slc);
    }
}
