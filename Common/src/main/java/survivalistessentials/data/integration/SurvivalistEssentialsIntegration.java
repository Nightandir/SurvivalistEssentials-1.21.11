package survivalistessentials.data.integration;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import static technology.roughness.whitenoise.util.ResourceLocationHelper.loc;

public final class SurvivalistEssentialsIntegration {

    private static final Map<ResourceLocation, Item> ALL = new LinkedHashMap<>();

    public static final String AYCE_MODID = "allyoucaneat";
    public static final String BMO_MODID = "biomemakeover";
    public static final String BOP_MODID = "biomesoplenty";
    public static final String BOTANIA_MODID = "botania";
    public static final String FT_MODID = "fruitfulfun";
    public static final String IE_MODID = "immersiveengineering";
    public static final String QUARK_MODID = "quark";
    public static final String SGC_MODID = "sushigocrafting";
    public static final String TCON_MODID = "tconstruct";
    public static final String WS_MODID = "watersource";
    public static final String AN_MODID = "ars_nouveau";
    public static final String EXNIHILO_MODID = "exnihilosequentia";
    public static final String UNDERGARDEN_MODID = "undergarden";
    public static final String DYNAMICTREES_MODID = "dynamictrees";
    public static final String BYG_MODID = "biomeswevegone";
    public static final String TF_MODID = "twilightforest";
    public static final String ECO_MODID = "ecologics";
    public static final String AQUA_MODID = "aquaculture";
    public static final String BAP_MODID = "betteranimalsplus";
    public static final String ALEX_MODID = "alexsmobs";
    public static final String MALUM_MODID = "malum";
    public static final String IFD_MODID = "iceandfire";
    public static final String TS_MODID = "tinkersurvival";
    public static final String CARRYON_MODID = "carryon";
    public static final String REGIONS_MODID = "regions_unexplored";
    public static final String TETRA_MODID = "tetra";
    public static final String MINECRAFT_MODID = "minecraft";
    public static final String CREATE_MODID = "create";
    public static final String LD_BEACH_MODID = "beachparty";
    public static final String LD_BLOOMING_MODID = "bloomingnature";
    public static final String LD_FARM_MODID = "farm_and_charm";
    public static final String LD_MEADOW_MODID = "meadow";
    public static final String LD_VINERY_MODID = "vinery";
    public static final String LD_WILDER_MODID = "wildernature";

