package com.satherov.luminax.datagen;

import com.satherov.luminax.Luminax;
import com.satherov.luminax.datagen.assets.LuminaxBlockModelProvider;
import com.satherov.luminax.datagen.assets.LuminaxBlockStateProvider;
import com.satherov.luminax.datagen.assets.LuminaxItemModelProvider;
import com.satherov.luminax.datagen.assets.lang.EN_USProvider;
import com.satherov.luminax.datagen.data.LuminaxLootTableProvider;
import com.satherov.luminax.datagen.data.LuminaxRecipeProvider;
import com.satherov.luminax.datagen.data.tags.LuminaxBlockTagProvider;
import com.satherov.luminax.datagen.data.tags.LuminaxItemTagProvider;
import net.minecraft.Util;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.data.registries.VanillaRegistries;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = Luminax.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class LuminaxDataGenerators {

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){

        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper fileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = CompletableFuture.supplyAsync(VanillaRegistries::createLookup, Util.backgroundExecutor());

        LuminaxDataProvider provider = new LuminaxDataProvider();

        // Assets
        provider.addSubProvider(event.includeClient(), new LuminaxBlockModelProvider(packOutput, fileHelper));
        provider.addSubProvider(event.includeClient(), new LuminaxBlockStateProvider(generator, fileHelper));
        provider.addSubProvider(event.includeClient(), new LuminaxItemModelProvider(packOutput, fileHelper));
        // Languages
        provider.addSubProvider(event.includeClient(), new EN_USProvider(packOutput));

        // Tags
        LuminaxBlockTagProvider blockTags = new LuminaxBlockTagProvider(packOutput, lookupProvider, fileHelper);
        provider.addSubProvider(event.includeServer(), blockTags);
        provider.addSubProvider(event.includeServer(), new LuminaxItemTagProvider(packOutput, lookupProvider, blockTags.contentsGetter()));

        // Recipes
        provider.addSubProvider(event.includeServer(), new LuminaxRecipeProvider(packOutput));

        // Loot Tables
        provider.addSubProvider(event.includeServer(), new LootTableProvider(packOutput, Collections.emptySet(), List.of(new LootTableProvider.SubProviderEntry(LuminaxLootTableProvider::new, LootContextParamSets.BLOCK))));

        generator.addProvider(true, provider);
    }
}
