package me.ghostdevelopment.ghostkits.Utils;

import me.ghostdevelopment.ghostkits.Files.LangFile;

public enum Language {

    PREFIX("prefix"),
    NOPERMS("no-perms")
    ;

    String message_path;
    Language(String message_path){
        this.message_path = message_path;
    }

    @Override
    public String toString() {
        return LangFile.getFile().getString(message_path);
    }

}
