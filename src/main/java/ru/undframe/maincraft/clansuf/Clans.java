package ru.undframe.maincraft.clansuf;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import ru.undframe.maincraft.clansuf.api.ClansAPI;
import ru.undframe.maincraft.clansuf.commands.Commands;
import ru.undframe.maincraft.clansuf.utils.Const;
import ru.undframe.maincraft.clansuf.utils.CustomConfig;
import ru.undframe.maincraft.clansuf.utils.MessageManager;
import ru.undframe.maincraft.clansuf.utils.Messages;

import java.util.HashMap;
import java.util.Map;

public class Clans extends JavaPlugin implements ClansAPI {
    /**
     * Подкоманды
     * /cmd String
     * String - строка подкоманды
     * Commands - inteface обработка команды
     */
    private Map<String,Commands>  listCommand = new HashMap<>();
    /**
     * YML Файл  в котором хронятся сообщения.
     */
    private CustomConfig message = new CustomConfig(this, "message", false);
    /**
     * Menager для управления редактированием сообщений
     */
    private MessageManager manager = new MessageManager(this.message);

    /**
     * Метод при запуске плагина
     */
    @Override
    public void onEnable(){
        new MessageManager(this.message).saveAll();
        //TODO Включение плагина
    }

    /**
     * Вызывается при выключении(завершение работы сервера) плагина
     */
    @Override
    public void onDisable(){
        //TODO выключение плагина
    }

    /**
     *
     * @param sender кто отправил команду
     * @param command команда
     * @param args апрументы
     *
     * Главная команда плагина.
     */
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String cmd = command.getName();

        if(args.length==0){
            return true;
        }
        boolean error = false;
        String subCommand = args[0]!=null ? args[0] : null;
        if(cmd.equals(Const.commandName.getText())){
            error =  !(listCommand.containsKey(subCommand) && listCommand.get(subCommand).onCommand(sender, args));
        }
        if(error){
            sender.sendMessage(this.manager.getMessage(Messages.cmdError));
        }
        return true;
    }


}
