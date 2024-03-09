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
        registerItem(SpeedBoots.name, SpeedBoots.item)
    }
}