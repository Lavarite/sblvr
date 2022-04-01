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
        loreLL.add("§7Strength: §c+45");
        loreLL.add("§7Crit Damage: §c+20%");
        loreLL.add("§7Health: §a+135");
        loreLL.add("§7Defence: §a+115");
        loreLL.add("§7Intelligence: §a+100");
        loreLL.add("");
        loreLL.add("§6§l§ks§7 §6§lLEGENDARY LEGGINGS §6§l§ks");
        metaLL.setUnbreakable(true);
        metaLL.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        metaLL.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        metaLL.setLore(loreLL);
        NamespacedKey Strength = new NamespacedKey(PluginSB.plugin, "Strength");
        NamespacedKey Critdamage = new NamespacedKey(PluginSB.plugin, "Critdamage");
        NamespacedKey Health = new NamespacedKey(PluginSB.plugin, "Health");
        NamespacedKey Defence = new NamespacedKey(PluginSB.plugin, "Defence");
        NamespacedKey Intelligence = new NamespacedKey(PluginSB.plugin, "Intelligence");
        NamespacedKey Rarity = new NamespacedKey(PluginSB.plugin, "Rarity");
        metaLL.getPersistentDataContainer().set(Strength, PersistentDataType.DOUBLE, 45.0);
        metaLL.getPersistentDataContainer().set(Critdamage, PersistentDataType.DOUBLE, 0.2);
        metaLL.getPersistentDataContainer().set(Health, PersistentDataType.DOUBLE, 135.0);
        metaLL.getPersistentDataContainer().set(Defence, PersistentDataType.DOUBLE, 115.0);
        metaLL.getPersistentDataContainer().set(Intelligence, PersistentDataType.DOUBLE, 100.0);
        metaLL.getPersistentDataContainer().set(Rarity, PersistentDataType.INTEGER, 5);
        LL.setItemMeta(metaLL);
        LORD_LEGS = LL;

        ShapedRecipe llc = new ShapedRecipe(new ItemStack(LordLeggings.LORD_LEGS));
        llc.shape("uuu","u u","u u");
        llc.setIngredient('u', new RecipeChoice.ExactChoice(strgDrag.LORD_FRAG));
        Bukkit.getServer().addRecipe(llc);
    }
}
