package me.lavarite.pluginsb.Items;

import me.lavarite.pluginsb.Items.Events.DamageReduction;
import me.lavarite.pluginsb.Items.Events.SBDragons.DragonTypes;
import me.lavarite.pluginsb.Items.Commands.ItemCommands;
import me.lavarite.pluginsb.Items.Events.ItemEvents;
import me.lavarite.pluginsb.Items.Events.SBDragons.dragdrop;
import me.lavarite.pluginsb.Items.Events.WeaponDamage;
import me.lavarite.pluginsb.Items.ItemStorage.AIS;
import me.lavarite.pluginsb.Items.StatCalc.*;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class PluginSB extends JavaPlugin {

    public static Plugin plugin;

    @Override
    public void onEnable() {
        System.out.println("Sup fucker");
        plugin = this;
        AIS.ItemInit();
        getServer().getPluginManager().registerEvents(new ItemEvents(), this);


        getServer().getPluginManager().registerEvents(new WeaponDamage(), this);
        getServer().getPluginManager().registerEvents(new DamageReduction(), this);


        getServer().getPluginManager().registerEvents(new CritCalc(), this);
        getServer().getPluginManager().registerEvents(new DamageCalc(), this);
        getServer().getPluginManager().registerEvents(new DefenceCalc(), this);
        getServer().getPluginManager().registerEvents(new HealthCalc(), this);
        getServer().getPluginManager().registerEvents(new IntelligenceCalc(), this);
        getServer().getPluginManager().registerEvents(new StrengthCalc(), this);


        getServer().getPluginManager().registerEvents(new DragonTypes(), this);
        getServer().getPluginManager().registerEvents(new dragdrop(), this);


        this.getCommand("giveitem").setExecutor(new ItemCommands());
        NamespacedKey CritDamage = new NamespacedKey(this, "CritDamage");
        NamespacedKey Strength = new NamespacedKey(this, "Strength");
        NamespacedKey Defence = new NamespacedKey(this, "Defence");
        NamespacedKey Mana = new NamespacedKey(this, "Mana");
        NamespacedKey Rarity = new NamespacedKey(this, "Rarity");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Soz i brb need go comit die");
    }
}