    public static Item AQUA_DRIFTWOOD;
    public static Item AQUA_FISH_FILLET_COOKED;
    public static Item AQUA_FROG_LEGS_COOKED;
    public static Item CHERRY_PLANKS;
    public static Item CITRUS_PLANKS;
    public static Item BMO_ANCIENT_OAK_PLANKS;
    public static Item BMO_BLIGHTED_BALSA_PLANKS;
    public static Item BMO_SWAMP_CYPRESS_PLANKS;
    public static Item BMO_WILLOW_PLANKS;
    public static Item BOP_DEAD_PLANKS;
    public static Item BOP_FIR_PLANKS;
    public static Item BOP_HELLBARK_PLANKS;
    public static Item BOP_JACARANDA_PLANKS;
    public static Item BOP_MAGIC_PLANKS;
    public static Item BOP_MAHOGANY_PLANKS;
    public static Item BOP_PALM_PLANKS;
    public static Item BOP_REDWOOD_PLANKS;
    public static Item BOP_UMBRAN_PLANKS;
    public static Item BOP_WILLOW_PLANKS;
    public static Item BOTANIA_DREAMWOOD_PLANKS;
    public static Item BOTANIA_LIVINGWOOD_PLANKS;
    public static Item IE_STICK_TREATED;
    public static Item QUARK_AZALEA_PLANKS;
    public static Item QUARK_BLOSSOM_PLANKS;
    public static Item AYCE_HAZEL_PLANKS;
    public static Item TCON_BLOODSHROOM_PLANKS;
    public static Item TCON_GREENHEART_PLANKS;
    public static Item TCON_SKYROOT_PLANKS;
    public static Item WS_PALM_TREE_PLANKS;
    public static Item AN_ARCHWOOD_PLANKS;
    public static Item UNDERGARDEN_SMOGSTEM_PLANKS;
    public static Item UNDERGARDEN_WIGGLEWOOD_PLANKS;
    public static Item UNDERGARDEN_GRONGLE_PLANKS;
    public static Item BYG_WHITE_MANGROVE_PLANKS;
    public static Item BYG_REDWOOD_PLANKS;
    public static Item BYG_BLUE_ENCHANTED_PLANKS;
    public static Item BYG_GREEN_ENCHANTED_PLANKS;
    public static Item BYG_MAHOGANY_PLANKS;
    public static Item BYG_BAOBAB_PLANKS;
    public static Item BYG_JACARANDA_PLANKS;
    public static Item BYG_CYPRESS_PLANKS;
    public static Item BYG_PALM_PLANKS;
    public static Item BYG_EBONY_PLANKS;
    public static Item BYG_RAINBOW_EUCALYPTUS_PLANKS;
    public static Item BYG_ASPEN_PLANKS;
    public static Item BYG_FIR_PLANKS;
    public static Item BYG_SKYRIS_PLANKS;
    public static Item BYG_CIKA_PLANKS;
    public static Item BYG_HOLLY_PLANKS;
    public static Item BYG_MAPLE_PLANKS;
    public static Item BYG_PINE_PLANKS;
    public static Item BYG_WILLOW_PLANKS;
    public static Item BYG_WITCH_HAZEL_PLANKS;
    public static Item BYG_ZELKOVA_PLANKS;
    public static Item BYG_IRONWOOD_PLANKS;
    public static Item BYG_SAKURA_PLANKS;
    public static Item BYG_PALO_VERDE_PLANKS;
    public static Item BYG_SPIRIT_PLANKS;
    public static Item BYG_FLORUS_STEM;
    public static Item ECO_COCONUT_PLANKS;
    public static Item ECO_WALNUT_PLANKS;
    public static Item ECO_AZALEA_PLANKS;
    public static Item ECO_FLOWERING_AZALEA_PLANKS;
    public static Item TF_CANOPY_PLANKS;
    public static Item TF_DARK_PLANKS;
    public static Item TF_MANGROVE_PLANKS;
    public static Item TF_MINING_PLANKS;
    public static Item TF_SORTING_PLANKS;
    public static Item TF_TIME_PLANKS;
    public static Item TF_TRANSFORMATION_PLANKS;
    public static Item TF_TWILIGHT_OAK_PLANKS;
    public static Item MALUM_RUNEWOOD_PLANKS;
    public static Item MALUM_SOULWOOD_PLANKS;
    public static Item IFD_DREADWOOD_PLANKS;
    public static Item RU_ALPHA_PLANKS;
    public static Item RU_ACACIA_BRANCH;
    public static Item RU_BAOBAB_PLANKS;
    public static Item RU_BAOBAB_BRANCH;
    public static Item RU_BIRCH_BRANCH;
    public static Item RU_BLACKWOOD_PLANKS;
    public static Item RU_BLACKWOOD_BRANCH;
    public static Item RU_BIOSHROOM_PLANKS;
    public static Item RU_BLUE_BIOSHROOM_PLANKS;
    public static Item RU_BRIMWOOD_PLANKS;
    public static Item RU_BRIMWOOD_BRANCH;
    public static Item RU_COBALT_PLANKS;
    public static Item RU_COBALT_BRANCH;
    public static Item RU_CYPRESS_PLANKS;
    public static Item RU_CYPRESS_BRANCH;
    public static Item RU_DARK_OAK_BRANCH;
    public static Item RU_DEAD_PLANKS;
    public static Item RU_DEAD_BRANCH;
    public static Item RU_EUCALYPTUS_PLANKS;
    public static Item RU_EUCALYPTUS_BRANCH;
    public static Item RU_GREEN_BIOSHROOM_PLANKS;
    public static Item RU_JOSHUA_PLANKS;
    public static Item RU_JOSHUA_BRANCH;
    public static Item RU_JUNGLE_BRANCH;
    public static Item RU_KAPOK_PLANKS;
    public static Item RU_KAPOK_BRANCH;
    public static Item RU_LARCH_PLANKS;
    public static Item RU_LARCH_BRANCH;
    public static Item RU_MANGROVE_BRANCH;
    public static Item RU_MAGNOLIA_PLANKS;
    public static Item RU_MAGNOLIA_BRANCH;
    public static Item RU_MAPLE_PLANKS;
    public static Item RU_MAPLE_BRANCH;
    public static Item RU_MAUVE_PLANKS;
    public static Item RU_MAUVE_BRANCH;
    public static Item RU_OAK_BRANCH;
    public static Item RU_PALM_PLANKS;
    public static Item RU_PALM_BRANCH;
    public static Item RU_PINE_PLANKS;
    public static Item RU_PINE_BRANCH;
    public static Item RU_PINK_BIOSHROOM_PLANKS;
    public static Item RU_REDWOOD_PLANKS;
    public static Item RU_REDWOOD_BRANCH;
    public static Item RU_SILVER_BIRCH_BRANCH;
    public static Item RU_SOCOTRA_PLANKS;
    public static Item RU_SOCOTRA_BRANCH;
    public static Item RU_SPRUCE_BRANCH;
    public static Item RU_WILLOW_PLANKS;
    public static Item RU_WILLOW_BRANCH;
    public static Item RU_YELLOW_BIOSHROOM_PLANKS;
    public static Item LD_PALM_PLANKS;
    public static Item LD_LARCH_PLANKS;
    public static Item LD_BAOBAB_PLANKS;
    public static Item LD_ASPEN_PLANKS;
    public static Item LD_SWAMP_OAK_PLANKS;
    public static Item LD_SWAMP_CYPRESS_PLANKS;
    public static Item LD_FAN_PALM_PLANKS;
    public static Item LD_EBONY_PLANKS;
    public static Item LD_CHESTNUT_PLANKS;
    public static Item LD_FIR_PLANKS;
    public static Item LD_CACTUS_PLANKS;
    public static Item LD_PINE_PLANKS;
    public static Item LD_DARK_CHERRY_PLANKS;

