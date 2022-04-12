package com.aqupd.snaplook.listeners;

import com.aqupd.snaplook.setup.Registrations;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.aqupd.snaplook.SnapLook.snapLook;

public class EventListener {

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onKeyPressed(KeyInputEvent event) {
		if (Registrations.keyBindings[0].isPressed()) snapLook();
		if (Registrations.keyBindings[1].isPressed()) snapLook();
	}
}
