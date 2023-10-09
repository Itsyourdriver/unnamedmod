package net.itsyourdriver.driverdoesmodding.datagen;

import com.mojang.logging.LogUtils;
import net.itsyourdriver.driverdoesmodding.driverdoesmodding;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.slf4j.Logger;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = driverdoesmodding.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    private static final Logger LOGGER = LogUtils.getLogger();
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        System.out.println("hello from debug");
        LOGGER.info("hi how are ya");
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        LOGGER.info("we did some stuff with packoutput and all that");
        System.out.println("got generator, packoutput, exfilehelper, and holderlookup");
        generator.addProvider(event.includeServer(), new ModRecipeProvider(packOutput));
        generator.addProvider(event.includeServer(), ModLootTableProvider.create(packOutput));
        System.out.println("modrecipeprovider done");
        generator.addProvider(event.includeClient(), new ModBlockStateProvider(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new ModItemModelProvider(packOutput, existingFileHelper));
        System.out.println("block states and item models done");
        ModBlockTagGenerator blockTagGenerator = generator.addProvider(event.includeServer(),
                new ModBlockTagGenerator(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new ModItemTagGenerator(packOutput, lookupProvider, blockTagGenerator.contentsGetter(), existingFileHelper));
        System.out.println("more stuff done");
    }
}
