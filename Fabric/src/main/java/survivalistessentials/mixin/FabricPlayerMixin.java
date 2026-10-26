package survivalistessentials.mixin;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;

import net.fabricmc.fabric.api.entity.FakePlayer;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.BlockState;

import org.apache.commons.lang3.tuple.Pair;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import survivalistessentials.event.HarvestEventHandler;

@Mixin(Player.class)
public abstract class FabricPlayerMixin {

    @Inject(method = "hasCorrectToolForDrops", at = @At("HEAD"), cancellable = true)
    private void survivalistessentials$hasCorrectToolForDrops(BlockState state, CallbackInfoReturnable<Boolean> cir) {
        Player player = (Player)(Object) this;

        if (!(player instanceof FakePlayer)) {
            cir.setReturnValue(HarvestEventHandler.canHarvest(player, state, cir.getReturnValueZ()));
        }
    }

    @ModifyReturnValue(method = "getDestroySpeed", at = @At("RETURN"))
    private float survivalistessentials$modifyDestroySpeed(float originalSpeed, BlockState state) {
        Player player = (Player) (Object) this;

        if (!(player instanceof FakePlayer)) {
            Pair<Boolean, Float> slowdown = HarvestEventHandler.getMiningSlowdown(player, state);

            if (slowdown.getLeft()) {
                return slowdown.getRight();
            }
        }

        return originalSpeed;
    }

}
