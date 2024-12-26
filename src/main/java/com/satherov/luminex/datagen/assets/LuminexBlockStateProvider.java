package com.satherov.luminex.datagen.assets;

import com.satherov.luminex.Luminex;
import com.satherov.luminex.content.SetHelper;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.WallBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;

public class LuminexBlockStateProvider extends BlockStateProvider {

    public LuminexBlockStateProvider(DataGenerator generator, ExistingFileHelper fileHelper) {
        super(generator.getPackOutput(), Luminex.MOD_ID, fileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        SetHelper.apply( set -> {
            simpleBlockWithItem(set.BLOCK.get(), cubeAll(set.BLOCK.get()));
            slabBlock(set.SLAB.get(), block(set.BLOCK), block(set.BLOCK));
            stairsBlock(set.STAIRS.get(), block(set.BLOCK));
            wall(set.WALL, block(set.BLOCK));
            pressurePlateBlock(set.PRESSURE_PLATE.get(), block(set.BLOCK));
            buttonBlock(set.BUTTON, block(set.BLOCK));
        });
    }

    private ResourceLocation block(DeferredHolder<Block, ? extends Block> block) {
        return modLoc("block/" + block.getId().getPath());
    }

    public void wall(DeferredHolder<Block, WallBlock> block, ResourceLocation texture) {
        super.wallBlock(block.get(), texture);
        models().wallInventory(block.getId().getPath(), texture);
    }

    public void buttonBlock(DeferredHolder<Block, ButtonBlock> block, ResourceLocation texture) {
        super.buttonBlock(block.get(), texture);
        models().buttonInventory(block.getId().getPath() + "_inventory", texture);
    }
}
