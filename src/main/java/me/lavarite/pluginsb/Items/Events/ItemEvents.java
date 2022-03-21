package me.lavarite.pluginsb.Items.Events;

import me.lavarite.pluginsb.Items.ItemStorage.AOTE;
import me.lavarite.pluginsb.Items.ItemStorage.AOTM;
import me.lavarite.pluginsb.Items.ItemStorage.AOTV;
import me.lavarite.pluginsb.Items.ItemStorage.HYPE;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import static java.lang.Math.*;
import static java.lang.Thread.sleep;

public class ItemEvents implements Listener {

    @EventHandler
    public void onRightClick(PlayerInteractEvent event) throws InterruptedException {
        Player player = event.getPlayer();
        if (event.getAction() == Action.RIGHT_CLICK_AIR && player.isSneaking()) {
            if (event.getItem().getItemMeta().equals(AOTM.MODIFIED_ASPECT_OF_THE_VOID.getItemMeta())) {
                Location tpBlock = player.getTargetBlock(null,61).getLocation();
                Block b1 = tpBlock.getBlock().getRelative(BlockFace.NORTH);
                Location b1L = b1.getLocation();
                Block b2 = b1L.getBlock().getRelative(BlockFace.NORTH);
                Location b2L = b2.getLocation();
                player.sendMessage("§aWhosh!");
                player.teleport(b2L);
                player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 10, 100));
            }
        }
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (event.getItem().getItemMeta().equals(AOTE.ASPECT_OF_THE_END.getItemMeta())) {
                Block block = player.getTargetBlock(null, 5);
                double bX = block.getX();
                double bY = block.getY();
                double bZ = block.getZ();
                double pX = player.getLocation().getX();
                double pY = player.getLocation().getY();
                double pZ = player.getLocation().getZ();
                double distance = sqrt(pow(bX - pX, 2) + pow(bY - pY, 2) + pow(bZ - pZ, 2));
                Location location = new Location(block.getWorld(), block.getX(), block.getY(), block.getZ(), player.getLocation().getYaw(), player.getLocation().getPitch());
                if (distance <= 3) {
                    player.sendMessage("§cThere are blocks in the way!");
                }
                if (distance > 3) {
                    player.teleport(location);
                    player.playSound(location, Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 1));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 10, 100));
                }
            }
                if (event.getItem().getItemMeta().equals(AOTV.ASPECT_OF_THE_VOID.getItemMeta())) {
                    Block block1 = player.getTargetBlock(null, 8);
                    double b1X = block1.getX();
                    double b1Y = block1.getY();
                    double b1Z = block1.getZ();
                    double p1X = player.getLocation().getX();
                    double p1Y = player.getLocation().getY();
                    double p1Z = player.getLocation().getZ();
                    double distance1 = sqrt(pow(b1X - p1X, 2) + pow(b1Y - p1Y, 2) + pow(b1Z - p1Z, 2));
                    Location location1 = new Location(block1.getWorld(), block1.getX(), block1.getY(), block1.getZ(), player.getLocation().getYaw(), player.getLocation().getPitch());
                    if (distance1 <= 3) {
                        player.sendMessage("§cThere are blocks in the way!");
                    }
                    if (distance1 > 3) {
                        player.teleport(location1);
                        player.playSound(location1, Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 1));
                        player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 10, 100));
                    }
                }
                if (event.getItem().getItemMeta().equals(AOTM.MODIFIED_ASPECT_OF_THE_VOID.getItemMeta())) {
                    Block block2 = player.getTargetBlock(null, 10);
                    double b2X = block2.getX();
                    double b2Y = block2.getY();
                    double b2Z = block2.getZ();
                    double p2X = player.getLocation().getX();
                    double p2Y = player.getLocation().getY();
                    double p2Z = player.getLocation().getZ();
                    double distance2 = sqrt(pow(b2X - p2X, 2) + pow(b2Y - p2Y, 2) + pow(b2Z - p2Z, 2));
                    Location location2 = new Location(block2.getWorld(), block2.getX(), block2.getY(), block2.getZ(), player.getLocation().getYaw(), player.getLocation().getPitch());
                    if (distance2 <= 3) {
                        player.sendMessage("§cThere are blocks in the way!");
                    }
                    if (distance2 > 3) {
                        player.teleport(location2);
                        player.playSound(location2, Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 1));
                        player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 10, 100));
                    }
                }
            if (event.getItem().getItemMeta().equals(HYPE.HYPERION.getItemMeta())) {
                Block block = player.getTargetBlock(null, 10);
                double b3X = block.getX();
                double b3Y = block.getY();
                double b3Z = block.getZ();
                double p3X = player.getLocation().getX();
                double p3Y = player.getLocation().getY();
                double p3Z = player.getLocation().getZ();
                double distance3 = sqrt(pow(b3X - p3X, 2) + pow(b3Y - p3Y, 2) + pow(b3Z - p3Z, 2));
                Location location3 = new Location(block.getWorld(), block.getX(), block.getY(), block.getZ(), player.getLocation().getYaw(), player.getLocation().getPitch());
                if (distance3 <= 3) {
                    player.sendMessage("§cThere are blocks in the way!");
                    player.playSound(location3, Sound.BLOCK_BREWING_STAND_BREW, 1, 1);
                    player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 1000, 5));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 100, 3));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 10, 100));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 3));
                }
                if (distance3 > 3) {
                    player.teleport(location3);
                    player.playSound(location3, Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
                    player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 1000, 5));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 100, 3));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 10, 100));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 3));
                }
                World world = player.getWorld();
                Location l = player.getLocation();
                player.setNoDamageTicks(20);
                player.spawnParticle(Particle.EXPLOSION_NORMAL, l, 3);
                player.playSound(l, Sound.ENTITY_GENERIC_EXPLODE, 0.5f, 1f);
                for (Entity nearby: world.getNearbyEntities(l, 8d, 8d, 8d)) {
                    if (nearby instanceof LivingEntity) {
                        LivingEntity entity = (LivingEntity) nearby;
                        entity.damage(50d);
                    }
                    if (nearby instanceof EnderDragon) {
                        EnderDragon dragon = (EnderDragon) nearby;
                        dragon.setHealth(dragon.getHealth()-20);
                        if (dragon.getHealth() < 20){
                            dragon.setHealth(0);
                        }
                    }
                }

            }
            }
    }
    }

