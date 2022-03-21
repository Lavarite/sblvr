package me.lavarite.pluginsb.Items;

import me.lavarite.pluginsb.Items.Events.SBDragons.DragonTypes;
import me.lavarite.pluginsb.Items.Commands.ItemCommands;
import me.lavarite.pluginsb.Items.Events.ItemEvents;
import me.lavarite.pluginsb.Items.Events.SBDragons.dragdrop;
import me.lavarite.pluginsb.Items.Events.WeaponDamage;
import me.lavarite.pluginsb.Items.ItemStorage.AIS;
import org.bukkit.plugin.java.JavaPlugin;

public final class PluginSB extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Sup fucker");
        AIS.ItemInit();
        getServer().getPluginManager().registerEvents(new ItemEvents(), this);
        getServer().getPluginManager().registerEvents(new WeaponDamage(), this);
        getServer().getPluginManager().registerEvents(new DragonTypes(), this);
        getServer().getPluginManager().registerEvents(new dragdrop(), this);
        this.getCommand("giveitem").setExecutor(new ItemCommands());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("Soz i brb need go comit die");
    }
}