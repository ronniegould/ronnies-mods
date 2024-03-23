package com.ronnie.items

import com.ronnie.armor.SpeedArmorMaterial
import net.minecraft.item.ArmorItem
import net.minecraft.item.Item


object SpeedArmour {
    const val name = "speed_boots"
    val item = SpeedArmorItem(
        SpeedArmorMaterial(),
        ArmorItem.Type.BOOTS,
        Item.Settings().fireproof()
    )

    const val legsName = "speed_leggings"
    val legsItem = SpeedArmorItem(
        SpeedArmorMaterial(),
        ArmorItem.Type.LEGGINGS,
        Item.Settings().fireproof()
    )

    const val chestName = "speed_chest"
    val chestItem = SpeedArmorItem(
        SpeedArmorMaterial(),
        ArmorItem.Type.CHESTPLATE,
        Item.Settings().fireproof()
    )

    const val helmetName = "speed_helmet"
    val helmetItem = SpeedArmorItem(
        SpeedArmorMaterial(),
        ArmorItem.Type.HELMET,
        Item.Settings().fireproof()
    )
}

