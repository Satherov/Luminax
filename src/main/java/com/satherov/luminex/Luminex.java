package com.satherov.luminex;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;

@Mod(Luminex.MODID)
public class Luminex
{
    public static final String MODID = "luminex";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Luminex(IEventBus modEventBus, ModContainer modContainer)
    {

    }
}
