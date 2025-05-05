![Coordify Logo](.images/banner-git.png)

<div align="center">
  
  <a href="https://www.minecraft.net/"><img src="https://img.shields.io/badge/Minecraft-1.21.5-brightgreen" alt="Minecraft Version"></a>
  <a href="https://papermc.io/"><img src="https://img.shields.io/badge/Server-PaperMC-orange" alt="Server"></a>
  <a href="https://modrinth.com/plugin/coordify"><img src="https://img.shields.io/badge/Download-Modrinth-00AF5C" alt="Modrinth"></a>
</div>

# Coordify
A lightweight PaperMC plugin that broadcasts a player's coordinates in chat using the `/coords` command. Perfect for survival servers where players want to share their location with customizable colors.

## Features 
- Customizable colors for player name, coordinates, and world via `config.yml`
- Supports Overworld, Nether, and End
- Minimal resource usage

> **Note**: Avoid using `/reload` as it may cause errors (e.g., `ConcurrentModificationException`). Always restart the server to apply changes to `config.yml`.

## ⚙️ Configuration
Edit `plugins/Coordify/config.yml` to customize colors for the `/coords` output:
```yaml
colors:
  player: "§b"          # Color for player's name
  coords: "§a"          # Color for X, Y, Z coordinates
  text: "§7"            # Color for "is at" and "in the"
  worlds:
    overworld: "§2"     # Color for Overworld
    nether: "§4"        # Color for Nether
    end: "§e"           # Color for End
```
Restart the server after editing to apply changes.

## 🛠️ Supported Versions
- **PaperMC**: 1.21-1.21.5 (recommended: 1.21.5)
- **Spigot**: Likely compatible, but PaperMC is preferred for optimizations
- **Unsupported**: Vanilla Minecraft, Forge, Fabric

For older versions (e.g., 1.13–1.20), set `api-version: 1.13` in `plugin.yml` and test compatibility.

## 📦 Building from Source
### Requirements
- Java 17+
- Maven

### Steps
```bash
git clone https://github.com/h6rd/coordify.git
cd coordify
mvn clean package -Pmc-1.21.5
```
The compiled `Coordify-1.0.jar` will be in the `target` folder.

## 📜 License
[MIT License](LICENSE) - Free to use, modify, and distribute.

## 🐛 Issues
Found a bug or have a feature request? Open an issue on [GitHub](https://github.com/h6rd/coordify/issues).
