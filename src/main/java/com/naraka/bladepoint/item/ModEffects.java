package com.naraka.bladepoint.item;

import com.naraka.bladepoint.Naraka;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEffects extends StatusEffects {
    // 添加第一个效果 ———— 回复护甲
    public static final StatusEffect REPLY_ARMOR = registerEffects("reply_armor", new ReplyArmorEffect());

    // 注册药水效果
    private static StatusEffect registerEffects(String id, StatusEffect entry) {
        return Registry.register(Registries.STATUS_EFFECT, Identifier.of(Naraka.MOD_ID, id), entry);
    }

    public static void init() {
        // 初始化
        Naraka.LOGGER.info("Registering Mod Effects");
    }
}