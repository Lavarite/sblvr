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

public class LordBoots {
    public static ItemStack LORD_BOOTS;
    public static void initLB() {
        LB();
    }
    private static void LB() {
        ItemStack LB = new ItemStack(Material.LEATHER_BOOTS,1);
        LeatherArmorMeta metaLB = (LeatherArmorMeta) LB.getItemMeta();
        assert metaLB != null;
        metaLB.setColor(Color.fromBGR(0,102,0));
        metaLB.setDisplayName("§6Necrolord Boots");
        List<String> loreLB = new ArrayList<>();
        loreLB.add("§7Strength: §c+30");
        loreLB.add("§7Crit Damage: §c+10");
        loreLB.add("§7Health: §a+105");
        loreLB.add("§7Defence: §a+75");
        loreLB.add("§7Intelligence: §a+50");
        loreLB.add("");
        loreLB.add("§6§l§ks§7 §6§lLEGENDARY BOOTS §6§l§ks");
        metaLB.setUnbreakable(true);
        metaLB.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        metaLB.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        metaLB.setLore(loreLB);
        LB.setItemMeta(metaLB);
        LORD_BOOTS = LB;

        ShapedRecipe lbc = new ShapedRecipe(new ItemStack(LordBoots.LORD_BOOTS));
        lbc.shape("   ","o o","o o");
        lbc.setIngredient('o', new RecipeChoice.ExactChoice(strgDrag.LORD_FRAG));
        Bukkit.getServer().addRecipe(lbc);
    }
    public static int strength = 30;
    public static double critdamage = 0.1;
    public static int health = 105;
    public static int defense = 75;
    public static int intelligence = 50;
    public static int rarity = 5;
}
