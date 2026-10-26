package survivalistessentials.items.item;

import org.jetbrains.annotations.NotNull;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import survivalistessentials.items.RecipeRemainderItem;

public class Mortar extends RecipeRemainderItem {

    public Mortar(Item.Properties tabGroup) {
        super(tabGroup);
    }

    @NotNull
    @Override
    public ItemStack getRemainingItem(@NotNull ItemStack stack) {
        return stack.copy();
    }

}
