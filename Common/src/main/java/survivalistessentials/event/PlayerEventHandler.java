package survivalistessentials.event;

import java.util.Objects;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;

import survivalistessentials.config.ConfigHandler;

import static survivalistessentials.util.ResourceLocationHelper.prefix;

public class PlayerEventHandler {

    private static final ResourceLocation STARTING_HEALTH_PENALTY = prefix("starting_health_penalty");

    public static void handlePlayerClone(ServerPlayer sp, boolean wasDeath) {
        applyHealthPenalty(sp);

        if (wasDeath) {
            if (ConfigHandler.Common.enableHungerPenalty()) {
                sp.getFoodData().setFoodLevel(ConfigHandler.Common.hunger());
                sp.getFoodData().setSaturation(ConfigHandler.Common.saturation());
            }
            if (ConfigHandler.Common.enableHealthPenalty()) {
                sp.setHealth(ConfigHandler.Common.health());
            }
        }
    }

    public static void applyHealthPenalty(ServerPlayer player) {
        if (player != null && ConfigHandler.Common.startingHealthPenalty() < 0) {
            float maxHealth = player.getMaxHealth();
            float newHealth = maxHealth + ConfigHandler.Common.startingHealthPenalty();

            if (newHealth >= 1.0F) {
                AttributeInstance attributeInstance = maxHealthAttribute(player);
                AttributeModifier modifier = new AttributeModifier(
                    STARTING_HEALTH_PENALTY,
                    ConfigHandler.Common.startingHealthPenalty(),
                    AttributeModifier.Operation.ADD_VALUE
                );

                attributeInstance.removeModifier(STARTING_HEALTH_PENALTY);
                attributeInstance.addPermanentModifier(modifier);
            }
        }
    }

    private static AttributeInstance maxHealthAttribute(Player player) {
        return Objects.requireNonNull(player.getAttribute(Attributes.MAX_HEALTH));
    }

}
