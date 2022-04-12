package com.aqupd.snaplook;

import com.aqupd.snaplook.listeners.EventListener;
import com.aqupd.snaplook.setup.Registrations;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

@Mod(modid = SnapLook.MOD_ID, name = SnapLook.MOD_NAME, version = SnapLook.VERSION, clientSideOnly = true)
public class SnapLook {

	public static final String MOD_ID = "snaplook";
	public static final String MOD_NAME = "Snap Look";
	public static final String VERSION = "1.0";

	public static boolean toggle = false;
	private final EventListener eventListener;

	public SnapLook() {
		Registrations.init();
		this.eventListener = new EventListener();
		FMLCommonHandler.instance().bus().register(this);
	}

	@SubscribeEvent
	public void onPlayerTick(TickEvent.PlayerTickEvent event) {
		snapLook();
	}

	@Mod.EventHandler
	public void onFMLInitializationEvent(FMLInitializationEvent ev) {
		MinecraftForge.EVENT_BUS.register(eventListener);
	}

	public static void snapLook(){
		Minecraft mc = Minecraft.getMinecraft();
		if(!toggle && (Registrations.keyBindings[0].isKeyDown())) {
			mc.gameSettings.thirdPersonView = 2;
			mc.entityRenderer.loadEntityShader((Entity)null);
			mc.renderGlobal.setDisplayListEntitiesDirty();
			toggle = true;
		}
		else if(!toggle && (Registrations.keyBindings[1].isKeyDown())) {
			mc.gameSettings.thirdPersonView = 1;
			mc.entityRenderer.loadEntityShader((Entity)null);
			mc.renderGlobal.setDisplayListEntitiesDirty();
			toggle = true;
		}
		else if(toggle && !(Registrations.keyBindings[0].isKeyDown()) && !(Registrations.keyBindings[1].isKeyDown())) {
			mc.gameSettings.thirdPersonView = 0;
			mc.entityRenderer.loadEntityShader(mc.getRenderViewEntity());
			mc.renderGlobal.setDisplayListEntitiesDirty();
			toggle = false;
		}
	}
}
