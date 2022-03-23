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

public class StormChestplate {
    public static ItemStack STORM_CHEST;
    public static void initSC() {
        SC();
    }
    private static void SC() {
        ItemStack SC = new ItemStack(Material.LEATHER_CHESTPLATE,1);
        LeatherArmorMeta metaSC = (LeatherArmorMeta) SC.getItemMeta();
        assert metaSC != null;
        metaSC.setColor(Color.fromBGR(255,128,0));
        metaSC.setDisplayName("§6Storm Chestplate");
        List<String> loreSC = new ArrayList<>();
        loreSC.add("§7Damage: §c+260");
        loreSC.add("§7Strength: §c+150");
        loreSC.add("§7Intelligence: §a+350");
        loreSC.add("§7Ferocity: §a+30");
        loreSC.add("");
        loreSC.add("§6§l§ks§7 §6§lLEGENDARY CHESTPLATE §6§l§ks");
        metaSC.setUnbreakable(true);
        metaSC.setLore(loreSC);
        SC.setItemMeta(metaSC);
        STORM_CHEST = SC;

        ShapedRecipe scc = new ShapedRecipe(new ItemStack(StormChestplate.STORM_CHEST));
        scc.shape("d d","ddd","ddd");
        scc.setIngredient('d', new RecipeChoice.ExactChoice(strgDrag.STORM_FRAG));
        Bukkit.getServer().addRecipe(scc);
    }
}
