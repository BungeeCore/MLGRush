package me.bungeecore.mlgrush;

import org.bukkit.plugin.java.JavaPlugin;

public class MLGRush extends JavaPlugin {

    public static MLGRush instance;

    public static String prefix = "§7| §9§bMLGRush §7| ";

    @Override
    public void onEnable() {
        instance = this;
    }

    @Override
    public void onDisable() {
        instance = null;
    }
}