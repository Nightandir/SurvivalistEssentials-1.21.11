package survivalistessentials.data.recipe;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.NotNull;

import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.InventoryChangeTrigger.TriggerInstance;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;

import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import net.neoforged.neoforge.common.conditions.NotCondition;

import survivalistessentials.SurvivalistEssentials;

public class NeoForgeRecipeProvider extends RecipeProvider.Runner implements ISurvivalistEssentialsRecipeProvider {

    private InternalRecipeProvider internalRecipeProvider;

    public NeoForgeRecipeProvider(PackOutput output, CompletableFuture<Provider> registries) {
        super(output, registries);
    }

    @Override
    protected @NotNull RecipeProvider createRecipeProvider(HolderLookup.@NotNull Provider provider, @NotNull RecipeOutput recipeOutput) {
        internalRecipeProvider = new InternalRecipeProvider(provider, recipeOutput);

        return internalRecipeProvider;
    }

    @Override
    public @NotNull String getName() {
        return SurvivalistEssentials.MOD_NAME + " - NeoForge Recipes";
    }

    @Override
    public RecipeOutput modLoaded(RecipeOutput recipeOutput, String modid) {
        return recipeOutput.withConditions(new ModLoadedCondition(modid));
    }

    @Override
    public RecipeOutput modNotLoaded(RecipeOutput recipeOutput, String modid) {
        return recipeOutput.withConditions(new NotCondition(new ModLoadedCondition(modid)));
    }

    @Override
    public RecipeOutput configResourceCondition(RecipeOutput recipeOutput, String configOption) {
        return recipeOutput.withConditions(new ConfigResourceCondition(configOption));
    }

    @Override
    public Criterion<TriggerInstance> _has(ItemLike itemLike) {
        return internalRecipeProvider._has(itemLike);
    }

    @Override
    public Criterion<TriggerInstance> _has(TagKey<Item> tag) {
        return internalRecipeProvider._has(tag);
    }

    private class InternalRecipeProvider extends RecipeProvider {

        RecipeOutput recipeOutput;
        HolderLookup.Provider registries;

        protected InternalRecipeProvider(Provider registries, RecipeOutput output) {
            super(registries, output);

            this.recipeOutput = output;
            this.registries = registries;
        }

        @Override
        public void buildRecipes() {
            buildModRecipes(registries, recipeOutput);
        }

        public Criterion<TriggerInstance> _has(ItemLike itemLike) {
            return has(itemLike);
        }

        public Criterion<TriggerInstance> _has(TagKey<Item> tag) {
            return has(tag);
        }

    }

}
