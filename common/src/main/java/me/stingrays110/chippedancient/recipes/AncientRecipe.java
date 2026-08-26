package me.stingrays110.chippedancient.recipes;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.teamresourceful.bytecodecs.base.ByteCodec;
import com.teamresourceful.bytecodecs.base.object.ObjectByteCodec;
import com.teamresourceful.resourcefullib.common.bytecodecs.ExtraByteCodecs;
import com.teamresourceful.resourcefullib.common.recipe.CodecRecipe;
import com.teamresourceful.resourcefullib.common.recipe.CodecRecipeSerializer;
import me.stingrays110.chippedancient.registry.ModRecipeSerializers;
import me.stingrays110.chippedancient.registry.ModRecipeTypes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeInput;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.stream.Stream;

public record AncientRecipe(
    List<Ingredient> ingredients
) implements CodecRecipe<RecipeInput> {

    public static final MapCodec<AncientRecipe> CODEC = RecordCodecBuilder.mapCodec(
        instance -> instance.group(
            Ingredient.CODEC.listOf().fieldOf("ingredients").forGetter(AncientRecipe::ingredients)
        ).apply(instance, AncientRecipe::new));

    public static final ByteCodec<AncientRecipe> NETWORK_CODEC = ObjectByteCodec.create(
        ExtraByteCodecs.INGREDIENT.listOf().fieldOf(AncientRecipe::ingredients),
        AncientRecipe::new
    );

    public Stream<ItemStack> getResults(ItemStack stack) {
        return stack.isEmpty() ? Stream.empty() : this.ingredients.stream()
            .filter(ingredient -> ingredient.test(stack))
            .map(Ingredient::getItems)
            .flatMap(Stream::of);
    }

    @Override
    public boolean matches(RecipeInput recipeInput, Level level) {
        ItemStack stack = recipeInput.getItem(0);
        return !stack.isEmpty() && this.ingredients.stream().anyMatch(ingredient -> ingredient.test(stack));
    }

    @Override
    public CodecRecipeSerializer<? extends CodecRecipe<RecipeInput>> serializer() {
        return ModRecipeSerializers.WORKBENCH.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipeTypes.WORKBENCH.get();
    }
}
