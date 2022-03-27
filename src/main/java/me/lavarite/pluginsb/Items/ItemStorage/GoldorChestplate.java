package me.lavarite.pluginsb.Items.ItemStorage;

import me.lavarite.pluginsb.Items.PluginSB;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.persistence.PersistentDataType;

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
        loreGC.add("§7Health: §a+310");
        loreGC.add("§7Defence: §a+275");
        loreGC.add("§7Intelligence: §a+20");
        loreGC.add("");
        loreGC.add("§6§l§ks§7 §6§lLEGENDARY CHESTPLATE §6§l§ks");
        metaGC.setUnbreakable(true);
        metaGC.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        metaGC.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        metaGC.setLore(loreGC);
        NamespacedKey Health = new NamespacedKey(PluginSB.plugin, "Health");
        NamespacedKey Defence = new NamespacedKey(PluginSB.plugin, "Defence");
        NamespacedKey Intelligence = new NamespacedKey(PluginSB.plugin, "Intelligence");
        NamespacedKey Rarity = new NamespacedKey(PluginSB.plugin, "Intelligence");
        metaGC.getPersistentDataContainer().set(Health, PersistentDataType.DOUBLE, 310.0);
        metaGC.getPersistentDataContainer().set(Defence, PersistentDataType.DOUBLE, 275.0);
        metaGC.getPersistentDataContainer().set(Intelligence, PersistentDataType.DOUBLE, 20.0);
        metaGC.getPersistentDataContainer().set(Rarity, PersistentDataType.INTEGER, 5);
        GC.setItemMeta(metaGC);
        GOLDOR_CHEST = GC;

        ShapedRecipe gcc = new ShapedRecipe(new ItemStack(GoldorChestplate.GOLDOR_CHEST));
        gcc.shape("e e","eee","eee");
        gcc.setIngredient('e', new RecipeChoice.ExactChoice(strgDrag.GOLDOR_FRAG));
        Bukkit.getServer().addRecipe(gcc);
    }
}
