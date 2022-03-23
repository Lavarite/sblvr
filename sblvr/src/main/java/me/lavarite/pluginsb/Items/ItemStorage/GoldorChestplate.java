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

public class GoldorChestplate {
    public static ItemStack GOLDOR_CHEST;
    public static void initGC() {
        GC();
    }
    private static void GC() {
        ItemStack GC = new ItemStack(Material.LEATHER_CHESTPLATE,1);
        LeatherArmorMeta metaGC = (LeatherArmorMeta) GC.getItemMeta();
        assert metaGC != null;
        metaGC.setColor(Color.fromBGR(0,102,0));
        metaGC.setDisplayName("§6Goldor Chestplate");
        List<String> loreGC = new ArrayList<>();
        loreGC.add("§7Damage: §c+260");
        loreGC.add("§7Strength: §c+150");
        loreGC.add("§7Intelligence: §a+350");
        loreGC.add("§7Ferocity: §a+30");
        loreGC.add("");
        loreGC.add("§6§l§ks§7 §6§lLEGENDARY CHESTPLATE §6§l§ks");
        metaGC.setUnbreakable(true);
        metaGC.setLore(loreGC);
        GC.setItemMeta(metaGC);
        GOLDOR_CHEST = GC;

        ShapedRecipe gcc = new ShapedRecipe(new ItemStack(GoldorChestplate.GOLDOR_CHEST));
        gcc.shape("e e","eee","eee");
        gcc.setIngredient('e', new RecipeChoice.ExactChoice(strgDrag.GOLDOR_FRAG));
        Bukkit.getServer().addRecipe(gcc);
    }
}
