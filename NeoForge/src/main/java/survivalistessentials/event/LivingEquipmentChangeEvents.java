package survivalistessentials.event;

import net.minecraft.world.entity.player.Player;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.event.entity.living.LivingEquipmentChangeEvent;

public class LivingEquipmentChangeEvents {

    @SubscribeEvent
    public static void onChange(LivingEquipmentChangeEvent event) {
        if (event.getEntity() instanceof Player player) {
            EquipmentChangeHandler.handleChange(player, event.getSlot(), event.getTo());
        }
    }

}
