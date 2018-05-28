package me.bungeecore.mlgrush.utils;

import me.bungeecore.mlgrush.MLGRush;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class LobbyCountdown {

    private static int countdown = 15;

    private static int TaskID = 0;

    public static void startCountdown() {
        Bukkit.getScheduler().scheduleAsyncRepeatingTask(MLGRush.instance, new Runnable() {
            public void run() {
                if (Bukkit.getOnlinePlayers().size() == 2) {
                    if (countdown != 0) {
                        countdown--;
                    }
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.setLevel(countdown);
                        all.setExp((float) countdown / 15);
                    }
                } else {
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        ActionBar.sendActionBar(all, "§8§l» §cWarte auf weitere Spieler...");
                        countdown = 15;
                    }
                }

                if (countdown == 10 || countdown == 5 || countdown == 4 || countdown == 3 || countdown == 2 || countdown == 1) {
                    Bukkit.broadcastMessage(MLGRush.prefix + "§7Das Spiel beginnt in §a" + countdown + " Sekunde/n§7...");
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        all.playSound(all.getLocation(), Sound.NOTE_BASS, 3, 3);
                    }
                }
                if (countdown == 0) {

                }
            }
        }, 20, 20);
    }
}
