package me.ghostdevelopment.ghostkits.Files;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class KitsFile {

    private static File file;
    private static FileConfiguration config;

    public static void setUp(){
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("GhostKits").getDataFolder(), "kits.yml");
        if(!(file.exists())){
            try {
                file.createNewFile();
            }catch (IOException e){
            }
        }
        config = YamlConfiguration.loadConfiguration(file);

    }

    public static FileConfiguration getFile(){return config;}
    public static void reload(){config=YamlConfiguration.loadConfiguration(file);}
    public static void save(){
        try {
            config.save(file);
        }catch (Exception e){
            Bukkit.getLogger().config("&cCould not write on kits.yml file.");
        }
    }

    private static void add(String key, String value){
        getFile().addDefault(key, value);
    }

}