    // TF Messed up log/wood crap
    public static ResourceLocation TF_CANOPY_LOG;
    public static ResourceLocation TF_CANOPY_STRIPPED_LOG;
    public static ResourceLocation TF_CANOPY_WOOD;
    public static ResourceLocation TF_CANOPY_STRIPPED_WOOD;
    public static ResourceLocation TF_DARK_LOG;
    public static ResourceLocation TF_DARK_STRIPPED_LOG;
    public static ResourceLocation TF_DARK_WOOD;
    public static ResourceLocation TF_DARK_STRIPPED_WOOD;
    public static ResourceLocation TF_MANGROVE_LOG;
    public static ResourceLocation TF_MANGROVE_STRIPPED_LOG;
    public static ResourceLocation TF_MANGROVE_WOOD;
    public static ResourceLocation TF_MANGROVE_STRIPPED_WOOD;
    public static ResourceLocation TF_MINING_LOG;
    public static ResourceLocation TF_MINING_STRIPPED_LOG;
    public static ResourceLocation TF_MINING_WOOD;
    public static ResourceLocation TF_MINING_STRIPPED_WOOD;
    public static ResourceLocation TF_SORTING_LOG;
    public static ResourceLocation TF_SORTING_STRIPPED_LOG;
    public static ResourceLocation TF_SORTING_WOOD;
    public static ResourceLocation TF_SORTING_STRIPPED_WOOD;
    public static ResourceLocation TF_TIME_LOG;
    public static ResourceLocation TF_TIME_STRIPPED_LOG;
    public static ResourceLocation TF_TIME_WOOD;
    public static ResourceLocation TF_TIME_STRIPPED_WOOD;
    public static ResourceLocation TF_TRANSFORMATION_LOG;
    public static ResourceLocation TF_TRANSFORMATION_STRIPPED_LOG;
    public static ResourceLocation TF_TRANSFORMATION_WOOD;
    public static ResourceLocation TF_TRANSFORMATION_STRIPPED_WOOD;
    public static ResourceLocation TF_TWILIGHT_OAK_LOG;
    public static ResourceLocation TF_TWILIGHT_OAK_STRIPPED_LOG;
    public static ResourceLocation TF_TWILIGHT_OAK_WOOD;
    public static ResourceLocation TF_TWILIGHT_OAK_STRIPPED_WOOD;

    // And now Biome Makeover messed up crap
    public static ResourceLocation BMO_ANCIENT_OAK_LOG;
    public static ResourceLocation BMO_STRIPPED_ANCIENT_OAK_LOG;
    public static ResourceLocation BMO_ANCIENT_OAK_WOOD;
    public static ResourceLocation BMO_STRIPPED_ANCIENT_OAK_WOOD;
    public static ResourceLocation BMO_BLIGHTED_BALSA_LOG;
    public static ResourceLocation BMO_STRIPPED_BLIGHTED_BALSA_LOG;
    public static ResourceLocation BMO_BLIGHTED_BALSA_WOOD;
    public static ResourceLocation BMO_STRIPPED_BLIGHTED_BALSA_WOOD;
    public static ResourceLocation BMO_SWAMP_CYPRESS_LOG;
    public static ResourceLocation BMO_STRIPPED_SWAMP_CYPRESS_LOG;
    public static ResourceLocation BMO_SWAMP_CYPRESS_WOOD;
    public static ResourceLocation BMO_STRIPPED_SWAMP_CYPRESS_WOOD;
    public static ResourceLocation BMO_WILLOW_LOG;
    public static ResourceLocation BMO_STRIPPED_WILLOW_LOG;
    public static ResourceLocation BMO_WILLOW_WOOD;
    public static ResourceLocation BMO_STRIPPED_WILLOW_WOOD;

