package com.satherov.luminax.datagen.assets;

import com.satherov.luminax.Luminax;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;

public class LuminaxLanguageProvider extends LanguageProvider {

    public LuminaxLanguageProvider(PackOutput output, String locale) {
        super(output, Luminax.MOD_ID, locale);
    }

    @Override
    protected void addTranslations() {}

    protected String format(String string) {
        String[] words = string.replace("_", " ").split(" ");
        StringBuilder formatted = new StringBuilder();
        for (String word : words) {
            formatted.append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1))
                    .append(" ");
        }
        return formatted.toString().trim();
    }

}
