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

public class GoldorHelmet {
    public static ItemStack GOLDOR_HELM;
    public static void initGH() {
        GH();
    }
    private static void GH() {
        ItemStack GH = new ItemStack(Material.LEATHER_HELMET,1);
        LeatherArmorMeta metaGH = (LeatherArmorMeta) GH.getItemMeta();
        assert metaGH != null;
        metaGH.setColor(Color.fromBGR(0,102,0));
        metaGH.setDisplayName("§6Goldor Helmet");
        List<String> loreGH = new ArrayList<>();
        loreGH.add("§7Health: §a+210");
        loreGH.add("§7Defense: §a+180");
        loreGH.add("§7Intelligence: §a+30");
        loreGH.add("");
        loreGH.add("§6§l§ks§7 §6§lLEGENDARY HELMET §6§l§ks");
        metaGH.setUnbreakable(true);
        metaGH.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        metaGH.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        metaGH.setLore(loreGH);
        NamespacedKey Health = new NamespacedKey(PluginSB.plugin, "Health");
        NamespacedKey Defence = new NamespacedKey(PluginSB.plugin, "Defence");
        NamespacedKey Intelligence = new NamespacedKey(PluginSB.plugin, "Intelligence");
        NamespacedKey Rarity = new NamespacedKey(PluginSB.plugin, "Intelligence");
        metaGH.getPersistentDataContainer().set(Health, PersistentDataType.DOUBLE, 210.0);
        metaGH.getPersistentDataContainer().set(Defence, PersistentDataType.DOUBLE, 180.0);
        metaGH.getPersistentDataContainer().set(Intelligence, PersistentDataType.DOUBLE, 30.0);
        metaGH.getPersistentDataContainer().set(Rarity, PersistentDataType.INTEGER, 5);
        GH.setItemMeta(metaGH);
        GOLDOR_HELM = GH;

        ShapedRecipe ghc = new ShapedRecipe(new ItemStack(GoldorHelmet.GOLDOR_HELM));
        ghc.shape("qqq","q q","   ");
        ghc.setIngredient('q', new RecipeChoice.ExactChoice(strgDrag.GOLDOR_FRAG));
        Bukkit.getServer().addRecipe(ghc);
    }
}
