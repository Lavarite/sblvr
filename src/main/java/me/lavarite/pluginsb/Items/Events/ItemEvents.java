package me.lavarite.pluginsb.Items.Events;

import me.lavarite.pluginsb.Items.ItemStorage.AOTE;
import me.lavarite.pluginsb.Items.ItemStorage.AOTM;
import me.lavarite.pluginsb.Items.ItemStorage.AOTV;
import me.lavarite.pluginsb.Items.ItemStorage.HYPE;
import me.lavarite.pluginsb.Items.PluginSB;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Objects;

import static java.lang.Math.*;
import static java.lang.Thread.sleep;

public class ItemEvents implements Listener {
    public double intelligenceSum =  0;
    public double helmetIntelligence = 0;
    public double chestplateIntelligence = 0;
    public double leggingsIntelligence = 0;
    public double bootsIntelligence = 0;
    public double weaponIntelligence = 0;
    public static double MaxIntelligence = 0;
    public static double currentIntelligence = 0;
    @EventHandler
    public void onRightClick(PlayerInteractEvent event) throws InterruptedException {

        intelligenceSum =  0;
        helmetIntelligence = 0;
        chestplateIntelligence = 0;
        leggingsIntelligence = 0;
        bootsIntelligence = 0;
        weaponIntelligence = 0;

        Player player = event.getPlayer();
        ItemStack helmet = player.getInventory().getHelmet();
        ItemStack chestplate = player.getInventory().getChestplate();
        ItemStack leggings = player.getInventory().getLeggings();
        ItemStack boots = player.getInventory().getBoots();
        ItemStack weapon = player.getInventory().getItemInMainHand();
        NamespacedKey Intelligence = new NamespacedKey(PluginSB.plugin, "Intelligence");
        if (helmet != null) {
            PersistentDataContainer helmetData = Objects.requireNonNull(helmet.getItemMeta()).getPersistentDataContainer();
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
        MaxIntelligence = intelligenceSum + 100;



        NamespacedKey ManaCost = new NamespacedKey(PluginSB.plugin, "ManaCost");


        if (event.getAction() == Action.RIGHT_CLICK_AIR && player.isSneaking()) {
            if (currentIntelligence >= AOTM.MODIFIED_ASPECT_OF_THE_VOID.getItemMeta().getPersistentDataContainer().get(ManaCost, PersistentDataType.DOUBLE))
                if (event.getItem().getItemMeta().equals(AOTM.MODIFIED_ASPECT_OF_THE_VOID.getItemMeta())) {
                    Location tpBlock = player.getTargetBlock(null,61).getLocation();
                    Block b1 = tpBlock.getBlock().getRelative(BlockFace.NORTH);
                    Location b1L = b1.getLocation();
                    Block b2 = b1L.getBlock().getRelative(BlockFace.NORTH);
                    if (b1.getBlockData().getMaterial().equals(Material.AIR) && b2.getBlockData().getMaterial().equals(Material.AIR)) {
                        player.sendMessage("§aWhosh!");
                        player.teleport(b1L);
                        player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 10, 100));
                        currentIntelligence = currentIntelligence - AOTM.MODIFIED_ASPECT_OF_THE_VOID.getItemMeta().getPersistentDataContainer().get(ManaCost, PersistentDataType.DOUBLE);
                    }
                    else if (currentIntelligence < AOTE.ASPECT_OF_THE_END.getItemMeta().getPersistentDataContainer().get(ManaCost, PersistentDataType.DOUBLE)) {
                        player.sendMessage("§cYou have not enough mana!");
                    }
                    else if (!(b1.getBlockData().getMaterial().equals(Material.AIR) && b2.getBlockData().getMaterial().equals(Material.AIR))) {
                        player.sendMessage("§cThere are blocks in the way!");
                    }
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

                if (distance > 3 && currentIntelligence >= AOTE.ASPECT_OF_THE_END.getItemMeta().getPersistentDataContainer().get(ManaCost, PersistentDataType.DOUBLE)) {
                    player.teleport(location);
                    player.playSound(location, Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 1));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 10, 100));
                    currentIntelligence = currentIntelligence-AOTE.ASPECT_OF_THE_END.getItemMeta().getPersistentDataContainer().get(ManaCost, PersistentDataType.DOUBLE);
                }
                else if (currentIntelligence < AOTE.ASPECT_OF_THE_END.getItemMeta().getPersistentDataContainer().get(ManaCost, PersistentDataType.DOUBLE)) {
                    player.sendMessage("§cYou have not enough mana!");
                }
                else if (distance <= 3) {
                    player.sendMessage("§cThere are blocks in the way!");
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

                if (distance1 > 3 && currentIntelligence >= AOTV.ASPECT_OF_THE_VOID.getItemMeta().getPersistentDataContainer().get(ManaCost, PersistentDataType.DOUBLE)) {
                    player.teleport(location1);
                    player.playSound(location1, Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 1));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 10, 100));
                    currentIntelligence = currentIntelligence -  AOTV.ASPECT_OF_THE_VOID.getItemMeta().getPersistentDataContainer().get(ManaCost, PersistentDataType.DOUBLE);
                }
                else if (currentIntelligence < AOTV.ASPECT_OF_THE_VOID.getItemMeta().getPersistentDataContainer().get(ManaCost, PersistentDataType.DOUBLE)) {
                    player.sendMessage("§cYou have not enough mana!");
                }
                else if (distance1 <= 3) {
                    player.sendMessage("§cThere are blocks in the way!");
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

                if (distance2 > 3 && currentIntelligence >= AOTM.MODIFIED_ASPECT_OF_THE_VOID.getItemMeta().getPersistentDataContainer().get(ManaCost, PersistentDataType.DOUBLE)) {
                    player.teleport(location2);
                    player.playSound(location2, Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
                    player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 100, 1));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 10, 100));
                    currentIntelligence = currentIntelligence - AOTM.MODIFIED_ASPECT_OF_THE_VOID.getItemMeta().getPersistentDataContainer().get(ManaCost, PersistentDataType.DOUBLE);
                }
                else if (currentIntelligence < AOTM.MODIFIED_ASPECT_OF_THE_VOID.getItemMeta().getPersistentDataContainer().get(ManaCost, PersistentDataType.DOUBLE)) {
                    player.sendMessage("§cYou have not enough mana!");
                }
                else if (distance2 <= 3) {
                    player.sendMessage("§cThere are blocks in the way!");
                }
            }



            if (event.getItem().getItemMeta().equals(HYPE.HYPERION.getItemMeta())) {
                player.sendMessage("§cYou have not enough mana!" + currentIntelligence);
                if (currentIntelligence >= HYPE.HYPERION.getItemMeta().getPersistentDataContainer().get(ManaCost, PersistentDataType.DOUBLE)) {
                    Block block = player.getTargetBlock(null, 10);
                    double b3X = block.getX();
                    double b3Y = block.getY();
                    double b3Z = block.getZ();
                    double p3X = player.getLocation().getX();
                    double p3Y = player.getLocation().getY();
                    double p3Z = player.getLocation().getZ();
                    double distance3 = sqrt(pow(b3X - p3X, 2) + pow(b3Y - p3Y, 2) + pow(b3Z - p3Z, 2));
                    Location location3 = new Location(block.getWorld(), block.getX(), block.getY(), block.getZ(), player.getLocation().getYaw(), player.getLocation().getPitch());

                    if (distance3 > 3 && currentIntelligence >= HYPE.HYPERION.getItemMeta().getPersistentDataContainer().get(ManaCost, PersistentDataType.DOUBLE)) {
                        player.teleport(location3);
                        player.playSound(location3, Sound.ENTITY_ENDERMAN_TELEPORT, 1, 1);
                        player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 1000, 5));
                        player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 100, 3));
                        player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 10, 100));
                        player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 3));
                    } else {
                        player.sendMessage("§cThere are blocks in the way!");
                        player.playSound(location3, Sound.BLOCK_BREWING_STAND_BREW, 1, 1);
                        player.addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 1000, 5));
                        player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 100, 3));
                        player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 10, 100));
                        player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 3));
                    }
                    World world = null;
                    world = player.getWorld();
                    Location l = player.getLocation();
                    player.setNoDamageTicks(20);
                    player.spawnParticle(Particle.EXPLOSION_NORMAL, l, 3);
                    player.playSound(l, Sound.ENTITY_GENERIC_EXPLODE, 0.5f, 1f);
                    for (Entity nearby : world.getNearbyEntities(l, 8d, 8d, 8d)) {
                        if (nearby instanceof LivingEntity) {
                            LivingEntity entity = (LivingEntity) nearby;
                            entity.damage(50d);
                        }
                        if (nearby instanceof EnderDragon) {
                            EnderDragon dragon = (EnderDragon) nearby;
                            dragon.setHealth(dragon.getHealth() - 20);
                            if (dragon.getHealth() < 20) {
                                dragon.setHealth(0);
                            }
                        }
                    }
                    currentIntelligence = currentIntelligence-HYPE.HYPERION.getItemMeta().getPersistentDataContainer().get(ManaCost, PersistentDataType.DOUBLE);
                } else{player.sendMessage("§cYou have not enough mana!" + currentIntelligence); }
            }
        }
    }
}

