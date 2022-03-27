package me.lavarite.pluginsb.Items.StatCalc;

import me.lavarite.pluginsb.Items.PluginSB;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.Objects;

public class CritCalc implements Listener {
    public double critSum;
    public double helmetCrit;
    public double chestplateCrit;
    public double leggingsCrit;
    public double bootsCrit;
    public double weaponCrit;
    @EventHandler
    public void CritCalcEvent(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            Player player = (Player) event.getDamager();
            ItemStack helmet = player.getInventory().getHelmet();
            ItemStack chestplate = player.getInventory().getChestplate();
            ItemStack leggings = player.getInventory().getLeggings();
            ItemStack boots = player.getInventory().getBoots();
            ItemStack weapon = player.getInventory().getItemInMainHand();
            NamespacedKey Crit = new NamespacedKey(PluginSB.plugin, "Critdamage");
            critSum = critSum+50;
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
        }
    }}
