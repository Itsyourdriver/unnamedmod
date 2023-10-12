package net.itsyourdriver.driverdoesmodding.Item;

import net.itsyourdriver.driverdoesmodding.Item.custom.FuelItem;
import net.itsyourdriver.driverdoesmodding.Item.custom.metaldetectoritem;
import net.itsyourdriver.driverdoesmodding.driverdoesmodding;
import net.minecraft.world.item.*;
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

    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire",
            () -> new Item(new Item.Properties().rarity(Rarity.RARE)));


    public static final RegistryObject<Item> STRAWBERRY = ITEMS.register("strawberry",
            () -> new Item(new Item.Properties().food(ModFoods.STRAWBERRY)));



    public static final RegistryObject<Item> SAPPHIRE_STAFF = ITEMS.register("sapphire_staff",
            () -> new Item(new Item.Properties().stacksTo(1).rarity(Rarity.RARE)));


    public static final RegistryObject<Item> SAPPHIRE_SWORD = ITEMS.register("sapphire_sword",
            () -> new SwordItem(ModToolTiers.SAPPHIRE, 4, 2, new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_PICKAXE = ITEMS.register("sapphire_pickaxe",
            () -> new PickaxeItem(ModToolTiers.SAPPHIRE, 1, 1, new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_AXE = ITEMS.register("sapphire_axe",
            () -> new AxeItem(ModToolTiers.SAPPHIRE, 7, 1, new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_SHOVEL = ITEMS.register("sapphire_shovel",
            () -> new ShovelItem(ModToolTiers.SAPPHIRE, 0, 0, new Item.Properties()));
    public static final RegistryObject<Item> SAPPHIRE_HOE = ITEMS.register("sapphire_hoe",
            () -> new HoeItem(ModToolTiers.SAPPHIRE, 0, 0, new Item.Properties()));





    public static final RegistryObject<Item> CRYSTAL_INFUSED_DRAGON_HELMET = ITEMS.register("crystal_infused_dragon_helmet",
            () -> new ArmorItem(ModArmorMaterials.crystal_infused_dragon, ArmorItem.Type.HELMET, new Item.Properties().rarity(Rarity.RARE)));

    public static final RegistryObject<Item> CRYSTAL_INFUSED_DRAGON_CHESTPLATE = ITEMS.register("crystal_infused_dragon_chestplate",
            () -> new ArmorItem(ModArmorMaterials.crystal_infused_dragon, ArmorItem.Type.CHESTPLATE, new Item.Properties().rarity(Rarity.RARE)));

    public static final RegistryObject<Item> CRYSTAL_INFUSED_DRAGON_LEGGINGS = ITEMS.register("crystal_infused_dragon_leggings",
            () -> new ArmorItem(ModArmorMaterials.crystal_infused_dragon, ArmorItem.Type.LEGGINGS, new Item.Properties().rarity(Rarity.RARE)));

    public static final RegistryObject<Item> CRYSTAL_INFUSED_DRAGON_BOOTS = ITEMS.register("crystal_infused_dragon_boots",
            () -> new ArmorItem(ModArmorMaterials.crystal_infused_dragon, ArmorItem.Type.BOOTS, new Item.Properties().rarity(Rarity.RARE)));









    public static final RegistryObject<Item> pine_cone = ITEMS.register("pine_cone",
            () -> new FuelItem(new Item.Properties(), 400));




    public static final RegistryObject<Item> METAL_DETECTOR = ITEMS.register("metal_detector",
            () -> new metaldetectoritem(new Item.Properties().rarity(Rarity.EPIC).durability(100)));



    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
