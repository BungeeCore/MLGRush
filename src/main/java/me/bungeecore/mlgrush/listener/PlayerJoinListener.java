package me.bungeecore.mlgrush.listener;

import me.bungeecore.mlgrush.MLGRush;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        e.setJoinMessage(MLGRush.prefix + "§a" + p.getName() + " §7hat das Spiel §abetreten§7.");
        if (MLGRush.teamRed.isEmpty()) {
            MLGRush.teamRed.add(p);
        } else if (MLGRush.teamBlue.isEmpty()) {
            MLGRush.teamBlue.add(p);
        }
    }
}
