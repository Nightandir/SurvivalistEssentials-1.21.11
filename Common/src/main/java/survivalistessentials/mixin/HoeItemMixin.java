package survivalistessentials.mixin;

import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import survivalistessentials.config.ConfigHandler;
import survivalistessentials.sound.SurvivalistEssentialsSounds;
import survivalistessentials.util.ItemUse;

@Mixin(HoeItem.class)
public abstract class HoeItemMixin {

    @Inject(method = "useOn", at = @At("HEAD"), cancellable = true)
    private void survivalistessentials$useOn(UseOnContext context, CallbackInfoReturnable<InteractionResult> cir) {
        Player player = context.getPlayer();

        if (player != null && !player.isCreative()) {
            final ItemStack handStack = player.getMainHandItem();
            final Level level = player.level();

            if (!ItemUse.isAllowedTool(handStack)) {
                if (!level.isClientSide() && ConfigHandler.Client.enableFailSound()) {
                    level.playSound(null, player.getOnPos(), SurvivalistEssentialsSounds.HOE_FAIL, SoundSource.PLAYERS, 0.2F, 1.0F);
                }
                cir.setReturnValue(InteractionResult.FAIL);
            }
        }
    }

}
