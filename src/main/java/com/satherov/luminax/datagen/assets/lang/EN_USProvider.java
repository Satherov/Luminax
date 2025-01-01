package com.satherov.luminax.datagen.assets.lang;

import com.satherov.luminax.content.LuminaxRegistry;
import com.satherov.luminax.datagen.assets.LuminaxLanguageProvider;
import net.minecraft.data.PackOutput;

public class EN_USProvider extends LuminaxLanguageProvider {

    public EN_USProvider(PackOutput output) {
        super(output, "en_us");
    }

    @Override
    protected void addTranslations() {
        add("itemGroup.luminax", "Luminax");
        add("luminax.configuration.show_dyenamics", "Show Dyenamics Blocks");
        LuminaxRegistry.BLOCKS.getEntries().forEach( block -> add(block.get(), format(block.getId().getPath())));
        LuminaxRegistry.DYENAMIC_BLOCKS.getEntries().forEach( block -> add(block.get(), format(block.getId().getPath())));
    }
}
