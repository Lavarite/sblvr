package me.lavarite.pluginsb.Items.Events;

import me.lavarite.pluginsb.Items.PluginSB;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityRegainHealthEvent;

public class StatRegen implements Listener {
    @EventHandler
    public void onJoin(EntityRegainHealthEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            event.setCancelled(true);
            Bukkit.getScheduler().scheduleAsyncDelayedTask(PluginSB.plugin, () -> player.setHealth(player.getHealth() + 0.5),140L);
        }
    }
}
