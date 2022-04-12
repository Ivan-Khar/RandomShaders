package com.aqupd.snaplook;

import com.aqupd.snaplook.listeners.EventListener;
import com.aqupd.snaplook.setup.Registrations;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = LeftHandedMod.MOD_ID, name = LeftHandedMod.MOD_NAME, version = LeftHandedMod.VERSION, clientSideOnly = true)
public class LeftHandedMod {

	public static final String MOD_ID = "snaplook";
	public static final String MOD_NAME = "Snap Look";
	public static final String VERSION = "1.0";

	public static boolean isLeftHand = true;

	private final EventListener eventListener;

	public LeftHandedMod() {
		Registrations.init();
		this.eventListener = new EventListener();
	}

	@Mod.EventHandler
	public void onFMLInitializationEvent(FMLInitializationEvent ev) {
		MinecraftForge.EVENT_BUS.register(eventListener);
	}

	public static void changeHands() {
		isLeftHand = !isLeftHand;
	}
}
