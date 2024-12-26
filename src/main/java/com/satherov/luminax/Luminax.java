package com.satherov.luminax;

import com.satherov.luminax.content.LuminaxRegistry;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(Luminax.MOD_ID)
public class Luminax
{
    public static final String MOD_ID = "luminax";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Luminax(IEventBus modEventBus, ModContainer modContainer)
    {
        LuminaxRegistry.CREATIVE_TABS.register(modEventBus);
        LuminaxRegistry.BLOCKS.register(modEventBus);
        LuminaxRegistry.ITEMS.register(modEventBus);
    }
}
