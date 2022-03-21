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

public class NecronLeggings {
    public static ItemStack NECRON_LEGS;
    public static void initNL() {
        NL();
    }
    private static void NL() {
        ItemStack NL = new ItemStack(Material.LEATHER_LEGGINGS,1);
        LeatherArmorMeta metaNL = (LeatherArmorMeta) NL.getItemMeta();
        assert metaNL != null;
        metaNL.setColor(Color.fromBGR(0,102,204));
        metaNL.setDisplayName("§6Necron Leggings");
        List<String> loreNL = new ArrayList<>();
        loreNL.add("§7Strength: §c+40");
        loreNL.add("§7Crit Damage: §c+30%");
        loreNL.add("§7Health: §a+230");
        loreNL.add("§7Defense: §a+125");
        loreNL.add("§7Intelligence: §a+10");
        loreNL.add("");
        loreNL.add("§6§l§ks§7 §6§lLEGENDARY LEGGINGS §6§l§ks");
        metaNL.setUnbreakable(true);
        metaNL.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        metaNL.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        metaNL.setLore(loreNL);
        NL.setItemMeta(metaNL);
        NECRON_LEGS = NL;

        ShapedRecipe nlc = new ShapedRecipe(new ItemStack(NecronLeggings.NECRON_LEGS));
        nlc.shape("hhh","h h","h h");
        nlc.setIngredient('h', new RecipeChoice.ExactChoice(strgDrag.NECRON_FRAG));
        Bukkit.getServer().addRecipe(nlc);
    }
    public static int strength = 40;
    public static double critdamage = 0.3;
    public static int health = 230;
    public static int defense = 125;
    public static int intelligence = 10;
    public static int rarity = 5;
}
