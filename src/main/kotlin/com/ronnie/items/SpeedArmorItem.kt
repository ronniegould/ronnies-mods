package com.ronnie.items

import com.google.common.collect.ImmutableMap
import com.ronnie.Tbd
import com.ronnie.armor.SpeedArmorMaterial
import net.minecraft.entity.Entity
import net.minecraft.entity.EquipmentSlot
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ArmorItem
import net.minecraft.item.ArmorMaterial
import net.minecraft.item.ItemStack
import net.minecraft.world.World


class SpeedArmorItem(speedArmorMaterial: SpeedArmorMaterial, boots: Type, fireproof: Settings) : ArmorItem(speedArmorMaterial, boots, fireproof) {
    private val materialToEffectMap: Map<ArmorMaterial, StatusEffectInstance> =
        ImmutableMap.Builder<ArmorMaterial, StatusEffectInstance>()
            .put(
                SpeedArmorMaterial(),
                StatusEffectInstance(StatusEffects.SPEED, 2000, 1)
            ).build()

    override fun inventoryTick(stack: ItemStack?, world: World, entity: Entity?, slot: Int, selected: Boolean) {
        if (!world.isClient()) {
            if (entity is PlayerEntity) {
                if (hasBootsOn(entity)) {
                    evaluateArmorEffects(entity)
                }
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected)
    }

    private fun evaluateArmorEffects(player: PlayerEntity) {
        for (entry in materialToEffectMap.entries) {
            val mapArmorMaterial: ArmorMaterial = entry.key
            val mapStatusEffect: StatusEffectInstance = entry.value
            if (hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect)
            }
        }
    }

    private fun addStatusEffectForMaterial(
        player: PlayerEntity,
        mapArmorMaterial: ArmorMaterial,
        mapStatusEffect: StatusEffectInstance
    ) {
        val hasPlayerEffect = player.hasStatusEffect(mapStatusEffect.effectType)
        if (hasCorrectArmorOn(mapArmorMaterial, player) && !hasPlayerEffect) {
            player.addStatusEffect(
                StatusEffectInstance(
                    mapStatusEffect.effectType,
                    mapStatusEffect.duration, mapStatusEffect.amplifier
                )
            )
        }
    }

    private fun hasBootsOn(player: PlayerEntity): Boolean {
        val boots = player.inventory.getArmorStack(0)
        return !boots.isEmpty
    }

    private fun hasCorrectArmorOn(material: ArmorMaterial, player: PlayerEntity): Boolean {
        val boots = player.inventory.getArmorStack(0).item as ArmorItem
        return  boots.material.name === material.name
    }
}