package survivalistessentials.data;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import survivalistessentials.data.loot.GlobalLootModifier;
import survivalistessentials.data.overrides.BlockTagsOverrideProvider;
import survivalistessentials.SurvivalistEssentials;
import survivalistessentials.data.recipe.NeoForgeRecipeProvider;
import survivalistessentials.world.feature.SurvivalistEssentialsFeatures;
import survivalistessentials.world.modifier.SurvivalistEssentialsBiomeModifiers;

@EventBusSubscriber(modid = SurvivalistEssentials.MODID)
public final class DataGenerators {

    private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
        .add(Registries.CONFIGURED_FEATURE, SurvivalistEssentialsFeatures::configuredBootstrap)
        .add(Registries.PLACED_FEATURE, SurvivalistEssentialsFeatures::placementBootstrap)
        .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, context -> {
            context.register(SurvivalistEssentialsBiomeModifiers.LOOSE_ROCKS_MODIFIER_KEY, new BiomeModifiers.AddFeaturesBiomeModifier(
                context.lookup(Registries.BIOME).getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(context.lookup(Registries.PLACED_FEATURE).getOrThrow(SurvivalistEssentialsFeatures.PLACED_LOOSE_ROCKS_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION
            ));
        });

    @SubscribeEvent
    public static void gatherData(GatherDataEvent.Client event) {
        DataGenerator gen = event.getGenerator();
        PackOutput packOutput = gen.getPackOutput();
        String modpackOverrides = System.getenv("MOD_OVERRIDES");
        CompletableFuture<HolderLookup.Provider> provider = event.getLookupProvider();

        gen.addProvider(true, new NeoForgeRecipeProvider(packOutput, provider));
        gen.addProvider(true, new GlobalLootModifier(packOutput, provider));

        if (modpackOverrides != null && modpackOverrides.contains("all")) {
            gen.addProvider(true, new BlockTagsOverrideProvider(packOutput, event.getLookupProvider()));
        }

        gen.addProvider(true, new DatapackBuiltinEntriesProvider(
                packOutput,
                event.getLookupProvider(),
                BUILDER,
                Set.of(SurvivalistEssentials.MODID)
        ));
    }

}
