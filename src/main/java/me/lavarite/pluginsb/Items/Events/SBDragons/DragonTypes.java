package me.lavarite.pluginsb.Items.Events.SBDragons;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Random;

import static org.apache.commons.lang.math.RandomUtils.nextInt;

    public class DragonTypes implements Listener {
        @EventHandler
        public void DragonTypesInit(CreatureSpawnEvent event) {
            EnderDragon Drag = (EnderDragon) event.getEntity();
            if (event.getEntityType().equals(EntityType.ENDER_DRAGON)) {
                int matchDrag = new Random().nextInt(100);
                if (matchDrag > 58) {
                    Bukkit.broadcastMessage("§5§lEnder Dragon §r§5has spawned!");
                    Drag.setCustomName("§5§lEnder Dragon");
                    Drag.setHealth(500);
                    Drag.setMaxHealth(500);
                }
                if (matchDrag < 59 && matchDrag > 30) {
                    Bukkit.broadcastMessage("§2§lGoldor Dragon §r§5has spawned!");
                    Drag.setCustomName("§2§lGoldor Dragon");
                    Drag.setHealth(2000);
                    Drag.setMaxHealth(2000);
                }
                if (matchDrag > 10 && matchDrag < 31) {
                    Bukkit.broadcastMessage("§3§lStorm Dragon §r§5has spawned!");
                    Drag.setCustomName("§3§lStrom Dragon");
                    Drag.setHealth(750);
                    Drag.setMaxHealth(750);
                }
                if (matchDrag > 0 && matchDrag < 11) {
                    Bukkit.broadcastMessage("§c§lNecron Dragon §r§5has spawned!");
                    Drag.setCustomName("§c§lNecron Dragon");
                    Drag.setHealth(750);
                    Drag.setMaxHealth(750);
                }
                if (matchDrag == 0) {
                    Bukkit.broadcastMessage("§6§lNecrolord Dragon §r§5has spawned!");
                    Drag.setCustomName("§6§lNecrolord Dragon");
                    Drag.setHealth(1500);
                    Drag.setMaxHealth(1500);
                }
            }
        }
    }
