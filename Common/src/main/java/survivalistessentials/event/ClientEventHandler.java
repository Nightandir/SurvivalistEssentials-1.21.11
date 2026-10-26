package survivalistessentials.event;

import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

import technology.roughness.whitenoise.platform.Services;

import survivalistessentials.config.ConfigHandler;
import survivalistessentials.data.integration.SurvivalistEssentialsIntegration;

public class ClientEventHandler {

    public static void clientPlayerLogin(Player player) {
        if (!Services.PLATFORM.isModLoaded(SurvivalistEssentialsIntegration.TS_MODID)
            && Services.PLATFORM.isModLoaded(SurvivalistEssentialsIntegration.TCON_MODID)
            && ConfigHandler.Client.informTConCompat()) {
            Component message = Component.translatable("message.survivalistessentials.tcon_compat")
                .withStyle(ChatFormatting.DARK_GREEN);

            Minecraft.getInstance().gui.getChat().addMessage(message);
            ConfigHandler.Client.disableTConCompatMessage();
        }
    }

}
