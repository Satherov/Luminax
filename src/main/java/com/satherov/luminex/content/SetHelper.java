package com.satherov.luminex.content;

import java.util.function.Consumer;

public class SetHelper {
    public static void apply(Consumer<BlockSet> consumer) {
        BlockSet.getSets().forEach(consumer);
    }
}
