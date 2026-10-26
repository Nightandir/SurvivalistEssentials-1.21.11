package survivalistessentials.event;

import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.AbstractFurnaceBlock;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import survivalistessentials.items.SurvivalistEssentialsItems;

/** Shift-right-click furnace ignition inspired by Lit It Up. */
public final class FurnaceIgnitionHandler {
    private FurnaceIgnitionHandler() {}

    public static void register() {
        UseBlockCallback.EVENT.register((player, level, hand, hit) -> {
            if (!player.isShiftKeyDown()) return InteractionResult.PASS;

            if (!(level.getBlockEntity(hit.getBlockPos())
                    instanceof AbstractFurnaceBlockEntity furnace)) {
                return InteractionResult.PASS;
            }

            ItemStack held = player.getItemInHand(hand);
            boolean primitive = held.is(SurvivalistEssentialsItems.PRIMITIVE_FIRESTARTER);
            boolean flintAndSteel = held.is(Items.FLINT_AND_STEEL);

            if (!primitive && !flintAndSteel) return InteractionResult.PASS;
            if (level.isClientSide()) return InteractionResult.SUCCESS;

            BlockPos pos = hit.getBlockPos();
            BlockState state = level.getBlockState(pos);

            if (state.getValue(AbstractFurnaceBlock.LIT)) {
                return InteractionResult.SUCCESS;
            }

            ItemStack input = furnace.getItem(0);
            ItemStack fuel = furnace.getItem(1);

            // Temporary check: both input and fuel slots must be non-empty.
            if (input.isEmpty() || fuel.isEmpty()) {
                return InteractionResult.PASS;
            }

            if (primitive && level.random.nextFloat() >= 0.60F) {
                level.playSound(
                        null, pos, SoundEvents.SCAFFOLDING_BREAK,
                        SoundSource.BLOCKS, 1.0F, 1.0F);

                player.displayClientMessage(
                        net.minecraft.network.chat.Component.translatable(
                                "message.survivalistessentials.failed_ignition"),
                        true);

                player.getCooldowns().addCooldown(held, 40);

                if (!player.isCreative()) {
                    held.shrink(1);
                }

                return InteractionResult.SUCCESS;
            }

            level.setBlock(
                    pos, state.setValue(AbstractFurnaceBlock.LIT, true), 3);

            level.playSound(
                    null, pos, SoundEvents.FLINTANDSTEEL_USE,
                    SoundSource.BLOCKS, 1.0F, 1.0F);

            if (primitive) {
                if (!player.isCreative()) {
                    held.shrink(1);
                }
            } else {
                held.hurtAndBreak(
                        1, player,
                        hand == net.minecraft.world.InteractionHand.MAIN_HAND
                                ? EquipmentSlot.MAINHAND
                                : EquipmentSlot.OFFHAND);
            }

            return InteractionResult.SUCCESS;
        });
    }
}