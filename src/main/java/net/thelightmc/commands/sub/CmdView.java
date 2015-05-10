package net.thelightmc.commands.sub;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.CommandSender;
import net.thelightmc.Note;
import net.thelightmc.commands.SubCommand;
import net.thelightmc.manager.NoteManager;

import java.util.List;

/**
 * @Author TheLightMC
 */

public class CmdView implements SubCommand {

    @Override
    public void execute(CommandSender sender, String[] args) {
        if (args.length > 1) {
            List<Note> noteList = NoteManager.getInstance().getNotesOnPlayer(args[1]);
            if (noteList.isEmpty()) {
                sender.sendMessage(ChatColor.RED + "The player " + args[1] + " has no Notes.");
                return;
            }
            int i = 1;
            for (Note note : noteList) {
                sender.sendMessage(ChatColor.GRAY.toString() + i + ". " + ChatColor.GREEN + "\""+ note.getContent() + "\" placed by " + note.getSender());
                i++;
            }
        } else {
            sender.sendMessage(ChatColor.RED + "Usage: /note view <Name>");
        }
    }

    @Override
    public String getCommand() {
        return "view";
    }

    @Override
    public String getDescription() {
        return "Views the notes on a player";
    }
}
