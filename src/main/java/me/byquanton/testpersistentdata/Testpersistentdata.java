package me.byquanton.testpersistentdata;

import me.byquanton.testpersistentdata.command.TestPersistentCommand;
import org.bukkit.NamespacedKey;
import org.bukkit.plugin.java.JavaPlugin;

public final class Testpersistentdata extends JavaPlugin {

    public NamespacedKey key = new NamespacedKey(this,"data");

    @Override
    public void onEnable() {
        TestPersistentCommand testPersistentCommand = new TestPersistentCommand(this);
        this.getServer().getPluginCommand("testpersistent").setExecutor(testPersistentCommand);
        this.getServer().getPluginCommand("testpersistent").setTabCompleter(testPersistentCommand);
    }

    @Override
    public void onDisable() {

    }
}
