package net.thelightmc.manager;

import net.thelightmc.Note;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author TheLightMC
 */
public class NoteManager {
    private final static NoteManager instance = new NoteManager();
    private static ArrayList<Note> noteList = new ArrayList<>();
    public static NoteManager getInstance() {
        return instance;
    }
    private NoteManager() {}
    public ArrayList<Note> getNoteList() {
        return noteList;
    }

    public List<Note> getNotesOnPlayer(String arg) {
        List<Note> noteList = new ArrayList<>();
        for (Note note : getNoteList()) {
            if (note.getTarget().equalsIgnoreCase(arg)) {
                noteList.add(note);
            }
        }
        return noteList;
    }

    public void addNote(Note note) {
        noteList.add(note);
    }
}
