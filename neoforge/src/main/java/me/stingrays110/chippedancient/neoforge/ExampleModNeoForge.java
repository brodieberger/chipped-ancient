package me.stingrays110.chippedancient.neoforge;

import net.neoforged.fml.common.Mod;

import me.stingrays110.chippedancient.ExampleMod;

@Mod(ExampleMod.MOD_ID)
public final class ExampleModNeoForge {
    public ExampleModNeoForge() {
        // Run our common setup.
        ExampleMod.init();
    }
}
