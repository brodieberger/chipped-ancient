package me.stingrays110.chippedancient;

import me.stingrays110.chippedancient.registry.ModBlocks;
import me.stingrays110.chippedancient.registry.ModItems;

public final class ExampleMod {
    public static final String MOD_ID = "chipped_ancient";

    public static void init() {
        ModBlocks.BLOCKS.init();
        ModItems.ITEMS.init();
    }
}
