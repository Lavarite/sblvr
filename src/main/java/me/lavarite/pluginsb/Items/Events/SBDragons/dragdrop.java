package me.lavarite.pluginsb.Items.Events.SBDragons;

import me.lavarite.pluginsb.Items.ItemStorage.AOTE;
import me.lavarite.pluginsb.Items.ItemStorage.strgDrag;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.Random;

public class dragdrop implements Listener {
    @EventHandler
    public void dragdeath(EntityDeathEvent event){
        LivingEntity Drag = event.getEntity();
        if (Drag instanceof EnderDragon){
            Random rand = new Random();
            if (Drag.getCustomName().equals("§5§lEnder Dragon")) {
                int dAOTE = rand.nextInt(100);
                if (dAOTE < 3) {
                    Drag.getLocation().getWorld().dropItem(Drag.getLocation(), AOTE.ASPECT_OF_THE_END);
                }
            }
            if (Drag.getCustomName().equals("§2§lGoldor Dragon")) {
                int dGF = rand.nextInt(100);
                if (dGF < 1) {
                    Drag.getLocation().getWorld().dropItem(Drag.getLocation(), strgDrag.GOLDOR_FRAG);
                }
            }
            if (Drag.getCustomName().equals("§2§l§3§lStrom Dragon")) {
                int dGF = rand.nextInt(100);
                if (dGF < 1) {
                    Drag.getLocation().getWorld().dropItem(Drag.getLocation(), strgDrag.STORM_FRAG);
                }
            }
            if (Drag.getCustomName().equals("§c§lNecron Dragon")) {
                int dGF = rand.nextInt(100);
                if (dGF < 1) {
                    Drag.getLocation().getWorld().dropItem(Drag.getLocation(), strgDrag.NECRON_FRAG);
                }
            }
            if (Drag.getCustomName().equals("§6§lNecrolord Dragon")) {
                int dGF = rand.nextInt(100);
                if (dGF < 1) {
                    Drag.getLocation().getWorld().dropItem(Drag.getLocation(), strgDrag.LORD_FRAG);
                }
            }
        }
    }
}
