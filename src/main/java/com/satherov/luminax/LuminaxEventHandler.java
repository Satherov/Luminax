package com.satherov.luminax;

import com.satherov.luminax.content.LuminaxRegistry;
import net.minecraft.world.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;


@Mod.EventBusSubscriber(modid = Luminax.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class LuminaxEventHandler {
    @SubscribeEvent
    public static void creativeTab(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey().equals(LuminaxRegistry.CREATIVE_TAB.getKey())) {
            for (RegistryObject<? extends Item> item : LuminaxRegistry.ITEMS.getEntries()) {
                event.accept(item.get());
            }
        }
    }
}
