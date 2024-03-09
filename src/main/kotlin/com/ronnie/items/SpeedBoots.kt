package com.ronnie.items

import com.ronnie.armor.SpeedArmorMaterial
import net.minecraft.item.ArmorItem
import net.minecraft.item.Item


object SpeedBoots {
    const val name = "speed_boots"
    val item = SpeedArmorItem(
        SpeedArmorMaterial(),
        ArmorItem.Type.BOOTS,
        Item.Settings().fireproof()
    )
}

