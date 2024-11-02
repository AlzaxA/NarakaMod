package com.naraka.bladepoint.item;

import com.google.common.collect.Multimap;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.world.World;

public class LangSwordItem extends SwordItem {
    private float chargeValue = 0.0f; // 蓄力值
    private static final float MAX_CHARGE = 10.0f; // 最大蓄力值

    public LangSwordItem(ModToolMaterial material, int attackDamage, float attackSpeed, Item.Settings settings, Multimap<EntityAttribute, EntityAttributeModifier> attributeModifiers) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
        if (!world.isClient && hand == Hand.MAIN_HAND && user instanceof PlayerEntity) {
            // ↓ 执行蓄力函数
            chargingAttack();
        }
        return super.use(world, user, hand);
    }

    // 蓄力攻击逻辑
    private void chargingAttack() {
        for (int i = 1; i <= MAX_CHARGE; i++) {
            chargeValue += i;
        }
    }
}