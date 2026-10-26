package survivalistessentials.mixin;

import net.minecraft.network.Connection;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.network.CommonListenerCookie;
import net.minecraft.server.players.PlayerList;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import survivalistessentials.event.PlayerEventHandler;

@Mixin(PlayerList.class)
public abstract class FabricPlayerListMixin {

    @Inject(method = "placeNewPlayer", at = @At("RETURN"))
    private void injectPlaceNewPlayer(Connection connection, ServerPlayer sp, CommonListenerCookie cookie, CallbackInfo ci) {
        PlayerEventHandler.applyHealthPenalty(sp);
    }

}
