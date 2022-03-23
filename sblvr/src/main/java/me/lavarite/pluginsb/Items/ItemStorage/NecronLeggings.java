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
        loreNL.add("§7Damage: §c+260");
        loreNL.add("§7Strength: §c+150");
        loreNL.add("§7Intelligence: §a+350");
        loreNL.add("§7Ferocity: §a+30");
        loreNL.add("");
        loreNL.add("§6§l§ks§7 §6§lLEGENDARY LEGGINGS §6§l§ks");
        metaNL.setUnbreakable(true);
        metaNL.setLore(loreNL);
        NL.setItemMeta(metaNL);
        NECRON_LEGS = NL;

        ShapedRecipe nlc = new ShapedRecipe(new ItemStack(NecronLeggings.NECRON_LEGS));
        nlc.shape("hhh","h h","h h");
        nlc.setIngredient('h', new RecipeChoice.ExactChoice(strgDrag.NECRON_FRAG));
        Bukkit.getServer().addRecipe(nlc);
    }
}
