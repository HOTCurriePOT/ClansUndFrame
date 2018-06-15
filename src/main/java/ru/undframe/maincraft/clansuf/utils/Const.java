package ru.undframe.maincraft.clansuf.utils;

public enum Const {
    commandName("clan");

    private String text;
    Const(String text){
        this.text = text;
    }
    public String getText(){
        return this.text;
    }
}
