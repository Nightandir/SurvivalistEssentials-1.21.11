package survivalistessentials.common;

import java.util.Map;

import com.google.common.base.Joiner;
import com.google.common.collect.Maps;

import org.slf4j.helpers.MessageFormatter;

import survivalistessentials.config.ConfigHandler;
import survivalistessentials.util.ItemUse;

public class Translations {

    private static final Joiner LINE_JOINER = Joiner.on("\n");
    private static final Map<String, String> translations = Maps.newHashMap();

    static {
        translations.put("enablefailsound", "Enables the fail sound if using the wrong tool.");
        translations.put("informtconcompat", "Informs user if Tinkers' Construct is installed and recommends installing Tinkers' Survival.");
        translations.put("flintchance", "Chance for a successful flint knapping. (1.0 = 100%, 0.4 = 40%, etc.)");
        translations.put("healrate", "Heal rate for bandages. Crude bandages are 50% less effective. (1.0 = 100%, 0.4 = 40%, etc.)");
        translations.put("slowdownspeed", "Slowdown speed when using incorrect tool.");
        translations.put("invertlisttowhitelist", joiner(
            "Inverts blacklist to be whitelist. This allows for immersion mods/modpacks to only ",
            "allow tools or armor for specific mods. Default: false"
        ));
        translations.put("modslist", joiner(
            "List of mods that tools will become wet noodles. If inverted, acts as a whitelist. Default: ",
            "[\"" + String.join("\", \"", ConfigHandler.Common.modsStrings) + "\"]"
        ));
        translations.put("itemslist", joiner(
            "List of individual tools that will always work. Format tooltype-modid:item",
            "Default: [\"" + String.join("\", \"", ConfigHandler.Common.itemsStrings) + "\"]",
            "Types: [\"" + String.join("\", \"", ItemUse.TOOL_TYPES) + "\"]"
        ));
        translations.put("logmodpackdata", "Used to dump log info for Survivalist Essentials Modpack. Ignore.");
        translations.put("blockmodslist", joiner(
            "List of mods that have blocks that are generally decorative in nature and ",
            "require no tool for harvesting blocks. Default: ",
            "[\"" + String.join("\", \"", ConfigHandler.Common.blockModsStrings) + "\"]"
        ));
        translations.put("enablehungerpenalty", "Hunger penalty feature. If after dying, player is rewarded with reduced hunger levels.");
        translations.put("hunger", "Hunger value after death in half shanks. (0 = Really? That's just cruel, 20 = No penalty.)");
        translations.put("saturation", "Saturation value after death. Range 0 to 20.");
        translations.put("enablehealthpenalty", "Health penalty feature. If after dying, player is rewarded with reduced health levels.");
        translations.put("health", "Health value after death in half hearts.");
        translations.put("startinghealthpenalty", "Health penalty in half hearts player starts with. Reduces total starting health by this amount.");
        translations.put("genericdamage", "The amount of generic damage in half hearts a disabled tool, or bare hand should do. Default 0");
        translations.put("armormodslist", joiner(
            "List of mods that armor will not be equipable for. If inverted, acts as a whitelist. Default: ",
            "[\"" + String.join("\", \"", ConfigHandler.Common.armorModsStrings) + "\"]"
        ));
        translations.put("armorlist", joiner(
            "List of individual armor items that will be disabled. If inverted, acts as a whitelist. Format modid:item Default: ",
            "[\"" + String.join("\", \"", ConfigHandler.Common.armorStrings) + "\"]"
        ));
        translations.put("taglist", joiner(
            "List of tags when added to tools or armor will be disabled. If inverted, acts as a whitelist.",
            "[\"" + String.join("\", \"", ConfigHandler.Common.tagStrings) + "\"]"
        ));
        translations.put("disablemodpackbook", "Disables the modpack book from being available. It doesn't work outside of the official modpack.");
    }

    public static String get(String key) {
        return translations.getOrDefault(key, key);
    }

    public static String get(String key, String... values) {
        return MessageFormatter.arrayFormat(translations.getOrDefault(key, key), values).getMessage();
    }

    private static String joiner(String... string) {
        return LINE_JOINER.join(string);
    }

}
