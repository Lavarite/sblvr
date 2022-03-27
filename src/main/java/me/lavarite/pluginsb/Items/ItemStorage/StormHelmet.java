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

public class StormHelmet {
    public static ItemStack STORM_HELM;
    public static void initSH() {
        SH();
    }
    private static void SH() {
        ItemStack SH = new ItemStack(Material.LEATHER_HELMET,1);
        LeatherArmorMeta metaSH = (LeatherArmorMeta) SH.getItemMeta();
        assert metaSH != null;
        metaSH.setColor(Color.fromBGR(255,128,0));
        metaSH.setDisplayName("§6Storm Helmet");
        List<String> loreSH = new ArrayList<>();
        loreSH.add("§7Health: §a+180");
        loreSH.add("§7Defense: §a+80");
        loreSH.add("§7Intelligence: §a+250");
        loreSH.add("");
        loreSH.add("§6§l§ks§7 §6§lLEGENDARY HELMET §6§l§ks");
        metaSH.setUnbreakable(true);
        metaSH.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        metaSH.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        metaSH.setLore(loreSH);
        NamespacedKey Health = new NamespacedKey(PluginSB.plugin, "Health");
        NamespacedKey Defence = new NamespacedKey(PluginSB.plugin, "Defence");
        NamespacedKey Intelligence = new NamespacedKey(PluginSB.plugin, "Intelligence");
        NamespacedKey Rarity = new NamespacedKey(PluginSB.plugin, "Rarity");
        metaSH.getPersistentDataContainer().set(Health, PersistentDataType.DOUBLE, 180.0);
        metaSH.getPersistentDataContainer().set(Defence, PersistentDataType.DOUBLE, 80.0);
        metaSH.getPersistentDataContainer().set(Intelligence, PersistentDataType.DOUBLE, 300.0);
        metaSH.getPersistentDataContainer().set(Rarity, PersistentDataType.INTEGER, 5);
        SH.setItemMeta(metaSH);
        STORM_HELM = SH;

        ShapedRecipe shc = new ShapedRecipe(new ItemStack(StormHelmet.STORM_HELM));
        shc.shape("aaa","a a","   ");
        shc.setIngredient('a', new RecipeChoice.ExactChoice(strgDrag.STORM_FRAG));
        Bukkit.getServer().addRecipe(shc);
    }
}
