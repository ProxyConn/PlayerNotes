package net.thelightmc;

import net.md_5.bungee.api.plugin.Plugin;
import net.thelightmc.commands.CmdNote;
import net.thelightmc.commands.sub.CmdAdd;
import net.thelightmc.commands.sub.CmdView;
import net.thelightmc.database.Database;
import net.thelightmc.database.FlatDatabase;
import net.thelightmc.manager.NoteManager;
import net.thelightmc.util.FileUtil;

import java.io.IOException;

/**
 * @Author TheLightMC
 */
public class Notes extends Plugin {
    Database database;
    @Override
    public void onEnable() {
        getProxy().getPluginManager().registerCommand(this,new CmdNote(new CmdAdd(),new CmdView()));
        try {
            database = new FlatDatabase(FileUtil.getFile("notes.txt",true));
        } catch (IOException e) {
            e.printStackTrace();
        }
        NoteManager.getInstance().getNoteList().addAll(database.load());
    }

    @Override
    public void onDisable() {
        try {
            database.save(NoteManager.getInstance().getNoteList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
