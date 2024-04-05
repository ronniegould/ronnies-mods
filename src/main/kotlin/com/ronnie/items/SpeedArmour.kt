package com.ronnie.items

import com.ronnie.armor.SpeedArmorMaterial
import net.minecraft.item.ArmorItem
import net.minecraft.item.Item
import net.minecraft.text.Text
import net.minecraft.util.Formatting


object SpeedArmour {
    const val name = "speed_boots"
    val item = SpeedArmorItem(
        SpeedArmorMaterial(),
        ArmorItem.Type.BOOTS,
        Item.Settings().fireproof(),
        Text.translatable("item.tbd.speed_boots").formatted(Formatting.DARK_BLUE)
    )

    const val legsName = "speed_leggings"
    val legsItem = SpeedArmorItem(
        SpeedArmorMaterial(),
        ArmorItem.Type.LEGGINGS,
        Item.Settings().fireproof(),
        Text.translatable("item.tbd.speed_leggings")
    )

    const val chestName = "speed_chest"
    val chestItem = SpeedArmorItem(
        SpeedArmorMaterial(),
        ArmorItem.Type.CHESTPLATE,
        Item.Settings().fireproof(),
        Text.translatable("item.tbd.speed_chest")
    )

    const val helmetName = "speed_helmet"
    val helmetItem = SpeedArmorItem(
        SpeedArmorMaterial(),
        ArmorItem.Type.HELMET,
        Item.Settings().fireproof(),
        Text.translatable("item.tbd.speed_helmet")
    )
}

