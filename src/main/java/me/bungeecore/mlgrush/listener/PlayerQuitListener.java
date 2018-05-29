package me.bungeecore.mlgrush.listener;

import me.bungeecore.mlgrush.MLGRush;
import me.bungeecore.mlgrush.utils.GameState;
import me.bungeecore.mlgrush.utils.LocationAPI;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        e.setQuitMessage(MLGRush.prefix + "§a" + p.getName() + " §7hat das Spiel §cverlassen§7.");
        if (MLGRush.teamBlue.contains(p)) {
            MLGRush.teamBlue.remove(p);
        }
        if (MLGRush.teamRed.contains(p)) {
            MLGRush.teamRed.remove(p);
        }
        if (MLGRush.gs == GameState.INGAME) {
            MLGRush.gs = GameState.END;
            for (Player all : Bukkit.getOnlinePlayers()) {
                all.teleport(LocationAPI.getLocation("Spawn"));
            }
            if (MLGRush.teamBlue.contains(p)) {
                MLGRush.teamRed.get(0).sendTitle("§6Herzlichen Glückwunsch", "§6du hast gewonnen.");
            }
            if (MLGRush.teamRed.contains(p)) {
                MLGRush.teamBlue.get(0).sendTitle("§6Herzlichen Glückwunsch", "§6du hast gewonnen.");
            }
        }
    }
}
