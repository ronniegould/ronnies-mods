package com.ronnie.items

import com.ronnie.tools.TbdToolMaterial
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.SwordItem

object IceSword {
    const val name = "ice_sword"
    val item = SwordItem(TbdToolMaterial(), 7, -3.2F, FabricItemSettings())
}