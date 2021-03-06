package com.jeff_media.jefflib.internal.nms.v1_17_R1;

import com.jeff_media.jefflib.data.tuples.Pair;
import lombok.experimental.UtilityClass;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.dedicated.DedicatedServer;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.chunk.LevelChunk;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_17_R1.CraftServer;
import org.bukkit.craftbukkit.v1_17_R1.CraftWorld;


@UtilityClass
class NMSBiomeUtils {

    private final ResourceKey<Registry<Biome>> BIOME_REGISTRY_RESOURCE_KEY = Registry.BIOME_REGISTRY;

    Pair<String, String> getBiomeName(final Location location) {
        final ResourceLocation key = getBiomeKey(location);
        return new Pair<>(key.getNamespace(), key.getPath());
    }

    ResourceLocation getBiomeKey(final Location location) {
        final Registry<Biome> registry = getBiomeRegistry();
        return registry.getKey(getBiomeBase(location));
    }

    Registry<Biome> getBiomeRegistry() {
        final DedicatedServer dedicatedServer = ((CraftServer) Bukkit.getServer()).getServer();
        return dedicatedServer.registryAccess().registry(BIOME_REGISTRY_RESOURCE_KEY).get();
    }

    Biome getBiomeBase(final Location location) {
        final BlockPos pos = new BlockPos(location.getBlockX(), 0, location.getBlockZ());
        final LevelChunk nmsChunk = ((CraftWorld) location.getWorld()).getHandle().getChunkAt(pos);
        if (nmsChunk != null) {
            return nmsChunk.getBiomes().getNoiseBiome(pos.getX(), 0, pos.getZ());
        }
        return null;
    }
}
