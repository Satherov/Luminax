package com.satherov.luminax.datagen.data;

import com.satherov.luminax.content.LuminaxRegistry;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Collectors;

public class LuminaxLootTableProvider extends VanillaBlockLoot {

    public LuminaxLootTableProvider(Provider provider) {
        super(provider);
    }

    @Override
    public void generate() {
        getKnownBlocks().forEach(this::dropSelf);
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return LuminaxRegistry.BLOCKS.getEntries()
                .stream()
                .map(DeferredHolder::get)
                .collect(Collectors.toList());
    }
}