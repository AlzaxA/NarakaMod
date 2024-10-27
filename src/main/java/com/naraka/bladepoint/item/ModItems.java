package com.naraka.bladepoint.item;

import com.naraka.bladepoint.Naraka;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
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

    private static Item registerItems(String id, Item item) {
        // 注册物品到游戏中
        return Registry.register(Registries.ITEM, Identifier.of(Naraka.MOD_ID, id), item);
    }

    public static void init() {
        // 初始化
        Naraka.LOGGER.info("Registering Mod Items");

    }
}