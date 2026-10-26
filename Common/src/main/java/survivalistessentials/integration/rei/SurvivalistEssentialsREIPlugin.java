package survivalistessentials.integration.rei;

import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.entry.EntryRegistry;
import me.shedaniel.rei.api.common.entry.EntryStack;

import net.minecraft.world.item.ItemStack;

import survivalistessentials.config.ConfigHandler;
import survivalistessentials.items.SurvivalistEssentialsItems;
import survivalistessentials.platform.Services;

public class SurvivalistEssentialsREIPlugin implements REIClientPlugin {

    @Override
    public void registerEntries(EntryRegistry registry) {
        registry.removeEntryIf(this::shouldHideEntry);
    }

    private boolean shouldHideEntry(EntryStack<?> entryStack) {
        if (!Services.REI_HELPER.isVanillaItemType(entryStack)) return false;

        ItemStack stack = entryStack.castValue();

        if (ConfigHandler.Common.disableModpackBook()) {
            return stack.getItem() == SurvivalistEssentialsItems.MODPACK_BOOK;
        }

        return false;
    }

}
