package net.itsyourdriver.driverdoesmodding.datagen;

import net.itsyourdriver.driverdoesmodding.Item.ModItems;
import net.itsyourdriver.driverdoesmodding.block.ModBlocks;
import net.itsyourdriver.driverdoesmodding.driverdoesmodding;
import net.itsyourdriver.driverdoesmodding.loot.AddItemModifier;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemEntityPropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

public class ModGlobalLootModifiersProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifiersProvider(PackOutput output) {
        super(output, driverdoesmodding.MOD_ID);
    }

    @Override
    protected void start() {
    add("dragon_scale_from_ender_dragon", new AddItemModifier(new LootItemCondition[]{
          //  LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.GRASS_BLOCK).build(), - for block drops!
            //LootItemRandomChanceCondition.randomChance(0.35f).build()

            new LootTableIdCondition.Builder(new ResourceLocation("entities/ender_dragon")).build()
    }, ModItems.dragon_scale.get()));




        add("empty_crystal_from_end_city_treasure", new AddItemModifier(new LootItemCondition[] {

                LootItemRandomChanceCondition.randomChance(0.4f).build(),
                new LootTableIdCondition.Builder(new ResourceLocation("chests/end_city_treasure")).build() }, ModItems.empty_crystal.get()));


    }
}
