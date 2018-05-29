package me.bungeecore.mlgrush.utils;

import me.bungeecore.mlgrush.MLGRush;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class LocationAPI {

    public static void setLocation(Player p, String loc) {
        MLGRush.cfg.set(loc + ".World" , p.getWorld().getName());
        MLGRush.cfg.set(loc + ".X", p.getLocation().getX());
        MLGRush.cfg.set(loc + ".Y", p.getLocation().getY());
        MLGRush.cfg.set(loc + ".Z", p.getLocation().getZ());
        MLGRush.cfg.set(loc + ".Yaw", p.getLocation().getYaw());
        MLGRush.cfg.set(loc + ".Pitch", p.getLocation().getPitch());

        try {
            MLGRush.cfg.save(MLGRush.file);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Location getLocation(String loc) {
        World world = Bukkit.getWorld(MLGRush.cfg.getString(loc + ".World"));
        double x = MLGRush.cfg.getDouble(loc + ".X");
        double y = MLGRush.cfg.getDouble(loc + ".Y");
        double z = MLGRush.cfg.getDouble(loc + ".Z");
        float yaw = (float) MLGRush.cfg.getDouble(loc + ".Yaw");
        float pitch = (float) MLGRush.cfg.getDouble(loc + ".Pitch");

        Location location = new Location(world, x, y, z, yaw, pitch);
        return location;
    }

    public static void setHigh(Player p, String high) {
        MLGRush.cfg.set(high + ".Y", p.getLocation().getY());

        try {
            MLGRush.cfg.save(MLGRush.file);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static int getHigh(String high) {
        int high1 = MLGRush.cfg.getInt(high + ".Y");
        return high1;
    }
}
