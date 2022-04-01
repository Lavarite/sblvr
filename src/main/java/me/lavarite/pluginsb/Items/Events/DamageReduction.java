package me.lavarite.pluginsb.Items.Events;

import me.lavarite.pluginsb.Items.PluginSB;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.Objects;

public class DamageReduction implements Listener {
    public double defenceSum = 0;
    public double helmetDefence = 0;
    public double chestplateDefence = 0;
    public double leggingsDefence = 0;
    public double bootsDefence = 0;
    public double weaponDefence = 0;
    public double healthSum = 100;
    public double helmetHealth = 0;
    public double chestplateHealth = 0;
    public double leggingsHealth = 0;
    public double bootsHealth = 0;
    public double weaponHealth = 0;
    public double currentHealth;
    @EventHandler
    public void ReductionCalc(EntityDamageEvent event) {
        double damage = event.getDamage();
        if (event.getEntity() instanceof Player) {
            defenceSum = 1;
            helmetDefence = 0;
            chestplateDefence = 0;
            leggingsDefence = 0;
            bootsDefence = 0;
            weaponDefence = 0;
            healthSum = 100;
            helmetHealth = 0;
            chestplateHealth = 0;
            leggingsHealth = 0;
            bootsHealth = 0;
            weaponHealth = 0;
            event.setDamage(0);
            Player player = (Player) event.getEntity();
            ItemStack helmet = player.getInventory().getHelmet();
            ItemStack chestplate = player.getInventory().getChestplate();
            ItemStack leggings = player.getInventory().getLeggings();
            ItemStack boots = player.getInventory().getBoots();
            ItemStack weapon = player.getInventory().getItemInMainHand();
            NamespacedKey Defence = new NamespacedKey(PluginSB.plugin, "Defence");
            NamespacedKey Health = new NamespacedKey(PluginSB.plugin, "Health");
            if (helmet != null) {
                PersistentDataContainer helmetData = Objects.requireNonNull(helmet.getItemMeta()).getPersistentDataContainer();
                if (helmetData.has(Defence, PersistentDataType.DOUBLE)) {
                    helmetDefence = helmetData.get(Defence, PersistentDataType.DOUBLE);
                    defenceSum += helmetDefence;
                }
            }
            if (chestplate != null) {
                PersistentDataContainer helmetData = Objects.requireNonNull(chestplate.getItemMeta()).getPersistentDataContainer();
                if (helmetData.has(Defence, PersistentDataType.DOUBLE)) {
                    chestplateDefence = helmetData.get(Defence, PersistentDataType.DOUBLE);
                    defenceSum += chestplateDefence;
                }
            }
            if (leggings != null) {
                PersistentDataContainer helmetData = Objects.requireNonNull(leggings.getItemMeta()).getPersistentDataContainer();
                if (helmetData.has(Defence, PersistentDataType.DOUBLE)) {
                    leggingsDefence = helmetData.get(Defence, PersistentDataType.DOUBLE);
                    defenceSum += leggingsDefence;
                }
            }
            if (boots != null) {
                PersistentDataContainer helmetData = Objects.requireNonNull(boots.getItemMeta()).getPersistentDataContainer();
                if (helmetData.has(Defence, PersistentDataType.DOUBLE)) {
                    bootsDefence = helmetData.get(Defence, PersistentDataType.DOUBLE);
                    defenceSum += bootsDefence;
                }
            }
            if (weapon.hasItemMeta()) {
                PersistentDataContainer helmetData = Objects.requireNonNull(weapon.getItemMeta()).getPersistentDataContainer();
                if (helmetData.has(Defence, PersistentDataType.DOUBLE)) {
                    weaponDefence = helmetData.get(Defence, PersistentDataType.DOUBLE);
                    defenceSum += weaponDefence;
                }
            }



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
                PersistentDataContainer helmetData = Objects.requireNonNull(weapon.getItemMeta()).getPersistentDataContainer();
                if (helmetData.has(Health, PersistentDataType.DOUBLE)) {
                    weaponHealth = helmetData.get(Health, PersistentDataType.DOUBLE);
                    healthSum += weaponHealth;
                }
            }
            double damageFinal;
            double healthratio;
            healthratio = healthSum/20;
            damage = damage/(1+defenceSum/100);
            damageFinal = damage/healthratio;
            player.sendMessage("damage = " + damage);
            event.setDamage(damageFinal);
            currentHealth = player.getHealth()*healthratio;
        }
    }
    public double DefenceStat = defenceSum;
    public double HealthStat = currentHealth;
}
