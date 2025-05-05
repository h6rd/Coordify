package org.hrdq.coordify;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class CoordifyCommand implements CommandExecutor {
    private final JavaPlugin plugin;
    private final ConfigManager configManager;

    public CoordifyCommand(JavaPlugin plugin, ConfigManager configManager) {
        this.plugin = plugin;
        this.configManager = configManager;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can only be used by players!");
            return true;
        }

        Player player = (Player) sender;
        String worldName = player.getWorld().getName();
        String displayWorldName;
        String configWorldName;

        switch (worldName.toLowerCase()) {
            case "world":
                displayWorldName = "Overworld";
                configWorldName = "overworld";
                break;
            case "world_nether":
                displayWorldName = "Nether";
                configWorldName = "the_nether";
                break;
            case "world_the_end":
                displayWorldName = "End";
                configWorldName = "the_end";
                break;
            default:
                displayWorldName = worldName;
                configWorldName = worldName;
                break;
        }

        // Get coordinates
        int x = player.getLocation().getBlockX();
        int y = player.getLocation().getBlockY();
        int z = player.getLocation().getBlockZ();

        // Get colors from config
        String playerColor = configManager.getPlayerColor();
        String coordsColor = configManager.getCoordsColor();
        String textColor = configManager.getTextColor();
        String worldColor = configManager.getWorldColor(configWorldName);

        // Format message
        String message = String.format(
                "%s%s%s is at %s%d %d %d%s in the %s%s%s",
                playerColor, player.getName(), textColor,
                coordsColor, x, y, z, textColor,
                worldColor, displayWorldName, textColor
        );

        // Broadcast message to all players
        plugin.getServer().broadcastMessage(message);

        return true;
    }
}