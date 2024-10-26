package com.naraka.bladepoint.block;

import com.naraka.bladepoint.Naraka;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    // 添加方块对应物品到游戏
    public static void registerBlockItems(String id, Block block) {
        Item item = Registry.register(Registries.ITEM, Identifier.of(Naraka.MOD_ID, id), new BlockItem(block, new Item.Settings()));
        if (item instanceof BlockItem) {
            ((BlockItem) item).appendBlocks(Item.BLOCK_ITEMS, item);
        }
    }

    // 注册方块到游戏
    public static Block register(String id, Block block) {
        registerBlockItems(id, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Naraka.MOD_ID, id), block);
    }

    public static void init() {
        Naraka.LOGGER.info("Registering blocks");
    }
}