package com.jeff_media.jefflib.pluginhooks;

import com.jeff_media.jefflib.PluginUtils;
import com.jeff_media.jefflib.exceptions.MissingPluginException;
import lombok.experimental.UtilityClass;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import java.util.Collection;

/**
 * WorldGuard related methods. Can be safely used even when WorldGuard is not installed, as long as you catch the {@link MissingPluginException}
 */
@UtilityClass
public class WorldGuardUtils {

    /**
     * Checks whether WorldGuard is installed and enabled
     *
     * @return true when WorldGuard is installed and enabled, otherwise false
     */
    public static boolean isWorldGuardInstalled() {
        return PluginUtils.isInstalledAndEnabled("WorldGuard");
    }

    /**
     * Checks whether a location is inside a region of the given name/id
     * <p>
     * Example Usage:
     *
     * <pre>
     *     if(WorldGuardUtils.isInsideRegion(player.getLocation(), "my-region") {
     *         System.out.println("The player is inside the region \"my-region\"!");
     *     }
     * </pre>
     *
     * @param location   Location to check
     * @param regionName Name of the region to check
     * @return true when the location is inside the given region, otherwise false
     * @throws MissingPluginException exception
     */
    public static boolean isInsideRegion(final Location location, final String regionName) throws MissingPluginException {
        try {
            return getRegionsAtLocation(location).contains(regionName);
        } catch (final Throwable t) {
            throw new MissingPluginException("WorldGuard");
        }
    }

    /**
     * Gets a collection of all region names at a specific location
     *
     * @param location Location to check
     * @return Collection of all region names at this location
     * @throws MissingPluginException exception
     */
    @Nonnull
    public static Collection<String> getRegionsAtLocation(final Location location) throws MissingPluginException {
        try {
            return WorldGuardHandler.getRegionsAtLocation(location);
        } catch (final Throwable t) {
            throw new MissingPluginException("WorldGuard");
        }
    }

    public static boolean canPlace(@Nonnull final Player player, @Nonnull final Location location) throws MissingPluginException {
        try {
            return WorldGuardHandler.canPlace(player, location);
        } catch (final Throwable t) {
            throw new MissingPluginException("WorldGuard");
        }
    }

    public static boolean canInteract(@Nonnull final Player player, @Nonnull final Location location) throws MissingPluginException {
        try {
            return WorldGuardHandler.canInteract(player, location);
        } catch (final Throwable t) {
            throw new MissingPluginException("WorldGuard");
        }
    }

    public static boolean canBreak(@Nonnull final Player player, @Nonnull final Location location) throws MissingPluginException {
        try {
            return WorldGuardHandler.canBreak(player, location);
        } catch (final Throwable t) {
            throw new MissingPluginException("WorldGuard");
        }
    }
}
