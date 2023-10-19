package net.itsyourdriver.driverdoesmodding.datagen;

import net.itsyourdriver.driverdoesmodding.Item.ModItems;
import net.itsyourdriver.driverdoesmodding.driverdoesmodding;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModItemTagGenerator extends ItemTagsProvider {
    public ModItemTagGenerator(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, driverdoesmodding.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(ItemTags.TRIMMABLE_ARMOR)// haha no trim for you >:))
                .add(ModItems.CRYSTAL_INFUSED_DRAGON_LEGGINGS.get(),
                    ModItems.CRYSTAL_INFUSED_DRAGON_BOOTS.get(), ModItems.CRYSTAL_INFUSED_DRAGON_CHESTPLATE.get(),
                    ModItems.CRYSTAL_INFUSED_DRAGON_HELMET.get());
    }
}
