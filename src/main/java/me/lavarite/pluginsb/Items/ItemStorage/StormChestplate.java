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
        loreSC.add("§7Health: §a+260");
        loreSC.add("§7Defense: §a+120");
        loreSC.add("§7Intelligence: §a+250");
        loreSC.add("");
        loreSC.add("§6§l§ks§7 §6§lLEGENDARY CHESTPLATE §6§l§ks");
        metaSC.setUnbreakable(true);
        metaSC.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        metaSC.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        metaSC.setLore(loreSC);
        NamespacedKey Health = new NamespacedKey(PluginSB.plugin, "Health");
        NamespacedKey Defence = new NamespacedKey(PluginSB.plugin, "Defence");
        NamespacedKey Intelligence = new NamespacedKey(PluginSB.plugin, "Intelligence");
        NamespacedKey Rarity = new NamespacedKey(PluginSB.plugin, "Rarity");
        metaSC.getPersistentDataContainer().set(Health, PersistentDataType.DOUBLE, 260.0);
        metaSC.getPersistentDataContainer().set(Defence, PersistentDataType.DOUBLE, 120.0);
        metaSC.getPersistentDataContainer().set(Intelligence, PersistentDataType.DOUBLE, 500.0);
        metaSC.getPersistentDataContainer().set(Rarity, PersistentDataType.INTEGER, 5);
        SC.setItemMeta(metaSC);
        STORM_CHEST = SC;

        ShapedRecipe scc = new ShapedRecipe(new ItemStack(StormChestplate.STORM_CHEST));
        scc.shape("d d","ddd","ddd");
        scc.setIngredient('d', new RecipeChoice.ExactChoice(strgDrag.STORM_FRAG));
        Bukkit.getServer().addRecipe(scc);
    }
}
