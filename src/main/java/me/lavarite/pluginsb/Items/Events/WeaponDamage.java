package me.lavarite.pluginsb.Items.Events;

import me.lavarite.pluginsb.Items.StatCalc.CritCalc;
import me.lavarite.pluginsb.Items.StatCalc.DamageCalc;
import me.lavarite.pluginsb.Items.StatCalc.StrengthCalc;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class WeaponDamage implements Listener{
    @EventHandler
    public void DamageCalc(EntityDamageByEntityEvent event){
        event.setDamage(0);
        if (event.getDamager() instanceof Player){
            Player player = (Player) event.getDamager();
            double finalDamageResult;
            double damageFinalCalc = new DamageCalc().damageSum;
            double strengthFinalCalc = new StrengthCalc().strengthSum;
            double critdamageFinalCalc = new CritCalc().critSum;
            finalDamageResult = (5+damageFinalCalc)*(1+strengthFinalCalc/100)*critdamageFinalCalc/50;
            event.setDamage(finalDamageResult);
            player.sendMessage("you dealt " + finalDamageResult + " damage");
        }
    }
}
