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
        loreSB.add("§7Health: §a+145");
        loreSB.add("§7Defense: §a+65");
        loreSB.add("§7Intelligence: §a+250");
        loreSB.add("");
        loreSB.add("§6§l§ks§7 §6§lLEGENDARY BOOTS §6§l§ks");
        metaSB.setUnbreakable(true);
        metaSB.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        metaSB.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        metaSB.setLore(loreSB);
        NamespacedKey Health = new NamespacedKey(PluginSB.plugin, "Health");
        NamespacedKey Defence = new NamespacedKey(PluginSB.plugin, "Defence");
        NamespacedKey Intelligence = new NamespacedKey(PluginSB.plugin, "Intelligence");
        NamespacedKey Rarity = new NamespacedKey(PluginSB.plugin, "Rarity");
        metaSB.getPersistentDataContainer().set(Health, PersistentDataType.DOUBLE, 160.0);
        metaSB.getPersistentDataContainer().set(Defence, PersistentDataType.DOUBLE, 65.0);
        metaSB.getPersistentDataContainer().set(Intelligence, PersistentDataType.DOUBLE, 250.0);
        metaSB.getPersistentDataContainer().set(Rarity, PersistentDataType.INTEGER, 5);
        SB.setItemMeta(metaSB);
        STORM_BOOTS = SB;

        ShapedRecipe sbc = new ShapedRecipe(new ItemStack(StormBoots.STORM_BOOTS));
        sbc.shape("   ","i i","i i");
        sbc.setIngredient('i', new RecipeChoice.ExactChoice(strgDrag.STORM_FRAG));
        Bukkit.getServer().addRecipe(sbc);
    }
}
