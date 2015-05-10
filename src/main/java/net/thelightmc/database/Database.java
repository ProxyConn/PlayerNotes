package net.thelightmc.database;

import net.thelightmc.Note;
/**
 * @Author TheLightMC
 */
import java.io.IOException;
import java.util.Collection;

public interface Database {
    void save(Collection<? extends Note> note) throws IOException;
    Collection<? extends Note> load();
    DataType getType();
    enum DataType {
        MySQL,FlatFile;
    }
}
