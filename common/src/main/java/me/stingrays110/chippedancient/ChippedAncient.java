package me.stingrays110.chippedancient;

import me.stingrays110.chippedancient.registry.ModBlocks;
import me.stingrays110.chippedancient.registry.ModItems;
import me.stingrays110.chippedancient.registry.ModMenuTypes;
import me.stingrays110.chippedancient.registry.ModRecipeSerializers;
import me.stingrays110.chippedancient.registry.ModRecipeTypes;

public final class ChippedAncient {
    public static final String MOD_ID = "chipped_ancient";

    public static void init() {
        ModBlocks.BLOCKS.init();
        ModItems.ITEMS.init();
        ModMenuTypes.MENUS.init();
        ModRecipeTypes.RECIPE_TYPES.init();
        ModRecipeSerializers.RECIPE_SERIALIZERS.init();
    }
}
