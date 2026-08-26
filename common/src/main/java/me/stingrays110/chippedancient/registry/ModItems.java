package me.stingrays110.chippedancient.registry;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import me.stingrays110.chippedancient.ChippedAncient;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;

public class ModItems {
    public static final ResourcefulRegistry<Item> ITEMS = ResourcefulRegistries.create(BuiltInRegistries.ITEM, ChippedAncient.MOD_ID);

    public static final RegistryEntry<Item> ANCIENT_BENCH = ITEMS.register("ancient_bench",
        () -> new BlockItem(ModBlocks.ANCIENT_BENCH.get(), new Item.Properties()));

    public static final RegistryEntry<Item> COBBLESTONE_B17 = ITEMS.register("cobblestone_b17",
        () -> new BlockItem(ModBlocks.COBBLESTONE_B17.get(), new Item.Properties()));

    public static final RegistryEntry<Item> OAK_PLANKS_C0014A = ITEMS.register("oak_planks_c0014a",
        () -> new BlockItem(ModBlocks.OAK_PLANKS_C0014A.get(), new Item.Properties()));

    public static final RegistryEntry<Item> GLASS_C0019A02 = ITEMS.register("glass_c0019a02",
        () -> new BlockItem(ModBlocks.GLASS_C0019A02.get(), new Item.Properties()));
}
