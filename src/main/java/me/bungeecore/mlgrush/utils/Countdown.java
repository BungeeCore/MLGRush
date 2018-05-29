package me.bungeecore.mlgrush.utils;

import me.bungeecore.mlgrush.MLGRush;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class Countdown {

    private static int countdown = 15;

    private static int TaskID = 0;

    public static void startCountdown() {
        TaskID = Bukkit.getScheduler().scheduleAsyncRepeatingTask(MLGRush.instance, new Runnable() {
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
                    for (Player all : MLGRush.teamBlue) {
                        all.teleport(LocationAPI.getLocation("spawn_Blue"));
                    }
                    for (Player all : MLGRush.teamRed) {
                        all.teleport(LocationAPI.getLocation("spawn_Red"));
                    }
                    Bukkit.broadcastMessage(MLGRush.prefix + "§7Lass die Spiele beginnen.");
                    countdown = 15;
                    MLGRush.gs = GameState.INGAME;
                }
                if (MLGRush.gs != GameState.LOBBY) {
                    if (Bukkit.getScheduler().isCurrentlyRunning(TaskID)) {
                        Bukkit.getScheduler().cancelTask(TaskID);
                    }
                }
            }
        }, 20, 20);
    }
}
