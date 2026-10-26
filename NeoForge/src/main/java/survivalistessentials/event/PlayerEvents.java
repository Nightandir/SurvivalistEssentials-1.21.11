package survivalistessentials.event;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;

import net.neoforged.bus.api.EventPriority;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.player.PlayerEvent;

public class PlayerEvents {

    @SubscribeEvent
    public static void onPlayerLogin(PlayerEvent.PlayerLoggedInEvent event) {
        Player player = event.getEntity();

        if (!player.level().isClientSide()) {
            ServerPlayer sp = (ServerPlayer) player;

            PlayerEventHandler.applyHealthPenalty(sp);
        }
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public static void onPlayerClone(PlayerEvent.Clone event) {
        Player player = event.getEntity();

        if (!player.isCreative()
                && !player.isSpectator()
                && !player.level().isClientSide()
                && event.isWasDeath()) {
            ServerPlayer sp = (ServerPlayer) player;

            PlayerEventHandler.handlePlayerClone(sp, true);
        }
    }

}
