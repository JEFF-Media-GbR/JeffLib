package com.jeff_media.jefflib.pluginhooks;

import com.jeff_media.jefflib.data.worldboundingbox.CuboidWorldBoundingBox;
import com.jeff_media.jefflib.internal.annotations.Internal;
import com.sk89q.worldedit.IncompleteRegionException;
import com.sk89q.worldedit.LocalSession;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.entity.Player;
import com.sk89q.worldedit.regions.Region;
import com.sk89q.worldedit.session.SessionManager;
import com.sk89q.worldedit.world.World;
import lombok.experimental.UtilityClass;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.util.BoundingBox;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

@Internal
@UtilityClass
final class WorldEditHandler {

    @Nullable
    public static CuboidWorldBoundingBox getCuboidSelection(final org.bukkit.entity.Player player) {
        try {
            final Region region = getSelectedRegion(player);
            final Block max = BukkitAdapter.adapt(player.getWorld(), region.getMaximumPoint()).getBlock();
            final Block min = BukkitAdapter.adapt(player.getWorld(), region.getMinimumPoint()).getBlock();
            return new CuboidWorldBoundingBox(player.getWorld(), BoundingBox.of(min, max));
        } catch (final IncompleteRegionException exception) {
            return null;
        }
    }

    private static Region getSelectedRegion(final org.bukkit.entity.Player player) throws IncompleteRegionException {
        final Player actor = BukkitAdapter.adapt(player);
        final SessionManager manager = WorldEdit.getInstance().getSessionManager();
        final LocalSession session = manager.get(actor);
        final World selectionWorld = session.getSelectionWorld();
        return session.getSelection(selectionWorld);
    }

    @Nullable
    public static List<Location> getPolygonSelection(final org.bukkit.entity.Player player) {
        try {
            final Region region = getSelectedRegion(player);
            final List<Location> points = new ArrayList<>();
            region.forEach((blockVector3) -> points.add(BukkitAdapter.adapt(player.getWorld(), blockVector3)));
            return points;
        } catch (final IncompleteRegionException exception) {
            return null;
        }
    }

}
