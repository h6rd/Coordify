package org.hrdq.coordify;

import org.bukkit.plugin.java.JavaPlugin;

public class CoordifyPlugin extends JavaPlugin {
    private ConfigManager configManager;

    @Override
    public void onEnable() {
        // Initialize configuration
        configManager = new ConfigManager(this);
        configManager.loadConfig();

        // Register command
        getCommand("coords").setExecutor(new CoordifyCommand(this, configManager));
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}