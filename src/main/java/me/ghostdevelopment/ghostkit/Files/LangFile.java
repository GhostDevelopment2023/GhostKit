package me.ghostdevelopment.ghostkit.Files;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class LangFile {

    private static File file;
    private static FileConfiguration config;

    public static void setUp(){
        file = new File(Bukkit.getServer().getPluginManager().getPlugin("GhostKits").getDataFolder(), "messages.yml");
        if(!(file.exists())){
            try {
                file.createNewFile();
            }catch (IOException e){
            }
        }
        config = YamlConfiguration.loadConfiguration(file);

        add("prefix", "&5&lGhostKits &7&l>");
        add("no-perms", "%prefix% &cNo permissions.");
    }

    public static FileConfiguration getFile(){return config;}
    public static void reload(){config=YamlConfiguration.loadConfiguration(file);}
    public static void save(){
        try {
            config.save(file);
        }catch (Exception e){
            Bukkit.getLogger().config("&cCould not write on messages.yml file.");
        }
    }

    private static void add(String key, String value){
        getFile().addDefault(key, value);
    }

}
