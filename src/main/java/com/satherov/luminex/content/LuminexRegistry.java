package com.satherov.luminex.content;

import com.satherov.luminex.Luminex;
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

public class LuminexRegistry {


    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Luminex.MOD_ID);
    public static DeferredRegister<Block> BLOCKS = DeferredRegister.createBlocks(Luminex.MOD_ID);
    public static DeferredRegister.Items ITEMS = DeferredRegister.createItems(Luminex.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CREATIVE_TAB = CREATIVE_TABS.register("creative_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable(String.format("itemGroup.%s", Luminex.MOD_ID)))
            .icon(() -> LuminexRegistry.WHITE.BLOCK.get().asItem().getDefaultInstance())
            .build()
    );

    public static final BlockSet WHITE = new BlockSet("white");
    public static final BlockSet LIGHT_GRAY = new BlockSet("light_gray");
    public static final BlockSet GRAY = new BlockSet("gray");
    public static final BlockSet BLACK = new BlockSet("black");
    public static final BlockSet BROWN = new BlockSet("brown");
    public static final BlockSet RED = new BlockSet("red");
    public static final BlockSet ORANGE = new BlockSet("orange");
    public static final BlockSet YELLOW = new BlockSet("yellow");
    public static final BlockSet LIME = new BlockSet("lime");
    public static final BlockSet GREEN = new BlockSet("green");
    public static final BlockSet CYAN = new BlockSet("cyan");
    public static final BlockSet LIGHT_BLUE = new BlockSet("light_blue");
    public static final BlockSet BLUE = new BlockSet("blue");
    public static final BlockSet PURPLE = new BlockSet("purple");
    public static final BlockSet MAGENTA = new BlockSet("magenta");
    public static final BlockSet PINK = new BlockSet("pink");

    public static final TagKey<Block> BLOCKTAG_BLOCK = BlockTags.create(ResourceLocation.fromNamespaceAndPath(Luminex.MOD_ID, "blocks"));
    public static final TagKey<Block> BLOCKTAG_SLAB = BlockTags.create(ResourceLocation.fromNamespaceAndPath(Luminex.MOD_ID, "slabs"));
    public static final TagKey<Block> BLOCKTAG_STAIRS = BlockTags.create(ResourceLocation.fromNamespaceAndPath(Luminex.MOD_ID, "stairs"));
    public static final TagKey<Block> BLOCKTAG_WALL = BlockTags.create(ResourceLocation.fromNamespaceAndPath(Luminex.MOD_ID, "walls"));
    public static final TagKey<Block> BLOCKTAG_PRESSURE_PLATE = BlockTags.create(ResourceLocation.fromNamespaceAndPath(Luminex.MOD_ID, "pressure_plates"));
    public static final TagKey<Block> BLOCKTAG_BUTTON = BlockTags.create(ResourceLocation.fromNamespaceAndPath(Luminex.MOD_ID, "buttons"));

    public static final TagKey<Item> ITEMTAG_BLOCK = ItemTags.create(ResourceLocation.fromNamespaceAndPath(Luminex.MOD_ID, "blocks"));
    public static final TagKey<Item> ITEMTAG_SLAB = ItemTags.create(ResourceLocation.fromNamespaceAndPath(Luminex.MOD_ID, "slabs"));
    public static final TagKey<Item> ITEMTAG_STAIRS = ItemTags.create(ResourceLocation.fromNamespaceAndPath(Luminex.MOD_ID, "stairs"));
    public static final TagKey<Item> ITEMTAG_WALL = ItemTags.create(ResourceLocation.fromNamespaceAndPath(Luminex.MOD_ID, "walls"));
    public static final TagKey<Item> ITEMTAG_PRESSURE_PLATE = ItemTags.create(ResourceLocation.fromNamespaceAndPath(Luminex.MOD_ID, "pressure_plates"));
    public static final TagKey<Item> ITEMTAG_BUTTON = ItemTags.create(ResourceLocation.fromNamespaceAndPath(Luminex.MOD_ID, "buttons"));

}