package net.itsyourdriver.driverdoesmodding.Item;

import net.itsyourdriver.driverdoesmodding.driverdoesmodding;

import net.itsyourdriver.driverdoesmodding.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, driverdoesmodding.MOD_ID);


    public static final RegistryObject<CreativeModeTab> ITSYOURDRIVER = CREATIVE_MODE_TABS.register("itsyourdriver",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.dragon_infused_crystal.get()))
                    .title(Component.translatable("creativetab.itsyourdriver"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.dragon_scale.get());
                        pOutput.accept(ModItems.dragon_infused_crystal.get());
                        pOutput.accept(ModItems.empty_crystal.get());
                        pOutput.accept(ModItems.METAL_DETECTOR.get());

                        pOutput.accept(ModItems.STRAWBERRY.get());
                        pOutput.accept(ModItems.pine_cone.get());


                        pOutput.accept(ModItems.SAPPHIRE_STAFF.get());


                        pOutput.accept(ModBlocks.test_block.get());
                        pOutput.accept(ModBlocks.SOUND_BLOCK.get());


                        pOutput.accept(ModItems.SAPPHIRE_SWORD.get());
                        pOutput.accept(ModItems.SAPPHIRE_PICKAXE.get());
                        pOutput.accept(ModItems.SAPPHIRE_AXE.get());
                        pOutput.accept(ModItems.SAPPHIRE_SHOVEL.get());
                        pOutput.accept(ModItems.SAPPHIRE_HOE.get());


                        pOutput.accept(ModItems.CRYSTAL_INFUSED_DRAGON_CHESTPLATE.get());
                        pOutput.accept(ModItems.CRYSTAL_INFUSED_DRAGON_BOOTS.get());
                        pOutput.accept(ModItems.CRYSTAL_INFUSED_DRAGON_LEGGINGS.get());
                        pOutput.accept(ModItems.CRYSTAL_INFUSED_DRAGON_HELMET.get());


                        pOutput.accept(ModBlocks.SAPPHIRE_STAIRS.get());
                        pOutput.accept(ModBlocks.SAPPHIRE_SLAB.get());
                        pOutput.accept(ModBlocks.SAPPHIRE_BUTTON.get());
                        pOutput.accept(ModBlocks.SAPPHIRE_PRESSURE_PLATE.get());

                        pOutput.accept(ModBlocks.SAPPHIRE_FENCE.get());
                        pOutput.accept(ModBlocks.SAPPHIRE_FENCE_GATE.get());
                        pOutput.accept(ModBlocks.SAPPHIRE_WALL.get());

                        pOutput.accept(ModBlocks.SAPPHIRE_DOOR.get());
                        pOutput.accept(ModBlocks.SAPPHIRE_TRAPDOOR.get());

                    })
                    .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
