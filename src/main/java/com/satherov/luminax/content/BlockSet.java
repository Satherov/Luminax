package com.satherov.luminax.content;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraftforge.registries.RegistryObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class BlockSet {

    public final String name;

    private static final List<BlockSet> instances = new ArrayList<>();
    public static List<BlockSet> getSets() {
        return instances;
    }

    public final RegistryObject<Block> BLOCK;
    public final RegistryObject<StairBlock> STAIRS;
    public final RegistryObject<SlabBlock> SLAB;
    public final RegistryObject<WallBlock> WALL;
    public final RegistryObject<PressurePlateBlock> PRESSURE_PLATE;
    public final RegistryObject<ButtonBlock> BUTTON;

    public final RegistryObject<Block> DIM_BLOCK;
    public final RegistryObject<StairBlock> DIM_STAIRS;
    public final RegistryObject<SlabBlock> DIM_SLAB;
    public final RegistryObject<WallBlock> DIM_WALL;
    public final RegistryObject<PressurePlateBlock> DIM_PRESSURE_PLATE;
    public final RegistryObject<ButtonBlock> DIM_BUTTON;

    public BlockSet(String name) {
        this.name = name;
        instances.add(this);

        BLOCK = register(String.format("%s_block", name), () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).lightLevel((state) -> 15)));
        STAIRS = register(String.format("%s_stairs", name), () -> new StairBlock(BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.STONE_STAIRS).lightLevel((state) -> 15)));
        SLAB = register(String.format("%s_slab", name), () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_SLAB).lightLevel((state) -> 15)));
        WALL = register(String.format("%s_wall", name), () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL).lightLevel((state) -> 15)));
        PRESSURE_PLATE = register(String.format("%s_pressure_plate", name), () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.STONE_PRESSURE_PLATE).lightLevel((state) -> 15), BlockSetType.STONE));
        BUTTON = register(String.format("%s_button", name), () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).lightLevel((state) -> 15), BlockSetType.STONE, 20, true));

        DIM_BLOCK = register(String.format("dim_%s_block", name), () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE)));
        DIM_STAIRS = register(String.format("dim_%s_stairs", name), () -> new StairBlock(BLOCK.get().defaultBlockState(), BlockBehaviour.Properties.copy(Blocks.STONE_STAIRS)));
        DIM_SLAB = register(String.format("dim_%s_slab", name), () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE_SLAB)));
        DIM_WALL = register(String.format("dim_%s_wall", name), () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BRICK_WALL)));
        DIM_PRESSURE_PLATE = register(String.format("dim_%s_pressure_plate", name), () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.copy(Blocks.STONE_PRESSURE_PLATE), BlockSetType.STONE));
        DIM_BUTTON = register(String.format("dim_%s_button", name), () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON), BlockSetType.STONE, 20, true));

    }

    private static <T extends Block> RegistryObject<T> register (String name, Supplier<T> properties) {
        RegistryObject<T> block = LuminaxRegistry.BLOCKS.register(name, properties);
        LuminaxRegistry.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
        return block;
    }
}
