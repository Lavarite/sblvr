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

public class DamageCalc implements Listener {
    public double damageSum;
    public double weaponDamage;
    @EventHandler
    public void DamageCalcEvent(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player) {
            Player player = (Player) event.getDamager();
            ItemStack weapon = player.getInventory().getItemInMainHand();
            NamespacedKey Damage = new NamespacedKey(PluginSB.plugin, "Damage");
            if (weapon.hasItemMeta()) {
                PersistentDataContainer helmetData = weapon.getItemMeta().getPersistentDataContainer();
                if (helmetData.has(Damage, PersistentDataType.DOUBLE)) {
                    weaponDamage = helmetData.get(Damage, PersistentDataType.DOUBLE);
                    damageSum += weaponDamage;
                }
            }
        }
    }
}
