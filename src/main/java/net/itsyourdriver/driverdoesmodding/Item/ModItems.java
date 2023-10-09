package net.itsyourdriver.driverdoesmodding.Item;

import net.itsyourdriver.driverdoesmodding.Item.custom.FuelItem;
import net.itsyourdriver.driverdoesmodding.Item.custom.metaldetectoritem;
import net.itsyourdriver.driverdoesmodding.driverdoesmodding;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, driverdoesmodding.MOD_ID);

    public static final RegistryObject<Item> dragon_scale = ITEMS.register("dragon_scale",
            () -> new Item(new Item.Properties().rarity(Rarity.EPIC)));

    public static final RegistryObject<Item> dragon_infused_crystal = ITEMS.register("dragon_infused_crystal",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));

    public static final RegistryObject<Item> empty_crystal = ITEMS.register("empty_crystal",
            () -> new Item(new Item.Properties().rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<Item> STRAWBERRY = ITEMS.register("strawberry",
            () -> new Item(new Item.Properties().food(ModFoods.STRAWBERRY)));

    public static final RegistryObject<Item> pine_cone = ITEMS.register("pine_cone",
            () -> new FuelItem(new Item.Properties(), 400));

    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new metaldetectoritem(new Item.Properties().rarity(Rarity.EPIC).durability(100)));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
