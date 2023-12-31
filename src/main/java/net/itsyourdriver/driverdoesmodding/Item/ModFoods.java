package net.itsyourdriver.driverdoesmodding.Item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.PotionItem;

public class ModFoods {
    public static final FoodProperties STRAWBERRY = new FoodProperties.Builder().nutrition(2).fast()
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 200), 0.1f).build();
    public static final FoodProperties CHORUS_BERRY = new FoodProperties.Builder().nutrition(2)
            .saturationMod(0.2f).effect(() -> new MobEffectInstance(MobEffects.LEVITATION, 200), 0.5f).build();
}