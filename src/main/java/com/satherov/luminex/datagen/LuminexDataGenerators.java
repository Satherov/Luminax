package com.satherov.luminex.datagen;

import com.satherov.luminex.Luminex;
import com.satherov.luminex.datagen.assets.LuminexBlockStateProvider;
import com.satherov.luminex.datagen.assets.LuminexItemModelProvider;
import com.satherov.luminex.datagen.assets.lang.EN_USProvider;
import com.satherov.luminex.datagen.data.LuminexLootTableProvider;
import com.satherov.luminex.datagen.data.LuminexRecipeProvider;
import com.satherov.luminex.datagen.data.tags.LuminexBlockTagProvider;
import com.satherov.luminex.datagen.data.tags.LuminexItemTagProvider;
import net.minecraft.Util;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.registries.VanillaRegistries;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@EventBusSubscriber(modid = Luminex.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public class LuminexDataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){

        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = CompletableFuture.supplyAsync(VanillaRegistries::createLookup, Util.backgroundExecutor());

        LuminexDataProvider provider = new LuminexDataProvider();

        // Assets
        provider.addSubProvider(event.includeClient(), new LuminexBlockStateProvider(generator, fileHelper));
        provider.addSubProvider(event.includeClient(), new LuminexItemModelProvider(packOutput, fileHelper));
        // Languages
        provider.addSubProvider(event.includeClient(), new EN_USProvider(packOutput));

        // Tags
        LuminexBlockTagProvider blockTags = new LuminexBlockTagProvider(packOutput, lookupProvider, fileHelper);
        provider.addSubProvider(event.includeServer(), blockTags);
        provider.addSubProvider(event.includeServer(), new LuminexItemTagProvider(packOutput, lookupProvider, blockTags.contentsGetter()));

        // Recipes
        provider.addSubProvider(event.includeServer(), new LuminexRecipeProvider(packOutput, lookupProvider));

        // Loot Tables
        provider.addSubProvider(event.includeServer(), new LootTableProvider(packOutput, Collections.emptySet(), List.of(new LootTableProvider.SubProviderEntry(LuminexLootTableProvider::new, LootContextParamSets.BLOCK)), lookupProvider));

        generator.addProvider(true, provider);
    }
}
