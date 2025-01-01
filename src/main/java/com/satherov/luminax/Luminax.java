package com.satherov.luminax;

import com.satherov.luminax.content.LuminaxRegistry;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.neoforge.client.gui.ConfigurationScreen;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
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
        LuminaxRegistry.BLOCKS.register(modEventBus);
        LuminaxRegistry.ITEMS.register(modEventBus);

        LuminaxRegistry.DYENAMIC_BLOCKS.register(modEventBus);
        LuminaxRegistry.DYENAMIC_ITEMS.register(modEventBus);

        LuminaxRegistry.CREATIVE_TABS.register(modEventBus);

        modContainer.registerConfig(ModConfig.Type.CLIENT, LuminaxConfig.SPEC);
        modContainer.registerExtensionPoint(IConfigScreenFactory.class, ConfigurationScreen::new);
    }
}
