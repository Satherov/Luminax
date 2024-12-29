package com.satherov.luminax.content;

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
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class LuminaxRegistry {


    public static final DeferredRegister<CreativeModeTab> CREATIVE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Luminax.MOD_ID);
    public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, Luminax.MOD_ID);
    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(Registries.ITEM, Luminax.MOD_ID);

    public static final RegistryObject<CreativeModeTab> CREATIVE_TAB = CREATIVE_TABS.register("creative_tab", () -> CreativeModeTab.builder()
            .title(Component.translatable(String.format("itemGroup.%s", Luminax.MOD_ID)))
            .icon(() -> LuminaxRegistry.WHITE.BLOCK.get().asItem().getDefaultInstance())
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

    public static final TagKey<Block> BLOCKTAG_BLOCK = BlockTags.create(new ResourceLocation(Luminax.MOD_ID, "blocks"));
    public static final TagKey<Block> BLOCKTAG_DIM_BLOCK = BlockTags.create(new ResourceLocation(Luminax.MOD_ID, "dim_blocks"));
    public static final TagKey<Block> BLOCKTAG_SLAB = BlockTags.create(new ResourceLocation(Luminax.MOD_ID, "slabs"));
    public static final TagKey<Block> BLOCKTAG_DIM_SLAB = BlockTags.create(new ResourceLocation(Luminax.MOD_ID, "dim_slabs"));
    public static final TagKey<Block> BLOCKTAG_STAIRS = BlockTags.create(new ResourceLocation(Luminax.MOD_ID, "stairs"));
    public static final TagKey<Block> BLOCKTAG_DIM_STAIRS = BlockTags.create(new ResourceLocation(Luminax.MOD_ID, "dim_stairs"));
    public static final TagKey<Block> BLOCKTAG_WALL = BlockTags.create(new ResourceLocation(Luminax.MOD_ID, "walls"));
    public static final TagKey<Block> BLOCKTAG_DIM_WALL = BlockTags.create(new ResourceLocation(Luminax.MOD_ID, "dim_walls"));
    public static final TagKey<Block> BLOCKTAG_PRESSURE_PLATE = BlockTags.create(new ResourceLocation(Luminax.MOD_ID, "pressure_plates"));
    public static final TagKey<Block> BLOCKTAG_DIM_PRESSURE_PLATE = BlockTags.create(new ResourceLocation(Luminax.MOD_ID, "dim_pressure_plates"));
    public static final TagKey<Block> BLOCKTAG_BUTTON = BlockTags.create(new ResourceLocation(Luminax.MOD_ID, "buttons"));
    public static final TagKey<Block> BLOCKTAG_DIM_BUTTON = BlockTags.create(new ResourceLocation(Luminax.MOD_ID, "dim_buttons"));

    public static final TagKey<Item> ITEMTAG_BLOCK = ItemTags.create(new ResourceLocation(Luminax.MOD_ID, "blocks"));
    public static final TagKey<Item> ITEMTAG_DIM_BLOCK = ItemTags.create(new ResourceLocation(Luminax.MOD_ID, "dim_blocks"));
    public static final TagKey<Item> ITEMTAG_SLAB = ItemTags.create(new ResourceLocation(Luminax.MOD_ID, "slabs"));
    public static final TagKey<Item> ITEMTAG_DIM_SLAB = ItemTags.create(new ResourceLocation(Luminax.MOD_ID, "dim_slabs"));
    public static final TagKey<Item> ITEMTAG_STAIRS = ItemTags.create(new ResourceLocation(Luminax.MOD_ID, "stairs"));
    public static final TagKey<Item> ITEMTAG_DIM_STAIRS = ItemTags.create(new ResourceLocation(Luminax.MOD_ID, "dim_stairs"));
    public static final TagKey<Item> ITEMTAG_WALL = ItemTags.create(new ResourceLocation(Luminax.MOD_ID, "walls"));
    public static final TagKey<Item> ITEMTAG_DIM_WALL = ItemTags.create(new ResourceLocation(Luminax.MOD_ID, "dim_walls"));
    public static final TagKey<Item> ITEMTAG_PRESSURE_PLATE = ItemTags.create(new ResourceLocation(Luminax.MOD_ID, "pressure_plates"));
    public static final TagKey<Item> ITEMTAG_DIM_PRESSURE_PLATE = ItemTags.create(new ResourceLocation(Luminax.MOD_ID, "dim_pressure_plates"));
    public static final TagKey<Item> ITEMTAG_BUTTON = ItemTags.create(new ResourceLocation(Luminax.MOD_ID, "buttons"));
    public static final TagKey<Item> ITEMTAG_DIM_BUTTON = ItemTags.create(new ResourceLocation(Luminax.MOD_ID, "dim_buttons"));

}
