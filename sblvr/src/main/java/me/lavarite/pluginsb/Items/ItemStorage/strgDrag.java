package me.lavarite.pluginsb.Items.ItemStorage;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.ArrayList;
import java.util.List;

public class strgDrag {
    public static ItemStack GOLDOR_FRAG;
    public static ItemStack STORM_FRAG;
    public static ItemStack NECRON_FRAG;
    public static ItemStack LORD_FRAG;
    public static ItemStack DRAGON_CORE;

    public static void initDrag() {
        GF();
        SF();
        NF();
        LF();
        DC();
    }

    private static void DC() {
        ItemStack DC = new ItemStack(Material.BEACON,1);
        ItemMeta metaDC = (ItemMeta) DC.getItemMeta();
        assert metaDC != null;
        metaDC.setDisplayName("§6Dragon Core");
        List<String> loreDC = new ArrayList<>();
        loreDC.add("§6§lLEGENDARY ITEM");
        metaDC.setLore(loreDC);
        DC.setItemMeta(metaDC);
        DRAGON_CORE = DC;

        ShapedRecipe dcc = new ShapedRecipe(new ItemStack(strgDrag.DRAGON_CORE));
        dcc.shape(" g ","sln","   ");
        dcc.setIngredient('g', new RecipeChoice.ExactChoice(strgDrag.GOLDOR_FRAG));
        dcc.setIngredient('s', new RecipeChoice.ExactChoice(strgDrag.STORM_FRAG));
        dcc.setIngredient('n', new RecipeChoice.ExactChoice(strgDrag.NECRON_FRAG));
        dcc.setIngredient('l', new RecipeChoice.ExactChoice(strgDrag.LORD_FRAG));
        Bukkit.getServer().addRecipe(dcc);
    }
    private static void GF() {
        ItemStack GF = new ItemStack(Material.GREEN_DYE,1);
        ItemMeta metaGF = (ItemMeta) GF.getItemMeta();
        assert metaGF != null;
        metaGF.setDisplayName("§5Goldor Fragment");
        List<String> loreGF = new ArrayList<>();
        loreGF.add("§5§lEPIC ITEM");
        metaGF.setLore(loreGF);
        GF.setItemMeta(metaGF);
        GOLDOR_FRAG = GF;
    }
    private static void SF() {
        ItemStack SF = new ItemStack(Material.BLUE_DYE,1);
        ItemMeta metaSF = (ItemMeta) SF.getItemMeta();
        assert metaSF != null;
        metaSF.setDisplayName("§5Storm Fragment");
        List<String> loreSF = new ArrayList<>();
        loreSF.add("§5§lEPIC ITEM");
        metaSF.setLore(loreSF);
        SF.setItemMeta(metaSF);
        STORM_FRAG = SF;
    }
    private static void NF() {
        ItemStack NF = new ItemStack(Material.RED_DYE,1);
        ItemMeta metaNF = (ItemMeta) NF.getItemMeta();
        assert metaNF != null;
        metaNF.setDisplayName("§5Necron Fragment");
        List<String> loreNF = new ArrayList<>();
        loreNF.add("§5§lEPIC ITEM");
        metaNF.setLore(loreNF);
        NF.setItemMeta(metaNF);
        NECRON_FRAG = NF;
    }
    private static void LF() {
        ItemStack LF = new ItemStack(Material.BLACK_DYE,1);
        ItemMeta metaLF = (ItemMeta) LF.getItemMeta();
        assert metaLF != null;
        metaLF.setDisplayName("§5Necrolord Fragment");
        List<String> loreLF = new ArrayList<>();
        loreLF.add("§5§lEPIC ITEM");
        metaLF.setLore(loreLF);
        LF.setItemMeta(metaLF);
        LORD_FRAG = LF;
    }
}
