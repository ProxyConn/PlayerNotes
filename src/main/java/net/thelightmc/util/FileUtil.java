package net.thelightmc.util;

import net.md_5.bungee.config.Configuration;
import net.md_5.bungee.config.ConfigurationProvider;
import net.md_5.bungee.config.YamlConfiguration;

import java.io.File;
import java.io.IOException;

/**
 * @Author TheLightMC
 */

public class FileUtil {
    private static String directory = "plugins/Notes/";
    public static Configuration getFile(String fileName) throws IOException {
        File file = getFile(fileName,true);
        return ConfigurationProvider.getProvider(YamlConfiguration.class).load(file);
    }
    public static File getFile(String fileName,boolean createIfNotExist) throws IOException {
        File file = new File(directory,fileName);
        if (createIfNotExist && !file.exists()) {
            boolean success = file.createNewFile();
            if (!success) {
                throw new IOException("File couldn't be created");
            }
        }
        return file;
    }
}
