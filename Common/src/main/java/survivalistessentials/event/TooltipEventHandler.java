package survivalistessentials.event;

import java.util.List;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

import survivalistessentials.SurvivalistEssentials;
import survivalistessentials.util.ItemUse;

public class TooltipEventHandler {

    public static void onItemToolTip(ItemStack stack, List<Component> tooltipComponent) {
        Component message;
        String tooltip = "";

        if (!ItemUse.getToolClass(stack).equals("unknown") && !ItemUse.isAllowedTool(stack)) {
            String type = ItemUse.getToolClass(stack);
            tooltip = "tooltip." + SurvivalistEssentials.MODID + ".uselessTool2";

            if (!type.equals("unknown")) {
                switch (type) {
                    case "bow", "crossbow" -> tooltip = "tooltip." + SurvivalistEssentials.MODID + ".uselessBow1";
                    case "hoe" -> tooltip = "tooltip." + SurvivalistEssentials.MODID + ".uselessHoe1";
                    case "pickaxe" -> tooltip = "tooltip." + SurvivalistEssentials.MODID + ".uselessTool1";
                    case "axe", "darkstar", "spear", "sword", "weapon" ->
                        tooltip = "tooltip." + SurvivalistEssentials.MODID + ".uselessWeapon1";
                    default -> {
                    }
                }
            }
        }
        else if (ItemUse.isArmor(stack) && !ItemUse.isAllowedArmor(stack)) {
            tooltip = "tooltip." + SurvivalistEssentials.MODID + ".uselessArmor1";
        }

        if (!tooltip.isEmpty()) {
            message = Component.translatable(tooltip).withStyle(ChatFormatting.DARK_RED);

            tooltipComponent.add(message);
        }

    }

}
