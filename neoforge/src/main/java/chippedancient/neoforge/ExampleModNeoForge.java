package chippedancient.neoforge;

import net.neoforged.fml.common.Mod;

import chippedancient.ExampleMod;

@Mod(ExampleMod.MOD_ID)
public final class ExampleModNeoForge {
    public ExampleModNeoForge() {
        // Run our common setup.
        ExampleMod.init();
    }
}
