package com.satherov.luminax;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

@EventBusSubscriber(modid = Luminax.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class LuminaxConfig {

    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    private static final ModConfigSpec.BooleanValue SHOW_DYENAMICS = BUILDER
            .comment("Should dyenamics blocks should appear in the creative menu even if dyenamics is not loaded?")
            .comment("Needs a reload to take effect")
            .define("show_dyenamics", false);

    static final ModConfigSpec SPEC = BUILDER.build();

    public static boolean show_dyenamics;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        show_dyenamics = SHOW_DYENAMICS.get();
    }
}
