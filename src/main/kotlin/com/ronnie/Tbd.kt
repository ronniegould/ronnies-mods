package com.ronnie

import com.ronnie.potions.TbdPotions
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.Item
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

object Tbd : ModInitializer {
	const val MOD_ID = "tbd"

	private val CUSTOM_ITEM = Registry.register(Registries.ITEM, Identifier(MOD_ID, "custom_item"), Item(FabricItemSettings()));

	override fun onInitialize() {
		TbdPotions.registerPotions()
		TbdPotions.registerPotionsRecipes()
	}
}