package survivalistessentials.world;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import survivalistessentials.world.block.LooseRockBlock;
import survivalistessentials.world.item.RockStone;

import static survivalistessentials.util.ResourceLocationHelper.prefix;

public final class SurvivalistEssentialsWorld {

    private static final Map<ResourceLocation, Item> ALL = new LinkedHashMap<>();
    public static final Map<ResourceLocation, Block> ALL_BLOCKS = new LinkedHashMap<>();

    // Blocks
    public static Block ANDESITE_LOOSE_ROCK;
    public static Block DIORITE_LOOSE_ROCK;
    public static Block GRANITE_LOOSE_ROCK;
    public static Block STONE_LOOSE_ROCK;
    public static Block SANDSTONE_LOOSE_ROCK;
    public static Block RED_SANDSTONE_LOOSE_ROCK;

    // Items
    public static Item ROCK_STONE = make(prefix("rock_stone"), new RockStone(
        new Item.Properties().setId(ResourceKey.create(Registries.ITEM, prefix("rock_stone")))
    ));

    public static void initBlocks(BiConsumer<Block, ResourceLocation> consumer) {
        ANDESITE_LOOSE_ROCK = makeBlock("andesite_loose_rock");
        DIORITE_LOOSE_ROCK = makeBlock("diorite_loose_rock");
        GRANITE_LOOSE_ROCK = makeBlock("granite_loose_rock");
        STONE_LOOSE_ROCK = makeBlock("stone_loose_rock");
        SANDSTONE_LOOSE_ROCK = makeBlock("sandstone_loose_rock");
        RED_SANDSTONE_LOOSE_ROCK = makeBlock("red_sandstone_loose_rock");

        for (Map.Entry<ResourceLocation, Block> entry : ALL_BLOCKS.entrySet()) {
            consumer.accept(entry.getValue(), entry.getKey());
        }
    }

    public static void initItems(BiConsumer<Item, ResourceLocation> consumer) {
        make("andesite_loose_rock", ANDESITE_LOOSE_ROCK);
        make("diorite_loose_rock", DIORITE_LOOSE_ROCK);
        make("granite_loose_rock", GRANITE_LOOSE_ROCK);
        make("stone_loose_rock", STONE_LOOSE_ROCK);
        make("sandstone_loose_rock", SANDSTONE_LOOSE_ROCK);
        make("red_sandstone_loose_rock", RED_SANDSTONE_LOOSE_ROCK);

        for (Map.Entry<ResourceLocation, Item> entry : ALL.entrySet()) {
            consumer.accept(entry.getValue(), entry.getKey());
        }
    }

    private static Block makeBlock(String name) {
        ResourceLocation loc = prefix(name);
        ResourceKey<Block> resourceKey = ResourceKey.create(Registries.BLOCK, loc);
        Block block = new LooseRockBlock(resourceKey);

        ALL_BLOCKS.put(loc, block);

        return block;
    }

    private static void make(String name, Block block) {
        ResourceLocation loc = prefix(name);

        make(loc, new BlockItem(block, new Item.Properties().setId(ResourceKey.create(Registries.ITEM, loc))));
    }

    private static Item make(ResourceLocation loc, Item item) {
        if (item instanceof BlockItem blockItem) {
            blockItem.registerBlocks(Item.BY_BLOCK, item);
        }

        ALL.put(loc, item);

        return item;
    }

    public static Map<ResourceLocation, Item> getAll() {
        return ALL;
    }

}
