package com.ronnie

import com.ronnie.items.TbdRegisterItems
import com.ronnie.potions.TbdPotions
import net.fabricmc.api.ModInitializer

object Tbd : ModInitializer {
	const val MOD_ID = "tbd"

	override fun onInitialize() {
		TbdPotions.registerPotions()
		TbdPotions.registerPotionsRecipes()
		TbdRegisterItems.registerItems()
	}
}