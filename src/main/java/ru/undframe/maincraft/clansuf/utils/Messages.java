package ru.undframe.maincraft.clansuf.utils;

public enum Messages {
    PexError("&cУ вас нет прав на эту команду"),
    cmdError("&cВо время выполнения команды произошла ошибка. %n%&7Используйте команду %n% / clan [] []")
    ;
    private String name;
    Messages(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
