package com.satherov.luminax;

import com.satherov.luminax.content.LuminaxRegistry;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

@Mod(Luminax.MOD_ID)
public class Luminax
{
    public static final String MOD_ID = "luminax";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Luminax()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        LuminaxRegistry.CREATIVE_TABS.register(modEventBus);
        LuminaxRegistry.BLOCKS.register(modEventBus);
        LuminaxRegistry.ITEMS.register(modEventBus);
    }
}
