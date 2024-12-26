package com.satherov.luminex.datagen.data.tags;

import com.satherov.luminex.Luminex;
import com.satherov.luminex.content.LuminexRegistry;
import com.satherov.luminex.content.SetHelper;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class LuminexBlockTagProvider extends BlockTagsProvider {

    public LuminexBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Luminex.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        SetHelper.apply( set -> {
            tag(BlockTags.SLABS).add(set.SLAB.get());
            tag(BlockTags.STAIRS).add(set.STAIRS.get());
            tag(BlockTags.WALLS).add(set.WALL.get());
            tag(BlockTags.PRESSURE_PLATES).add(set.PRESSURE_PLATE.get());
            tag(BlockTags.BUTTONS).add(set.BUTTON.get());

            tag(BlockTags.MINEABLE_WITH_PICKAXE)
                    .add(set.BLOCK.get())
                    .add(set.SLAB.get())
                    .add(set.STAIRS.get())
                    .add(set.WALL.get())
                    .add(set.PRESSURE_PLATE.get())
                    .add(set.BUTTON.get());

            tag(LuminexRegistry.BLOCKTAG_BLOCK).add(set.BLOCK.get());
            tag(LuminexRegistry.BLOCKTAG_SLAB).add(set.SLAB.get());
            tag(LuminexRegistry.BLOCKTAG_STAIRS).add(set.STAIRS.get());
            tag(LuminexRegistry.BLOCKTAG_WALL).add(set.WALL.get());
            tag(LuminexRegistry.BLOCKTAG_PRESSURE_PLATE).add(set.PRESSURE_PLATE.get());
            tag(LuminexRegistry.BLOCKTAG_BUTTON).add(set.BUTTON.get());
        });
    }
}
