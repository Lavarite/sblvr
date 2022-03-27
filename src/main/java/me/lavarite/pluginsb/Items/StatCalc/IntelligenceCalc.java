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

public class IntelligenceCalc implements Listener {
    public double intelligenceSum = 100;
    public double helmetIntelligence;
    public double chestplateIntelligence;
    public double leggingsIntelligence;
    public double bootsIntelligence;
    public double weaponIntelligence;
    @EventHandler
    public void IntelligenceCalcEvent(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            Player player = (Player) event.getDamager();
            ItemStack helmet = player.getInventory().getHelmet();
            ItemStack chestplate = player.getInventory().getChestplate();
            ItemStack leggings = player.getInventory().getLeggings();
            ItemStack boots = player.getInventory().getBoots();
            ItemStack weapon = player.getInventory().getItemInMainHand();
            NamespacedKey Intelligence = new NamespacedKey(PluginSB.plugin, "Intelligence");
            if (helmet != null) {
                PersistentDataContainer helmetData = helmet.getItemMeta().getPersistentDataContainer();
                if (helmetData.has(Intelligence, PersistentDataType.DOUBLE)) {
                    helmetIntelligence = helmetData.get(Intelligence, PersistentDataType.DOUBLE);
                    intelligenceSum += helmetIntelligence;
                }
            }
            if (chestplate != null) {
                PersistentDataContainer helmetData = chestplate.getItemMeta().getPersistentDataContainer();
                if (helmetData.has(Intelligence, PersistentDataType.DOUBLE)) {
                    chestplateIntelligence = helmetData.get(Intelligence, PersistentDataType.DOUBLE);
                    intelligenceSum += chestplateIntelligence;
                }
            }
            if (leggings != null) {
                PersistentDataContainer helmetData = leggings.getItemMeta().getPersistentDataContainer();
                if (helmetData.has(Intelligence, PersistentDataType.DOUBLE)) {
                    leggingsIntelligence = helmetData.get(Intelligence, PersistentDataType.DOUBLE);
                    intelligenceSum += leggingsIntelligence;
                }
            }
            if (boots != null) {
                PersistentDataContainer helmetData = boots.getItemMeta().getPersistentDataContainer();
                if (helmetData.has(Intelligence, PersistentDataType.DOUBLE)) {
                    bootsIntelligence = helmetData.get(Intelligence, PersistentDataType.DOUBLE);
                    intelligenceSum += bootsIntelligence;
                }
            }
            if (weapon.hasItemMeta()) {
                PersistentDataContainer helmetData = weapon.getItemMeta().getPersistentDataContainer();
                if (helmetData.has(Intelligence, PersistentDataType.DOUBLE)) {
                    weaponIntelligence = helmetData.get(Intelligence, PersistentDataType.DOUBLE);
                    intelligenceSum += weaponIntelligence;
                }
            }
        }
    }
}
