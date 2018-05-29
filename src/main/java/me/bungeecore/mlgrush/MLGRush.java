package me.bungeecore.mlgrush;

import me.bungeecore.mlgrush.utils.GameState;
import me.bungeecore.mlgrush.utils.LobbyCountdown;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.ArrayList;

public class MLGRush extends JavaPlugin {

    public static MLGRush instance;

    public static String prefix = "§7| §9§bMLGRush §7| ";

    public static File file;
    public static FileConfiguration cfg;

    public static ArrayList<Player> teamBlue = new ArrayList<Player>();
    public static ArrayList<Player> teamRed = new ArrayList<Player>();
    public static GameState gs;

    @Override
    public void onEnable() {
        instance = this;
        gs = GameState.LOBBY;
        file = new File(instance.getDataFolder(), "locs.yml");
        cfg = YamlConfiguration.loadConfiguration(file);
        LobbyCountdown.startCountdown();
    }

    @Override
    public void onDisable() {
        instance = null;
    }
}