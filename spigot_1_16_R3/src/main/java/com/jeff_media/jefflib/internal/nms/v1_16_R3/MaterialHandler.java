package com.jeff_media.jefflib.internal.nms.v1_16_R3;

import com.jeff_media.jefflib.internal.NMSReflUtils;
import com.jeff_media.jefflib.internal.nms.AbstractNMSMaterialHandler;
import net.minecraft.server.v1_16_R3.Item;
import org.bukkit.Material;
import org.bukkit.craftbukkit.v1_16_R3.util.CraftMagicNumbers;

class MaterialHandler implements AbstractNMSMaterialHandler {
    private static final String ITEM_MAXSTACKSIZE_FIELD = "maxStackSize";

    @Override
    public void setMaxStackSize(final Material material, final int maxStackSize) {
        NMSReflUtils.setField(Item.class, CraftMagicNumbers.getItem(material), ITEM_MAXSTACKSIZE_FIELD, maxStackSize);
    }
}