    public static void init(BiConsumer<Item, ResourceLocation> consumer) {
        String dataGen = System.getenv("DATA_GEN");
        if (dataGen != null && dataGen.contains("all")) {
            AQUA_DRIFTWOOD = makeItem(aquaLoc("driftwood"));
            AQUA_FISH_FILLET_COOKED = makeItem(aquaLoc("fish_fillet_cooked"));
            AQUA_FROG_LEGS_COOKED = makeItem(aquaLoc("frog_legs_cooked"));
            CHERRY_PLANKS = makeItem(ftLoc("cherry_planks"));
            CITRUS_PLANKS = makeItem(ftLoc("citrus_planks"));
            BMO_ANCIENT_OAK_PLANKS = makeItem(bmoLoc("ancient_oak_planks"));
            BMO_BLIGHTED_BALSA_PLANKS = makeItem(bmoLoc("blighted_balsa_planks"));
            BMO_SWAMP_CYPRESS_PLANKS = makeItem(bmoLoc("swamp_cypress_planks"));
            BMO_WILLOW_PLANKS = makeItem(bmoLoc("willow_planks"));
            BOP_DEAD_PLANKS = makeItem(bopLoc("dead_planks"));
            BOP_FIR_PLANKS = makeItem(bopLoc("fir_planks"));
            BOP_HELLBARK_PLANKS = makeItem(bopLoc("hellbark_planks"));
            BOP_JACARANDA_PLANKS = makeItem(bopLoc("jacaranda_planks"));
            BOP_MAGIC_PLANKS = makeItem(bopLoc("magic_planks"));
            BOP_MAHOGANY_PLANKS = makeItem(bopLoc("mahogany_planks"));
            BOP_PALM_PLANKS = makeItem(bopLoc("palm_planks"));
            BOP_REDWOOD_PLANKS = makeItem(bopLoc("redwood_planks"));
            BOP_UMBRAN_PLANKS = makeItem(bopLoc("umbran_planks"));
            BOP_WILLOW_PLANKS = makeItem(bopLoc("willow_planks"));
            BOTANIA_DREAMWOOD_PLANKS = makeItem(botaniaLoc("dreamwood_planks"));
            BOTANIA_LIVINGWOOD_PLANKS = makeItem(botaniaLoc("livingwood_planks"));
            IE_STICK_TREATED = makeItem(ieLoc("stick_treated"));
            QUARK_AZALEA_PLANKS = makeItem(qLoc("azalea_planks"));
            QUARK_BLOSSOM_PLANKS = makeItem(qLoc("blossom_planks"));
            AYCE_HAZEL_PLANKS = makeItem(ayceLoc("hazel_planks"));
            TCON_BLOODSHROOM_PLANKS = makeItem(tconLoc("bloodshroom_planks"));
            TCON_GREENHEART_PLANKS = makeItem(tconLoc("greenheart_planks"));
            TCON_SKYROOT_PLANKS = makeItem(tconLoc("skyroot_planks"));
            WS_PALM_TREE_PLANKS = makeItem(wsLoc("palm_tree_planks"));
            AN_ARCHWOOD_PLANKS = makeItem(anLoc("archwood_planks"));
            UNDERGARDEN_GRONGLE_PLANKS = makeItem(undergardenLoc("grongle_planks"));
            UNDERGARDEN_SMOGSTEM_PLANKS = makeItem(undergardenLoc("smogstem_planks"));
            UNDERGARDEN_WIGGLEWOOD_PLANKS = makeItem(undergardenLoc("wigglewood_planks"));
            BYG_WHITE_MANGROVE_PLANKS = makeItem(bygLoc("white_mangrove_planks"));
            BYG_REDWOOD_PLANKS = makeItem(bygLoc("redwood_planks"));
            BYG_BLUE_ENCHANTED_PLANKS = makeItem(bygLoc("blue_enchanted_planks"));
            BYG_GREEN_ENCHANTED_PLANKS = makeItem(bygLoc("green_enchanted_planks"));
            BYG_MAHOGANY_PLANKS = makeItem(bygLoc("mahogany_planks"));
            BYG_BAOBAB_PLANKS = makeItem(bygLoc("baobab_planks"));
            BYG_JACARANDA_PLANKS = makeItem(bygLoc("jacaranda_planks"));
            BYG_CYPRESS_PLANKS = makeItem(bygLoc("cypress_planks"));
            BYG_PALM_PLANKS = makeItem(bygLoc("palm_planks"));
            BYG_EBONY_PLANKS = makeItem(bygLoc("ebony_planks"));
            BYG_RAINBOW_EUCALYPTUS_PLANKS = makeItem(bygLoc("rainbow_eucalyptus_planks"));
            BYG_ASPEN_PLANKS = makeItem(bygLoc("aspen_planks"));
            BYG_FIR_PLANKS = makeItem(bygLoc("fir_planks"));
            BYG_SKYRIS_PLANKS = makeItem(bygLoc("skyris_planks"));
            BYG_CIKA_PLANKS = makeItem(bygLoc("cika_planks"));
            BYG_HOLLY_PLANKS = makeItem(bygLoc("holly_planks"));
            BYG_MAPLE_PLANKS = makeItem(bygLoc("maple_planks"));
            BYG_PINE_PLANKS = makeItem(bygLoc("pine_planks"));
            BYG_WILLOW_PLANKS = makeItem(bygLoc("willow_planks"));
            BYG_WITCH_HAZEL_PLANKS = makeItem(bygLoc("witch_hazel_planks"));
            BYG_ZELKOVA_PLANKS = makeItem(bygLoc("zelkova_planks"));
            BYG_IRONWOOD_PLANKS = makeItem(bygLoc("ironwood_planks"));
            BYG_SAKURA_PLANKS = makeItem(bygLoc("sakura_planks"));
            BYG_PALO_VERDE_PLANKS = Items.BIRCH_PLANKS;
            BYG_FLORUS_STEM = makeItem(bygLoc("florus_planks"));
            BYG_SPIRIT_PLANKS = makeItem(bygLoc("spirit_planks"));
            TF_CANOPY_PLANKS = makeItem(tfLoc("canopy_planks"));
            TF_DARK_PLANKS = makeItem(tfLoc("dark_planks"));
            TF_MANGROVE_PLANKS = makeItem(tfLoc("mangrove_planks"));
            TF_MINING_PLANKS = makeItem(tfLoc("mining_planks"));
            TF_SORTING_PLANKS = makeItem(tfLoc("sorting_planks"));
            TF_TIME_PLANKS = makeItem(tfLoc("time_planks"));
            TF_TRANSFORMATION_PLANKS = makeItem(tfLoc("transformation_planks"));
            TF_TWILIGHT_OAK_PLANKS = makeItem(tfLoc("twilight_oak_planks"));
            ECO_COCONUT_PLANKS = makeItem(ecoLoc("coconut_planks"));
            ECO_WALNUT_PLANKS = makeItem(ecoLoc("walnut_planks"));
            ECO_AZALEA_PLANKS = makeItem(ecoLoc("azalea_planks"));
            ECO_FLOWERING_AZALEA_PLANKS = makeItem(ecoLoc("flowering_azalea_planks"));
            RU_ALPHA_PLANKS = makeItem(regionsLoc("alpha_planks"));
            RU_ACACIA_BRANCH = makeItem(regionsLoc("acacia_branch"));
            RU_BAOBAB_PLANKS = makeItem(regionsLoc("baobab_planks"));
            RU_BAOBAB_BRANCH = makeItem(regionsLoc("baobab_branch"));
            RU_BIRCH_BRANCH = makeItem(regionsLoc("birch_branch"));
            RU_BLACKWOOD_PLANKS = makeItem(regionsLoc("blackwood_planks"));
            RU_BLACKWOOD_BRANCH = makeItem(regionsLoc("blackwood_branch"));
            RU_BIOSHROOM_PLANKS = makeItem(regionsLoc("bioshroom_planks"));
            RU_BLUE_BIOSHROOM_PLANKS = makeItem(regionsLoc("blue_bioshroom_planks"));
            RU_BRIMWOOD_PLANKS = makeItem(regionsLoc("brimwood_planks"));
            RU_BRIMWOOD_BRANCH = makeItem(regionsLoc("brimwood_branch"));
            RU_COBALT_PLANKS = makeItem(regionsLoc("cobalt_planks"));
            RU_COBALT_BRANCH = makeItem(regionsLoc("cobalt_branch"));
            RU_CYPRESS_PLANKS = makeItem(regionsLoc("cypress_planks"));
            RU_CYPRESS_BRANCH = makeItem(regionsLoc("cypress_branch"));
            RU_DARK_OAK_BRANCH = makeItem(regionsLoc("dark_oak_branch"));
            RU_DEAD_PLANKS = makeItem(regionsLoc("dead_planks"));
            RU_DEAD_BRANCH = makeItem(regionsLoc("dead_branch"));
            RU_EUCALYPTUS_PLANKS = makeItem(regionsLoc("eucalyptus_planks"));
            RU_EUCALYPTUS_BRANCH = makeItem(regionsLoc("eucalyptus_branch"));
            RU_GREEN_BIOSHROOM_PLANKS = makeItem(regionsLoc("green_bioshroom_planks"));
            RU_JOSHUA_PLANKS = makeItem(regionsLoc("joshua_planks"));
            RU_JOSHUA_BRANCH = makeItem(regionsLoc("joshua_branch"));
            RU_JUNGLE_BRANCH = makeItem(regionsLoc("jungle_branch"));
            RU_KAPOK_PLANKS = makeItem(regionsLoc("kapok_planks"));
            RU_KAPOK_BRANCH = makeItem(regionsLoc("kapok_branch"));
            RU_LARCH_PLANKS = makeItem(regionsLoc("larch_planks"));
            RU_LARCH_BRANCH = makeItem(regionsLoc("larch_branch"));
            RU_MANGROVE_BRANCH = makeItem(regionsLoc("mangrove_branch"));
            RU_MAGNOLIA_PLANKS = makeItem(regionsLoc("magnolia_planks"));
            RU_MAGNOLIA_BRANCH = makeItem(regionsLoc("magnolia_branch"));
            RU_MAPLE_PLANKS = makeItem(regionsLoc("maple_planks"));
            RU_MAPLE_BRANCH = makeItem(regionsLoc("maple_branch"));
            RU_MAUVE_PLANKS = makeItem(regionsLoc("mauve_planks"));
            RU_MAUVE_BRANCH = makeItem(regionsLoc("mauve_branch"));
            RU_OAK_BRANCH = makeItem(regionsLoc("oak_branch"));
            RU_PALM_PLANKS = makeItem(regionsLoc("palm_planks"));
            RU_PALM_BRANCH = makeItem(regionsLoc("palm_branch"));
            RU_PINE_PLANKS = makeItem(regionsLoc("pine_planks"));
            RU_PINE_BRANCH = makeItem(regionsLoc("pine_branch"));
            RU_PINK_BIOSHROOM_PLANKS = makeItem(regionsLoc("pink_bioshroom_planks"));
            RU_REDWOOD_PLANKS = makeItem(regionsLoc("redwood_planks"));
            RU_REDWOOD_BRANCH = makeItem(regionsLoc("redwood_branch"));
            RU_SILVER_BIRCH_BRANCH = makeItem(regionsLoc("silver_birch_branch"));
            RU_SOCOTRA_PLANKS = makeItem(regionsLoc("socotra_planks"));
            RU_SOCOTRA_BRANCH = makeItem(regionsLoc("socotra_branch"));
            RU_SPRUCE_BRANCH = makeItem(regionsLoc("spruce_branch"));
            RU_WILLOW_PLANKS = makeItem(regionsLoc("willow_planks"));
            RU_WILLOW_BRANCH = makeItem(regionsLoc("willow_branch"));
            RU_YELLOW_BIOSHROOM_PLANKS = makeItem(regionsLoc("yellow_bioshroom_planks"));
            LD_PALM_PLANKS = makeItem(ldBeachLoc("palm_planks"));
            LD_LARCH_PLANKS = makeItem(ldBloomingLoc("larch_planks"));
            LD_BAOBAB_PLANKS = makeItem(ldBloomingLoc("baobab_planks"));
            LD_ASPEN_PLANKS = makeItem(ldBloomingLoc("aspen_planks"));
            LD_SWAMP_OAK_PLANKS = makeItem(ldBloomingLoc("swamp_oak_planks"));
            LD_SWAMP_CYPRESS_PLANKS = makeItem(ldBloomingLoc("swamp_cypress_planks"));
            LD_FAN_PALM_PLANKS = makeItem(ldBloomingLoc("fan_palm_planks"));
            LD_EBONY_PLANKS = makeItem(ldBloomingLoc("ebony_planks"));
            LD_CHESTNUT_PLANKS = makeItem(ldBloomingLoc("chestnut_planks"));
            LD_FIR_PLANKS = makeItem(ldBloomingLoc("fir_planks"));
            LD_CACTUS_PLANKS = makeItem(ldBloomingLoc("cactus_planks"));
            LD_PINE_PLANKS = makeItem(ldMeadowLoc("pine_planks"));
            LD_DARK_CHERRY_PLANKS = makeItem(ldVineryLoc("dark_cherry_planks"));

            // TF Messed up log/wood crap
            TF_CANOPY_LOG = tfLoc("canopy_log");
            TF_CANOPY_STRIPPED_LOG = tfLoc("stripped_canopy_log");
            TF_CANOPY_WOOD = tfLoc("canopy_wood");
            TF_CANOPY_STRIPPED_WOOD = tfLoc("stripped_canopy_wood");
            TF_DARK_LOG = tfLoc("dark_log");
            TF_DARK_STRIPPED_LOG = tfLoc("stripped_dark_log");
            TF_DARK_WOOD = tfLoc("dark_wood");
            TF_DARK_STRIPPED_WOOD = tfLoc("stripped_dark_wood");
            TF_MANGROVE_LOG = tfLoc("mangrove_log");
            TF_MANGROVE_STRIPPED_LOG = tfLoc("stripped_mangrove_log");
            TF_MANGROVE_WOOD = tfLoc("mangrove_wood");
            TF_MANGROVE_STRIPPED_WOOD = tfLoc("stripped_mangrove_wood");
            TF_MINING_LOG = tfLoc("mining_log");
            TF_MINING_STRIPPED_LOG = tfLoc("stripped_mining_log");
            TF_MINING_WOOD = tfLoc("mining_wood");
            TF_MINING_STRIPPED_WOOD = tfLoc("stripped_mining_wood");
            TF_SORTING_LOG = tfLoc("sorting_log");
            TF_SORTING_STRIPPED_LOG = tfLoc("stripped_sorting_log");
            TF_SORTING_WOOD = tfLoc("sorting_wood");
            TF_SORTING_STRIPPED_WOOD = tfLoc("stripped_sorting_wood");
            TF_TIME_LOG = tfLoc("time_log");
            TF_TIME_STRIPPED_LOG = tfLoc("stripped_time_log");
            TF_TIME_WOOD = tfLoc("time_wood");
            TF_TIME_STRIPPED_WOOD = tfLoc("stripped_time_wood");
            TF_TRANSFORMATION_LOG = tfLoc("transformation_log");
            TF_TRANSFORMATION_STRIPPED_LOG = tfLoc("stripped_transformation_log");
            TF_TRANSFORMATION_WOOD = tfLoc("transformation_wood");
            TF_TRANSFORMATION_STRIPPED_WOOD = tfLoc("stripped_transformation_wood");
            TF_TWILIGHT_OAK_LOG = tfLoc("twilight_oak_log");
            TF_TWILIGHT_OAK_STRIPPED_LOG = tfLoc("stripped_twilight_oak_log");
            TF_TWILIGHT_OAK_WOOD = tfLoc("twilight_oak_wood");
            TF_TWILIGHT_OAK_STRIPPED_WOOD = tfLoc("stripped_twilight_oak_wood");

            /*
             * And now Biome Makeover is doing stupid things ... tags were
             * added for a reason, this is a pattern with multiloader mods that
             * is just getting stupid. Either quit supporting Fabric loader, or
             * figure this shit out, it is going back to 1.12 stupidity.
             */
            BMO_ANCIENT_OAK_LOG = bmoLoc("ancient_oak_log");
            BMO_STRIPPED_ANCIENT_OAK_LOG = bmoLoc("stripped_ancient_oak_log");
            BMO_ANCIENT_OAK_WOOD = bmoLoc("ancient_oak_wood");
            BMO_STRIPPED_ANCIENT_OAK_WOOD = bmoLoc("stripped_ancient_oak_wood");
            BMO_BLIGHTED_BALSA_LOG = bmoLoc("blighted_balsa_log");
            BMO_STRIPPED_BLIGHTED_BALSA_LOG = bmoLoc("stripped_blighted_balsa_log");
            BMO_BLIGHTED_BALSA_WOOD = bmoLoc("blighted_balsa_wood");
            BMO_STRIPPED_BLIGHTED_BALSA_WOOD = bmoLoc("stripped_blighted_balsa_wood");
            BMO_SWAMP_CYPRESS_LOG = bmoLoc("swamp_cypress_log");
            BMO_STRIPPED_SWAMP_CYPRESS_LOG = bmoLoc("stripped_swamp_cypress_log");
            BMO_SWAMP_CYPRESS_WOOD = bmoLoc("swamp_cypress_wood");
            BMO_STRIPPED_SWAMP_CYPRESS_WOOD = bmoLoc("stripped_swamp_cypress_wood");
            BMO_WILLOW_LOG = bmoLoc("willow_log");
            BMO_STRIPPED_WILLOW_LOG = bmoLoc("stripped_willow_log");
            BMO_WILLOW_WOOD = bmoLoc("willow_wood");
            BMO_STRIPPED_WILLOW_WOOD = bmoLoc("stripped_willow_wood");
            MALUM_RUNEWOOD_PLANKS = makeItem(malumLoc("runewood_planks"));
            MALUM_SOULWOOD_PLANKS = makeItem(malumLoc("soulwood_planks"));
            IFD_DREADWOOD_PLANKS = makeItem(ifdLoc("dreadwood_planks"));
        }

        for (Map.Entry<ResourceLocation, Item> entry : ALL.entrySet()) {
            consumer.accept(entry.getValue(), entry.getKey());
        }
    }

