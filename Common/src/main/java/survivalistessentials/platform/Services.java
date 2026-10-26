package survivalistessentials.platform;

import survivalistessentials.SurvivalistEssentials;
import survivalistessentials.platform.services.IPlatformHelper;
import survivalistessentials.platform.services.IREIHelper;

public class Services extends technology.roughness.whitenoise.platform.Services {

    public static final IPlatformHelper PLATFORM_HELPER = load(SurvivalistEssentials.LOGGER, IPlatformHelper.class);
    public static final IREIHelper REI_HELPER = load(SurvivalistEssentials.LOGGER, IREIHelper.class);

}
