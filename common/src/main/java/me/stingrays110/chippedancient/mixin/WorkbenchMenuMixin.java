package me.stingrays110.chippedancient.mixin;

import earth.terrarium.chipped.common.menus.WorkbenchMenu;
import me.stingrays110.chippedancient.registry.ModMenuTypes;
import me.stingrays110.chippedancient.registry.ModRecipeTypes;
import net.minecraft.util.StringUtil;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.CraftingInput;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;
import java.util.Locale;

@Mixin(WorkbenchMenu.class)
public abstract class WorkbenchMenuMixin {

    @Inject(method = "updateResults", at = @At("HEAD"), cancellable = true)
    private void chippedAncient$updateResults(String filter, CallbackInfo ci) {
        WorkbenchMenu menu = (WorkbenchMenu) (Object) this;
        if (menu.getType() != ModMenuTypes.ANCIENT_BENCH.get()) return;

        ci.cancel();
        ItemStack selected = menu.selectedStack();
        if (selected.isEmpty()) return;

        menu.setFilter(filter);
        CraftingInput input = CraftingInput.of(1, 1, List.of(selected));
        menu.level().getRecipeManager()
            .getRecipeFor(ModRecipeTypes.WORKBENCH.get(), input, menu.level()).ifPresentOrElse(recipe -> {
                List<ItemStack> results = menu.results();
                results.clear();
                recipe.value().getResults(input.getItem(0)).forEach(result -> {
                    if (filter == null
                        || StringUtil.isBlank(filter)
                        || result.getDisplayName().getString().toLowerCase(Locale.ROOT).contains(filter.toLowerCase(Locale.ROOT))) {
                        results.add(result);
                    }
                });
            }, menu::reset);
    }
}
