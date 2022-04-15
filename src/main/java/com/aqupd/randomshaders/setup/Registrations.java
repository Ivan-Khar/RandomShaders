package com.aqupd.randomshaders.setup;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

public class Registrations {

	public static KeyBinding[] keyBindings;

	public static void init() {
		keyBindings = new KeyBinding[2];
		keyBindings[0] = new KeyBinding("key.aqupd.randomshader", Keyboard.KEY_N, "key.aqupd.categories.randomshaders");
		keyBindings[1] = new KeyBinding("key.aqupd.resetshader", Keyboard.KEY_M, "key.aqupd.categories.randomshaders");

		for (KeyBinding keyBinding : keyBindings) {
			ClientRegistry.registerKeyBinding(keyBinding);
		}
	}
}
