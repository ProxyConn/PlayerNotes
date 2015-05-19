package net.thelightmc.commands;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.md_5.bungee.api.ProxyServer;
import net.md_5.bungee.api.connection.ProxiedPlayer;
import net.md_5.bungee.api.plugin.Command;
import net.md_5.bungee.api.plugin.TabExecutor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/**
 * @Author TheLightMC
 */
public class CmdNote extends Command implements TabExecutor {
    private ArrayList<SubCommand> subCommandList = new ArrayList<>();
    public CmdNote(SubCommand... subCommands) {
        super("note", "Notes.note");
        subCommandList.addAll(Arrays.asList(subCommands));
    }

    @Override
    public void execute(CommandSender commandSender, String[] strings) {
        if (strings.length > 0) {
            for (SubCommand command : subCommandList) {
                if (strings[0].equalsIgnoreCase(command.getCommand())) {
                    command.execute(commandSender,strings);
                    return;
                }
            }
            commandSender.sendMessage(ChatColor.RED + "That is not a valid sub-command.");
        } else {
            for (SubCommand subCommand : subCommandList) {
                commandSender.sendMessage(ChatColor.GREEN + "/note " + subCommand.getCommand() + " " + ChatColor.YELLOW + subCommand.getDescription());
            }
        }
    }

    @Override
    public Iterable<String> onTabComplete(CommandSender commandSender, String[] strings) {
        HashSet<String> hashSet = new HashSet<>();
        if (strings.length == 0) {
            for (SubCommand subCommand : subCommandList) {
                hashSet.add(subCommand.getCommand());
            }
        } else {
            for (ProxiedPlayer player : ProxyServer.getInstance().getPlayers()) {
                hashSet.add(player.getName());
            }
        }
        return hashSet;
    }
}
