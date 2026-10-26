package survivalistessentials;

import java.util.Map;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;

import survivalistessentials.event.TooltipEventHandler;
import survivalistessentials.items.SurvivalistEssentialsItems;

public class SurvivalistEssentialsClientFabric implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        registerCreativeTabItems();
        ItemTooltipCallback.EVENT.register((stack, context, tooltip, lines) -> {
            TooltipEventHandler.onItemToolTip(stack, lines);
        });
    }

    private void registerCreativeTabItems() {
        for (Map.Entry<ResourceLocation, Item> entry : SurvivalistEssentialsItems.getToolsAndUtilities().entrySet()) {
            ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register(entries -> entries.accept(entry.getValue()));
        }
        for (Map.Entry<ResourceLocation, Item> entry : SurvivalistEssentialsItems.getAllIngredients().entrySet()) {
            ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.INGREDIENTS)
                .register(entries -> entries.accept(entry.getValue()));
        }
    }

}
