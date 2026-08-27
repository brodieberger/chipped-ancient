package me.stingrays110.chippedancient.mixin;

import me.stingrays110.chippedancient.ChippedAncient;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.List;

@Mixin(BlockBehaviour.class)
public abstract class BlockBehaviourMixin {

    @Inject(
        method = "getDrops",
        at = @At(
            value = "INVOKE",
            target = "Ljava/util/Collections;emptyList()Ljava/util/List;",
            ordinal = 0
        ),
        cancellable = true
    )
    private void chippedAncient$getDrops(BlockState state, LootParams.Builder builder, CallbackInfoReturnable<List<ItemStack>> cir) {
        if (!(((Object) this) instanceof Block block)) return;

        ResourceLocation blockId = BuiltInRegistries.BLOCK.getKey(block);
        if (!blockId.getNamespace().equals(ChippedAncient.MOD_ID)) return;

        ResourceLocation tableId = ResourceLocation.fromNamespaceAndPath(blockId.getNamespace(), "blocks/" + blockId.getPath());
        LootTable table = builder.getLevel().getServer().reloadableRegistries()
            .getLootTable(ResourceKey.create(Registries.LOOT_TABLE, tableId));

        if (table != LootTable.EMPTY) {
            LootParams params = builder.withParameter(LootContextParams.BLOCK_STATE, state).create(LootContextParamSets.BLOCK);
            cir.setReturnValue(table.getRandomItems(params));
        } else {
            cir.setReturnValue(List.of(new ItemStack(block)));
        }
    }
}
