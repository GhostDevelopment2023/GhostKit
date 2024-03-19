package me.ghostdevelopment.ghostkits.Utils;

import org.bukkit.ChatColor;

public class Translator {

    protected String translate(String s){
        return ChatColor.translateAlternateColorCodes('&', s);
    }

}
