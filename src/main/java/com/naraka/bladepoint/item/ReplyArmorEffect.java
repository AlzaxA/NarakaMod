package com.naraka.bladepoint.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class ReplyArmorEffect extends StatusEffect {
    public ReplyArmorEffect() {
        super(
                StatusEffectCategory.BENEFICIAL, // 药水效果是有益的还是有害的
                0x98D982); // 显示的颜色
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return true;
    }//效果每tick都生效

    @Override
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity player) {
            for (int i = 0; i < 4; i++) {
                int lastdamage = player.getInventory().getArmorStack(i).getDamage();
                player.getInventory().getArmorStack(i).setDamage(lastdamage - 5 * (amplifier + 1));
            }
        }
        super.applyUpdateEffect(entity, amplifier);
    }
}