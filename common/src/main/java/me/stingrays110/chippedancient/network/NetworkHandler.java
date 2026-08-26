package me.stingrays110.chippedancient.network;

import com.teamresourceful.resourcefullib.common.network.Network;
import me.stingrays110.chippedancient.ChippedAncient;
import net.minecraft.resources.ResourceLocation;

public class NetworkHandler {

    public static final Network CHANNEL = new Network(ResourceLocation.fromNamespaceAndPath(ChippedAncient.MOD_ID, "main"), 1);

    public static void init() {
        CHANNEL.register(ServerboundCraftPacket.TYPE);
    }
}
