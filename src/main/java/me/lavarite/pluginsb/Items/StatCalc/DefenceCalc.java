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

public class DefenceCalc implements Listener {
    public double defenceSum = 0;
    public double helmetDefence;
    public double chestplateDefence;
    public double leggingsDefence;
    public double bootsDefence;
    public double weaponDefence;
    @EventHandler
    public void DefenceCalcEvent(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            Player player = (Player) event.getDamager();
            ItemStack helmet = player.getInventory().getHelmet();
            ItemStack chestplate = player.getInventory().getChestplate();
            ItemStack leggings = player.getInventory().getLeggings();
            ItemStack boots = player.getInventory().getBoots();
            ItemStack weapon = player.getInventory().getItemInMainHand();
            NamespacedKey Defence = new NamespacedKey(PluginSB.plugin, "Defence");
            if (helmet != null) {
                PersistentDataContainer helmetData = helmet.getItemMeta().getPersistentDataContainer();
                if (helmetData.has(Defence, PersistentDataType.DOUBLE)) {
                    helmetDefence = helmetData.get(Defence, PersistentDataType.DOUBLE);
                    defenceSum += helmetDefence;
                }
            }
            if (chestplate != null) {
                PersistentDataContainer helmetData = chestplate.getItemMeta().getPersistentDataContainer();
                if (helmetData.has(Defence, PersistentDataType.DOUBLE)) {
                    chestplateDefence = helmetData.get(Defence, PersistentDataType.DOUBLE);
                    defenceSum += chestplateDefence;
                }
            }
            if (leggings != null) {
                PersistentDataContainer helmetData = leggings.getItemMeta().getPersistentDataContainer();
                if (helmetData.has(Defence, PersistentDataType.DOUBLE)) {
                    leggingsDefence = helmetData.get(Defence, PersistentDataType.DOUBLE);
                    defenceSum += leggingsDefence;
                }
            }
            if (boots != null) {
                PersistentDataContainer helmetData = boots.getItemMeta().getPersistentDataContainer();
                if (helmetData.has(Defence, PersistentDataType.DOUBLE)) {
                    bootsDefence = helmetData.get(Defence, PersistentDataType.DOUBLE);
                    defenceSum += bootsDefence;
                }
            }
            if (weapon.hasItemMeta()) {
                PersistentDataContainer helmetData = weapon.getItemMeta().getPersistentDataContainer();
                if (helmetData.has(Defence, PersistentDataType.DOUBLE)) {
                    weaponDefence = helmetData.get(Defence, PersistentDataType.DOUBLE);
                    defenceSum += weaponDefence;
                }
            }
        }
    }
}
