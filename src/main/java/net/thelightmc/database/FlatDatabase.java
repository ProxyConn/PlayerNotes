package net.thelightmc.database;

import net.thelightmc.Note;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * @Author TheLightMC
 */

public class FlatDatabase implements Database {

    private File file;
    public FlatDatabase(File file) {

        this.file = file;
    }


    @Override
    public void save(Collection<? extends Note> notes) throws IOException {
        FileWriter writer = new FileWriter(getFile());
        for (Note note : notes) {
            writer.write(note.getTarget() + ":" + note.getSender() + ":" + note.getContent().replaceAll(" ","|") + "\n");
        }
        writer.flush();
        writer.close();
    }

    @Override
    public Collection<? extends Note> load() {
        ArrayList<Note> notes = new ArrayList<>();
        String line;
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(getFile()));
            while ((line = br.readLine()) != null) {
                String[] split = line.split(":");
                String target = split[0];
                String sender = split[1];
                String content = split[2];
                Note note = new Note(target,content,sender);
                notes.add(note);
            }
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
        return notes;
    }

    @Override
    public DataType getType() {
        return DataType.FlatFile;
    }

    private File getFile() {
        return file;
    }
}
