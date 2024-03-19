package me.ghostdevelopment.ghostkits;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class GhostKits extends JavaPlugin {

    @Override
    public void onEnable() {

        Bukkit.getLogger().info("\n\n" +
                "  _____ _               _   _  ___ _       \n" +
                " / ____| |             | | | |/ (_) |      \n" +
                "| |  __| |__   ___  ___| |_| ' / _| |_ ___ \n" +
                "| | |_ | '_ \\ / _ \\/ __| __|  < | | __/ __|\n" +
                "| |__| | | | | (_) \\__ \\ |_| . \\| | |_\\__ \\\n" +
                " \\_____|_| |_|\\___/|___/\\__|_|\\_\\_|\\__|___/\n\n" +
                "GhostKits by GhostAndry\n");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
