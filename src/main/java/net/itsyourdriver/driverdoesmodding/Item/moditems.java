package net.itsyourdriver.driverdoesmodding.Item;

import net.itsyourdriver.driverdoesmodding.driverdoesmodding;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class moditems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, driverdoesmodding.MOD_ID);

    public static final RegistryObject<Item> dragon_scale = ITEMS.register("dragon_scale",
            () -> new Item(new Item.Properties().rarity(Rarity.EPIC)));

    public static final RegistryObject<Item> dragon_crystal = ITEMS.register("dragon_crystal",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
