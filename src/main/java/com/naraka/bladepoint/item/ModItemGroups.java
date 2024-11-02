package com.naraka.bladepoint.item;


import com.naraka.bladepoint.Naraka;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup NARAKA_GROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of(Naraka.MOD_ID, "naraka_group"),
            // 设置自定义物品栏位置和名字 ———— 自动往后堆叠
            ItemGroup.create(null, -1).displayName(Text.translatable("itemGroup.naraka_group"))
                    // 设置自定义物品栏显示图标
                    .icon(() -> new ItemStack(ModItems.ICE_ETHER))
                    // 设置自定义物品栏内容
                    .entries((displayContext, entries) -> {
                        // 在这里增加物品
                        entries.add(ModItems.ICE_ETHER);
                        entries.add(ModItems.CAGULATION_PILLS);
                        entries.add(ModItems.LARGR_CAGULATION_PILLS);
                        entries.add(ModItems.WHITE_ARMOR_HELMET);
                        entries.add(ModItems.WHITE_ARMOR_CHESTPLATE);
                        entries.add(ModItems.WHITE_ARMOR_LEGGINGS);
                        entries.add(ModItems.WHITE_ARMOR_BOOTS);
                        entries.add(ModItems.ARMOR_POWDER);
                        entries.add(ModItems.LARGE_ARMOR_POWDER);
                        entries.add(ModItems.BLUE_ARMOR_HELMET);
                        entries.add(ModItems.BLUE_ARMOR_CHESTPLATE);
                        entries.add(ModItems.BLUE_ARMOR_LEGGINGS);
                        entries.add(ModItems.BLUE_ARMOR_BOOTS);
                        entries.add(ModItems.PURPLE_ARMOR_HELMET);
                        entries.add(ModItems.PURPLE_ARMOR_CHESTPLATE);
                        entries.add(ModItems.PURPLE_ARMOR_LEGGINGS);
                        entries.add(ModItems.PURPLE_ARMOR_BOOTS);
                        entries.add(ModItems.GOLD_ARMOR_HELMET);
                        entries.add(ModItems.GOLD_ARMOR_CHESTPLATE);
                        entries.add(ModItems.GOLD_ARMOR_LEGGINGS);
                        entries.add(ModItems.GOLD_ARMOR_BOOTS);
                    }).build());

    public static void init() {
        // 初始化
        Naraka.LOGGER.info("Fantasy Mod Item Groups");
    }
}