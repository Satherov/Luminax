package com.satherov.luminax.datagen.assets;

import com.satherov.luminax.Luminax;
import com.satherov.luminax.content.SetHelper;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

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

            blockModel(set.DIM_BLOCK, set.BLOCK);
            slabModel(set.DIM_SLAB, set.BLOCK);
            stairModel(set.DIM_STAIRS, set.BLOCK);
            buttonModel(set.DIM_BUTTON, set.BLOCK);
            pressurePlateModel(set.DIM_PRESSURE_PLATE, set.BLOCK);
            wallModel(set.DIM_WALL, set.BLOCK);
        });
    }

    private ResourceLocation block(RegistryObject<? extends Block> block) {
        return modLoc("block/" + block.getId().getPath());
    }

    private void blockModel(RegistryObject<? extends Block> block) {
        this.singleTexture("block/" + block.getId().getPath(), new ResourceLocation(Luminax.MOD_ID, "block/no_shade_block"), "texture", block(block));
    }

    private void blockModel(RegistryObject<? extends Block> block, RegistryObject<? extends Block> block2) {
        this.singleTexture("block/" + block.getId().getPath(), new ResourceLocation(Luminax.MOD_ID, "block/no_shade_block"), "texture", block(block2));
    }

    private void slabModel(RegistryObject<? extends SlabBlock> slab, RegistryObject<? extends Block> block) {
        this.singleTexture("block/" + slab.getId().getPath(), new ResourceLocation(Luminax.MOD_ID, "block/no_shade_slab"), "texture", block(block));
        this.singleTexture("block/" + slab.getId().getPath() + "_top", new ResourceLocation(Luminax.MOD_ID, "block/no_shade_slab_top"), "texture", block(block));
    }

    private void stairModel(RegistryObject<? extends StairBlock> stair, RegistryObject<? extends Block> block) {
        this.singleTexture("block/" + stair.getId().getPath(), new ResourceLocation(Luminax.MOD_ID, "block/no_shade_stair"), "texture", block(block));
        this.singleTexture("block/" + stair.getId().getPath() + "_inner", new ResourceLocation(Luminax.MOD_ID, "block/no_shade_inner_stair"), "texture", block(block));
        this.singleTexture("block/" + stair.getId().getPath() + "_outer", new ResourceLocation(Luminax.MOD_ID, "block/no_shade_outer_stair"), "texture", block(block));
    }

    private void buttonModel(RegistryObject<? extends ButtonBlock> button, RegistryObject<? extends Block> block) {
        this.singleTexture("block/" + button.getId().getPath(), new ResourceLocation(Luminax.MOD_ID, "block/no_shade_button"), "texture", block(block));
        this.singleTexture("block/" + button.getId().getPath() + "_pressed", new ResourceLocation(Luminax.MOD_ID, "block/no_shade_button_pressed"), block(block));
        this.singleTexture("block/" + button.getId().getPath() + "_inventory", new ResourceLocation(Luminax.MOD_ID, "block/no_shade_button_inventory"), "texture", block(block));
    }

    private void pressurePlateModel(RegistryObject<? extends PressurePlateBlock> pressurePlate, RegistryObject<? extends Block> block) {
        this.singleTexture("block/" + pressurePlate.getId().getPath(), new ResourceLocation(Luminax.MOD_ID, "block/no_shade_pressure_plate_up"), "texture", block(block));
        this.singleTexture("block/" + pressurePlate.getId().getPath() + "_down", new ResourceLocation(Luminax.MOD_ID, "block/no_shade_pressure_plate_down"), "texture", block(block));
    }

    private void wallModel(RegistryObject<? extends WallBlock> wall, RegistryObject<? extends Block> block) {
        this.singleTexture("block/" + wall.getId().getPath(), new ResourceLocation(Luminax.MOD_ID, "block/no_shade_wall_inventory"), "texture", block(block));
        this.singleTexture("block/" + wall.getId().getPath() + "_post", new ResourceLocation(Luminax.MOD_ID, "block/no_shade_wall_post"), "texture", block(block));
        this.singleTexture("block/" + wall.getId().getPath() + "_side", new ResourceLocation(Luminax.MOD_ID, "block/no_shade_wall_side"), "texture", block(block));
        this.singleTexture("block/" + wall.getId().getPath() + "_side_tall", new ResourceLocation(Luminax.MOD_ID, "block/no_shade_wall_side_tall"), "texture", block(block));
    }
}
