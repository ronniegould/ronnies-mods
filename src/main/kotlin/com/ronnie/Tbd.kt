package com.ronnie

import com.ronnie.items.TbdRegisterItems
import com.ronnie.potions.TbdPotions
import net.fabricmc.api.ModInitializer
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

object Tbd : ModInitializer {
	const val MOD_ID = "tbd"
	val LOGGER: Logger = LogManager.getLogger(MOD_ID)

	override fun onInitialize() {
		TbdPotions.registerPotions()
		TbdPotions.registerPotionsRecipes()
		TbdRegisterItems.registerItems()
	}
}