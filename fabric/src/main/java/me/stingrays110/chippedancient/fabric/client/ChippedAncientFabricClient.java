package me.stingrays110.chippedancient.fabric.client;

import me.stingrays110.chippedancient.client.screens.AncientBenchScreen;
import me.stingrays110.chippedancient.registry.ModMenuTypes;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screens.MenuScreens;

public final class ChippedAncientFabricClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        MenuScreens.register(ModMenuTypes.ANCIENT_BENCH.get(), AncientBenchScreen::new);
    }
}
