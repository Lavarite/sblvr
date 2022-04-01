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
import org.checkerframework.checker.units.qual.C;

import java.util.ArrayList;
import java.util.List;

public class LordBoots {
    public static ItemStack LORD_BOOTS;
    public static void initLB() {
        LB();
    }
    private static void LB() {
        ItemStack LB = new ItemStack(Material.LEATHER_BOOTS,1);
        LeatherArmorMeta metaLB = (LeatherArmorMeta) LB.getItemMeta();
        assert metaLB != null;
        metaLB.setColor(Color.fromBGR(0,102,0));
        metaLB.setDisplayName("§6Necrolord Boots");
        List<String> loreLB = new ArrayList<>();
        loreLB.add("§7Strength: §c+30");
        loreLB.add("§7Crit Damage: §c+20%");
        loreLB.add("§7Health: §a+95");
        loreLB.add("§7Defence: §a+90");
        loreLB.add("§7Intelligence: §a+50");
        loreLB.add("");
        loreLB.add("§6§l§ks§7 §6§lLEGENDARY BOOTS §6§l§ks");
        metaLB.setUnbreakable(true);
        metaLB.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        metaLB.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        metaLB.setLore(loreLB);
        NamespacedKey Strength = new NamespacedKey(PluginSB.plugin, "Strength");
        NamespacedKey Critdamage = new NamespacedKey(PluginSB.plugin, "Critdamage");
        NamespacedKey Health = new NamespacedKey(PluginSB.plugin, "Health");
        NamespacedKey Defence = new NamespacedKey(PluginSB.plugin, "Defence");
        NamespacedKey Intelligence = new NamespacedKey(PluginSB.plugin, "Intelligence");
        NamespacedKey Rarity = new NamespacedKey(PluginSB.plugin, "Rarity");
        metaLB.getPersistentDataContainer().set(Strength, PersistentDataType.DOUBLE, 30.0);
        metaLB.getPersistentDataContainer().set(Critdamage, PersistentDataType.DOUBLE, 0.2);
        metaLB.getPersistentDataContainer().set(Health, PersistentDataType.DOUBLE, 95.0);
        metaLB.getPersistentDataContainer().set(Defence, PersistentDataType.DOUBLE, 90.0);
        metaLB.getPersistentDataContainer().set(Intelligence, PersistentDataType.DOUBLE, 50.0);
        metaLB.getPersistentDataContainer().set(Rarity, PersistentDataType.INTEGER, 5);
        LB.setItemMeta(metaLB);
        LORD_BOOTS = LB;

        ShapedRecipe lbc = new ShapedRecipe(new ItemStack(LordBoots.LORD_BOOTS));
        lbc.shape("   ","o o","o o");
        lbc.setIngredient('o', new RecipeChoice.ExactChoice(strgDrag.LORD_FRAG));
        Bukkit.getServer().addRecipe(lbc);
    }
}
