package survivalistessentials.mixin;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import survivalistessentials.config.ConfigHandler;
import survivalistessentials.event.AttackEventHandler;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    // Based on https://github.com/TwelveIterationMods/Balm/blob/1.21.10/fabric/src/main/java/net/blay09/mods/balm/mixin/LivingEntityMixin.java
    // Equivalent to NeoForge LivingDamageEvent.Pre
    @ModifyVariable(method = "actuallyHurt(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/damagesource/DamageSource;F)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/LivingEntity;setAbsorptionAmount(F)V"), argsOnly = true)
    private float actuallyHurt(float damageAmount, ServerLevel serverLevel, DamageSource source) {
        if (AttackEventHandler.hasGenericDamage(source)) {
            return ConfigHandler.Common.genericDamage();
        }

        return damageAmount;
    }

}
