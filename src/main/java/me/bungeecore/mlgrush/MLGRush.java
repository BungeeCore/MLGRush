package me.bungeecore.mlgrush;

import org.bukkit.plugin.java.JavaPlugin;

public class MLGRush extends JavaPlugin {

    public static MLGRush instance;

    @Override
    public void onEnable() {
        instance = this;
    }

    @Override
    public void onDisable() {
        instance = null;
    }
}