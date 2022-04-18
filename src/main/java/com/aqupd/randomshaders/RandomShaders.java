package com.aqupd.randomshaders;

import static com.aqupd.randomshaders.util.Configuration.*;

import com.aqupd.randomshaders.listeners.EventListener;
import com.aqupd.randomshaders.setup.Registrations;
import java.io.IOException;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = RandomShaders.MOD_ID, name = RandomShaders.MOD_NAME, version = RandomShaders.VERSION, clientSideOnly = true)
public class RandomShaders {

	public static final String MOD_ID = "randomshaders";
	public static final String MOD_NAME = "Random Shaders";
	public static final String VERSION = "1.1";
	public static final Logger LOGGER = LogManager.getLogger();
	public static final String logprefix = "[AqUpd's " + MOD_NAME + "] ";

	private final EventListener eventListener;
	private static final Minecraft mc = Minecraft.getMinecraft();

	public RandomShaders() throws IOException {
		Registrations.init();
		loadOptions();
		saveOptions();
		this.eventListener = new EventListener();
		FMLCommonHandler.instance().bus().register(this);
	}

	@Mod.EventHandler
	public void onFMLInitializationEvent(FMLInitializationEvent ev) {
		MinecraftForge.EVENT_BUS.register(eventListener);
	}

	public static void randomShader() {
		int i = (int) (Math.random() * shaders.size());
		mc.entityRenderer.loadShader(new ResourceLocation(shaders.get(i)));
		if (msgchat) mc.ingameGUI.getChatGUI().printChatMessage(new ChatComponentText("§r§f§lShader \"" + shaders.get(i) + "\" applied"));
		if (msgaction) mc.ingameGUI.setRecordPlaying(new ChatComponentText("§r§f§lShader \"" + shaders.get(i) + "\" applied"), false);
	}

	public static void resetShader() {
		if (mc.gameSettings.thirdPersonView == 0) {
			mc.entityRenderer.loadEntityShader(mc.getRenderViewEntity());
		} else if (mc.gameSettings.thirdPersonView >= 1) {
			mc.entityRenderer.loadEntityShader(null);
		}
	}
}
