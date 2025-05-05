package org.hrdq.coordify;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class ConfigManager {
    private final JavaPlugin plugin;
    private FileConfiguration config;

    public ConfigManager(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void loadConfig() {
        plugin.saveDefaultConfig();
        config = plugin.getConfig();
    }

    public String getPlayerColor() {
        return config.getString("colors.player", "§b");
    }

    public String getCoordsColor() {
        return config.getString("colors.coords", "§a");
    }

    public String getTextColor() {
        return config.getString("colors.text", "§7");
    }

    public String getWorldColor(String worldName) {
        switch (worldName.toLowerCase()) {
            case "overworld":
                return config.getString("colors.worlds.overworld", "§2");
            case "the_nether":
                return config.getString("colors.worlds.nether", "§4");
            case "the_end":
                return config.getString("colors.worlds.end", "§e");
            default:
                return "§f"; // Default color for unknown worlds
        }
    }
}