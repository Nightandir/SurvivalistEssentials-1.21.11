package survivalistessentials.platform;

import net.minecraft.world.entity.player.Player;

import tschipp.carryon.common.carry.CarryOnDataManager;

import survivalistessentials.platform.services.IPlatformHelper;

public class NeoForgePlatformHelper implements IPlatformHelper {

    @Override
    public boolean isCarryonKeyPressed(Player player) {
        return CarryOnDataManager.getCarryData(player).isKeyPressed();
    }

}
