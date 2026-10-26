package survivalistessentials.mixin;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.AbstractHurtingProjectile;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import survivalistessentials.event.HarvestEventHandler;

@Mixin(AbstractHurtingProjectile.class)
public abstract class AbstractHurtingProjectileMixin {

    /*
     * Inject to capture spell projectile hits before the hit is processed
     * so that we can determine which block was hit for harvesting purposes.
     */
    @Inject(method = "tick", at = @At(value = "HEAD"))
    private void survivalistessentials$beforeHit(CallbackInfo ci) {
        Entity projectile = ((Projectile) (Object) this).getOwner();

        if (projectile != null && projectile.toString().toLowerCase().contains("spell")) {
            Vec3 position = projectile.position();
            Vec3 nextPosition = position.add(projectile.getDeltaMovement());
            BlockHitResult hitresult = projectile.level().clip(
                new ClipContext(position, nextPosition, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, projectile));
            BlockPos pos = hitresult.getBlockPos();

            HarvestEventHandler.setSpellHitBlock(projectile.level().getBlockState(new BlockPos(pos)).getBlock());
        }
    }

}
