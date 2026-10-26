package survivalistessentials.registries;

import com.mojang.serialization.MapCodec;

import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import survivalistessentials.SurvivalistEssentials;

public class SurvivalistEssentialsNeoForgeRegistries {

    public static final DeferredRegister<MapCodec<? extends ICondition>> CONDITION_SERIALIZERS_DEFERRED_REGISTER =
        DeferredRegister.create(NeoForgeRegistries.CONDITION_SERIALIZERS, SurvivalistEssentials.MODID);

}
