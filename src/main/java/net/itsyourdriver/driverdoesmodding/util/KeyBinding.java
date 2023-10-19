package net.itsyourdriver.driverdoesmodding.util;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import org.lwjgl.glfw.GLFW;

public class KeyBinding {

    public static final String KEY_CATEGORY_MOD = "key.category.driverdoesmodding.title";
    public static final String KEY_DASH = "key.driverdoesmodding.dash";
    public static final KeyMapping DASH_KEY = new KeyMapping(KEY_DASH, KeyConflictContext.IN_GAME,
            InputConstants.Type.KEYSYM, GLFW.GLFW_KEY_Z, KEY_CATEGORY_MOD);







}
