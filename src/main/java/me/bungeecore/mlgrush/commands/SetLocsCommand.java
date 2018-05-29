package me.bungeecore.mlgrush.commands;

import me.bungeecore.mlgrush.MLGRush;
import me.bungeecore.mlgrush.utils.LocationAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetLocsCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (p.hasPermission("mlgrush.admin.use")) {
                if (args.length >= 0 && args.length != 1) {
                    p.sendMessage(MLGRush.prefix + "§c/setlocs spawn §8- §7Setzte den Spawn für die Wartelobby.");
                    p.sendMessage(MLGRush.prefix + "§c/setlocs blue §8- §7Setze den Spawn für §9Team Blau§7.");
                    p.sendMessage(MLGRush.prefix + "§c/setlocs red §8- §7Setze den Spawn für §cTeam Rot§7.");
                    p.sendMessage(MLGRush.prefix + "§c/setlocs deathHigh §8- §7Setze die Höhe wo man zum Anfang teleportiert wird.");
                }
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("spawn")) {
                        LocationAPI.setLocation(p, "Spawn");
                        p.sendMessage(MLGRush.prefix + "§7Du hast §aerfolgreich §7den Spawn für die Wartelobby §agesetzt§7!");
                    }
                    if (args[0].equalsIgnoreCase("blue")) {
                        LocationAPI.setLocation(p, "spawn_Blue");
                        p.sendMessage(MLGRush.prefix + "§7Du hast §aerfolgreich §7den Spawn für §9Team Blau §agesetzt§7!");
                    }
                    if (args[0].equalsIgnoreCase("red")) {
                        LocationAPI.setLocation(p, "spawn_Red");
                        p.sendMessage(MLGRush.prefix + "§7Du hast §aerfolgreich §7den Spawn für §cTeam Rot §agesetzt§7!");
                    }
                    if (args[0].equalsIgnoreCase("deathHigh")) {
                        LocationAPI.setHigh(p, "deathHigh");
                        p.sendMessage(MLGRush.prefix + "§7Du hast §aerfolgreich §7die Todeshöhe §agesetzt§7!");
                    }
                }
            } else {
                p.sendMessage(MLGRush.prefix + "§cDu hast keine Rechte auf diesen Befehl!");
            }
        } else {
            sender.sendMessage(MLGRush.prefix + "§cDu musst dafür ein Spieler sein!");
        }

        return false;
    }
}
