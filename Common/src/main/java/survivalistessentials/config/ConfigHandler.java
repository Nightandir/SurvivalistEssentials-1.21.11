package survivalistessentials.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;

import technology.roughness.whitenoise.config.WhiteNoiseConfigSpec;

import survivalistessentials.common.Translations;
import survivalistessentials.util.ItemUse;

public final class ConfigHandler {

    public static final WhiteNoiseConfigSpec CLIENT_SPEC;
    public static final WhiteNoiseConfigSpec COMMON_SPEC;

    private static final Client CLIENT;
    private static final Common COMMON;

    static {
        final Pair<Client, WhiteNoiseConfigSpec> specPairClient = new WhiteNoiseConfigSpec.Builder().configure(Client::new);
        final Pair<Common, WhiteNoiseConfigSpec> specPairCommon = new WhiteNoiseConfigSpec.Builder().configure(Common::new);

        CLIENT_SPEC = specPairClient.getRight();
        CLIENT = specPairClient.getLeft();
        COMMON_SPEC = specPairCommon.getRight();
        COMMON = specPairCommon.getLeft();
    }

    public static void init() {
        Common.tagList().clear();
        Common.TAGS.get().forEach((s) -> {
            Common.tagList().add(TagKey.create(Registries.ITEM, ResourceLocation.parse(s)));
        });

        ItemUse.init();
    }

    public static final class Client {

        private final WhiteNoiseConfigSpec.BooleanValue ENABLE_FAIL_SOUND;
        private final WhiteNoiseConfigSpec.BooleanValue INFORM_TCON_COMPAT;

        Client(WhiteNoiseConfigSpec.Builder builder) {
            ENABLE_FAIL_SOUND = builder
                .comment(getTranslation("enablefailsound"))
                .define("ENABLE_FAIL_SOUND", false);
            INFORM_TCON_COMPAT = builder
                .comment(getTranslation("informtconcompat"))
                .define("INFORM_TCON_COMPAT", true);
        }

        public static boolean enableFailSound() {
            return CLIENT.ENABLE_FAIL_SOUND.get();
        }

        public static boolean informTConCompat() {
            return CLIENT.INFORM_TCON_COMPAT.get();
        }

        public static void disableTConCompatMessage() {
            CLIENT.INFORM_TCON_COMPAT.set(false);
            CLIENT.INFORM_TCON_COMPAT.save();
        }

    }

    public static final class Common {

        private final WhiteNoiseConfigSpec.DoubleValue FLINT_CHANCE;
        private final WhiteNoiseConfigSpec.DoubleValue HEAL_RATE;
        private final WhiteNoiseConfigSpec.DoubleValue SLOW_DOWN_SPEED;
        private final WhiteNoiseConfigSpec.BooleanValue ENABLE_HUNGER_PENALTY;
        private final WhiteNoiseConfigSpec.IntValue HUNGER;
        private final WhiteNoiseConfigSpec.IntValue SATURATION;
        private final WhiteNoiseConfigSpec.BooleanValue ENABLE_HEALTH_PENALTY;
        private final WhiteNoiseConfigSpec.DoubleValue HEALTH;
        private final WhiteNoiseConfigSpec.DoubleValue STARTING_HEALTH_PENALTY;
        private final WhiteNoiseConfigSpec.IntValue GENERIC_DAMAGE;
        private final WhiteNoiseConfigSpec.BooleanValue INVERT_LIST_TO_WHITELIST;
        private final WhiteNoiseConfigSpec.BooleanValue DISABLE_MODPACK_BOOK;

        private static final List<String> MODS_LIST = List.of("mods");
        public static final String[] modsStrings = new String[] {};
        // See: https://github.com/MinecraftForge/MinecraftForge/blob/1.18.x/fmlloader/src/main/java/net/minecraftforge/fml/loading/moddiscovery/ModInfo.java
        private static final Predicate<Object> modidValidator = s -> s instanceof String
                && ((String) s).matches("^[a-z][a-z0-9_]{1,63}$");
        private static WhiteNoiseConfigSpec.ConfigValue<List<? extends String>> MODS;

        private static final List<String> ITEMS_LIST = List.of("items");
        public static final String[] itemsStrings = new String[] {
           "pickaxe-minecraft:diamond_pickaxe",
        };
        private static final Predicate<Object> itemidValidator = s -> s instanceof String
                && ((String) s).matches("[a-z]+[-]{1}[a-z][a-z0-9_]{1,63}+[:]{1}[a-z_]+");
        private static WhiteNoiseConfigSpec.ConfigValue<List<? extends String>> ITEMS;

        private static WhiteNoiseConfigSpec.BooleanValue LOG_MODPACK_DATA;

        private static final List<String> BLOCK_MODS_LIST = List.of("blockmods");
        public static final String[] blockModsStrings = new String[] {
            "comforts"
        };
        private static WhiteNoiseConfigSpec.ConfigValue<List<? extends String>> BLOCK_MODS;

        private static final List<String> ARMOR_MODS_LIST = List.of("armormods");
        public static final String[] armorModsStrings = new String[] {};
        private static WhiteNoiseConfigSpec.ConfigValue<List<? extends String>> ARMOR_MODS;
        private static final List<String> ARMOR_LIST = List.of("armor");
        public static final String[] armorStrings = new String[] {};
        private static final Predicate<Object> resourceLocationValidator = s -> s instanceof String
                && ((String) s).matches("[a-z]+[:]{1}[a-z_]+");
        private static WhiteNoiseConfigSpec.ConfigValue<List<? extends String>> ARMORS;
        private static final List<String> TAG_LIST = List.of("tag");
        public static final String[] tagStrings = new String[] {
            "c:blacklist_tools"
        };
        private static final List<TagKey<Item>> tagList = new ArrayList<>();
        private static WhiteNoiseConfigSpec.ConfigValue<List<? extends String>> TAGS;