    private static Item makeItem(ResourceLocation loc) {
        Item item = (new Item(new Item.Properties().setId(ResourceKey.create(Registries.ITEM, loc))));

        ALL.put(loc, item);

        return item;
    }

    public static ResourceLocation bmoLoc(String name) {
        return getLoc(BMO_MODID, name);
    }

    public static ResourceLocation tconLoc(String name) {
        return getLoc(TCON_MODID, name);
    }

    public static ResourceLocation ayceLoc(String name) {
        return getLoc(AYCE_MODID, name);
    }

    public static ResourceLocation qLoc(String name) {
        return getLoc(QUARK_MODID, name);
    }

    public static ResourceLocation bopLoc(String name) {
        return getLoc(BOP_MODID, name);
    }

    public static ResourceLocation botaniaLoc(String name) {
        return getLoc(BOTANIA_MODID, name);
    }

    public static ResourceLocation ftLoc(String name) {
        return getLoc(FT_MODID, name);
    }

    public static ResourceLocation ieLoc(String name) {
        return getLoc(IE_MODID, name);
    }

    public static ResourceLocation sgcLoc(String name) {
        return getLoc(SGC_MODID, name);
    }

    public static ResourceLocation wsLoc(String name) {
        return getLoc(WS_MODID, name);
    }

