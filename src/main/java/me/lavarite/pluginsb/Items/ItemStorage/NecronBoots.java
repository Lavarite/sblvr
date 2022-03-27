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

public class NecronBoots {
    public static ItemStack NECRON_BOOTS;
    public static void initNB() {
        NB();
    }
    private static void NB() {
        ItemStack NB = new ItemStack(Material.LEATHER_BOOTS,1);
        LeatherArmorMeta metaNB = (LeatherArmorMeta) NB.getItemMeta();
        assert metaNB != null;
        metaNB.setColor(Color.fromBGR(0,128,255));
        metaNB.setDisplayName("§6Necron Boots");
        List<String> loreNB = new ArrayList<>();
        loreNB.add("§7Strength: §c+40");
        loreNB.add("§7Crit Damage: §c+30%");
        loreNB.add("§7Health: §a+145");
        loreNB.add("§7Defense: §a+185");
        loreNB.add("§7Intelligence: §a+10");
        loreNB.add("");
        loreNB.add("§6§l§ks§7 §6§lLEGENDARY BOOTS §6§l§ks");
        metaNB.setUnbreakable(true);
        metaNB.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        metaNB.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        metaNB.setLore(loreNB);
        NamespacedKey Strength = new NamespacedKey(PluginSB.plugin, "Strength");
        NamespacedKey Critdamage = new NamespacedKey(PluginSB.plugin, "Critdamage");
        NamespacedKey Health = new NamespacedKey(PluginSB.plugin, "Health");
        NamespacedKey Defence = new NamespacedKey(PluginSB.plugin, "Defence");
        NamespacedKey Intelligence = new NamespacedKey(PluginSB.plugin, "Intelligence");
        NamespacedKey Rarity = new NamespacedKey(PluginSB.plugin, "Rarity");
        metaNB.getPersistentDataContainer().set(Strength, PersistentDataType.DOUBLE, 30.0);
        metaNB.getPersistentDataContainer().set(Critdamage, PersistentDataType.DOUBLE, 0.1);
        metaNB.getPersistentDataContainer().set(Health, PersistentDataType.DOUBLE, 105.0);
        metaNB.getPersistentDataContainer().set(Defence, PersistentDataType.DOUBLE, 55.0);
        metaNB.getPersistentDataContainer().set(Intelligence, PersistentDataType.DOUBLE, 50.0);
        metaNB.getPersistentDataContainer().set(Rarity, PersistentDataType.INTEGER, 5);
        NB.setItemMeta(metaNB);
        NECRON_BOOTS = NB;

        ShapedRecipe nbc = new ShapedRecipe(new ItemStack(NecronBoots.NECRON_BOOTS));
        nbc.shape("   ","k k","k k");
        nbc.setIngredient('k', new RecipeChoice.ExactChoice(strgDrag.NECRON_FRAG));
        Bukkit.getServer().addRecipe(nbc);
    }
    public static int strength = 40;
    public static double critdamage = 0.3;
    public static int health = 145;
    public static int defense = 185;
    public static int intelligence = 10;
    public static int rarity = 5;
}
