package com.ronnie.items

import com.ronnie.Tbd
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier


object  TbdRegisterItems {
    private fun registerItem(name: String, item: Item): Item {
        return Registry.register(Registries.ITEM, Identifier(Tbd.MOD_ID, name), item)
    }

    fun registerItems() {
        registerItem(IceSword.name, IceSword.item)
        registerItem(SpeedArmour.name, SpeedArmour.item)
        registerItem(SpeedArmour.legsName, SpeedArmour.legsItem)
        registerItem(SpeedArmour.chestName, SpeedArmour.chestItem)
        registerItem(SpeedArmour.helmetName, SpeedArmour.helmetItem)
    }
}