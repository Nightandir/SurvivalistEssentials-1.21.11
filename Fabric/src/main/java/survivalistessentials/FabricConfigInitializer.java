package survivalistessentials;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;

import technology.roughness.whitenoise.config.WhiteNoiseConfigInitializer;

import survivalistessentials.config.ConfigHandler;

public class FabricConfigInitializer implements WhiteNoiseConfigInitializer {

    @Override
    public void onInitializeConfig() {
        SurvivalistEssentials.initConfig();

        ServerLifecycleEvents.SERVER_STARTING.register(server -> {
            ConfigHandler.init();
        });
    }

}
