package net.itsyourdriver.driverdoesmodding.Item;

import net.itsyourdriver.driverdoesmodding.driverdoesmodding;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class moditems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, driverdoesmodding.MOD_ID);

    public static final RegistryObject<Item> test_item = ITEMS.register("test_item",
            () -> new Item(new Item.Properties()));
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
