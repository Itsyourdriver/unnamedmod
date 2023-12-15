package net.itsyourdriver.driverdoesmodding.datagen;

import net.itsyourdriver.driverdoesmodding.Item.ModItems;
import net.itsyourdriver.driverdoesmodding.block.ModBlocks;
import net.itsyourdriver.driverdoesmodding.driverdoesmodding;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.armortrim.TrimPattern;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import com.mojang.logging.LogUtils;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

import java.util.List;
import java.util.function.Consumer;


public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {

    private static final Logger LOGGER = LogUtils.getLogger();
    private static final List<ItemLike> SAPPHIRE_SMELTABLES = List.of(ModItems.empty_crystal.get());


    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {
        LOGGER.info("we did some stuff with packoutput and all that");
       // oreSmelting(pWriter, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.dragon_infused_crystal.get(), 0.25f, 500, "sapphire");
      //  oreBlasting(pWriter, SAPPHIRE_SMELTABLES, RecipeCategory.MISC, ModItems.dragon_infused_crystal.get(), 0.25f, 370, "sapphire");
        dragonSmithing(pWriter,Items.NETHERITE_CHESTPLATE, RecipeCategory.MISC, ModItems.CRYSTAL_INFUSED_DRAGON_CHESTPLATE.get());
        dragonSmithing(pWriter,Items.NETHERITE_LEGGINGS, RecipeCategory.MISC, ModItems.CRYSTAL_INFUSED_DRAGON_LEGGINGS.get());
        dragonSmithing(pWriter,Items.NETHERITE_HELMET, RecipeCategory.MISC, ModItems.CRYSTAL_INFUSED_DRAGON_HELMET.get());
        dragonSmithing(pWriter,Items.NETHERITE_BOOTS, RecipeCategory.MISC, ModItems.CRYSTAL_INFUSED_DRAGON_BOOTS.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.test_block.get())
                .pattern("SSS")
                .pattern("SSS")
                .pattern("SSS")
                .define('S', ModItems.SAPPHIRE.get())
                .unlockedBy(getHasName(ModItems.SAPPHIRE.get()), has(ModItems.SAPPHIRE.get()))
                .save(pWriter);



        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.dragon_infused_crystal.get(), 1)
                .pattern(" F ")
                .pattern("FEF")
                .pattern(" F ")
                .define('E', ModItems.empty_crystal.get())
                .define('F', Items.DRAGON_BREATH)
                .unlockedBy(getHasName(ModItems.empty_crystal.get()), has(Items.DRAGON_BREATH))
                .save(pWriter);




        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.crystal_infused_dragon_upgrade_smithing_template.get(), 2)
                .pattern("FDF")
                .pattern("FEF")
                .pattern(" F ")
                .define('D', ModItems.crystal_infused_dragon_upgrade_smithing_template.get())
                .define('E', ModItems.empty_crystal.get())
                .define('F', Items.DIAMOND)
                .unlockedBy(getHasName(ModItems.dragon_scale.get()), has(ModItems.empty_crystal.get()))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.dragon_ingot.get(), 1)
                .pattern(" F ")
                .pattern(" E ")
                .pattern(" F ")
                .define('E', ModItems.dragon_infused_crystal.get())
                .define('F', ModItems.dragon_scale.get())
                .unlockedBy(getHasName(ModItems.dragon_scale.get()), has(ModItems.dragon_infused_crystal.get()))
                .save(pWriter);



        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.SAPPHIRE.get(), 9)
                .requires(ModBlocks.test_block.get())
                .unlockedBy(getHasName(ModBlocks.test_block.get()), has(ModBlocks.test_block.get()))
                .save(pWriter);




    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void dragonSmithing(Consumer<FinishedRecipe> pFinishedRecipeConsumer, Item pIngredientItem, RecipeCategory pCategory, Item pResultItem) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(ModItems.crystal_infused_dragon_upgrade_smithing_template.get()), Ingredient.of(pIngredientItem), Ingredient.of(ModItems.dragon_ingot.get()), pCategory, pResultItem).unlocks("has_dragon_infused_crystal", has(ModItems.dragon_ingot.get())).save(pFinishedRecipeConsumer, getItemName(pResultItem) + "_smithing");
    }
    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult, pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult,
                            pExperience, pCookingTime, pCookingSerializer)
                    .group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer,  driverdoesmodding.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}