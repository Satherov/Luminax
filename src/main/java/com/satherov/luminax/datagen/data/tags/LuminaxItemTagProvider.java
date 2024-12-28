package com.satherov.luminax.datagen.data.tags;

import com.satherov.luminax.content.LuminaxRegistry;
import com.satherov.luminax.content.SetHelper;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

public class LuminaxItemTagProvider extends ItemTagsProvider {

    public LuminaxItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags) {
        super(output, lookupProvider, blockTags);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        SetHelper.apply(set -> {
            tag(ItemTags.SLABS).add(set.SLAB.get().asItem());
            tag(ItemTags.STAIRS).add(set.STAIRS.get().asItem());
            tag(ItemTags.WALLS).add(set.WALL.get().asItem());
            tag(ItemTags.BUTTONS).add(set.BUTTON.get().asItem());

            tag(LuminaxRegistry.ITEMTAG_BLOCK).add(set.BLOCK.get().asItem());
            tag(LuminaxRegistry.ITEMTAG_DIM_BLOCK).add(set.DIM_BLOCK.get().asItem());
            tag(LuminaxRegistry.ITEMTAG_SLAB).add(set.SLAB.get().asItem());
            tag(LuminaxRegistry.ITEMTAG_DIM_SLAB).add(set.DIM_SLAB.get().asItem());
            tag(LuminaxRegistry.ITEMTAG_STAIRS).add(set.STAIRS.get().asItem());
            tag(LuminaxRegistry.ITEMTAG_DIM_STAIRS).add(set.DIM_STAIRS.get().asItem());
            tag(LuminaxRegistry.ITEMTAG_WALL).add(set.WALL.get().asItem());
            tag(LuminaxRegistry.ITEMTAG_DIM_WALL).add(set.DIM_WALL.get().asItem());
            tag(LuminaxRegistry.ITEMTAG_PRESSURE_PLATE).add(set.PRESSURE_PLATE.get().asItem());
            tag(LuminaxRegistry.ITEMTAG_DIM_PRESSURE_PLATE).add(set.DIM_PRESSURE_PLATE.get().asItem());
            tag(LuminaxRegistry.ITEMTAG_BUTTON).add(set.BUTTON.get().asItem());
            tag(LuminaxRegistry.ITEMTAG_DIM_BUTTON).add(set.DIM_BUTTON.get().asItem());
        });
    }
}
