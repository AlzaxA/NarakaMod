package com.naraka.bladepoint.item;

import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

import java.util.function.Supplier;

public enum ModToolMaterial implements ToolMaterial {
    ;
    private final int durability;
    // 挖掘速度
    private final float miningSpeed;
    // 攻击伤害
    private final float attackDamage;
    // 挖掘等级
    private final int miningLevel;
    private final int enchantability;
    // 修补材料
    private final Supplier<Ingredient> repairIngredientSupplier;

    ModToolMaterial(int durability, float miningSpeed, float attackDamage, int miningLevel, int enchantability, Supplier<Ingredient> repairIngredientSupplier) {
        this.durability = durability;
        this.miningSpeed = miningSpeed;
        this.attackDamage = attackDamage;
        this.miningLevel = miningLevel;
        this.enchantability = enchantability;
        this.repairIngredientSupplier = repairIngredientSupplier;
    }

    @Override
    public int getDurability() {
        return this.durability;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return this.miningSpeed;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.miningLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredientSupplier.get();
    }
}