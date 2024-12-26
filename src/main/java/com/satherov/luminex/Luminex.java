package com.satherov.luminex;

import com.satherov.luminex.content.LuminexRegistry;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(Luminex.MOD_ID)
public class Luminex
{
    public static final String MOD_ID = "luminex";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Luminex(IEventBus modEventBus, ModContainer modContainer)
    {
        LuminexRegistry.CREATIVE_TABS.register(modEventBus);
        LuminexRegistry.BLOCKS.register(modEventBus);
        LuminexRegistry.ITEMS.register(modEventBus);
    }
}
