package survivalistessentials.event;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.ClientPlayerNetworkEvent;

public class ClientEvents {

    @SubscribeEvent
    public static void clientPlayerLogin(ClientPlayerNetworkEvent.LoggingIn event) {
        ClientEventHandler.clientPlayerLogin(event.getPlayer());
    }

}
