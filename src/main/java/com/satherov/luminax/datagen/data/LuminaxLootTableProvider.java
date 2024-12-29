package com.satherov.luminax.datagen.data;

import com.satherov.luminax.content.LuminaxRegistry;
import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.stream.Collectors;

public class LuminaxLootTableProvider extends VanillaBlockLoot {

    @Override
    public void generate() {
        getKnownBlocks().forEach(this::dropSelf);
    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return LuminaxRegistry.BLOCKS.getEntries()
                .stream()
                .map(RegistryObject::get)
                .collect(Collectors.toList());
    }
}
