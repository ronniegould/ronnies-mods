package com.ronnie.armor

import net.minecraft.item.ArmorItem
import net.minecraft.item.ArmorMaterial
import net.minecraft.recipe.Ingredient
import net.minecraft.sound.SoundEvent
import net.minecraft.sound.SoundEvents


class SpeedArmorMaterial: ArmorMaterial {
    override fun getDurability(type: ArmorItem.Type): Int {
        return 400
    }

    override fun getProtection(type: ArmorItem.Type?): Int {
        return 10
    }

    override fun getEnchantability(): Int {
        return 10
    }

    override fun getEquipSound(): SoundEvent {
        return SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE
    }

    override fun getRepairIngredient(): Ingredient {
        throw Error("Not yet implemented")
    }

    override fun getName(): String {
        return "speed_armor"
    }

    override fun getToughness(): Float {
        return 5.0f
    }

    override fun getKnockbackResistance(): Float {
        return 1.9f
    }
}