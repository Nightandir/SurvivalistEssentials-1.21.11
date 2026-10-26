package survivalistessentials.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

import survivalistessentials.data.client.SurvivalistEssentialsModelProvider;
import survivalistessentials.data.client.handbook.SurvivalistEssentialsBookProvider;
import survivalistessentials.data.loot.ModLootTables;
import survivalistessentials.SurvivalistEssentials;
import survivalistessentials.data.recipe.FabricModRecipeProvider;

public class FabricDatagenInitializer implements DataGeneratorEntrypoint {

    @Override
    public void onInitializeDataGenerator(FabricDataGenerator gen) {
        FabricDataGenerator.Pack pack = gen.createPack();

        if (System.getProperty(SurvivalistEssentials.MODID + ".common_datagen") != null) {
            configureCommonDatagen(pack);
        }
        else {
            configureFabricDatagen(pack);
        }
    }

    /*
     * Datagen common across all modloaders.
     */
    public static void configureCommonDatagen(FabricDataGenerator.Pack pack) {
        pack.addProvider(CommonItemTagsProvider::new);
        pack.addProvider(CommonBlockTagsProvider::new);
        pack.addProvider(ModLootTables::create);
        pack.addProvider(SurvivalistEssentialsLanguageProvider::new);
        pack.addProvider(SurvivalistEssentialsBookProvider::new);
        pack.addProvider(SurvivalistEssentialsModelProvider::new);
    }

    /*
     * Fabric only datagen.
     */
    public static void configureFabricDatagen(FabricDataGenerator.Pack pack) {
        pack.addProvider(FabricModRecipeProvider::new);
    }

}
