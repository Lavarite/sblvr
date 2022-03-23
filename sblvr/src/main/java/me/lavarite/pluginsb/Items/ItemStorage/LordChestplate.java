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

public class LordChestplate {
    public static ItemStack LORD_CHEST;
    public static void initLC() {
        LC();
    }
    private static void LC() {
        ItemStack LC = new ItemStack(Material.LEATHER_CHESTPLATE,1);
        LeatherArmorMeta metaLC = (LeatherArmorMeta) LC.getItemMeta();
        assert metaLC != null;
        metaLC.setColor(Color.fromBGR(102,102,0));
        metaLC.setDisplayName("§6Necrolord Chestplate");
        List<String> loreLC = new ArrayList<>();
        loreLC.add("§7Damage: §c+260");
        loreLC.add("§7Strength: §c+150");
        loreLC.add("§7Intelligence: §a+350");
        loreLC.add("§7Ferocity: §a+30");
        loreLC.add("");
        loreLC.add("§6§l§ks§7 §6§lLEGENDARY CHESTPLATE §6§l§ks");
        metaLC.setUnbreakable(true);
        metaLC.setLore(loreLC);
        LC.setItemMeta(metaLC);
        LORD_CHEST = LC;

        ShapedRecipe lcc = new ShapedRecipe(new ItemStack(LordChestplate.LORD_CHEST));
        lcc.shape("t t","ttt","ttt");
        lcc.setIngredient('t', new RecipeChoice.ExactChoice(strgDrag.LORD_FRAG));
        Bukkit.getServer().addRecipe(lcc);
    }
}
