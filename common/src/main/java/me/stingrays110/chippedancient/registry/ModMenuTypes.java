package me.stingrays110.chippedancient.registry;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import earth.terrarium.chipped.common.menus.WorkbenchMenu;
import me.stingrays110.chippedancient.ChippedAncient;
import me.stingrays110.chippedancient.mixin.AbstractContainerMenuAccessor;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.inventory.MenuType;

public class ModMenuTypes {
    public static final ResourcefulRegistry<MenuType<?>> MENUS = ResourcefulRegistries.create(BuiltInRegistries.MENU, ChippedAncient.MOD_ID);

    public static final RegistryEntry<MenuType<WorkbenchMenu>> ANCIENT_BENCH = MENUS.register("ancient_bench", () -> new MenuType<>(ModMenuTypes::create, FeatureFlags.VANILLA_SET));

    // fix for hardcoded menu type from Chipped.
    public static WorkbenchMenu create(int containerId, Inventory inventory) {
        WorkbenchMenu menu = new WorkbenchMenu(containerId, inventory);
        ((AbstractContainerMenuAccessor) menu).chippedAncient$setMenuType(ANCIENT_BENCH.get());
        return menu;
    }
}
