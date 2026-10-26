package survivalistessentials.mixin;

import net.minecraft.server.level.ServerPlayer;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import survivalistessentials.event.PlayerEventHandler;

@Mixin(ServerPlayer.class)
public abstract class FabricServerPlayerMixin {

    @Inject(method = "restoreFrom", at = @At("RETURN"))
    private void survivalistessentials$restoreFrom(ServerPlayer original, boolean keepEverything, CallbackInfo ci) {
        ServerPlayer player = (ServerPlayer) (Object) this;

        if (!player.isCreative() && !player.isSpectator()) {
            PlayerEventHandler.handlePlayerClone(player, !keepEverything);
        }
    }

}
