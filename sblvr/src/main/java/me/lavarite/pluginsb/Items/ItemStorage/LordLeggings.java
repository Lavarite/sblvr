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

public class LordLeggings {
    public static ItemStack LORD_LEGS;
    public static void initLL() {
        LL();
    }
    private static void LL() {
        ItemStack LL = new ItemStack(Material.LEATHER_LEGGINGS,1);
        LeatherArmorMeta metaLL = (LeatherArmorMeta) LL.getItemMeta();
        assert metaLL != null;
        metaLL.setColor(Color.fromBGR(51,102,0));
        metaLL.setDisplayName("§6Necrolord Leggings");
        List<String> loreLL = new ArrayList<>();
        loreLL.add("§7Damage: §c+260");
        loreLL.add("§7Strength: §c+150");
        loreLL.add("§7Intelligence: §a+350");
        loreLL.add("§7Ferocity: §a+30");
        loreLL.add("");
        loreLL.add("§6§l§ks§7 §6§lLEGENDARY LEGGINGS §6§l§ks");
        metaLL.setUnbreakable(true);
        metaLL.setLore(loreLL);
        LL.setItemMeta(metaLL);
        LORD_LEGS = LL;

        ShapedRecipe llc = new ShapedRecipe(new ItemStack(LordLeggings.LORD_LEGS));
        llc.shape("uuu","u u","u u");
        llc.setIngredient('u', new RecipeChoice.ExactChoice(strgDrag.LORD_FRAG));
        Bukkit.getServer().addRecipe(llc);
    }
}
