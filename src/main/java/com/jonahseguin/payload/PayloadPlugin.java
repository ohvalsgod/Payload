package com.jonahseguin.payload;

import java.net.InetAddress;

import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by Jonah on 11/16/2017.
 * Project: Payload
 *
 * @ 6:44 PM
 *
 * This class is just here so that Payload can be used as a dependency via
 * loaded plugin instead of being shaded.
 *
 * Also provides some utility methods.
 */
public class PayloadPlugin extends JavaPlugin {

    private static PayloadPlugin instance = null;

    public static String format(String s, String... args) {
        if (args != null) {
            if (args.length > 0) {
                for (int i = 0; i < args.length; i++) {
                    if (s.contains("{" + i + "}")) {
                        s = s.replace("{" + i + "}", args[i]);
                    }
                }
            }
        }

        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static String getIP(InetAddress inetAddress) {
        return inetAddress.toString().split("/")[1];
    }

    public static void runASync(Plugin plugin, Runnable runnable) {
        plugin.getServer().getScheduler().runTaskAsynchronously(plugin, runnable);
    }

    public static PayloadPlugin get() {
        return instance;
    }

    @Override
    public void onEnable() {
        PayloadPlugin.instance = this;
        getLogger().info(PayloadPlugin.format("Payload v{0} by Jonah Seguin enabled.", PayloadPlugin.get().getDescription().getVersion()));
    }

    @Override
    public void onDisable() {
        getLogger().info(PayloadPlugin.format("Payload v{0} by Jonah Seguin disabled.", PayloadPlugin.get().getDescription().getVersion()));
        PayloadPlugin.instance = null;
    }
}