package com.ronnie.items

import com.ronnie.Tbd
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier


object  TbdRegisterItems {
    lateinit var helmet: Item
    lateinit var chest: Item
    lateinit var leggings: Item
    lateinit var boots: Item

    private fun registerItem(name: String, item: Item): Item {
        return Registry.register(Registries.ITEM, Identifier(Tbd.MOD_ID, name), item)
    }

    fun registerItems() {
        registerItem(IceSword.name, IceSword.item)
        boots = registerItem(SpeedArmour.name, SpeedArmour.item)
        leggings = registerItem(SpeedArmour.legsName, SpeedArmour.legsItem)
        chest = registerItem(SpeedArmour.chestName, SpeedArmour.chestItem)
        helmet = registerItem(SpeedArmour.helmetName, SpeedArmour.helmetItem)
    }
}