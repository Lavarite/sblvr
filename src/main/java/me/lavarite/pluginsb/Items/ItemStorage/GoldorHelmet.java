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

public class GoldorHelmet {
    public static ItemStack GOLDOR_HELM;
    public static void initGH() {
        GH();
    }
    private static void GH() {
        ItemStack GH = new ItemStack(Material.LEATHER_HELMET,1);
        LeatherArmorMeta metaGH = (LeatherArmorMeta) GH.getItemMeta();
        assert metaGH != null;
        metaGH.setColor(Color.fromBGR(0,102,0));
        metaGH.setDisplayName("§6Goldor Helmet");
        List<String> loreGH = new ArrayList<>();
        loreGH.add("§7Damage: §c+260");
        loreGH.add("§7Strength: §c+150");
        loreGH.add("§7Intelligence: §a+350");
        loreGH.add("§7Ferocity: §a+30");
        loreGH.add("");
        loreGH.add("§6§l§ks§7 §6§lLEGENDARY HELMET §6§l§ks");
        metaGH.setUnbreakable(true);
        metaGH.setLore(loreGH);
        GH.setItemMeta(metaGH);
        GOLDOR_HELM = GH;

        ShapedRecipe ghc = new ShapedRecipe(new ItemStack(GoldorHelmet.GOLDOR_HELM));
        ghc.shape("qqq","q q","   ");
        ghc.setIngredient('q', new RecipeChoice.ExactChoice(strgDrag.GOLDOR_FRAG));
        Bukkit.getServer().addRecipe(ghc);
    }
}
