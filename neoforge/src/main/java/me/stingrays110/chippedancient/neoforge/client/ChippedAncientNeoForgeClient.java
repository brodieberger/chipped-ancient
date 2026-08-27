package me.stingrays110.chippedancient.neoforge.client;

import earth.terrarium.chipped.client.screens.WorkbenchScreen;
import me.stingrays110.chippedancient.registry.ModMenuTypes;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;

@EventBusSubscriber(value = Dist.CLIENT, bus = EventBusSubscriber.Bus.MOD)
public class ChippedAncientNeoForgeClient {

    @SubscribeEvent
    public static void onRegisterScreens(RegisterMenuScreensEvent event) {
        event.register(ModMenuTypes.ANCIENT_BENCH.get(), WorkbenchScreen::new);
    }
}
