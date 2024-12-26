package com.satherov.luminex.datagen.assets;

import com.satherov.luminex.Luminex;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class LuminexLanguageProvider extends LanguageProvider {

    public LuminexLanguageProvider(PackOutput output, String locale) {
        super(output, Luminex.MOD_ID, locale);
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
