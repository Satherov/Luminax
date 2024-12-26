package com.satherov.luminex.datagen.data.tags;

import com.satherov.luminex.content.LuminexRegistry;
import com.satherov.luminex.content.SetHelper;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

public class LuminexItemTagProvider extends ItemTagsProvider {

    public LuminexItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, CompletableFuture<TagLookup<Block>> blockTags) {
        super(output, lookupProvider, blockTags);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        SetHelper.apply(set -> {
            tag(ItemTags.SLABS).add(set.SLAB.get().asItem());
            tag(ItemTags.STAIRS).add(set.STAIRS.get().asItem());
            tag(ItemTags.WALLS).add(set.WALL.get().asItem());
            tag(ItemTags.BUTTONS).add(set.BUTTON.get().asItem());

            tag(LuminexRegistry.ITEMTAG_BLOCK).add(set.BLOCK.get().asItem());
            tag(LuminexRegistry.ITEMTAG_SLAB).add(set.SLAB.get().asItem());
            tag(LuminexRegistry.ITEMTAG_STAIRS).add(set.STAIRS.get().asItem());
            tag(LuminexRegistry.ITEMTAG_WALL).add(set.WALL.get().asItem());
            tag(LuminexRegistry.ITEMTAG_PRESSURE_PLATE).add(set.PRESSURE_PLATE.get().asItem());
            tag(LuminexRegistry.ITEMTAG_BUTTON).add(set.BUTTON.get().asItem());
        });
    }
}
