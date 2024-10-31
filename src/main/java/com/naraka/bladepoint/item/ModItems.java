package com.naraka.bladepoint.item;

import com.naraka.bladepoint.Naraka;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    // 添加第一个游戏物品
    public static final Item ICE_ETHER = registerItems("ice_ether", new Item(new Item.Settings()));
    // 添加凝血丸 ———— cagulation pills
    public static final Item CAGULATION_PILLS = registerItems("cagulation_pills", new Item(new FabricItemSettings().food(ModFoodComponent.CAGULATION_PILLS).maxCount(8)));
    // 添加大型凝血丸 ———— large cagulation pills
    public static final Item LARGR_CAGULATION_PILLS = registerItems("large_cagulation_pills", new Item(new FabricItemSettings().food(ModFoodComponent.LARGE_CAGULATION_PILLS).maxCount(2)));
    // 添加白甲_头盔 ———— white_armor_helmet
    public static final Item WHITE_ARMOR_HELMET = registerItems("white_armor_helmet", new ModArmorItem(ModArmorMaterial.WHITE_ARMOR, ArmorItem.Type.HELMET, new FabricItemSettings()));
    // 添加白甲_靴子 ———— white_armor_boots
    public static final Item WHITE_ARMOR_BOOTS = registerItems("white_armor_boots", new ModArmorItem(ModArmorMaterial.WHITE_ARMOR, ArmorItem.Type.BOOTS, new FabricItemSettings()));
    // 添加白甲_胸甲 ———— white_armor_chestplate
    public static final Item WHITE_ARMOR_CHESTPLATE = registerItems("white_armor_chestplate", new ModArmorItem(ModArmorMaterial.WHITE_ARMOR, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    // 添加白甲_护腿 ———— white_armor_leggings
    public static final Item WHITE_ARMOR_LEGGINGS = registerItems("white_armor_leggings", new ModArmorItem(ModArmorMaterial.WHITE_ARMOR, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    // 添加护甲粉末 ———— armor_powder
    public static final Item ARMOR_POWDER = registerItems("armor_powder", new Item(new FabricItemSettings().food(ModFoodComponent.ARMOR_POWDER).maxCount(8)));
    // 添加大型护甲粉末 ———— large_armor_powder
    public static final Item LARGE_ARMOR_POWDER = registerItems("large_armor_powder", new Item(new FabricItemSettings().food(ModFoodComponent.LARGE_ARMOR_POWDER).maxCount(2)));

    private static Item registerItems(String id, Item item) {
        // 注册物品到游戏中
        return Registry.register(Registries.ITEM, Identifier.of(Naraka.MOD_ID, id), item);
    }

    public static void init() {
        // 初始化
        Naraka.LOGGER.info("Registering Mod Items");

    }
}