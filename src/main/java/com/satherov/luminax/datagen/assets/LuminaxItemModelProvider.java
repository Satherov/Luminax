package com.satherov.luminax.datagen.assets;

import com.satherov.luminax.Luminax;
import com.satherov.luminax.content.SetHelper;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class LuminaxItemModelProvider extends ItemModelProvider {

    public LuminaxItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Luminax.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        SetHelper.apply(set -> {
            blockModel(set.BLOCK);
            blockModel(set.SLAB);
            blockModel(set.STAIRS);
            blockModel(set.WALL);
            blockModel(set.PRESSURE_PLATE);
            buttonModel(set.BUTTON);

            blockModel(set.DIM_BLOCK);
            blockModel(set.DIM_SLAB);
            blockModel(set.DIM_STAIRS);
            blockModel(set.DIM_WALL);
            blockModel(set.DIM_PRESSURE_PLATE);
            buttonModel(set.DIM_BUTTON);
        });
    }

    public void blockModel(RegistryObject<? extends Block> block) {
        withExistingParent(block.getId().getPath(), modLoc("block/" + block.getId().getPath()));
    }

    public void buttonModel(RegistryObject<? extends ButtonBlock> block) {
        withExistingParent(block.getId().getPath(), modLoc("block/" + block.getId().getPath() + "_inventory"));
    }
}
