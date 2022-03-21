package me.lavarite.pluginsb.Items.Commands;

import me.lavarite.pluginsb.Items.ItemStorage.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class ItemCommands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("LOL IMAGINE DOING THIS!!1!");
        }
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (cmd.getName().equalsIgnoreCase("giveItem")) {
                if (args.length == 1) {
                    switch (args[0]) {
                        case ("aspectofthe"): {
                            player.getInventory().addItem(AOTE.ASPECT_OF_THE_END, AOTV.ASPECT_OF_THE_VOID, AOTM.MODIFIED_ASPECT_OF_THE_VOID);
                            break;
                        }
                        case ("goldorset"): {
                            player.getInventory().addItem(GoldorBoots.GOLDOR_BOOTS, GoldorChestplate.GOLDOR_CHEST, GoldorLeggings.GOLDOR_LEGS, GoldorBoots.GOLDOR_BOOTS);
                            break;
                        }
                        case ("stormset"): {
                            player.getInventory().addItem(StormHelmet.STORM_HELM, StormChestplate.STORM_CHEST, StormLeggings.STORM_LEGS, StormBoots.STORM_BOOTS);
                            break;
                        }
                        case ("necronset"): {
                            player.getInventory().addItem(NecronHelmet.NECRON_HELM, NecronChestplate.NECRON_CHEST, NecronLeggings.NECRON_LEGS, NecronBoots.NECRON_BOOTS);
                            break;
                        }
                        case ("lordset"): {
                            player.getInventory().addItem(LordHelmet.LORD_HELM, LordChestplate.LORD_CHEST, LordLeggings.LORD_LEGS, LordBoots.LORD_BOOTS);
                            break;
                        }
                        default: {
                            player.sendMessage("Don't be making up items now");
                        }
                    }
                }
            }
        }
        return true;
    }
}
