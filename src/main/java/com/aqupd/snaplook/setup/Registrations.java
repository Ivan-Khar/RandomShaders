package com.aqupd.snaplook.setup;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import org.lwjgl.input.Keyboard;

public class Registrations {

	public static KeyBinding[] keyBindings;

	public static void init() {

		keyBindings = new KeyBinding[2];
		keyBindings[0] = new KeyBinding("key.aqupd.snapforward", Keyboard.KEY_F, "key.aqupd.categories.snaplook");
		keyBindings[1] = new KeyBinding("key.aqupd.snapbackwards", Keyboard.KEY_G, "key.aqupd.categories.snaplook");

		for (KeyBinding keyBinding : keyBindings) {
			ClientRegistry.registerKeyBinding(keyBinding);
		}
	}
}
