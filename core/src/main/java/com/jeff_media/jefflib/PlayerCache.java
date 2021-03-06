package com.jeff_media.jefflib;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.YamlConfiguration;

import javax.annotation.Nonnull;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * Caches player names, UUIDs, Skins, etc.
 *
 * @deprecated Draft API. Will be using async loading / saving and maybe SQLite
 */
@Deprecated
public final class PlayerCache {

    private static final File cacheFile;
    private static final YamlConfiguration cache;

    static {
        cacheFile = new File(JeffLib.getPlugin().getDataFolder(), "playercache.yml");
        cache = YamlConfiguration.loadConfiguration(cacheFile);
    }

    public static String getName(final UUID uuid) {
        return getName(Bukkit.getOfflinePlayer(uuid));
    }

    @Nonnull
    public static String getName(final OfflinePlayer player) {
        final String name = player.getName();
        if (name != null) {
            cache.set(player.getUniqueId().toString(), name);
            return name;
        }
        return cache.getString(player.getUniqueId().toString(), "Unknown Player (" + player.getUniqueId().toString().split("-")[0] + ")");
    }

    public static void save() {
        try {
            cache.save(cacheFile);
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }
}
