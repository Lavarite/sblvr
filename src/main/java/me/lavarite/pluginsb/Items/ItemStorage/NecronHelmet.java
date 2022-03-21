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

public class NecronHelmet {
    public static ItemStack NECRON_HELM;
    public static void initNH() {
        NH();
    }
    private static void NH() {
        ItemStack NH = new ItemStack(Material.LEATHER_HELMET,1);
        LeatherArmorMeta metaNH = (LeatherArmorMeta) NH.getItemMeta();
        assert metaNH != null;
        metaNH.setColor(Color.fromBGR(0,0,102));
        metaNH.setDisplayName("§6Necron Helmet");
        List<String> loreNH = new ArrayList<>();
        loreNH.add("§7Strength: §c+40");
        loreNH.add("§7Crit Damage: §c+30%");
        loreNH.add("§7Health: §a+180");
        loreNH.add("§7Defense: §a+100");
        loreNH.add("§7Intelligence: §a+30");
        loreNH.add("");
        loreNH.add("§6§l§ks§7 §6§lLEGENDARY HELMET §6§l§ks");
        metaNH.setUnbreakable(true);
        metaNH.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        metaNH.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        metaNH.setLore(loreNH);
        NH.setItemMeta(metaNH);
        NECRON_HELM = NH;

        ShapedRecipe nhc = new ShapedRecipe(new ItemStack(NecronHelmet.NECRON_HELM));
        nhc.shape("www","w w","   ");
        nhc.setIngredient('w', new RecipeChoice.ExactChoice(strgDrag.NECRON_FRAG));
        Bukkit.getServer().addRecipe(nhc);
    }
    public static int strength = 40;
    public static double critdamage = 0.3;
    public static int health = 180;
    public static int defense = 100;
    public static int intelligence = 30;
    public static int rarity = 5;
}
