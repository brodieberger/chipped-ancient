package me.stingrays110.chippedancient.registry;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import me.stingrays110.chippedancient.ChippedAncient;
import me.stingrays110.chippedancient.menus.AncientBenchMenu;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;

public class ModMenuTypes {
    public static final ResourcefulRegistry<MenuType<?>> MENUS = ResourcefulRegistries.create(BuiltInRegistries.MENU, ChippedAncient.MOD_ID);

    public static final RegistryEntry<MenuType<AncientBenchMenu>> ANCIENT_BENCH = MENUS.register("ancient_bench", () -> new MenuType<>(AncientBenchMenu::new, FeatureFlags.VANILLA_SET));
}