        Common(WhiteNoiseConfigSpec.Builder builder) {
            FLINT_CHANCE = builder
                .comment(getTranslation("flintchance"))
                .defineInRange("FLINT_CHANCE", 0.6, 0.1, 1.0);
            HEAL_RATE = builder
                .comment(getTranslation("healrate"))
                .defineInRange("HEAL_RATE", 0.14, 0.1, 1.0);
            SLOW_DOWN_SPEED = builder
                .comment(getTranslation("slowdownspeed"))
                .defineInRange("SLOW_DOWN_SPEED", 0.4, 0.1, 1.0);
            INVERT_LIST_TO_WHITELIST = builder
                .comment(getTranslation("invertlisttowhitelist"))
                .define("INVERT_LIST_TO_WHITELIST", false);
            MODS = builder
                .comment(getTranslation("modslist"))
                .defineListAllowEmpty(MODS_LIST, getFields(modsStrings), modidValidator);
            ITEMS = builder
                .comment(getTranslation("itemslist"))
                .defineListAllowEmpty(ITEMS_LIST, getFields(itemsStrings), itemidValidator);
            LOG_MODPACK_DATA = builder
                .comment(getTranslation("logmodpackdata"))
                .define("LOG_MODPACK_DATA", false);
            BLOCK_MODS = builder
                .comment(getTranslation("blockmodslist"))
                .defineListAllowEmpty(BLOCK_MODS_LIST, getFields(blockModsStrings), modidValidator);
            ENABLE_HUNGER_PENALTY = builder
                .comment(getTranslation("enablehungerpenalty"))
                .define("ENABLE_HUNGER_PENALTY", false);
            HUNGER = builder
                .comment(getTranslation("hunger"))
                .defineInRange("HUNGER", 8, 0, 20);
            SATURATION = builder
                .comment(getTranslation("saturation"))
                .defineInRange("SATURATION", 0, 0, 20);
            ENABLE_HEALTH_PENALTY = builder
                .comment(getTranslation("enablehealthpenalty"))
                .define("ENABLE_HEALTH_PENALTY", false);
            HEALTH = builder
                .comment(getTranslation("health"))
                .defineInRange("HEALTH", 6.0, 0.5, 100.0);
            STARTING_HEALTH_PENALTY = builder
                    .comment(getTranslation("startinghealthpenalty"))
                    .defineInRange("STARTING_HEALTH_PENALTY", 0.0, 0.0, 19.0);
            GENERIC_DAMAGE = builder
                .comment(getTranslation("genericdamage"))
                .defineInRange("GENERIC_DAMAGE", 0, 0, 4);
            ARMOR_MODS = builder
                .comment(getTranslation("armormodslist"))
                .defineListAllowEmpty(ARMOR_MODS_LIST, getFields(armorModsStrings), modidValidator);
            ARMORS = builder
                .comment(getTranslation("armorlist"))
                .defineListAllowEmpty(ARMOR_LIST, getFields(armorStrings), resourceLocationValidator);
            TAGS = builder
                .comment(getTranslation("taglist"))
                .defineListAllowEmpty(TAG_LIST, getFields(tagStrings), resourceLocationValidator);
            DISABLE_MODPACK_BOOK = builder
                .comment(getTranslation("disablemodpackbook"))
                .define("DISABLE_MODPACK_BOOK", true);
        }

        public static double flintChance() {
            return COMMON.FLINT_CHANCE.get();
        }

        public static double healRate() {
            return COMMON.HEAL_RATE.get();
        }

        public static boolean invertListToWhitelist() {
            return COMMON.INVERT_LIST_TO_WHITELIST.get();
        }

        public static float slowDownSpeed() {
            double slowDownSpeed = COMMON.SLOW_DOWN_SPEED.get();

            return (float) slowDownSpeed;
        }

        private static Supplier<List<? extends String>> getFields(String[] strings) {
            return () -> Arrays.asList(strings);
        }

        public static List<? extends String> getMods() {
            return MODS.get();
        }

        public static List<? extends String> getItems() {
            return ITEMS.get();
        }

        public static boolean logModpackData() {
            return LOG_MODPACK_DATA.get();
        }

        public static List<? extends String> blockWhitelistMods() {
            return BLOCK_MODS.get();
        }

        public static boolean enableHungerPenalty() {
            return COMMON.ENABLE_HUNGER_PENALTY.get();
        }

        public static int hunger() {
            return COMMON.HUNGER.get();
        }

        public static int saturation() {
            return COMMON.SATURATION.get();
        }

        public static boolean enableHealthPenalty() {
            return COMMON.ENABLE_HEALTH_PENALTY.get();
        }

        public static float health() {
            double health = COMMON.HEALTH.get();

            return (float) health;
        }

        public static float startingHealthPenalty() {
            double health = COMMON.STARTING_HEALTH_PENALTY.get();
            health *= -1;

            return (float) health;
        }

        public static float genericDamage() {
            int damage = COMMON.GENERIC_DAMAGE.get();

            return (float) damage;
        }

        public static List<? extends String> armorMods() {
            return ARMOR_MODS.get();
        }

        public static List<? extends String> armorItems() {
            return ARMORS.get();
        }

        public static List<TagKey<Item>> tagList() {
            return tagList;
        }

        public static boolean disableModpackBook() {
            return COMMON.DISABLE_MODPACK_BOOK.get();
        }

        public static boolean getConfigValue(String key) {
            return switch (key) {
                case "disableModpackBook" -> disableModpackBook();
                default -> true;
            };
        }

    }

    private static String getTranslation(String key) {
        return Translations.get(key);
    }

}
