package com.naraka.bladepoint.item;

import com.google.common.collect.ImmutableMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.Map;

public class ModArmorItem extends ArmorItem {
    public ModArmorItem(ArmorMaterial material, Type type, Settings settings) {
        super(material, type, settings);
    }


    private static final Map<ArmorMaterial, StatusEffectInstance> map =
            (new ImmutableMap.Builder<ArmorMaterial, StatusEffectInstance>())
                    .put(ModArmorMaterial.WHITE_ARMOR, new StatusEffectInstance(StatusEffects.GLOWING, 1000, 1, false, false, true))
                    .build();

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient() && entity instanceof PlayerEntity player) {
            if (JudgingHelmetDurability(player)) {
                player.getInventory().getArmorStack(3);
            } else {

            }
            if (JudgingChestplateDurability(player)) {
                player.getInventory().getArmorStack(2);
            } else {

            }
            if (JudgingLeggingsDurability(player)) {
                player.getInventory().getArmorStack(1);
            } else {

            }
            if (JudgingBootsDurability(player)) {
                player.getInventory().getArmorStack(0);
            } else {

            }
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private boolean JudgingHelmetDurability(PlayerEntity player) {
        return this.material.getDurability(Type.HELMET) - player.getInventory().getArmorStack(3).getDamage() <= 1;
    }

    private boolean JudgingChestplateDurability(PlayerEntity player) {
        return this.material.getDurability(Type.CHESTPLATE) - player.getInventory().getArmorStack(2).getDamage() <= 1;
    }

    private boolean JudgingLeggingsDurability(PlayerEntity player) {
        return this.material.getDurability(Type.LEGGINGS) - player.getInventory().getArmorStack(1).getDamage() <= 1;
    }

    private boolean JudgingBootsDurability(PlayerEntity player) {
        return this.material.getDurability(Type.BOOTS) - player.getInventory().getArmorStack(0).getDamage() <= 1;
    }
}