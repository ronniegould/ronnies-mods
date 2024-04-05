package com.ronnie.items

import com.ronnie.armor.SpeedArmorMaterial
import net.minecraft.client.item.TooltipContext
import net.minecraft.entity.Entity
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.ArmorItem
import net.minecraft.item.ArmorMaterial
import net.minecraft.item.ItemStack
import net.minecraft.text.Text
import net.minecraft.world.World


class SpeedArmorItem(
    speedArmorMaterial: SpeedArmorMaterial,
    boots: Type,
    fireproof: Settings,
    private val tooltip: Text
    ) : ArmorItem(speedArmorMaterial, boots, fireproof) {
    override fun inventoryTick(stack: ItemStack?, world: World, entity: Entity?, slot: Int, selected: Boolean) {
        if (!world.isClient()) {
            if (entity is PlayerEntity) {
                evaluateArmorEffects(entity)
            }
        }
        super.inventoryTick(stack, world, entity, slot, selected)
    }

    override fun appendTooltip(
        stack: ItemStack?,
        world: World?,
        tooltip: MutableList<Text>?,
        context: TooltipContext?
    ) {
        tooltip?.add(this.tooltip);
        super.appendTooltip(stack, world, tooltip, context)
    }

    private fun evaluateArmorEffects(player: PlayerEntity) {
        val armourMaterial = SpeedArmorMaterial()
        if (hasBootsOn(player)) {
            if (hasCorrectBootsOn(armourMaterial, player)) {
                val hasPlayerEffect = player.hasStatusEffect(StatusEffects.JUMP_BOOST)
                if (!hasPlayerEffect) {
                    player.addStatusEffect(
                        StatusEffectInstance(
                            StatusEffects.JUMP_BOOST,
                            9000, 5
                        )
                    )
                }
            }
        }

        if (hasLegsOn(player)) {
            if (hasCorrectLegsOn(armourMaterial, player)) {
                val hasPlayerEffect = player.hasStatusEffect(StatusEffects.SPEED)
                if (!hasPlayerEffect) {
                    player.addStatusEffect(
                        StatusEffectInstance(
                            StatusEffects.SPEED,
                            9000, 15
                        )
                    )
                }
            }
        }

        if (hasChestOn(player)) {
            if (hasCorrectChestOn(armourMaterial, player)) {
                val hasPlayerEffect = player.hasStatusEffect(StatusEffects.SATURATION)
                if (!hasPlayerEffect) {
                    player.addStatusEffect(
                        StatusEffectInstance(
                            StatusEffects.SATURATION,
                            9000, 1
                        )
                    )
                }
            }
        }

        if (hasHelmetOn(player)) {
            if (hasCorrectHelmetOn(armourMaterial, player)) {
                val hasPlayerEffect = player.hasStatusEffect(StatusEffects.DOLPHINS_GRACE)
                if (!hasPlayerEffect) {
                    player.addStatusEffect(
                        StatusEffectInstance(
                            StatusEffects.DOLPHINS_GRACE,
                            9000, 10
                        )
                    )
                }
            }
        }

        // Add a full set effect
        if (hasFullArmourOn(player)) {
            if (hasCorrectFullArmourOn(armourMaterial, player)) {
                val hasPlayerStatusEffect = player.hasStatusEffect(StatusEffects.REGENERATION)
                if (!hasPlayerStatusEffect) {
                    player.addStatusEffect(StatusEffectInstance(
                        StatusEffects.REGENERATION, 9000, 10
                    ))
                }
            }
        }

    }

    private fun hasFullArmourOn(player: PlayerEntity): Boolean {
        return hasHelmetOn(player) && hasChestOn(player) && hasLegsOn(player) && hasBootsOn(player)
    }

    private fun hasCorrectFullArmourOn(material: ArmorMaterial, player: PlayerEntity): Boolean {
        return hasCorrectChestOn(material, player) && hasCorrectHelmetOn(material, player) && hasCorrectLegsOn(
            material,
            player
        ) && hasCorrectBootsOn(material, player)
    }

    private fun hasChestOn(player: PlayerEntity): Boolean {
        val chest = player.inventory.getArmorStack(2)
        return !chest.isEmpty
    }
    private fun hasCorrectChestOn(material: ArmorMaterial, player: PlayerEntity): Boolean {
        val item = player.inventory.getArmorStack(2).item
        if (item is ArmorItem) {
            return item.material.name === material.name
        }
        return false
    }

    private fun hasHelmetOn(player: PlayerEntity): Boolean {
        val helmet = player.inventory.getArmorStack(3)
        return !helmet.isEmpty
    }
    private fun hasCorrectHelmetOn(material: ArmorMaterial, player: PlayerEntity): Boolean {
        val item = player.inventory.getArmorStack(3).item
        if (item is ArmorItem) {
            return item.material.name === material.name
        }
        return false
    }

    private fun hasBootsOn(player: PlayerEntity): Boolean {
        val boots = player.inventory.getArmorStack(0)
        return !boots.isEmpty
    }

    private fun hasLegsOn(player: PlayerEntity): Boolean {
        val legs = player.inventory.getArmorStack(1)
        return !legs.isEmpty
    }
    private fun hasCorrectLegsOn(material: ArmorMaterial, player: PlayerEntity): Boolean {
        val item = player.inventory.getArmorStack(1).item
        if (item is ArmorItem) {
            return item.material.name === material.name
        }
        return false
    }

    private fun hasCorrectBootsOn(material: ArmorMaterial, player: PlayerEntity): Boolean {
        val boots = player.inventory.getArmorStack(0).item
        if (boots is ArmorItem) {
            return boots.material.name === material.name
        }
        return false
    }
}