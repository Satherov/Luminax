package com.satherov.luminax.content;

import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.neoforged.neoforge.registries.DeferredHolder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class BlockSet {

    public final String name;

    private static final List<BlockSet> instances = new ArrayList<>();
    public static List<BlockSet> getSets() {
        return instances;
    }

    public final DeferredHolder<Block, Block> BLOCK;
    public final DeferredHolder<Block, StairBlock> STAIRS;
    public final DeferredHolder<Block, SlabBlock> SLAB;
    public final DeferredHolder<Block, WallBlock> WALL;
    public final DeferredHolder<Block, PressurePlateBlock> PRESSURE_PLATE;
    public final DeferredHolder<Block, ButtonBlock> BUTTON;

    public final DeferredHolder<Block, Block> DIM_BLOCK;
    public final DeferredHolder<Block, StairBlock> DIM_STAIRS;
    public final DeferredHolder<Block, SlabBlock> DIM_SLAB;
    public final DeferredHolder<Block, WallBlock> DIM_WALL;
    public final DeferredHolder<Block, PressurePlateBlock> DIM_PRESSURE_PLATE;
    public final DeferredHolder<Block, ButtonBlock> DIM_BUTTON;

    public BlockSet(String name) {
        this.name = name;
        instances.add(this);

        BLOCK = register(String.format("%s_block", name), () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE).lightLevel((state) -> 15)));
        STAIRS = register(String.format("%s_stairs", name), () -> new StairBlock(BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS).lightLevel((state) -> 15)));
        SLAB = register(String.format("%s_slab", name), () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB).lightLevel((state) -> 15)));
        WALL = register(String.format("%s_wall", name), () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL).lightLevel((state) -> 15)));
        PRESSURE_PLATE = register(String.format("%s_pressure_plate", name), () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE).lightLevel((state) -> 15)));
        BUTTON = register(String.format("%s_button", name), () -> new ButtonBlock(BlockSetType.STONE, 20, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BUTTON).lightLevel((state) -> 15)));

        DIM_BLOCK = register(String.format("dim_%s_block", name), () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)));
        DIM_STAIRS = register(String.format("dim_%s_stairs", name), () -> new StairBlock(BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_STAIRS)));
        DIM_SLAB = register(String.format("dim_%s_slab", name), () -> new SlabBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_SLAB)));
        DIM_WALL = register(String.format("dim_%s_wall", name), () -> new WallBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BRICK_WALL)));
        DIM_PRESSURE_PLATE = register(String.format("dim_%s_pressure_plate", name), () -> new PressurePlateBlock(BlockSetType.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_PRESSURE_PLATE)));
        DIM_BUTTON = register(String.format("dim_%s_button", name), () -> new ButtonBlock(BlockSetType.STONE, 20, BlockBehaviour.Properties.ofFullCopy(Blocks.STONE_BUTTON)));

    }

    private static <T extends Block> DeferredHolder<Block, T> register (String name, Supplier<T> properties) {
        DeferredHolder<Block, T> block = LuminaxRegistry.BLOCKS.register(name, properties);
        LuminaxRegistry.ITEMS.registerSimpleBlockItem(name, block);
        return block;
    }
}
