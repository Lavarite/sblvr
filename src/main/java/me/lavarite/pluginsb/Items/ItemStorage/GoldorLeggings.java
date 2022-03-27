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

public class GoldorLeggings {
    public static ItemStack GOLDOR_LEGS;
    public static void initGL() {
        GL();
    }
    private static void GL() {
        ItemStack GL = new ItemStack(Material.LEATHER_LEGGINGS,1);
        LeatherArmorMeta metaGL = (LeatherArmorMeta) GL.getItemMeta();
        assert metaGL != null;
        metaGL.setColor(Color.fromBGR(0,102,0));
        metaGL.setDisplayName("§6Goldor Leggings");
        List<String> loreGL = new ArrayList<>();
        loreGL.add("§7Health: §a+250");
        loreGL.add("§7Defense: §a+220");
        loreGL.add("§7Intelligence: §a+20");
        loreGL.add("");
        loreGL.add("§6§l§ks§7 §6§lLEGENDARY LEGGINGS §6§l§ks");
        metaGL.setUnbreakable(true);
        metaGL.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        metaGL.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        metaGL.setLore(loreGL);
        NamespacedKey Health = new NamespacedKey(PluginSB.plugin, "Health");
        NamespacedKey Defence = new NamespacedKey(PluginSB.plugin, "Defence");
        NamespacedKey Intelligence = new NamespacedKey(PluginSB.plugin, "Intelligence");
        NamespacedKey Rarity = new NamespacedKey(PluginSB.plugin, "Intelligence");
        metaGL.getPersistentDataContainer().set(Health, PersistentDataType.DOUBLE, 250.0);
        metaGL.getPersistentDataContainer().set(Defence, PersistentDataType.DOUBLE, 220.0);
        metaGL.getPersistentDataContainer().set(Intelligence, PersistentDataType.DOUBLE, 20.0);
        metaGL.getPersistentDataContainer().set(Rarity, PersistentDataType.INTEGER, 5);
        GL.setItemMeta(metaGL);
        GOLDOR_LEGS = GL;

        ShapedRecipe glc = new ShapedRecipe(new ItemStack(GoldorLeggings.GOLDOR_LEGS));
        glc.shape("ggg","g g","g g");
        glc.setIngredient('g', new RecipeChoice.ExactChoice(strgDrag.GOLDOR_FRAG));
        Bukkit.getServer().addRecipe(glc);
    }
}
