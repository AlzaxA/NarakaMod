package com.naraka.bladepoint;

import com.naraka.bladepoint.block.ModBlocks;
import com.naraka.bladepoint.item.ModEffects;
import com.naraka.bladepoint.item.ModItemGroups;
import com.naraka.bladepoint.item.ModItems;
import com.naraka.bladepoint.item.ReplyArmorEffect;
import net.fabricmc.api.ModInitializer;

import net.minecraft.entity.effect.StatusEffect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Naraka implements ModInitializer {
    public static final String MOD_ID = "naraka";
    // This logger is used to write text to the console and the log file.
    // It is considered best practice to use your mod id as the logger's name.
    // That way, it's clear which mod wrote info, warnings, and errors.
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        // This code runs as soon as Minecraft is in a mod-load-ready state.
        // However, some things (like resources) may still be uninitialized.
        // Proceed with mild caution.
        // 模组物品初始化
        ModItems.init();
        // 模组物品栏初始化
        ModItemGroups.init();
        // 模组方块初始化
        ModBlocks.init();
        //状态初始化
        ModEffects.init();
        LOGGER.info("Hello Fabric world!");
    }
}