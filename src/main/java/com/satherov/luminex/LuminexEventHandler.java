package com.satherov.luminex;

import com.satherov.luminex.content.LuminexRegistry;
import net.minecraft.world.item.Item;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;

@EventBusSubscriber(modid = Luminex.MOD_ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class LuminexEventHandler {
    @SubscribeEvent
    public static void creativeTab(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey().equals(LuminexRegistry.CREATIVE_TAB.getKey())) {
            for (DeferredHolder<Item, ? extends Item> item : LuminexRegistry.ITEMS.getEntries()) {
                event.accept(item.get());
            }
        }
    }
}
