package me.lavarite.pluginsb.Items.StatCalc;

import me.lavarite.pluginsb.Items.PluginSB;
import org.bukkit.NamespacedKey;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class StrengthCalc implements Listener {
    public double strengthSum;
    public double helmetStrength;
    public double chestplateStrength;
    public double leggingsStrength;
    public double bootsStrength;
    public double weaponStrength;
    @EventHandler
    public void StrengthCalcEvent(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            Player player = (Player) event.getDamager();
            ItemStack helmet = player.getInventory().getHelmet();
            ItemStack chestplate = player.getInventory().getChestplate();
            ItemStack leggings = player.getInventory().getLeggings();
            ItemStack boots = player.getInventory().getBoots();
            ItemStack weapon = player.getInventory().getItemInMainHand();
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
        }
    }
}
