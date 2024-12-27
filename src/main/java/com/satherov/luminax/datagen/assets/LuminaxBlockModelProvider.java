package com.satherov.luminax.datagen.assets;

import com.satherov.luminax.Luminax;
import com.satherov.luminax.content.SetHelper;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.neoforged.neoforge.client.model.generators.BlockModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;

public class LuminaxBlockModelProvider extends BlockModelProvider {

    public LuminaxBlockModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Luminax.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        SetHelper.apply(set -> {
            blockModel(set.BLOCK);
            slabModel(set.SLAB, set.BLOCK);
            stairModel(set.STAIRS, set.BLOCK);
            buttonModel(set.BUTTON, set.BLOCK);
            pressurePlateModel(set.PRESSURE_PLATE, set.BLOCK);
            wallModel(set.WALL, set.BLOCK);
        });
    }

    private ResourceLocation block(DeferredHolder<Block, ? extends Block> block) {
        return modLoc("block/" + block.getId().getPath());
    }

    private void blockModel(DeferredHolder<Block, ? extends Block> block) {
        this.singleTexture("block/" + block.getId().getPath(), ResourceLocation.fromNamespaceAndPath(Luminax.MOD_ID, "block/no_shade_block"), "texture", block(block));
    }

    private void slabModel(DeferredHolder<Block, ? extends SlabBlock> slab, DeferredHolder<Block, ? extends Block> block) {
        this.singleTexture("block/" + slab.getId().getPath(), ResourceLocation.fromNamespaceAndPath(Luminax.MOD_ID, "block/no_shade_slab"), "texture", block(block));
        this.singleTexture("block/" + slab.getId().getPath() + "_top", ResourceLocation.fromNamespaceAndPath(Luminax.MOD_ID, "block/no_shade_slab_top"), "texture", block(block));
    }

    private void stairModel(DeferredHolder<Block, ? extends StairBlock> stair, DeferredHolder<Block, ? extends Block> block) {
        this.singleTexture("block/" + stair.getId().getPath(), ResourceLocation.fromNamespaceAndPath(Luminax.MOD_ID, "block/no_shade_stair"), "texture", block(block));
        this.singleTexture("block/" + stair.getId().getPath() + "_inner", ResourceLocation.fromNamespaceAndPath(Luminax.MOD_ID, "block/no_shade_inner_stair"), "texture", block(block));
        this.singleTexture("block/" + stair.getId().getPath() + "_outer", ResourceLocation.fromNamespaceAndPath(Luminax.MOD_ID, "block/no_shade_outer_stair"), "texture", block(block));
    }

    private void buttonModel(DeferredHolder<Block, ? extends ButtonBlock> button, DeferredHolder<Block, ? extends Block> block) {
        this.singleTexture("block/" + button.getId().getPath(), ResourceLocation.fromNamespaceAndPath(Luminax.MOD_ID, "block/no_shade_button"), "texture", block(block));
        this.singleTexture("block/" + button.getId().getPath() + "_pressed", ResourceLocation.fromNamespaceAndPath(Luminax.MOD_ID, "block/no_shade_button_pressed"), block(block));
        this.singleTexture("block/" + button.getId().getPath() + "_inventory", ResourceLocation.fromNamespaceAndPath(Luminax.MOD_ID, "block/no_shade_button_inventory"), "texture", block(block));
    }

    private void pressurePlateModel(DeferredHolder<Block, ? extends PressurePlateBlock> pressurePlate, DeferredHolder<Block, ? extends Block> block) {
        this.singleTexture("block/" + pressurePlate.getId().getPath(), ResourceLocation.fromNamespaceAndPath(Luminax.MOD_ID, "block/no_shade_pressure_plate_up"), "texture", block(block));
        this.singleTexture("block/" + pressurePlate.getId().getPath() + "_down", ResourceLocation.fromNamespaceAndPath(Luminax.MOD_ID, "block/no_shade_pressure_plate_down"), "texture", block(block));
    }

    private void wallModel(DeferredHolder<Block, ? extends WallBlock> wall, DeferredHolder<Block, ? extends Block> block) {
        this.singleTexture("block/" + wall.getId().getPath(), ResourceLocation.fromNamespaceAndPath(Luminax.MOD_ID, "block/no_shade_wall_inventory"), "texture", block(block));
        this.singleTexture("block/" + wall.getId().getPath() + "_post", ResourceLocation.fromNamespaceAndPath(Luminax.MOD_ID, "block/no_shade_wall_post"), "texture", block(block));
        this.singleTexture("block/" + wall.getId().getPath() + "_side", ResourceLocation.fromNamespaceAndPath(Luminax.MOD_ID, "block/no_shade_wall_side"), "texture", block(block));
        this.singleTexture("block/" + wall.getId().getPath() + "_side_tall", ResourceLocation.fromNamespaceAndPath(Luminax.MOD_ID, "block/no_shade_wall_side_tall"), "texture", block(block));
    }
}
