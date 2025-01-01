package com.satherov.luminax.content;

import java.util.function.Supplier;

import com.satherov.luminax.Luminax;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class LuminaxRegistry {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Luminax.MOD_ID);
    public static DeferredRegister<Block> BLOCKS = DeferredRegister.createBlocks(Luminax.MOD_ID);
    public static DeferredRegister.Items ITEMS = DeferredRegister.createItems(Luminax.MOD_ID);
    public static DeferredRegister<Block> DYENAMIC_BLOCKS = DeferredRegister.createBlocks(Luminax.MOD_ID);
    public static DeferredRegister.Items DYENAMIC_ITEMS = DeferredRegister.createItems(Luminax.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CREATIVE_TAB = CREATIVE_TABS.register("creative_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable(String.format("itemGroup.%s", Luminax.MOD_ID)))
            .icon(() -> LuminaxRegistry.WHITE.BLOCK.get().asItem().getDefaultInstance())
            .displayItems((parameters, output) ->
                    ITEMS.getEntries().stream()
                        .map(Supplier::get)
                        .map(Item::getDefaultInstance)
                        .forEach(output::accept)
            ).build()
    );

    public static final BlockSet WHITE = new BlockSet("white", false);
    public static final BlockSet LIGHT_GRAY = new BlockSet("light_gray", false);
    public static final BlockSet GRAY = new BlockSet("gray", false);
    public static final BlockSet BLACK = new BlockSet("black", false);
    public static final BlockSet BROWN = new BlockSet("brown", false);
    public static final BlockSet RED = new BlockSet("red", false);
    public static final BlockSet ORANGE = new BlockSet("orange", false);
    public static final BlockSet YELLOW = new BlockSet("yellow", false);
    public static final BlockSet LIME = new BlockSet("lime", false);
    public static final BlockSet GREEN = new BlockSet("green", false);
    public static final BlockSet CYAN = new BlockSet("cyan", false);
    public static final BlockSet LIGHT_BLUE = new BlockSet("light_blue", false);
    public static final BlockSet BLUE = new BlockSet("blue", false);
    public static final BlockSet PURPLE = new BlockSet("purple", false);
    public static final BlockSet MAGENTA = new BlockSet("magenta", false);
    public static final BlockSet PINK = new BlockSet("pink", false);

    public static final BlockSet HONEY = new BlockSet("honey", true);
    public static final BlockSet MINT = new BlockSet("mint", true);
    public static final BlockSet LAVENDER = new BlockSet("lavender", true);
    public static final BlockSet NAVY = new BlockSet("navy", true);
    public static final BlockSet BUBBLEGUM = new BlockSet("bubblegum", true);
    public static final BlockSet AMBER = new BlockSet("amber", true);
    public static final BlockSet CONIFER = new BlockSet("conifer", true);
    public static final BlockSet ICY_BLUE = new BlockSet("icy_blue", true);
    public static final BlockSet ULTRAMARINE = new BlockSet("ultramarine", true);
    public static final BlockSet MAROON = new BlockSet("maroon", true);
    public static final BlockSet WINE = new BlockSet("wine", true);
    public static final BlockSet ROSE = new BlockSet("rose", true);
    public static final BlockSet FLUORESCENT = new BlockSet("fluorescent", true);
    public static final BlockSet SPRING_GREEN = new BlockSet("spring_green", true);
    public static final BlockSet PEACH = new BlockSet("peach", true);
    public static final BlockSet CHERENKOV = new BlockSet("cherenkov", true);
    public static final BlockSet AQUAMARINE = new BlockSet("aquamarine", true);
    public static final BlockSet PERSIMMON = new BlockSet("persimmon", true);

    public static final TagKey<Block> BLOCKTAG_BLOCK = BlockTags.create(ResourceLocation.fromNamespaceAndPath(Luminax.MOD_ID, "blocks"));
    public static final TagKey<Block> BLOCKTAG_DIM_BLOCK = BlockTags.create(ResourceLocation.fromNamespaceAndPath(Luminax.MOD_ID, "dim_blocks"));
    public static final TagKey<Block> BLOCKTAG_SLAB = BlockTags.create(ResourceLocation.fromNamespaceAndPath(Luminax.MOD_ID, "slabs"));
    public static final TagKey<Block> BLOCKTAG_DIM_SLAB = BlockTags.create(ResourceLocation.fromNamespaceAndPath(Luminax.MOD_ID, "dim_slabs"));
    public static final TagKey<Block> BLOCKTAG_STAIRS = BlockTags.create(ResourceLocation.fromNamespaceAndPath(Luminax.MOD_ID, "stairs"));
    public static final TagKey<Block> BLOCKTAG_DIM_STAIRS = BlockTags.create(ResourceLocation.fromNamespaceAndPath(Luminax.MOD_ID, "dim_stairs"));
    public static final TagKey<Block> BLOCKTAG_WALL = BlockTags.create(ResourceLocation.fromNamespaceAndPath(Luminax.MOD_ID, "walls"));
    public static final TagKey<Block> BLOCKTAG_DIM_WALL = BlockTags.create(ResourceLocation.fromNamespaceAndPath(Luminax.MOD_ID, "dim_walls"));
    public static final TagKey<Block> BLOCKTAG_PRESSURE_PLATE = BlockTags.create(ResourceLocation.fromNamespaceAndPath(Luminax.MOD_ID, "pressure_plates"));
    public static final TagKey<Block> BLOCKTAG_DIM_PRESSURE_PLATE = BlockTags.create(ResourceLocation.fromNamespaceAndPath(Luminax.MOD_ID, "dim_pressure_plates"));
    public static final TagKey<Block> BLOCKTAG_BUTTON = BlockTags.create(ResourceLocation.fromNamespaceAndPath(Luminax.MOD_ID, "buttons"));
    public static final TagKey<Block> BLOCKTAG_DIM_BUTTON = BlockTags.create(ResourceLocation.fromNamespaceAndPath(Luminax.MOD_ID, "dim_buttons"));

    public static final TagKey<Item> ITEMTAG_BLOCK = ItemTags.create(ResourceLocation.fromNamespaceAndPath(Luminax.MOD_ID, "blocks"));
    public static final TagKey<Item> ITEMTAG_DIM_BLOCK = ItemTags.create(ResourceLocation.fromNamespaceAndPath(Luminax.MOD_ID, "dim_blocks"));
    public static final TagKey<Item> ITEMTAG_SLAB = ItemTags.create(ResourceLocation.fromNamespaceAndPath(Luminax.MOD_ID, "slabs"));
    public static final TagKey<Item> ITEMTAG_DIM_SLAB = ItemTags.create(ResourceLocation.fromNamespaceAndPath(Luminax.MOD_ID, "dim_slabs"));
    public static final TagKey<Item> ITEMTAG_STAIRS = ItemTags.create(ResourceLocation.fromNamespaceAndPath(Luminax.MOD_ID, "stairs"));
    public static final TagKey<Item> ITEMTAG_DIM_STAIRS = ItemTags.create(ResourceLocation.fromNamespaceAndPath(Luminax.MOD_ID, "dim_stairs"));
    public static final TagKey<Item> ITEMTAG_WALL = ItemTags.create(ResourceLocation.fromNamespaceAndPath(Luminax.MOD_ID, "walls"));
    public static final TagKey<Item> ITEMTAG_DIM_WALL = ItemTags.create(ResourceLocation.fromNamespaceAndPath(Luminax.MOD_ID, "dim_walls"));
    public static final TagKey<Item> ITEMTAG_PRESSURE_PLATE = ItemTags.create(ResourceLocation.fromNamespaceAndPath(Luminax.MOD_ID, "pressure_plates"));
    public static final TagKey<Item> ITEMTAG_DIM_PRESSURE_PLATE = ItemTags.create(ResourceLocation.fromNamespaceAndPath(Luminax.MOD_ID, "dim_pressure_plates"));
    public static final TagKey<Item> ITEMTAG_BUTTON = ItemTags.create(ResourceLocation.fromNamespaceAndPath(Luminax.MOD_ID, "buttons"));
    public static final TagKey<Item> ITEMTAG_DIM_BUTTON = ItemTags.create(ResourceLocation.fromNamespaceAndPath(Luminax.MOD_ID, "dim_buttons"));

}
