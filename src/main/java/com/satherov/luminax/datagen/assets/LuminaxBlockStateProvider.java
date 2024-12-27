package com.satherov.luminax.datagen.assets;

import com.satherov.luminax.Luminax;
import com.satherov.luminax.content.SetHelper;
import net.minecraft.core.Direction;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.properties.*;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.client.model.generators.MultiPartBlockStateBuilder;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.Map;

public class LuminaxBlockStateProvider extends BlockStateProvider {

    public LuminaxBlockStateProvider(DataGenerator generator, ExistingFileHelper fileHelper) {
        super(generator.getPackOutput(), Luminax.MOD_ID, fileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        SetHelper.apply( set -> {
            simpleBlock(set.BLOCK.get(), getExistingFile(set.BLOCK.getId().getPath()));
            slabBlock(set.SLAB, set.BLOCK);
            stairsBlock(set.STAIRS);
            buttonBlock(set.BUTTON);
            pressurePlateBlock(set.PRESSURE_PLATE);
            wallBlock(set.WALL);
        });
    }

    private ResourceLocation block(DeferredHolder<Block, ? extends Block> block) {
        return modLoc("block/" + block.getId().getPath());
    }

    private ModelFile getExistingFile(String path) {
        return models().getExistingFile(ResourceLocation.fromNamespaceAndPath(Luminax.MOD_ID, path));
    }

    public void slabBlock(DeferredHolder<Block, ? extends SlabBlock> slab, DeferredHolder<Block, ? extends Block> block) {
        this.getVariantBuilder(slab.get())
                .partialState().with(SlabBlock.TYPE, SlabType.BOTTOM)
                .addModels(new ConfiguredModel(getExistingFile(slab.getId().getPath())))
                .partialState().with(SlabBlock.TYPE, SlabType.TOP)
                .addModels(new ConfiguredModel(getExistingFile(slab.getId().getPath() + "_top")))
                .partialState().with(SlabBlock.TYPE, SlabType.DOUBLE)
                .addModels(new ConfiguredModel(models().getExistingFile(block(block))));
    }

    public void stairsBlock(DeferredHolder<Block, ? extends StairBlock> stair) {
        this.getVariantBuilder(stair.get()).forAllStatesExcept((state) -> {
            Direction facing = state.getValue(StairBlock.FACING);
            Half half = state.getValue(StairBlock.HALF);
            StairsShape shape = state.getValue(StairBlock.SHAPE);
            int yRot = (int)facing.getClockWise().toYRot();
            if (shape == StairsShape.INNER_LEFT || shape == StairsShape.OUTER_LEFT) {
                yRot += 270;
            }

            if (shape != StairsShape.STRAIGHT && half == Half.TOP) {
                yRot += 90;
            }

            yRot %= 360;
            boolean uvlock = yRot != 0 || half == Half.TOP;
            return ConfiguredModel.builder().modelFile(
                    shape == StairsShape.STRAIGHT ?
                            getExistingFile(stair.getId().getPath()) :
                            (shape != StairsShape.INNER_LEFT && shape != StairsShape.INNER_RIGHT ?
                            getExistingFile(stair.getId().getPath() + "_outer") :
                            getExistingFile(stair.getId().getPath() + "_inner"))
                    ).rotationX(half == Half.BOTTOM ? 0 : 180).rotationY(yRot).uvLock(uvlock).build();
        }, StairBlock.WATERLOGGED);
    }

    public void buttonBlock(DeferredHolder<Block, ? extends ButtonBlock> button) {
        this.getVariantBuilder(button.get()).forAllStates((state) -> {
            Direction facing = state.getValue(ButtonBlock.FACING);
            AttachFace face = state.getValue(ButtonBlock.FACE);
            boolean powered = state.getValue(ButtonBlock.POWERED);
            return ConfiguredModel.builder().modelFile(powered ?
                            getExistingFile(button.getId().getPath() + "_pressed") :
                            getExistingFile(button.getId().getPath())
                    ).rotationX(face == AttachFace.FLOOR ? 0 : (face == AttachFace.WALL ? 90 : 180))
                    .rotationY((int)(face == AttachFace.CEILING ? facing : facing.getOpposite()).toYRot())
                    .uvLock(face == AttachFace.WALL).build();
        });
    }

    public void pressurePlateBlock(DeferredHolder<Block, ? extends PressurePlateBlock> pressurePlate) {
        this.getVariantBuilder(pressurePlate.get())
                .partialState().with(PressurePlateBlock.POWERED, true)
                .addModels(new ConfiguredModel(getExistingFile(pressurePlate.getId().getPath() + "_down")))
                .partialState().with(PressurePlateBlock.POWERED, false)
                .addModels(new ConfiguredModel(getExistingFile(pressurePlate.getId().getPath())));
    }

    public void wallBlock(DeferredHolder<Block, ? extends WallBlock> wall) {
        MultiPartBlockStateBuilder builder = this.getMultipartBuilder(wall.get()).part().modelFile(getExistingFile(wall.getId().getPath() + "_post")).addModel().condition(WallBlock.UP, true).end();
        WALL_PROPS.entrySet().stream().filter((e) -> e.getKey().getAxis().isHorizontal()).forEach((e) -> {
            this.wallSidePart(builder, getExistingFile(wall.getId().getPath() + "_side"), e, WallSide.LOW);
            this.wallSidePart(builder, getExistingFile(wall.getId().getPath() + "_side_tall"), e, WallSide.TALL);
        });
    }

    private void wallSidePart(MultiPartBlockStateBuilder builder, ModelFile model, Map.Entry<Direction, Property<WallSide>> entry, WallSide height) {
        builder.part().modelFile(model).rotationY(((int) entry.getKey().toYRot() + 180) % 360).uvLock(true).addModel().condition(entry.getValue(), height);
    }
}
