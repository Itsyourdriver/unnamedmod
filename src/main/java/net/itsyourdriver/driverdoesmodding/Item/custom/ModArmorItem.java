package net.itsyourdriver.driverdoesmodding.Item.custom;

import ca.weblite.objc.Client;
import com.google.common.collect.ImmutableMap;
import com.mojang.authlib.minecraft.TelemetrySession;
import net.itsyourdriver.driverdoesmodding.Item.ModArmorMaterials;
import net.itsyourdriver.driverdoesmodding.Item.ModItems;
import net.itsyourdriver.driverdoesmodding.event.ClientEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;

import java.util.Map;

public class ModArmorItem extends ArmorItem {
    private static final Map<ArmorMaterial, MobEffectInstance> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<ArmorMaterial, MobEffectInstance>())
                    .put(ModArmorMaterials.crystal_infused_dragon, new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 600, 0,
                            true,false, true)).build();


    public ModArmorItem(ArmorMaterial pMaterial, Type pType, Properties pProperties) {
        super(pMaterial, pType, pProperties);
    }

    @Override
    public void onArmorTick(ItemStack stack, Level world, Player player) {
        if(!world.isClientSide()) {
            if(hasFullSuitOfArmorOn(player)) {
                evaluateArmorEffects(player);
            }
        }
    }


    private void evaluateArmorEffects(Player player) {
        for (Map.Entry<ArmorMaterial, MobEffectInstance> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            ArmorMaterial mapArmorMaterial = entry.getKey();
            MobEffectInstance mapStatusEffect = entry.getValue();

            //if(hasCorrectArmorOn(mapArmorMaterial, player) && player.getInventory().getArmor(2).getItem() != Items.ELYTRA) {
            if(hasCorrectArmorOn(mapArmorMaterial, player)) {
                addStatusEffectForMaterial(player, mapArmorMaterial, mapStatusEffect);

           // } else if (!hasCorrectArmorOn(mapArmorMaterial, player)) {

            //} else if (hasCorrectArmorOn(mapArmorMaterial,player) != true && player.getInventory().getArmor(2).getItem() == Items.ELYTRA) {
             //   ClientEvents.canDash = true;
             //   System.out.println("Set canDash to true");
            }
              //  ClientEvents.canDash = false;
              //  System.out.println(ClientEvents.canDash);
                // else ClientEvents.canDash = false; System.out.println("Set canDash to false");
        }
    }

    private void addStatusEffectForMaterial(Player player, ArmorMaterial mapArmorMaterial,
                                            MobEffectInstance mapStatusEffect) {
        boolean hasPlayerEffect = player.hasEffect(mapStatusEffect.getEffect());

        if(hasCorrectArmorOn(mapArmorMaterial, player) && !hasPlayerEffect) {
            player.addEffect(new MobEffectInstance(mapStatusEffect));
            ClientEvents.canDash = true;
           // System.out.println(ClientEvents.canDash);
        }


    }
    private boolean hasFullSuitOfArmorOn(Player player) {
        ItemStack boots = player.getInventory().getArmor(0);
        ItemStack leggings = player.getInventory().getArmor(1);
        ItemStack breastplate = player.getInventory().getArmor(2);
        ItemStack helmet = player.getInventory().getArmor(3);

        return !helmet.isEmpty() && !breastplate.isEmpty()
                && !leggings.isEmpty() && !boots.isEmpty();
    }

    public boolean hasCorrectArmorOn(ArmorMaterial material, Player player) {
     //for (ItemStack armorStack : player.getInventory().armor) {
      //      if(!(armorStack.getItem() instanceof ArmorItem && armorStack.getItem() instanceof ElytraItem)) {
       //       return false;
      //      }
      // }

        ArmorItem boots = ((ArmorItem)player.getInventory().getArmor(0).getItem());
        ArmorItem leggings = ((ArmorItem)player.getInventory().getArmor(1).getItem());
        //ArmorItem breastplate = ((ArmorItem)player.getInventory().getArmor(2).getItem());
        Item breastplate = player.getInventory().getArmor(2).getItem();
        ArmorItem helmet = ((ArmorItem)player.getInventory().getArmor(3).getItem());

        boolean playerHasElytraCase = false;

        if (breastplate == Items.ELYTRA && breastplate != ModItems.CRYSTAL_INFUSED_DRAGON_CHESTPLATE.get()) {
        playerHasElytraCase = true;


        } else if (breastplate != Items.ELYTRA && breastplate == ModItems.CRYSTAL_INFUSED_DRAGON_CHESTPLATE.get()) {
            playerHasElytraCase = true;
            //ClientEvents.canDash = true;
        }
        else
            playerHasElytraCase = false;
           // ClientEvents.canDash = false;

        //System.out.println(playerHasElytraCase);
        if (helmet.getMaterial() != material && playerHasElytraCase != true &&
                leggings.getMaterial() != material && boots.getMaterial() != material) {
            ClientEvents.canDash = false;
        }
//breastplate == ModItems.CRYSTAL_INFUSED_DRAGON_CHESTPLATE.get() || breastplate == Items.ELYTRA
        return helmet.getMaterial() == material && playerHasElytraCase&&
                leggings.getMaterial() == material && boots.getMaterial() == material;
    }



}
