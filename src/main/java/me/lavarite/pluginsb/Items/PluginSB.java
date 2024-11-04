package me.lavarite.pluginsb.Items;

import me.lavarite.pluginsb.Items.Events.*;
import me.lavarite.pluginsb.Items.Events.SBDragons.DragonTypes;
import me.lavarite.pluginsb.Items.Commands.ItemCommands;
import me.lavarite.pluginsb.Items.Events.SBDragons.dragdrop;
import me.lavarite.pluginsb.Items.ItemStorage.AIS;
import me.lavarite.pluginsb.Items.StatCalc.*;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import static java.lang.Thread.sleep;

public final class PluginSB extends JavaPlugin {

    public static Plugin plugin;

    @Override
    public void onEnable() {
        System.out.println("SBLVR is up!");
        plugin = this;
        AIS.ItemInit();

        getServer().getScheduler().scheduleSyncRepeatingTask(this, () -> {
            while (ItemEvents.currentIntelligence < ItemEvents.MaxIntelligence){
                ItemEvents.currentIntelligence++;
                Bukkit.broadcastMessage(""+ ItemEvents.currentIntelligence);
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },1,1);

        getServer().getPluginManager().registerEvents(new ItemEvents(), this);


        getServer().getPluginManager().registerEvents(new WeaponDamage(), this);
        getServer().getPluginManager().registerEvents(new DamageReduction(), this);


        getServer().getPluginManager().registerEvents(new IntelligenceCalc(), this);


        getServer().getPluginManager().registerEvents(new DragonTypes(), this);
        getServer().getPluginManager().registerEvents(new dragdrop(), this);


        getServer().getPluginManager().registerEvents(new StatRegen(), this);



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
