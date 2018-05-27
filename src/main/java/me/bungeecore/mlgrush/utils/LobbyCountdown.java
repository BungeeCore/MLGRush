package me.bungeecore.mlgrush.utils;

import me.bungeecore.mlgrush.MLGRush;
import org.bukkit.Bukkit;

public class LobbyCountdown {

    public static void startCountdown() {
        Bukkit.getScheduler().scheduleAsyncRepeatingTask(MLGRush.instance, new Runnable() {
            public void run() {

            }
        }, 20, 20);
    }
}
