package survivalistessentials.world.effect;

import java.util.function.BiConsumer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;

import static survivalistessentials.util.ResourceLocationHelper.prefix;

public final class SurvivalistEssentialsEffects {

    public static final ResourceLocation STOP_BLEEDING_ID = prefix("stop_bleeding");
    public static final MobEffect STOP_BLEEDING = new StopBleeding();

    public static final ResourceLocation ZOMBIE_ESSENCE_ID = prefix("zombie_essence");
    public static final MobEffect ZOMBIE_ESSENCE = new ZombieEssence();

    public static void init(BiConsumer<MobEffect, ResourceLocation> consumer) {
        consumer.accept(STOP_BLEEDING, STOP_BLEEDING_ID);
        consumer.accept(ZOMBIE_ESSENCE, ZOMBIE_ESSENCE_ID);
    }

}
