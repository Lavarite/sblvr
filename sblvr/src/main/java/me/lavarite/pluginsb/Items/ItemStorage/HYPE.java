package me.lavarite.pluginsb.Items.ItemStorage;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;


public class HYPE {
    public static ItemStack HYPERION;
    public static void init() {
        iHYPE();
    }

    private static void iHYPE() {
        ItemStack HP = new ItemStack(Material.IRON_SWORD, 1);
        ItemMeta metaHP = HP.getItemMeta();
        metaHP.setDisplayName("§6Hyperion");
        List<String> lore = new ArrayList<>();
        lore.add("§7Damage: §c+260");
        lore.add("§7Strength: §c+150");
        lore.add("§7Intelligence: §a+350");
        lore.add("§7Ferocity: §a+30");
        lore.add("");
        lore.add("§6Item Ability: Wither Impact §e§lRIGHT CLICK");
        lore.add("§7Teleport §a10 blocks §7ahead of");
        lore.add("§7you. Then implode dealing");
        lore.add("§7enormous damage to nearby");
        lore.add("§7enemies. Also applies the wither");
        lore.add("§7shield scroll ability reducing");
        lore.add("§7damage taken and granting an");
        lore.add("§7absorption shield for §e5");
        lore.add("§7seconds.");
        lore.add("");
        lore.add("§6§l§ks§7 §6§lLEGENDARY SWORD §6§l§ks");
        metaHP.setLore(lore);
        metaHP.setUnbreakable(true);
        HP.setItemMeta(metaHP);
        HYPERION = HP;

        ShapedRecipe hyper = new ShapedRecipe(new ItemStack(HYPERION));
        hyper.shape(" e "," v "," m ");
        hyper.setIngredient('e', new RecipeChoice.ExactChoice(AOTE.ASPECT_OF_THE_END));
        hyper.setIngredient('v', new RecipeChoice.ExactChoice(AOTV.ASPECT_OF_THE_VOID));
        hyper.setIngredient('m', new RecipeChoice.ExactChoice(AOTM.MODIFIED_ASPECT_OF_THE_VOID));
        Bukkit.getServer().addRecipe(hyper);
    }
}
