package me.ghostdevelopment.ghostkits;

import lombok.Getter;
import lombok.Setter;
import lombok.SneakyThrows;
import me.ghostdevelopment.ghostkits.Commands.GhostCommand;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;

public final class GhostKits extends JavaPlugin {

    @Getter @Setter
    private static GhostKits instance;

    @Override
    @SneakyThrows
    public void onEnable() {

        Bukkit.getLogger().info("\n\n" +
                "  _____ _               _   _  ___ _       \n" +
                " / ____| |             | | | |/ (_) |      \n" +
                "| |  __| |__   ___  ___| |_| ' / _| |_ ___ \n" +
                "| | |_ | '_ \\ / _ \\/ __| __|  < | | __/ __|\n" +
                "| |__| | | | | (_) \\__ \\ |_| . \\| | |_\\__ \\\n" +
                " \\_____|_| |_|\\___/|___/\\__|_|\\_\\_|\\__|___/\n\n" +
                "GhostKits by GhostAndry\n");

        setInstance(this);
        registerCommands();

    }

    private void registerCommands() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String packageName = getClass().getPackage().getName();
        for(Class<? extends GhostCommand> clazz: new Reflections(packageName + ".Commands.impl").getSubTypesOf(GhostCommand.class)){
            GhostCommand command = null;

            command = clazz.getDeclaredConstructor().newInstance();

            try {
                getCommand(command.getName()).setExecutor(command);
                if(command.getTabComplete()){
                    getCommand(command.getName()).setTabCompleter(command);
                }
            } catch (Exception e) {
                Bukkit.getLogger().warning("[GhostKits] Can't load %module% module"
                        .replace("%module%", command.getName())
                );
            }
        }
    }

}
