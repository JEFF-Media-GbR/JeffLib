package com.jeff_media.jefflib;

import org.bukkit.Bukkit;
import org.bukkit.World;

import javax.annotation.Nonnull;
import java.util.Objects;

/**
 * World related methods
 */
public final class WorldUtils {

    private static final boolean HAS_WORLD_MIN_HEIGHT_METHOD;

    static {
        boolean tmpHasWorldMinHeightMethod = false;
        try {
            if (World.class.getMethod("getMinHeight") != null) {
                tmpHasWorldMinHeightMethod = true;
            }
        } catch (NoSuchMethodException ignored) {

        }
        HAS_WORLD_MIN_HEIGHT_METHOD = tmpHasWorldMinHeightMethod;
    }

    /**
     * Gets the default world
     *
     * @nms
     */
    public static @Nonnull World getDefaultWorld() {
        return Objects.requireNonNull(Bukkit.getWorld(getDefaultWorldName()));
    }

    /**
     * Gets the default world name
     *
     * @nms
     */
    public static @Nonnull String getDefaultWorldName() {
        return JeffLib.getNMSHandler().getDefaultWorldName();
    }

    /**
     * Sets the full game time for a world without calling {@link org.bukkit.event.world.TimeSkipEvent}
     */
    public static void setFullTimeWithoutTimeSkipEvent(@Nonnull final World world, final long time, final boolean notifyPlayers) {
        JeffLib.getNMSHandler().setFullTimeWithoutTimeSkipEvent(world, time, notifyPlayers);
    }

    /**
     * Gets the lowest possible building height for a world. It's the same as {@link World#getMinHeight()} but also works on 1.16.4 and earlier
     */
    public static int getWorldMinHeight(final @Nonnull World world) {
        return HAS_WORLD_MIN_HEIGHT_METHOD ? world.getMinHeight() : 0;
    }
}
