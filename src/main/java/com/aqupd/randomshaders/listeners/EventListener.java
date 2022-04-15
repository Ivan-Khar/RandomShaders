package com.aqupd.randomshaders.listeners;

import static com.aqupd.randomshaders.RandomShaders.*;

import com.aqupd.randomshaders.setup.Registrations;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent.KeyInputEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EventListener {

	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onKeyPressed(KeyInputEvent event) {
		if (Registrations.keyBindings[0].isPressed()) randomShader();
		if (Registrations.keyBindings[1].isPressed()) resetShader();
	}
}
