package com.naraka.bladepoint.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

// 创建食品属性类，用于定义新食品的属性值
public class ModFoodComponent {
    public static final FoodComponent CAGULATION_PILLS = new FoodComponent.Builder().hunger(3).saturationModifier(0.3f)
            .statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1, 0), 1).alwaysEdible().build();
    public static final FoodComponent LARGE_CAGULATION_PILLS = new FoodComponent.Builder().hunger(8).saturationModifier(0.3f)
            .statusEffect(new StatusEffectInstance(StatusEffects.INSTANT_HEALTH, 1, 1), 1).alwaysEdible().build();
}
