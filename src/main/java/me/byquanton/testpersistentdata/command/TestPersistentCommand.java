package me.byquanton.testpersistentdata.command;

import me.byquanton.testpersistentdata.Testpersistentdata;
import org.bukkit.Chunk;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

import java.util.ArrayList;
import java.util.List;

public class TestPersistentCommand implements TabCompleter, CommandExecutor {

    private final Testpersistentdata plugin;

    public TestPersistentCommand(Testpersistentdata plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player player){
            if(args.length == 0){
                return false;
            }
            PersistentDataContainer persistentDataContainer = player.getLocation().getChunk().getPersistentDataContainer();
            if (args.length == 1 && args[0].equalsIgnoreCase("get")) {
                if(persistentDataContainer.has(plugin.key, PersistentDataType.STRING)){
                    player.sendMessage(persistentDataContainer.get(plugin.key, PersistentDataType.STRING));
                }else {
                    player.sendMessage("No Key Found");
                }
            }else if(args.length == 2 && args[0].equalsIgnoreCase("set")){
                persistentDataContainer.set(plugin.key,PersistentDataType.STRING, args[1]);
            }
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();
        if(args.length == 1){
            completions.add("set");
            completions.add("get");
        }
        return completions;
    }


}
