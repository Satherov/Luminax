package com.satherov.luminax.datagen.data.tags;

import com.satherov.luminax.Luminax;
import com.satherov.luminax.content.LuminaxRegistry;
import com.satherov.luminax.content.SetHelper;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class LuminaxBlockTagProvider extends BlockTagsProvider {

    public LuminaxBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Luminax.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        LuminaxRegistry.BLOCKS.getEntries().forEach( block -> tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block.get()));

        SetHelper.apply( set -> {
            tag(BlockTags.SLABS).add(set.SLAB.get()).add(set.DIM_SLAB.get());
            tag(BlockTags.STAIRS).add(set.STAIRS.get()).add(set.DIM_STAIRS.get());
            tag(BlockTags.WALLS).add(set.WALL.get()).add(set.DIM_WALL.get());
            tag(BlockTags.PRESSURE_PLATES).add(set.PRESSURE_PLATE.get()).add(set.DIM_PRESSURE_PLATE.get());
            tag(BlockTags.BUTTONS).add(set.BUTTON.get()).add(set.DIM_BUTTON.get());

            tag(LuminaxRegistry.BLOCKTAG_BLOCK).add(set.BLOCK.get());
            tag(LuminaxRegistry.BLOCKTAG_DIM_BLOCK).add(set.DIM_BLOCK.get());
            tag(LuminaxRegistry.BLOCKTAG_SLAB).add(set.SLAB.get());
            tag(LuminaxRegistry.BLOCKTAG_DIM_SLAB).add(set.DIM_SLAB.get());
            tag(LuminaxRegistry.BLOCKTAG_STAIRS).add(set.STAIRS.get());
            tag(LuminaxRegistry.BLOCKTAG_DIM_STAIRS).add(set.DIM_STAIRS.get());
            tag(LuminaxRegistry.BLOCKTAG_WALL).add(set.WALL.get());
            tag(LuminaxRegistry.BLOCKTAG_DIM_WALL).add(set.DIM_WALL.get());
            tag(LuminaxRegistry.BLOCKTAG_PRESSURE_PLATE).add(set.PRESSURE_PLATE.get());
            tag(LuminaxRegistry.BLOCKTAG_DIM_PRESSURE_PLATE).add(set.DIM_PRESSURE_PLATE.get());
            tag(LuminaxRegistry.BLOCKTAG_BUTTON).add(set.BUTTON.get());
            tag(LuminaxRegistry.BLOCKTAG_DIM_BUTTON).add(set.DIM_BUTTON.get());
        });
    }
}
