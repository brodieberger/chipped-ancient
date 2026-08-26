package me.stingrays110.chippedancient.fabric.client;

import me.stingrays110.chippedancient.client.screens.AncientBenchScreen;
import me.stingrays110.chippedancient.registry.ModBlocks;
import me.stingrays110.chippedancient.registry.ModMenuTypes;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.RenderType;

public final class ChippedAncientFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        MenuScreens.register(ModMenuTypes.ANCIENT_BENCH.get(), AncientBenchScreen::new);
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GLASS_C0019A02.get(), RenderType.cutout());
    }
}
