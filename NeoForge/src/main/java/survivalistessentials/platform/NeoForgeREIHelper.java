package survivalistessentials.platform;

import me.shedaniel.rei.api.common.entry.EntryStack;
import me.shedaniel.rei.api.common.entry.type.VanillaEntryTypes;

import survivalistessentials.platform.services.IREIHelper;

public class NeoForgeREIHelper implements IREIHelper {

    @Override
    public boolean isVanillaItemType(EntryStack<?> entryStack) {
        return entryStack.getType() == VanillaEntryTypes.ITEM;
    }

}
