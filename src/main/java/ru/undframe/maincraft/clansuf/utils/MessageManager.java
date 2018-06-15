package ru.undframe.maincraft.clansuf.utils;

import org.bukkit.ChatColor;

import java.util.HashMap;


public class MessageManager {
    private HashMap<String,String> messages = new HashMap<>();
    private CustomConfig message;
    
    public MessageManager(CustomConfig message){
        this.message = message;
    }

    

    public void saveAll(){
        for(Messages msg : Messages.values()){
            if(message.getCfg().contains(msg.name())){
                messages.put(msg.name(),message.getCfg().getString(msg.name()));
            }else{
                message.getCfg().set(msg.name(),msg.getName());
                messages.put(msg.name(),msg.getName());
            }

        }
        message.saveCfg();
    }

    public void reloadMsgeAll(){
        for(Messages msg : Messages.values()){
            message.getCfg().set(msg.name(),msg.getName());
            messages.put(msg.name(),msg.getName());
        }
        message.saveCfg();
    }

    public String getMessage(Messages msg){
        String s = messages.get(msg.name());
        s = ChatColor.translateAlternateColorCodes('&',s);
        s = s.replaceAll("%n%", System.getProperty("line.separator").replaceAll("\r", ""));
        return s;
    }

    public String getMessage(Messages msg,String... replace){
        String s = messages.get(msg.name());
        s = ChatColor.translateAlternateColorCodes('&',s);
        s = formet(s,replace);
        s = s.replaceAll("%n%", System.getProperty("line.separator").replaceAll("\r", ""));
        return s;
    }
    

    private String formet(String s,String... replace){
        for(int i = 0;i<replace.length;i+=2){
            if(i+1<replace.length)
                s = s.replaceAll("%"+replace[i]+"%", replace[i + 1]);
        }
        return s;
    }
    

}
