package com.satherov.luminex.datagen.data;

import com.satherov.luminex.content.LuminexRegistry;
import com.satherov.luminex.content.SetHelper;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.common.Tags;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class LuminexRecipeProvider extends RecipeProvider {

    public LuminexRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    private static final Map<Item, TagKey<Item>> colors = new HashMap<>();
    static {
        colors.put(LuminexRegistry.WHITE.BLOCK.get().asItem(), Tags.Items.DYES_WHITE);
        colors.put(LuminexRegistry.LIGHT_GRAY.BLOCK.get().asItem(), Tags.Items.DYES_LIGHT_GRAY);
        colors.put(LuminexRegistry.GRAY.BLOCK.get().asItem(), Tags.Items.DYES_GRAY);
        colors.put(LuminexRegistry.BLACK.BLOCK.get().asItem(), Tags.Items.DYES_BLACK);
        colors.put(LuminexRegistry.BROWN.BLOCK.get().asItem(), Tags.Items.DYES_BROWN);
        colors.put(LuminexRegistry.RED.BLOCK.get().asItem(), Tags.Items.DYES_RED);
        colors.put(LuminexRegistry.ORANGE.BLOCK.get().asItem(), Tags.Items.DYES_ORANGE);
        colors.put(LuminexRegistry.YELLOW.BLOCK.get().asItem(), Tags.Items.DYES_YELLOW);
        colors.put(LuminexRegistry.LIME.BLOCK.get().asItem(), Tags.Items.DYES_LIME);
        colors.put(LuminexRegistry.GREEN.BLOCK.get().asItem(), Tags.Items.DYES_GREEN);
        colors.put(LuminexRegistry.LIGHT_BLUE.BLOCK.get().asItem(), Tags.Items.DYES_LIGHT_BLUE);
        colors.put(LuminexRegistry.CYAN.BLOCK.get().asItem(), Tags.Items.DYES_CYAN);
        colors.put(LuminexRegistry.BLUE.BLOCK.get().asItem(), Tags.Items.DYES_BLUE);
        colors.put(LuminexRegistry.PURPLE.BLOCK.get().asItem(), Tags.Items.DYES_PURPLE);
        colors.put(LuminexRegistry.MAGENTA.BLOCK.get().asItem(), Tags.Items.DYES_MAGENTA);
        colors.put(LuminexRegistry.PINK.BLOCK.get().asItem(), Tags.Items.DYES_PINK);
    }

    private ShapedRecipeBuilder tint(TagKey<Item> item, TagKey<Item> color, Item output) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.MISC, output, 8)
                .pattern("aaa")
                .pattern("aba")
                .pattern("aaa")
                .define('a', item)
                .define('b', color)
                .unlockedBy(String.format("has_%s", item.location()), has(item));
    }

    private ShapedRecipeBuilder block(TagKey<Item>  color, Item output) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.MISC, output, 4)
                .pattern("aga")
                .pattern("gbg")
                .pattern("aga")
                .define('a', Items.STONE)
                .define('b', color)
                .define('g', Tags.Items.DUSTS_GLOWSTONE)
                .unlockedBy("has_stone", has(Items.STONE));
    }

    private ShapedRecipeBuilder slab(Item item, Item output) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.MISC, output, 6)
                .pattern("aaa")
                .define('a', item)
                .unlockedBy(String.format("has_%s", getItemName(item)), has(item));
    }

    private ShapedRecipeBuilder stair(Item item, Item output) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.MISC, output, 4)
                .pattern("a  ")
                .pattern("aa ")
                .pattern("aaa")
                .define('a', item)
                .unlockedBy(String.format("has_%s", getItemName(item)), has(item));
    }

    private ShapedRecipeBuilder wall(Item item, Item output) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.MISC, output, 6)
                .pattern("aaa")
                .pattern("aaa")
                .define('a', item)
                .unlockedBy(String.format("has_%s", getItemName(item)), has(item));
    }

    private ShapelessRecipeBuilder button(Item item, Item output) {
        return ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, output)
                .requires(item)
                .unlockedBy(String.format("has_%s", getItemName(item)), has(item));
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        SetHelper.apply(set -> {
            tint(LuminexRegistry.ITEMTAG_BLOCK, colors.get(set.BLOCK.get().asItem()), set.BLOCK.get().asItem()).save(recipeOutput, "tint_" + set.BLOCK.getId().getPath());
            block(colors.get(set.BLOCK.get().asItem()), set.BLOCK.get().asItem()).save(recipeOutput);
            slab(set.BLOCK.get().asItem(), set.SLAB.get().asItem()).save(recipeOutput);
            stair(set.BLOCK.get().asItem(), set.STAIRS.get().asItem()).save(recipeOutput);
            wall(set.BLOCK.get().asItem(), set.WALL.get().asItem()).save(recipeOutput);
            button(set.BLOCK.get().asItem(), set.BUTTON.get().asItem()).save(recipeOutput);
        });
    }
}
