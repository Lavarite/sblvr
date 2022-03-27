package me.lavarite.pluginsb.Items.ItemStorage;

import me.lavarite.pluginsb.Items.PluginSB;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

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
        metaHP.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        metaHP.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        NamespacedKey Damage = new NamespacedKey(PluginSB.plugin, "Damage");
        NamespacedKey Strength = new NamespacedKey(PluginSB.plugin, "Strength");
        NamespacedKey Intelligence = new NamespacedKey(PluginSB.plugin, "Intelligence");
        NamespacedKey Rarity = new NamespacedKey(PluginSB.plugin, "Rarity");
        metaHP.getPersistentDataContainer().set(Damage, PersistentDataType.DOUBLE, 260.0);
        metaHP.getPersistentDataContainer().set(Strength, PersistentDataType.DOUBLE, 150.0);
        metaHP.getPersistentDataContainer().set(Intelligence, PersistentDataType.DOUBLE, 350.0);
        metaHP.getPersistentDataContainer().set(Rarity, PersistentDataType.INTEGER, 5);
        HP.setItemMeta(metaHP);
        HYPERION = HP;

        ShapedRecipe h = new ShapedRecipe(new ItemStack(HYPERION));
        h.shape(" m "," k "," ] ");
        h.setIngredient(']', new RecipeChoice.ExactChoice(AOTE.ASPECT_OF_THE_END));
        h.setIngredient('k', new RecipeChoice.ExactChoice(AOTV.ASPECT_OF_THE_VOID));
        h.setIngredient('m', new RecipeChoice.ExactChoice(AOTM.MODIFIED_ASPECT_OF_THE_VOID));
        Bukkit.getServer().addRecipe(h);
    }
}
