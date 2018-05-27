package me.bungeecore.mlgrush.utils;

import me.bungeecore.mlgrush.MLGRush;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class LobbyCountdown {

    private static int countdown = 15;

    private static int TaskID = 0;

    public static void startCountdown() {
        Bukkit.getScheduler().scheduleAsyncRepeatingTask(MLGRush.instance, new Runnable() {
            public void run() {
                if (countdown != 0) {
                    countdown--;
                }

                if (countdown == 10 || countdown == 5 || countdown == 4 || countdown == 3 || countdown == 2 || countdown == 1) {
                    Bukkit.broadcastMessage(MLGRush.prefix + "§7Das Spiel beginnt in §a" + countdown + " Sekunde/n§7...");
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        
                    }
                }
            }
        }, 20, 20);
    }
}
