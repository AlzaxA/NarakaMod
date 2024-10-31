package com.naraka.bladepoint.item;

import com.google.common.collect.ImmutableMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.damage.DamageSource;
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
                    .put(ModArmorMaterial.WHITE_ARMOR, new StatusEffectInstance(StatusEffects.RESISTANCE, 20, 4, false, false, true))
                    .build();

    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
        if (!world.isClient() && entity instanceof PlayerEntity player) {
            if (JudgingHelmetDurability(player)) {
                player.getInventory().getArmorStack(3).setDamage(this.material.getDurability(Type.HELMET) - 10);
                player.equipStack(EquipmentSlot.HEAD,ItemStack.EMPTY);
                player.getInventory().insertStack(stack);
            }
            if (JudgingChestplateDurability(player)) {
                player.getInventory().getArmorStack(2).setDamage(this.material.getDurability(Type.HELMET) - 10);
                player.equipStack(EquipmentSlot.CHEST,ItemStack.EMPTY);
                player.getInventory().insertStack(stack);
            }
            if (JudgingLeggingsDurability(player)) {
                player.getInventory().getArmorStack(1).setDamage(this.material.getDurability(Type.HELMET) - 10);
                player.equipStack(EquipmentSlot.FEET,ItemStack.EMPTY);
                player.getInventory().insertStack(stack);
            }
            if (JudgingBootsDurability(player)) {
                player.getInventory().getArmorStack(0).setDamage(this.material.getDurability(Type.HELMET) - 10);
                player.equipStack(EquipmentSlot.FEET,ItemStack.EMPTY);
                player.getInventory().insertStack(stack);
            }
        }
        if (!world.isClient() && entity instanceof PlayerEntity player && hasFullSuitOfArmor(player)) {
            evaluateArmorEffects(player);
        }
        super.inventoryTick(stack, world, entity, slot, selected);
    }

    private boolean JudgingHelmetDurability(PlayerEntity player) {
        return this.material.getDurability(Type.HELMET) - player.getInventory().getArmorStack(3).getDamage() < 10;
    }

    private boolean JudgingChestplateDurability(PlayerEntity player) {
        return this.material.getDurability(Type.CHESTPLATE) - player.getInventory().getArmorStack(2).getDamage() < 10;
    }

    private boolean JudgingLeggingsDurability(PlayerEntity player) {
        return this.material.getDurability(Type.LEGGINGS) - player.getInventory().getArmorStack(1).getDamage() < 10;
    }

    private boolean JudgingBootsDurability(PlayerEntity player) {
        return this.material.getDurability(Type.BOOTS) - player.getInventory().getArmorStack(0).getDamage() < 10;
    }

    private boolean hasFullSuitOfArmor(PlayerEntity player){
        ItemStack helmet = player.getInventory().getArmorStack(3);
        ItemStack chestplate = player.getInventory().getArmorStack(2);
        ItemStack leggings = player.getInventory().getArmorStack(1);
        ItemStack boots = player.getInventory().getArmorStack(0);
        return !helmet.isEmpty() && !chestplate.isEmpty() && !leggings.isEmpty() && !boots.isEmpty();
    }

    private void evaluateArmorEffects(PlayerEntity player){
        for (Map.Entry<ArmorMaterial, StatusEffectInstance> entry : map.entrySet()) {
            ArmorMaterial material = entry.getKey();
            StatusEffectInstance effectInstance = entry.getValue();
            if (hasCorrectArmorSet(player,material)){
                addStatusEffect(player,effectInstance);
            }
        }
    }
    private boolean hasCorrectArmorSet(PlayerEntity player, ArmorMaterial material){
        for (ItemStack armorStack:player.getInventory().armor) {
            if(!(armorStack.getItem() instanceof ArmorItem)){

                return false;
            }
        }
    }
}