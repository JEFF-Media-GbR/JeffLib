package com.jeff_media.jefflib.pluginhooks;

import com.jeff_media.jefflib.PDCUtils;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;

/**
 * mcMMO related methods
 */
public final class McMMOUtils {

    private static final NamespacedKey SUPER_ABILITY_KEY = NamespacedKey.fromString("mcmmo:super_ability_boosted");

    public static void removeSuperAbilityBoost(final ItemStack item) {
        if (item == null || !item.hasItemMeta()) return;
        if (!McMMOUtils.isSuperAbilityBoosted(item)) return;
        final int originalLevel = McMMOUtils.getSuperAbilityBoostedOriginalLevel(item);
        setEfficiency(item, originalLevel);
        PDCUtils.remove(item, SUPER_ABILITY_KEY);
    }

    public static boolean isSuperAbilityBoosted(final ItemStack itemStack) {
        if (itemStack == null || !itemStack.hasItemMeta()) return false;
        return PDCUtils.has(itemStack, SUPER_ABILITY_KEY, PersistentDataType.INTEGER);
    }

    public static int getSuperAbilityBoostedOriginalLevel(final ItemStack itemStack) {
        if (itemStack == null || !itemStack.hasItemMeta()) return 0;
        return PDCUtils.getOrDefault(itemStack, SUPER_ABILITY_KEY, PersistentDataType.INTEGER, 0);
    }

    private static void setEfficiency(final ItemStack item, final int originalLevel) {
        final ItemMeta meta = item.getItemMeta();
        if (meta == null) return;
        meta.removeEnchant(Enchantment.DIG_SPEED);
        if (originalLevel != 0) {
            meta.addEnchant(Enchantment.DIG_SPEED, originalLevel, true);
        }
        item.setItemMeta(meta);
    }

}
