package com.naraka.bladepoint.item;

import com.naraka.bladepoint.Naraka;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;

import java.util.function.Supplier;

public enum ModArmorMaterial implements ArmorMaterial {
    // 添加白甲套装
    WHITE_ARMOR("white_armor", 4, new int[]{1, 3, 2, 1}, 0, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0, 0.1f, () -> Ingredient.ofItems(ModItems.ICE_ETHER)),
    BULE_ARMOR("blue_armor", 6, new int[]{1, 3, 2, 1}, 0, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0, 0.1f, () -> Ingredient.ofItems(ModItems.ICE_ETHER));

    private final String name;
    // 耐久倍数
    private final int durabilityMultiplier;
    // 保护等级
    private final int[] protectionAmounts;
    // 附魔类型
    private final int enchantability;
    // 装备声音
    private final SoundEvent equipSound;
    // 盔甲韧性
    private final float toughness;
    // 击退抗性
    private final float knockbackResistance;
    // 修理材料
    private Supplier<Ingredient> repairIngredientSupplier;
    // 头盔，衣服，裤子，鞋子基础耐久
    private static final int[] BASE_DURABILITY = {13, 15, 16, 11};

    ModArmorMaterial(String name, int durabilityMultiplier, int[] protectionAmounts, int enchantability, SoundEvent equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredientSupplier) {
        this.name = name;
        this.durabilityMultiplier = durabilityMultiplier;
        this.protectionAmounts = protectionAmounts;
        this.enchantability = enchantability;
        this.equipSound = equipSound;
        this.toughness = toughness;
        this.knockbackResistance = knockbackResistance;
        this.repairIngredientSupplier = repairIngredientSupplier;
    }

    @Override
    public int getDurability(ArmorItem.Type type) {
        return BASE_DURABILITY[type.ordinal()] * this.durabilityMultiplier;
    }

    @Override
    public int getProtection(ArmorItem.Type type) {
        return this.protectionAmounts[type.ordinal()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.equipSound;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredientSupplier.get();
    }

    @Override
    public String getName() {
        return Naraka.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
