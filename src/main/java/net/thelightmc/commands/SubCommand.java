package net.thelightmc.commands;

import net.md_5.bungee.api.CommandSender;

/**
 * @Author TheLightMC
 */
public interface SubCommand {
    void execute(CommandSender sender,String[] args);
    String getCommand();
    String getDescription();
}
