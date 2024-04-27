package com.ronnie

import com.ronnie.items.TbdRegisterItems
import com.ronnie.potions.TbdPotions
import net.fabricmc.api.ModInitializer
import net.fabricmc.fabric.api.loot.v2.LootTableEvents
import net.fabricmc.fabric.api.loot.v2.LootTableEvents.Modify
import net.fabricmc.fabric.api.loot.v2.LootTableSource
import net.minecraft.loot.LootManager
import net.minecraft.loot.LootPool
import net.minecraft.loot.LootTable
import net.minecraft.loot.entry.ItemEntry
import net.minecraft.resource.ResourceManager
import net.minecraft.util.Identifier
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger


object Tbd : ModInitializer {
	const val MOD_ID = "tbd"
	val LOGGER: Logger = LogManager.getLogger(MOD_ID)

	private val STRONGHOLD_LIBRARY_CHEST_LOOT_TABLE_ID = Identifier("minecraft", "chests/stronghold_library")
	private val END_CITY_TREASURE_CHEST_LOOT_TABLE_ID = Identifier("minecraft", "chests/end_city_treasure")
	private val BASTION_TREASURE_CHEST_LOOT_TABLE_ID = Identifier("minecraft", "chests/bastion_treasure")
	private val DESERT_PYRAMID_CHEST_LOOT_TABLE_ID = Identifier("minecraft", "chests/desert_pyramid")

	override fun onInitialize() {
		TbdPotions.registerPotions()
		TbdPotions.registerPotionsRecipes()
		TbdRegisterItems.registerItems()


		LootTableEvents.MODIFY.register(Modify { resourceManager: ResourceManager?, lootManager: LootManager?, id: Identifier, tableBuilder: LootTable.Builder, source: LootTableSource ->
			if (STRONGHOLD_LIBRARY_CHEST_LOOT_TABLE_ID == id) {
				val pool: LootPool.Builder = LootPool.builder()
					.with(ItemEntry.builder(TbdRegisterItems.helmet))
				tableBuilder.pool(pool)
			}
			if (END_CITY_TREASURE_CHEST_LOOT_TABLE_ID == id) {
				val pool: LootPool.Builder = LootPool.builder()
					.with(ItemEntry.builder(TbdRegisterItems.chest))
				tableBuilder.pool(pool)
			}
			if (BASTION_TREASURE_CHEST_LOOT_TABLE_ID == id) {
				val pool: LootPool.Builder = LootPool.builder()
					.with(ItemEntry.builder(TbdRegisterItems.leggings))
				tableBuilder.pool(pool)
			}
			if (DESERT_PYRAMID_CHEST_LOOT_TABLE_ID == id) {
				val pool: LootPool.Builder = LootPool.builder()
					.with(ItemEntry.builder(TbdRegisterItems.boots))
				tableBuilder.pool(pool)
			}

		})

	}
}