package com.satherov.luminex.datagen.assets;

import com.satherov.luminex.Luminex;
import com.satherov.luminex.content.SetHelper;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;

public class LuminexItemModelProvider extends ItemModelProvider {

    public LuminexItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Luminex.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        SetHelper.apply(set -> {
            blockModel(set.BLOCK);
            blockModel(set.SLAB);
            blockModel(set.STAIRS);
            blockModel(set.WALL);
            blockModel(set.PRESSURE_PLATE);
            buttonModel(set.BUTTON);
        });
    }

    public void blockModel(DeferredHolder<Block, ? extends Block> block) {
        withExistingParent(block.getId().getPath(), modLoc("block/" + block.getId().getPath()));
    }

    public void buttonModel(DeferredHolder<Block, ? extends ButtonBlock> block) {
        withExistingParent(block.getId().getPath(), modLoc("block/" + block.getId().getPath() + "_inventory"));
    }
}
