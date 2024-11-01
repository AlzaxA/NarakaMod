package com.naraka.bladepoint.item;

import com.google.common.collect.ImmutableMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
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

    // 添加套装效果
    private static final Map<ArmorMaterial, StatusEffectInstance> map =
            (new ImmutableMap.Builder<ArmorMaterial, StatusEffectInstance>())
                    .put(ModArmorMaterial.WHITE_ARMOR, new StatusEffectInstance(StatusEffects.RESISTANCE, 20, 4, false, false, true))
                    .put(ModArmorMaterial.BULE_ARMOR, new StatusEffectInstance(StatusEffects.RESISTANCE, 20, 4, false, false, true)).build();


    @Override
    // 每Tick监视物品栏，判断是否满足条件
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient() && entity instanceof PlayerEntity player) {
            if (JudgingHelmetDurability(player)) {
                // 自动脱下装备到物品栏
                player.getInventory().getArmorStack(3).setDamage(player.getInventory().getArmorStack(3).getMaxDamage() - 10);
                player.getInventory().insertStack(player.getInventory().getArmorStack(3));
                player.equipStack(EquipmentSlot.HEAD, ItemStack.EMPTY);
            }
            if (JudgingChestplateDurability(player)) {
                player.getInventory().getArmorStack(2).setDamage(player.getInventory().getArmorStack(2).getMaxDamage() - 10);
                player.getInventory().insertStack(player.getInventory().getArmorStack(2));
                player.equipStack(EquipmentSlot.CHEST, ItemStack.EMPTY);
            }
            if (JudgingLeggingsDurability(player)) {
                player.getInventory().getArmorStack(1).setDamage(player.getInventory().getArmorStack(1).getMaxDamage() - 10);
                player.getInventory().insertStack(player.getInventory().getArmorStack(1));
                player.equipStack(EquipmentSlot.LEGS, ItemStack.EMPTY);
            }
            if (JudgingBootsDurability(player)) {
                player.getInventory().getArmorStack(0).setDamage(player.getInventory().getArmorStack(0).getMaxDamage() - 10);
                player.getInventory().insertStack(player.getInventory().getArmorStack(0));
                player.equipStack(EquipmentSlot.FEET, ItemStack.EMPTY);
            }
        }
        if (!world.isClient() && entity instanceof PlayerEntity player && hasFullSuitOfArmor(player)) {
            evaluateArmorEffects(player);
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    // 判断装备耐久
    private boolean JudgingHelmetDurability(PlayerEntity player) {
        return player.getInventory().getArmorStack(3).getMaxDamage() - player.getInventory().getArmorStack(3).getDamage() < 10;
    }

    private boolean JudgingChestplateDurability(PlayerEntity player) {
        return player.getInventory().getArmorStack(2).getMaxDamage() - player.getInventory().getArmorStack(2).getDamage() < 10;
    }

    private boolean JudgingLeggingsDurability(PlayerEntity player) {
        return player.getInventory().getArmorStack(1).getMaxDamage() - player.getInventory().getArmorStack(1).getDamage() < 10;
    }

    private boolean JudgingBootsDurability(PlayerEntity player) {
        return player.getInventory().getArmorStack(0).getMaxDamage() - player.getInventory().getArmorStack(0).getDamage() < 10;
    }

    // 判断是否有全套盔甲
    private boolean hasFullSuitOfArmor(PlayerEntity player) {
        ItemStack helmet = player.getInventory().getArmorStack(3);
        ItemStack chestplate = player.getInventory().getArmorStack(2);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack boots = player.getInventory().getArmorStack(0);
        return !helmet.isEmpty() && !chestplate.isEmpty() && !leggings.isEmpty() && !boots.isEmpty();
    }

    // 分配套装状态
    private void evaluateArmorEffects(PlayerEntity player) {
        for (Map.Entry<ArmorMaterial, StatusEffectInstance> entry : map.entrySet()) {
            ArmorMaterial material = entry.getKey();
            StatusEffectInstance effectInstance = entry.getValue();
            if (hasCorrectArmorSet(player, material)) {
                addStatusEffect(player, effectInstance);
            }
        }
    }


    // 给玩家增加对应效果
    private void addStatusEffect(PlayerEntity player, StatusEffectInstance effectInstance) {
        player.addStatusEffect(effectInstance);
    }

    // 判断是否是正确的盔甲装备
    private boolean hasCorrectArmorSet(PlayerEntity player, ArmorMaterial material) {
        for (ItemStack armorStack : player.getInventory().armor) {
            if (!(armorStack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }
        ArmorItem helmet = (ArmorItem) player.getInventory().getArmorStack(3).getItem();
        ArmorItem chestplate = (ArmorItem) player.getInventory().getArmorStack(2).getItem();
        ArmorItem leggings = (ArmorItem) player.getInventory().getArmorStack(1).getItem();
        ArmorItem boots = (ArmorItem) player.getInventory().getArmorStack(0).getItem();
        return helmet.getMaterial() == material && chestplate.getMaterial() == material && leggings.getMaterial() == material && boots.getMaterial() == material;
    }
}