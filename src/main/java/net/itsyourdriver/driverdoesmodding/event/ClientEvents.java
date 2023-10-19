package net.itsyourdriver.driverdoesmodding.event;

import com.google.common.collect.ImmutableMap;
import net.itsyourdriver.driverdoesmodding.Item.ModArmorMaterials;
import net.itsyourdriver.driverdoesmodding.Item.ModItems;
import net.itsyourdriver.driverdoesmodding.Item.custom.ModArmorItem;
import net.itsyourdriver.driverdoesmodding.driverdoesmodding;
import net.itsyourdriver.driverdoesmodding.util.KeyBinding;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;



public class ClientEvents{


    public static boolean canDash = false;



    @Mod.EventBusSubscriber(modid = driverdoesmodding.MOD_ID, value = Dist.CLIENT)
    public static class ClientForgeEvents {


        static int cooldown = 0;


        @SubscribeEvent
        public static void onKeyInput(InputEvent.Key event) {

            //byte cooldown = 0;
            Minecraft mc = Minecraft.getInstance();
            Player player = mc.player;
//&& canDash == true
            if (KeyBinding.DASH_KEY.consumeClick() && cooldown <= 0 && player.onGround() == true) {

                Minecraft.getInstance().player.sendSystemMessage(Component.literal("Pressed a Key!"));
                Vec3 playerLook = player.getLookAngle();
                Vec3 dashVec = new Vec3(playerLook.x(), playerLook.y(), playerLook.z()); //new Vec3(playerLook.x(), playerLook.y(), playerLook.z());
                player.setDeltaMovement(dashVec);
                cooldown = 40;
                //System.out.println(canDash);
            }
        }

        @SubscribeEvent
        public static void onTick(TickEvent.PlayerTickEvent event)
        {
            if (cooldown > 0 && event.phase.equals(TickEvent.Phase.START) && event.side.isClient() && event.player.equals(Minecraft.getInstance().player))
                --cooldown;
        }

    }

    @Mod.EventBusSubscriber(modid = driverdoesmodding.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModBusEvents {
        @SubscribeEvent
        public static void onKeyRegister(RegisterKeyMappingsEvent event) {
            event.register(KeyBinding.DASH_KEY);
        }
    }
}
