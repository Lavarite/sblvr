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

public class HealthCalc implements Listener {
    public double healthSum = 100;
    public double helmetHealth;
    public double chestplateHealth;
    public double leggingsHealth;
    public double bootsHealth;
    public double weaponHealth;
    @EventHandler
    public void HealthCalcEvent(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            Player player = (Player) event.getDamager();
            ItemStack helmet = player.getInventory().getHelmet();
            ItemStack chestplate = player.getInventory().getChestplate();
            ItemStack leggings = player.getInventory().getLeggings();
            ItemStack boots = player.getInventory().getBoots();
            ItemStack weapon = player.getInventory().getItemInMainHand();
            NamespacedKey Health = new NamespacedKey(PluginSB.plugin, "Health");
            if (helmet != null) {
                PersistentDataContainer helmetData = helmet.getItemMeta().getPersistentDataContainer();
                if (helmetData.has(Health, PersistentDataType.DOUBLE)) {
                    helmetHealth = helmetData.get(Health, PersistentDataType.DOUBLE);
                    healthSum += helmetHealth;
                }
            }
            if (chestplate != null) {
                PersistentDataContainer helmetData = chestplate.getItemMeta().getPersistentDataContainer();
                if (helmetData.has(Health, PersistentDataType.DOUBLE)) {
                    chestplateHealth = helmetData.get(Health, PersistentDataType.DOUBLE);
                    healthSum += chestplateHealth;
                }
            }
            if (leggings != null) {
                PersistentDataContainer helmetData = leggings.getItemMeta().getPersistentDataContainer();
                if (helmetData.has(Health, PersistentDataType.DOUBLE)) {
                    leggingsHealth = helmetData.get(Health, PersistentDataType.DOUBLE);
                    healthSum += leggingsHealth;
                }
            }
            if (boots != null) {
                PersistentDataContainer helmetData = boots.getItemMeta().getPersistentDataContainer();
                if (helmetData.has(Health, PersistentDataType.DOUBLE)) {
                    bootsHealth = helmetData.get(Health, PersistentDataType.DOUBLE);
                    healthSum += bootsHealth;
                }
            }
            if (weapon.hasItemMeta()) {
                PersistentDataContainer helmetData = weapon.getItemMeta().getPersistentDataContainer();
                if (helmetData.has(Health, PersistentDataType.DOUBLE)) {
                    weaponHealth = helmetData.get(Health, PersistentDataType.DOUBLE);
                    healthSum += weaponHealth;
                }
            }
        }
    }
}
