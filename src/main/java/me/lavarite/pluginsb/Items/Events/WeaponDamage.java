package me.lavarite.pluginsb.Items.Events;

import me.lavarite.pluginsb.Items.PluginSB;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;





public class WeaponDamage implements Listener{
    public double critSum = 0;
    public double helmetCrit = 0;
    public double chestplateCrit = 0;
    public double leggingsCrit = 0;
    public double bootsCrit = 0;
    public double weaponCrit = 0;

    public double damageSum = 0;
    public double weaponDamage = 0;

    public double strengthSum = 0;
    public double helmetStrength = 0;
    public double chestplateStrength = 0;
    public double leggingsStrength = 0;
    public double bootsStrength = 0;
    public double weaponStrength = 0;
    @EventHandler
    public void DamageFinalCalc(EntityDamageByEntityEvent event){
        if (event.getDamager() instanceof Player){
            event.setDamage(0);
            Player player = (Player) event.getDamager();
            critSum = 0;
            strengthSum = 0;
            damageSum = 0;

            ItemStack helmet = player.getInventory().getHelmet();
            ItemStack chestplate = player.getInventory().getChestplate();
            ItemStack leggings = player.getInventory().getLeggings();
            ItemStack boots = player.getInventory().getBoots();
            ItemStack weapon = player.getInventory().getItemInMainHand();
            NamespacedKey Crit = new NamespacedKey(PluginSB.plugin, "Critdamage");
            critSum += 50;
            if (helmet != null) {
                PersistentDataContainer helmetData = helmet.getItemMeta().getPersistentDataContainer();
                if (helmetData.has(Crit, PersistentDataType.DOUBLE)) {
                    helmetCrit = helmetData.get(Crit, PersistentDataType.DOUBLE);
                    critSum += helmetCrit;
                }
            }
            if (chestplate != null) {
                PersistentDataContainer helmetData = chestplate.getItemMeta().getPersistentDataContainer();
                if (helmetData.has(Crit, PersistentDataType.DOUBLE)) {
                    chestplateCrit = helmetData.get(Crit, PersistentDataType.DOUBLE);
                    critSum += chestplateCrit;
                }
            }
            if (leggings != null) {
                PersistentDataContainer helmetData = leggings.getItemMeta().getPersistentDataContainer();
                if (helmetData.has(Crit, PersistentDataType.DOUBLE)) {
                    leggingsCrit = helmetData.get(Crit, PersistentDataType.DOUBLE);
                    critSum += leggingsCrit;
                }
            }
            if (boots != null) {
                PersistentDataContainer helmetData = boots.getItemMeta().getPersistentDataContainer();
                if (helmetData.has(Crit, PersistentDataType.DOUBLE)) {
                    bootsCrit = helmetData.get(Crit, PersistentDataType.DOUBLE);
                    critSum += bootsCrit;
                }
            }
            if (weapon.hasItemMeta()) {
                PersistentDataContainer helmetData = weapon.getItemMeta().getPersistentDataContainer();
                if (helmetData.has(Crit, PersistentDataType.DOUBLE)) {
                    weaponCrit = helmetData.get(Crit, PersistentDataType.DOUBLE);
                    critSum += weaponCrit;
                }
            }



            NamespacedKey Damage = new NamespacedKey(PluginSB.plugin, "Damage");
            if (weapon.hasItemMeta()) {
                PersistentDataContainer helmetData = weapon.getItemMeta().getPersistentDataContainer();
                if (helmetData.has(Damage, PersistentDataType.DOUBLE)) {
                    weaponDamage = helmetData.get(Damage, PersistentDataType.DOUBLE);
                    damageSum += weaponDamage;
                }
            }


            NamespacedKey Strength = new NamespacedKey(PluginSB.plugin, "Strength");
            if (helmet != null) {
                PersistentDataContainer helmetData = helmet.getItemMeta().getPersistentDataContainer();
                if (helmetData.has(Strength, PersistentDataType.DOUBLE)) {
                    helmetStrength = helmetData.get(Strength, PersistentDataType.DOUBLE);
                    strengthSum += helmetStrength;
                }
            }
            if (chestplate != null) {
                PersistentDataContainer helmetData = chestplate.getItemMeta().getPersistentDataContainer();
                if (helmetData.has(Strength, PersistentDataType.DOUBLE)) {
                    chestplateStrength = helmetData.get(Strength, PersistentDataType.DOUBLE);
                    strengthSum += chestplateStrength;
                }
            }
            if (leggings != null) {
                PersistentDataContainer helmetData = leggings.getItemMeta().getPersistentDataContainer();
                if (helmetData.has(Strength, PersistentDataType.DOUBLE)) {
                    leggingsStrength = helmetData.get(Strength, PersistentDataType.DOUBLE);
                    strengthSum += leggingsStrength;
                }
            }
            if (boots != null) {
                PersistentDataContainer helmetData = boots.getItemMeta().getPersistentDataContainer();
                if (helmetData.has(Strength, PersistentDataType.DOUBLE)) {
                    bootsStrength = helmetData.get(Strength, PersistentDataType.DOUBLE);
                    strengthSum += bootsStrength;
                }
            }
            if (weapon.hasItemMeta()) {
                PersistentDataContainer helmetData = weapon.getItemMeta().getPersistentDataContainer();
                if (helmetData.has(Strength, PersistentDataType.DOUBLE)) {
                    weaponStrength = helmetData.get(Strength, PersistentDataType.DOUBLE);
                    strengthSum += weaponStrength;
                }
            }


            double finalDamageResult;
            player.sendMessage("you have " + damageSum + " damage");
            player.sendMessage("you have " + strengthSum + " strength");
            player.sendMessage("you have " + (critSum) + " crit");
            finalDamageResult = (5+damageSum)*(1+strengthSum/100)*(critSum)/50;
            event.setDamage(finalDamageResult);
            player.sendMessage("you dealt " + finalDamageResult + " damage");
        }
    }
    public double DamageStat = damageSum;
    public double StrengthStat = strengthSum;
    public double CritStat = critSum;
}
