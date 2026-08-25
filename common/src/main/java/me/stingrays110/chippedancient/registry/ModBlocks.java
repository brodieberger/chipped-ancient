package me.stingrays110.chippedancient.registry;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import me.stingrays110.chippedancient.ChippedAncient;
import me.stingrays110.chippedancient.blocks.AncientBenchBlock;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class ModBlocks {
    public static final ResourcefulRegistry<Block> BLOCKS = ResourcefulRegistries.create(BuiltInRegistries.BLOCK, ChippedAncient.MOD_ID);

    public static final RegistryEntry<Block> ANCIENT_BENCH = BLOCKS.register("ancient_bench",
        () -> new AncientBenchBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.CRAFTING_TABLE)));

    public static final RegistryEntry<Block> COBBLESTONE_B17 = BLOCKS.register("cobblestone_b17",
        () -> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.COBBLESTONE)));
}
