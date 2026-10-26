package survivalistessentials.mixin;

import net.fabricmc.fabric.api.entity.FakePlayer;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerPlayerGameMode;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import survivalistessentials.event.HarvestEventHandler;

@Mixin(ServerPlayerGameMode.class)
public abstract class FabricServerPlayerGameModeMixin {

    @Shadow
    @Final
    protected ServerPlayer player;

    @Shadow
    protected ServerLevel level;

    @Inject(method = "destroyBlock", at = @At(value = "INVOKE",
        target = "Lnet/minecraft/world/level/block/state/BlockState;getBlock()Lnet/minecraft/world/level/block/Block;",
        ordinal = 0
    ),
    cancellable = true)
    private void onBreak(BlockPos pos, CallbackInfoReturnable<Boolean> cir) {
        if (this.player instanceof FakePlayer) {
            return;
        }

        if (HarvestEventHandler.shouldCancelBreakBlock(this.level, pos, this.player)) {
            cir.setReturnValue(false);
        }
    }

}
