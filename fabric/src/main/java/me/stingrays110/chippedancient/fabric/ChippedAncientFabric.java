package me.stingrays110.chippedancient.fabric;

import net.fabricmc.api.ModInitializer;

import me.stingrays110.chippedancient.ChippedAncient;

public final class ChippedAncientFabric implements ModInitializer {
    @Override
    public void onInitialize() {
        ChippedAncient.init();
    }
}
