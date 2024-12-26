package com.satherov.luminax;

import com.satherov.luminax.content.LuminaxRegistry;
import net.minecraft.world.item.Item;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;

@EventBusSubscriber(modid = Luminax.MOD_ID, value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class LuminaxEventHandler {
    @SubscribeEvent
    public static void creativeTab(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey().equals(LuminaxRegistry.CREATIVE_TAB.getKey())) {
            for (DeferredHolder<Item, ? extends Item> item : LuminaxRegistry.ITEMS.getEntries()) {
                event.accept(item.get());
            }
        }
    }
}