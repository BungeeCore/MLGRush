package me.bungeecore.mlgrush;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class MLGRush extends JavaPlugin {

    public static MLGRush instance;

    public static String prefix = "§7| §9§bMLGRush §7| ";

    public static File file;
    public static FileConfiguration cfg;

    @Override
    public void onEnable() {
        instance = this;
        file = new File(instance.getDataFolder(), "locs.yml");
        cfg = YamlConfiguration.loadConfiguration(file);
    }

    @Override
    public void onDisable() {
        instance = null;
    }
}