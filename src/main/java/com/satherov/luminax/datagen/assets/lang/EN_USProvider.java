package com.satherov.luminax.datagen.assets.lang;

import com.satherov.luminax.content.SetHelper;
import com.satherov.luminax.datagen.assets.LuminaxLanguageProvider;
import net.minecraft.data.PackOutput;

public class EN_USProvider extends LuminaxLanguageProvider {

    public EN_USProvider(PackOutput output) {
        super(output, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.luminax", "Luminax");

        SetHelper.apply( set -> {
            add(set.BLOCK.get(), format(set.BLOCK.getId().getPath()));
            add(set.SLAB.get(), format(set.SLAB.getId().getPath()));
            add(set.STAIRS.get(), format(set.STAIRS.getId().getPath()));
            add(set.WALL.get(), format(set.WALL.getId().getPath()));
            add(set.PRESSURE_PLATE.get(), format(set.PRESSURE_PLATE.getId().getPath()));
            add(set.BUTTON.get(), format(set.BUTTON.getId().getPath()));
        });
    }
}
