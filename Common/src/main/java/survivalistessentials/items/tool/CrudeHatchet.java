package survivalistessentials.items.tool;

import org.jetbrains.annotations.NotNull;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;

import survivalistessentials.items.RecipeRemainderAxeItem;

public class CrudeHatchet extends RecipeRemainderAxeItem {

    public CrudeHatchet(ToolMaterial toolMaterial, float attackDamage, float attackSpeed, Properties properties) {
        super(toolMaterial, attackDamage, attackSpeed, properties);
    }

    @NotNull
    @Override
    public ItemStack getRemainingItem(@NotNull ItemStack stack) {
        ItemStack container = stack.copy();

        container.setDamageValue(container.getDamageValue() + 1);

        if (container.getDamageValue() < container.getMaxDamage()) {
            return container;
        }
        else {
            stack.shrink(1);

            return ItemStack.EMPTY;
        }
    }

}
