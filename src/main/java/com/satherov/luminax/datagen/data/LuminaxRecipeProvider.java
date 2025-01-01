package com.satherov.luminax.datagen.data;

import com.satherov.luminax.content.LuminaxRegistry;
import com.satherov.luminax.content.SetHelper;
import cy.jdkdigital.dyenamics.core.util.DyenamicDyeColor;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class LuminaxRecipeProvider extends RecipeProvider implements IConditionBuilder {

    public LuminaxRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    private static final Map<Item, TagKey<Item>> colors = new HashMap<>();
    static {
        colors.put(LuminaxRegistry.WHITE.BLOCK.get().asItem(), Tags.Items.DYES_WHITE);
        colors.put(LuminaxRegistry.LIGHT_GRAY.BLOCK.get().asItem(), Tags.Items.DYES_LIGHT_GRAY);
        colors.put(LuminaxRegistry.GRAY.BLOCK.get().asItem(), Tags.Items.DYES_GRAY);
        colors.put(LuminaxRegistry.BLACK.BLOCK.get().asItem(), Tags.Items.DYES_BLACK);
        colors.put(LuminaxRegistry.BROWN.BLOCK.get().asItem(), Tags.Items.DYES_BROWN);
        colors.put(LuminaxRegistry.RED.BLOCK.get().asItem(), Tags.Items.DYES_RED);
        colors.put(LuminaxRegistry.ORANGE.BLOCK.get().asItem(), Tags.Items.DYES_ORANGE);
        colors.put(LuminaxRegistry.YELLOW.BLOCK.get().asItem(), Tags.Items.DYES_YELLOW);
        colors.put(LuminaxRegistry.LIME.BLOCK.get().asItem(), Tags.Items.DYES_LIME);
        colors.put(LuminaxRegistry.GREEN.BLOCK.get().asItem(), Tags.Items.DYES_GREEN);
        colors.put(LuminaxRegistry.LIGHT_BLUE.BLOCK.get().asItem(), Tags.Items.DYES_LIGHT_BLUE);
        colors.put(LuminaxRegistry.CYAN.BLOCK.get().asItem(), Tags.Items.DYES_CYAN);
        colors.put(LuminaxRegistry.BLUE.BLOCK.get().asItem(), Tags.Items.DYES_BLUE);
        colors.put(LuminaxRegistry.PURPLE.BLOCK.get().asItem(), Tags.Items.DYES_PURPLE);
        colors.put(LuminaxRegistry.MAGENTA.BLOCK.get().asItem(), Tags.Items.DYES_MAGENTA);
        colors.put(LuminaxRegistry.PINK.BLOCK.get().asItem(), Tags.Items.DYES_PINK);
        colors.put(LuminaxRegistry.HONEY.BLOCK.get().asItem(), DyenamicDyeColor.HONEY.getTag());
        colors.put(LuminaxRegistry.MINT.BLOCK.get().asItem(), DyenamicDyeColor.MINT.getTag());
        colors.put(LuminaxRegistry.LAVENDER.BLOCK.get().asItem(), DyenamicDyeColor.LAVENDER.getTag());
        colors.put(LuminaxRegistry.NAVY.BLOCK.get().asItem(), DyenamicDyeColor.NAVY.getTag());
        colors.put(LuminaxRegistry.BUBBLEGUM.BLOCK.get().asItem(), DyenamicDyeColor.BUBBLEGUM.getTag());
        colors.put(LuminaxRegistry.AMBER.BLOCK.get().asItem(), DyenamicDyeColor.AMBER.getTag());
        colors.put(LuminaxRegistry.CONIFER.BLOCK.get().asItem(), DyenamicDyeColor.CONIFER.getTag());
        colors.put(LuminaxRegistry.ICY_BLUE.BLOCK.get().asItem(), DyenamicDyeColor.ICY_BLUE.getTag());
        colors.put(LuminaxRegistry.ULTRAMARINE.BLOCK.get().asItem(), DyenamicDyeColor.ULTRAMARINE.getTag());
        colors.put(LuminaxRegistry.MAROON.BLOCK.get().asItem(), DyenamicDyeColor.MAROON.getTag());
        colors.put(LuminaxRegistry.WINE.BLOCK.get().asItem(), DyenamicDyeColor.WINE.getTag());
        colors.put(LuminaxRegistry.ROSE.BLOCK.get().asItem(), DyenamicDyeColor.ROSE.getTag());
        colors.put(LuminaxRegistry.FLUORESCENT.BLOCK.get().asItem(), DyenamicDyeColor.FLUORESCENT.getTag());
        colors.put(LuminaxRegistry.SPRING_GREEN.BLOCK.get().asItem(), DyenamicDyeColor.SPRING_GREEN.getTag());
        colors.put(LuminaxRegistry.PEACH.BLOCK.get().asItem(), DyenamicDyeColor.PEACH.getTag());
        colors.put(LuminaxRegistry.CHERENKOV.BLOCK.get().asItem(), DyenamicDyeColor.CHERENKOV.getTag());
        colors.put(LuminaxRegistry.AQUAMARINE.BLOCK.get().asItem(), DyenamicDyeColor.AQUAMARINE.getTag());
        colors.put(LuminaxRegistry.PERSIMMON.BLOCK.get().asItem(), DyenamicDyeColor.PERSIMMON.getTag());
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

    private ShapedRecipeBuilder dimBlock(TagKey<Item>  color, Item output) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.MISC, output, 4)
                .pattern("awa")
                .pattern("wbw")
                .pattern("awa")
                .define('a', Items.STONE)
                .define('b', color)
                .define('w', Blocks.WHITE_WOOL)
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

    private ShapedRecipeBuilder pressurePlate(Item item, Item output) {
        return ShapedRecipeBuilder.shaped(RecipeCategory.MISC, output, 1)
                .pattern("aa")
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

            if (set.dyenamic) {
                tint(LuminaxRegistry.ITEMTAG_BLOCK, colors.get(set.BLOCK.get().asItem()), set.BLOCK.get().asItem()).save(recipeOutput.withConditions(new ModLoadedCondition("dyenamics")), "tint_" + set.BLOCK.getId().getPath());
                block(colors.get(set.BLOCK.get().asItem()), set.BLOCK.get().asItem()).save(recipeOutput.withConditions(new ModLoadedCondition("dyenamics")));

                tint(LuminaxRegistry.ITEMTAG_DIM_BLOCK, colors.get(set.BLOCK.get().asItem()), set.DIM_BLOCK.get().asItem()).save(recipeOutput.withConditions(new ModLoadedCondition("dyenamics")), "tint_" + set.DIM_BLOCK.getId().getPath());
                dimBlock(colors.get(set.BLOCK.get().asItem()), set.DIM_BLOCK.get().asItem()).save(recipeOutput.withConditions(new ModLoadedCondition("dyenamics")));
            } else {
                tint(LuminaxRegistry.ITEMTAG_BLOCK, colors.get(set.BLOCK.get().asItem()), set.BLOCK.get().asItem()).save(recipeOutput, "tint_" + set.BLOCK.getId().getPath());
                block(colors.get(set.BLOCK.get().asItem()), set.BLOCK.get().asItem()).save(recipeOutput);

                tint(LuminaxRegistry.ITEMTAG_DIM_BLOCK, colors.get(set.BLOCK.get().asItem()), set.DIM_BLOCK.get().asItem()).save(recipeOutput, "tint_" + set.DIM_BLOCK.getId().getPath());
                dimBlock(colors.get(set.BLOCK.get().asItem()), set.DIM_BLOCK.get().asItem()).save(recipeOutput);
            }

            slab(set.BLOCK.get().asItem(), set.SLAB.get().asItem()).save(recipeOutput);
            stair(set.BLOCK.get().asItem(), set.STAIRS.get().asItem()).save(recipeOutput);
            wall(set.BLOCK.get().asItem(), set.WALL.get().asItem()).save(recipeOutput);
            pressurePlate(set.BLOCK.get().asItem(), set.PRESSURE_PLATE.get().asItem()).save(recipeOutput);
            button(set.BLOCK.get().asItem(), set.BUTTON.get().asItem()).save(recipeOutput);

            slab(set.DIM_BLOCK.get().asItem(), set.DIM_SLAB.get().asItem()).save(recipeOutput);
            stair(set.DIM_BLOCK.get().asItem(), set.DIM_STAIRS.get().asItem()).save(recipeOutput);
            wall(set.DIM_BLOCK.get().asItem(), set.DIM_WALL.get().asItem()).save(recipeOutput);
            pressurePlate(set.DIM_BLOCK.get().asItem(), set.DIM_PRESSURE_PLATE.get().asItem()).save(recipeOutput);
            button(set.DIM_BLOCK.get().asItem(), set.DIM_BUTTON.get().asItem()).save(recipeOutput);
        });
    }
}
