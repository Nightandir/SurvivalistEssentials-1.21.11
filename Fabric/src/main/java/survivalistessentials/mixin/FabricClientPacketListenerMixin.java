package survivalistessentials.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.network.protocol.game.ClientboundLoginPacket;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import survivalistessentials.event.ClientEventHandler;

@Mixin(ClientPacketListener.class)
public abstract class FabricClientPacketListenerMixin {

    @Inject(method = "handleLogin", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/Options;setServerRenderDistance(I)V", shift = At.Shift.AFTER))
    private void handleLogin(ClientboundLoginPacket packet, CallbackInfo ci) {
        ClientEventHandler.clientPlayerLogin(Minecraft.getInstance().player);
    }

}
