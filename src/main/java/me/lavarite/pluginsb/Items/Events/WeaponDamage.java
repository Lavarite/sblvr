package me.lavarite.pluginsb.Items.Events;

import me.lavarite.pluginsb.Items.PluginSB;
import me.lavarite.pluginsb.Items.StatCalc.CritCalc;
import me.lavarite.pluginsb.Items.StatCalc.DamageCalc;
import me.lavarite.pluginsb.Items.StatCalc.StrengthCalc;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class WeaponDamage implements Listener{
    @EventHandler
    public void DamageFinalCalc(EntityDamageByEntityEvent event){
        if (event.getDamager() instanceof Player){
            event.setDamage(0);
            Player player = (Player) event.getDamager();
            NamespacedKey Damage = new NamespacedKey(PluginSB.plugin, "Damage");
            NamespacedKey Strength = new NamespacedKey(PluginSB.plugin, "Strength");
            NamespacedKey Critdamage = new NamespacedKey(PluginSB.plugin, "Critdamage");
            double finalDamageResult;
            double damageFinalCalc = new DamageCalc().damageSum;
            player.sendMessage("you have " + damageFinalCalc + " damage");
            double strengthFinalCalc = new StrengthCalc().strengthSum;
            player.sendMessage("you have " + strengthFinalCalc + " strength");
            double critdamageFinalCalc = new CritCalc().critSum;
            player.sendMessage("you have " + critdamageFinalCalc + " crit");
            finalDamageResult = (5+damageFinalCalc)*(1+strengthFinalCalc/100)*critdamageFinalCalc/50;
            event.setDamage(finalDamageResult);
            player.sendMessage("you dealt " + finalDamageResult + " damage");
        }
    }
}
