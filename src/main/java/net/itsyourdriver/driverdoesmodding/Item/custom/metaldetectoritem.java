package net.itsyourdriver.driverdoesmodding.Item.custom;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ClickAction;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class metaldetectoritem extends Item {
    public metaldetectoritem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().isClientSide()) {
        BlockPos positionClicked = pContext.getClickedPos();
        Player player = pContext.getPlayer();
        boolean foundBlock = false;

        for(int i = 0; i <= positionClicked.getY() + 64; i++) {
            BlockState state = pContext.getLevel().getBlockState(positionClicked.below(i));

            if (isValubleBlock(state)){
            outputValueBleCoordinate(positionClicked.below(i), player, state.getBlock());
            foundBlock = true;


            break;
            }

        }
        if(!foundBlock){
            player.sendSystemMessage(Component.literal("No valuables Found!"));
        }


        }

        pContext.getItemInHand().hurtAndBreak(1, pContext.getPlayer(),
                player -> player.broadcastBreakEvent(player.getUsedItemHand()));

        return InteractionResult.SUCCESS;
    }

    private void outputValueBleCoordinate(BlockPos blockPos, Player player, Block block) {
        player.sendSystemMessage(Component.literal("Found " + I18n.get(block.getDescriptionId()) + " at " +
                "(" + blockPos.getX() + ", " + blockPos.getY() + "," + blockPos.getZ() + ")"));
    }

    private boolean isValubleBlock(BlockState state) {
        return state.is(Blocks.IRON_ORE) || state.is(Blocks.GOLD_ORE);
    }
}
