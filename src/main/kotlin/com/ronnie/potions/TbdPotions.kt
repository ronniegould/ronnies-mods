package com.ronnie.potions

import com.ronnie.Tbd
import net.minecraft.entity.effect.StatusEffectInstance
import net.minecraft.entity.effect.StatusEffects
import net.minecraft.item.Items
import net.minecraft.potion.Potion
import net.minecraft.potion.Potions
import net.minecraft.recipe.BrewingRecipeRegistry
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.util.Identifier

object TbdPotions {
    private val SPEED4_POTION: Potion = Registry.register(
        Registries.POTION,
        Identifier(Tbd.MOD_ID, "speed4_potion"),
        Potion(StatusEffectInstance(StatusEffects.SPEED, 3600, 3))
    )

    fun registerPotions() {
    }

    fun registerPotionsRecipes() {
        BrewingRecipeRegistry.registerPotionRecipe(Potions.AWKWARD, Items.COBBLESTONE, TbdPotions.SPEED4_POTION)
    }
}