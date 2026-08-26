package me.stingrays110.chippedancient.registry;

import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import me.stingrays110.chippedancient.ChippedAncient;
import me.stingrays110.chippedancient.recipes.AncientRecipe;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeType;

public class ModRecipeTypes {
    public static final ResourcefulRegistry<RecipeType<?>> RECIPE_TYPES = ResourcefulRegistries.create(BuiltInRegistries.RECIPE_TYPE, ChippedAncient.MOD_ID);

    public static final RegistryEntry<RecipeType<AncientRecipe>> WORKBENCH = RECIPE_TYPES.register("workbench", () -> new RecipeType<>() {
        @Override
        public String toString() {
            return "workbench";
        }
    });
}
