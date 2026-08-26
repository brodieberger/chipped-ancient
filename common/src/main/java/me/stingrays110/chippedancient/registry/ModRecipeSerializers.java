package me.stingrays110.chippedancient.registry;

import com.teamresourceful.resourcefullib.common.recipe.CodecRecipeSerializer;
import com.teamresourceful.resourcefullib.common.registry.RegistryEntry;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistries;
import com.teamresourceful.resourcefullib.common.registry.ResourcefulRegistry;
import me.stingrays110.chippedancient.ChippedAncient;
import me.stingrays110.chippedancient.recipes.AncientRecipe;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class ModRecipeSerializers {
    public static final ResourcefulRegistry<RecipeSerializer<?>> RECIPE_SERIALIZERS = ResourcefulRegistries.create(BuiltInRegistries.RECIPE_SERIALIZER, ChippedAncient.MOD_ID);

    public static final RegistryEntry<CodecRecipeSerializer<AncientRecipe>> WORKBENCH = RECIPE_SERIALIZERS.register("workbench", () ->
        new CodecRecipeSerializer<>(ModRecipeTypes.WORKBENCH.get(), AncientRecipe.CODEC, AncientRecipe.NETWORK_CODEC));
}
