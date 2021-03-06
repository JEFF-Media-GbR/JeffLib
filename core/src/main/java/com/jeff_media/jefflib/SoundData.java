package com.jeff_media.jefflib;

import com.google.common.base.Enums;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Locale;
import java.util.Objects;

// TODO: Test whether something broke after switching from Sound to String

/**
 * Data class to wrap all information needed to play a sound
 */
@Data
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public final class SoundData {

    /**
     *
     */
    private final String sound;
    private float volume = 1;
    private float pitch = 1;
    private float pitchVariant;
    private SoundCategory soundCategory = SoundCategory.MASTER;

    /**
     * Parses a {@link ConfigurationSection} into a {@link SoundData} object.
     * <p>
     * <b>Example:</b>
     * <pre>
     * SoundData sound = SoundData.fromConfigurationSection(getConfig().getConfigurationSection("my_sound",null);
     * </pre>
     * <p>
     * <b>Example YAML:</b>
     * <pre>
     * my_sound:
     *  sound: AMBIENT_CAVE    # case insensitive for builtin sounds, CaSe SeNsItIvE for custom sounds
     *  volume: 0.5            # optional, default 1
     *  pitch: 1.5             # optional, default 1
     *  pitch-variant: 0.5     # optional, default 0. If this is set to 0.5, and pitch is set to 1.5, the sound will play with a pitch between 1 and 2
     *  sound-category: MASTER # optional, case insensitive, default MASTER
     *  </pre>
     *
     * @param config ConfigurationSection to parse
     * @param prefix Prefix to use when looking up values in the ConfigurationSection. If non-null, this prefix is prefixed to all keys. For example, if this is set to "foo-", then the keys to look up are "foo-sound", "foo-volume", etc.
     * @throws IllegalArgumentException When no sound is defined, or if the sound category is not valid.
     */
    public static SoundData fromConfigurationSection(@Nonnull final ConfigurationSection config, @Nullable String prefix) throws IllegalArgumentException {
        if (prefix == null) prefix = "";
        String soundName = config.getString(prefix + "effect");
        if (soundName == null || soundName.isEmpty()) {
            throw new IllegalArgumentException("No sound effect defined");
        }
        final Sound sound = Enums.getIfPresent(Sound.class, soundName.toUpperCase(Locale.ROOT)).orNull();
        if (sound != null) {
            soundName = sound.name();
        }
        final float volume = (float) config.getDouble(prefix + "volume", 1.0D);
        final float pitch = (float) config.getDouble(prefix + "pitch", 1.0D);
        final float pitchVariant = (float) config.getDouble(prefix + "pitch-variant", 1.0D);
        final String soundCategoryName = config.getString(prefix + "sound-category", SoundCategory.MASTER.name()).toUpperCase(Locale.ROOT);
        final SoundCategory soundCategory = Enums.getIfPresent(SoundCategory.class, soundCategoryName.toUpperCase()).orNull();
        if (soundCategory == null) {
            throw new IllegalArgumentException("Unknown sound category: " + soundCategoryName);
        }

        return new SoundData(soundName, volume, pitch, pitchVariant, soundCategory);
    }

    /**
     * Plays the sound only to the given player
     *
     * @param player Player
     */
    public void playToPlayer(final Player player) {
        player.playSound(player.getLocation(), sound, soundCategory, volume, getFinalPitch());
    }

    private float getFinalPitch() {
        return (float) (pitch - (pitchVariant / 2) + JeffLib.getThreadLocalRandom().nextDouble(0, pitchVariant));
    }

    /**
     * Plays the sound only to the given player, at the given location
     *
     * @param player   Player
     * @param location Location
     */
    public void playToPlayer(final Player player, final Location location) {
        player.playSound(location, sound, soundCategory, volume, getFinalPitch());
    }

    /**
     * Plays the sound to all players in the world, at the given location
     *
     * @param location Location
     */
    public void playToWorld(final Location location) {
        Objects.requireNonNull(location.getWorld()).playSound(location, sound, soundCategory, volume, getFinalPitch());
    }

}

