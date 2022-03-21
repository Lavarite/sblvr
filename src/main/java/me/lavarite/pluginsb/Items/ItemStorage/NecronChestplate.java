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

public class NecronChestplate {
    public static ItemStack NECRON_CHEST;
    public static void initNC() {
        NC();
    }
    private static void NC() {
        ItemStack NC = new ItemStack(Material.LEATHER_CHESTPLATE,1);
        LeatherArmorMeta metaNC = (LeatherArmorMeta) NC.getItemMeta();
        assert metaNC != null;
        metaNC.setColor(Color.fromBGR(0,0,204));
        metaNC.setDisplayName("§6Necron Chestplate");
        List<String> loreNC = new ArrayList<>();
        loreNC.add("§7Strength: §c+150");
        loreNC.add("§7Crit Damage: §c+30%");
        loreNC.add("§7Health: §a+260");
        loreNC.add("§7Defense: §a+140");
        loreNC.add("§7Intelligence: §a+10");
        loreNC.add("");
        loreNC.add("§6§l§ks§7 §6§lLEGENDARY CHESTPLATE §6§l§ks");
        metaNC.setUnbreakable(true);
        metaNC.setLore(loreNC);
        metaNC.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        metaNC.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        NC.setItemMeta(metaNC);
        NECRON_CHEST = NC;

        ShapedRecipe ncc = new ShapedRecipe(new ItemStack(NecronChestplate.NECRON_CHEST));
        ncc.shape("r r","rrr","rrr");
        ncc.setIngredient('r', new RecipeChoice.ExactChoice(strgDrag.NECRON_FRAG));
        Bukkit.getServer().addRecipe(ncc);
    }
    public static int strength = 40;
    public static double critdamage = 0.3;
    public static int health = 260;
    public static int defense = 140;
    public static int intelligence = 10;
    public static int rarity = 5;
}
