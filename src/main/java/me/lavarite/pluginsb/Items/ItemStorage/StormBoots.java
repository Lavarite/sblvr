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

public class StormBoots {
    public static ItemStack STORM_BOOTS;
    public static void initSB() {
        SB();
    }
    private static void SB() {
        ItemStack SB = new ItemStack(Material.LEATHER_BOOTS,1);
        LeatherArmorMeta metaSB = (LeatherArmorMeta) SB.getItemMeta();
        assert metaSB != null;
        metaSB.setColor(Color.fromBGR(255,128,0));
        metaSB.setDisplayName("§6Storm Boots");
        List<String> loreSB = new ArrayList<>();
        loreSB.add("§7Damage: §c+260");
        loreSB.add("§7Strength: §c+150");
        loreSB.add("§7Intelligence: §a+350");
        loreSB.add("§7Ferocity: §a+30");
        loreSB.add("");
        loreSB.add("§6§l§ks§7 §6§lLEGENDARY BOOTS §6§l§ks");
        metaSB.setUnbreakable(true);
        metaSB.setLore(loreSB);
        SB.setItemMeta(metaSB);
        STORM_BOOTS = SB;

        ShapedRecipe sbc = new ShapedRecipe(new ItemStack(StormBoots.STORM_BOOTS));
        sbc.shape("   ","i i","i i");
        sbc.setIngredient('i', new RecipeChoice.ExactChoice(strgDrag.STORM_FRAG));
        Bukkit.getServer().addRecipe(sbc);
    }
}