    public static ResourceLocation anLoc(String name) {
        return getLoc(AN_MODID, name);
    }

    public static ResourceLocation exnihiloLoc(String name) {
        return getLoc(EXNIHILO_MODID, name);
    }

    public static ResourceLocation undergardenLoc(String name) {
        return getLoc(UNDERGARDEN_MODID, name);
    }

    public static ResourceLocation dynamictreesLoc(String name) {
        return getLoc(DYNAMICTREES_MODID, name);
    }

    public static ResourceLocation bygLoc(String name) {
        return getLoc(BYG_MODID, name);
    }

    public static ResourceLocation tfLoc(String name) {
        return getLoc(TF_MODID, name);
    }

    public static ResourceLocation ecoLoc(String name) {
        return getLoc(ECO_MODID, name);
    }

    public static ResourceLocation aquaLoc(String name) {
        return getLoc(AQUA_MODID, name);
    }

    public static ResourceLocation bapLoc(String name) {
        return getLoc(BAP_MODID, name);
    }

    public static ResourceLocation alexLoc(String name) {
        return getLoc(ALEX_MODID, name);
    }

    public static ResourceLocation malumLoc(String name) {
        return getLoc(MALUM_MODID, name);
    }

    public static ResourceLocation ifdLoc(String name) {
        return getLoc(IFD_MODID, name);
    }

    public static ResourceLocation tsLoc(String name) {
        return getLoc(TS_MODID, name);
    }

    public static ResourceLocation regionsLoc(String name) {
        return getLoc(REGIONS_MODID, name);
    }

    public static ResourceLocation tetraLoc(String name) {
        return getLoc(TETRA_MODID, name);
    }

    public static ResourceLocation mcLoc(String name) {
        return getLoc(MINECRAFT_MODID, name);
    }

    public static ResourceLocation ldBeachLoc(String name) {
        return loc(LD_BEACH_MODID, name);
    }

    public static ResourceLocation ldBloomingLoc(String name) {
        return loc(LD_BLOOMING_MODID, name);
    }

    public static ResourceLocation ldFarmLoc(String name) {
        return loc(LD_FARM_MODID, name);
    }

    public static ResourceLocation ldMeadowLoc(String name) {
        return loc(LD_MEADOW_MODID, name);
    }

    public static ResourceLocation ldVineryLoc(String name) {
        return loc(LD_VINERY_MODID, name);
    }

    public static ResourceLocation ldWilderLoc(String name) {
        return loc(LD_WILDER_MODID, name);
    }

    private static ResourceLocation getLoc(String modid, String name) {
        return loc(modid, name);
    }

}
