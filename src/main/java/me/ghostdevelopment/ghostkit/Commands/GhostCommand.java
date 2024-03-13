package me.ghostdevelopment.ghostkit.Commands;

import lombok.Getter;
import lombok.Setter;
import me.ghostdevelopment.ghostkit.Utils.Translator;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Getter @Setter
public abstract class GhostCommand extends Translator implements CommandExecutor, TabCompleter {

    private String name;
    private String permission1;
    private String permission2;
    private String permission3;
    private Boolean tabComplete;

    public GhostCommand(String name, String permission1, String permission2, String permission3, Boolean tabComplete) {
        this.name = name;
        this.permission1 = permission1;
        this.permission2 = permission2;
        this.permission3 = permission3;
        this.tabComplete = tabComplete;
    }
    public GhostCommand(String name, String permission1, String permission2, String permission3) {
        this.name = name;
        this.permission1 = permission1;
        this.permission2 = permission2;
        this.permission3 = permission3;
        this.tabComplete = false;
    }
    public GhostCommand(String name, String permission1, String permission2) {
        this.name = name;
        this.permission1 = permission1;
        this.permission2 = permission2;
        this.permission3 = null;
        this.tabComplete = false;
    }
    public GhostCommand(String name, String permission1) {
        this.name = name;
        this.permission1 = permission1;
        this.permission2 = null;
        this.permission3 = null;
        this.tabComplete = false;
    }
    public GhostCommand(String name) {
        this.name = name;
        this.permission1 = null;
        this.permission2 = null;
        this.permission3 = null;
        this.tabComplete = false;
    }
    public GhostCommand(String name, String permission1, String permission2, Boolean tabComplete) {
        this.name = name;
        this.permission1 = permission1;
        this.permission2 = permission2;
        this.permission3 = null;
        this.tabComplete = tabComplete;
    }
    public GhostCommand(String name, String permission1, Boolean tabComplete) {
        this.name = name;
        this.permission1 = permission1;
        this.permission2 = null;
        this.permission3 = null;
        this.tabComplete = tabComplete;
    }
    public GhostCommand(String name, Boolean tabComplete) {
        this.name = name;
        this.permission1 = null;
        this.permission2 = null;
        this.permission3 = null;
        this.tabComplete = tabComplete;
    }

    @Override
    public boolean onCommand(CommandSender sender, org.bukkit.command.Command command, String label, String[] args) {

        if (getPermission1() != null) {
            if (!(sender.hasPermission(getPermission1())
                    || sender.hasPermission(getPermission2())
                    || sender.hasPermission(getPermission3())
                    || sender.hasPermission("ghostkits.*")
                    || sender.hasPermission("*")
            )) {
                sender.sendMessage(translate(LangFile.getFile().getString("no-permissions")
                        .replaceAll("%prefix%", LangFile.getFile().getString("prefix"))
                ));
                return false;
            }
        }

        execute(sender, args);
        return true;
    }

    public abstract void execute(CommandSender sender, String[] args);
    public List<String> onTabComplete(CommandSender sender, org.bukkit.command.Command command, String alias, String[] args) {
        return new ArrayList<>();
    }

}
