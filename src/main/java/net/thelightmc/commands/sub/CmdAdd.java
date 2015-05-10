package net.thelightmc.commands.sub;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.thelightmc.Note;
import net.thelightmc.commands.SubCommand;
import net.thelightmc.manager.NoteManager;

/**
 * @Author TheLightMC
 */
public class CmdAdd implements SubCommand {
    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length > 2) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int i = 2; i < args.length; i++) {
                stringBuilder.append(args[i]);
            }
            Note note = new Note(args[1],stringBuilder.toString(),sender.getName());
            sender.sendMessage(ChatColor.GREEN + "You have added a note to " + args[1]);
            NoteManager.getInstance().addNote(note);
        } else {
            sender.sendMessage(ChatColor.RED + "Usage: /note add <Player> <Text>");
        }
    }

    @Override
    public String getCommand() {
        return "add";
    }

    @Override
    public String getDescription() {
        return "Adds a note on a player";
    }
}
