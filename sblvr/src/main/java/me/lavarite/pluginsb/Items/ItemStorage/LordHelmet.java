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

public class LordHelmet {
    public static ItemStack LORD_HELM;
    public static void initLH() {
        LH();
    }
    private static void LH() {
        ItemStack LH = new ItemStack(Material.LEATHER_HELMET,1);
        LeatherArmorMeta metaLH = (LeatherArmorMeta) LH.getItemMeta();
        assert metaLH != null;
        metaLH.setColor(Color.fromBGR(102,51,0));
        metaLH.setDisplayName("§6Necrolord Helmet");
        List<String> loreLH = new ArrayList<>();
        loreLH.add("§7Damage: §c+260");
        loreLH.add("§7Strength: §c+150");
        loreLH.add("§7Intelligence: §a+350");
        loreLH.add("§7Ferocity: §a+30");
        loreLH.add("");
        loreLH.add("§6§l§ks§7 §6§lLEGENDARY HELMET §6§l§ks");
        metaLH.setUnbreakable(true);
        metaLH.setLore(loreLH);
        LH.setItemMeta(metaLH);
        LORD_HELM = LH;

        ShapedRecipe lhc = new ShapedRecipe(new ItemStack(LordHelmet.LORD_HELM));
        lhc.shape("sss","s s","   ");
        lhc.setIngredient('s', new RecipeChoice.ExactChoice(strgDrag.LORD_FRAG));
        Bukkit.getServer().addRecipe(lhc);
    }
}
