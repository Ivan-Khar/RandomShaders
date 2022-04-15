package com.aqupd.randomshaders.util;

import com.google.gson.Gson;

import java.io.*;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static com.aqupd.randomshaders.RandomShaders.LOGGER;
import static com.aqupd.randomshaders.RandomShaders.logprefix;

public class Configuration {

	private static final Gson gson = new Gson();
	private static final ParameterizedType typeListString = new ParameterizedType() {
		public Type[] getActualTypeArguments()
		{
			return new Type[] {String.class};
		}
		public Type getRawType()
		{
			return List.class;
		}
		public Type getOwnerType()
		{
			return null;
		}
	};

	public static List<String> shaders = gson.fromJson("[\"shaders/post/antialias.json\",\"shaders/post/art.json\",\"shaders/post/bits.json\",\"shaders/post/blobs.json\",\"shaders/post/blobs2.json\",\"shaders/post/blur.json\",\"shaders/post/bumpy.json\",\"shaders/post/color_convolve.json\",\"shaders/post/creeper.json\",\"shaders/post/deconverge.json\",\"shaders/post/desaturate.json\",\"shaders/post/entity_outline.json\",\"shaders/post/flip.json\",\"shaders/post/fxaa.json\",\"shaders/post/green.json\",\"shaders/post/invert.json\",\"shaders/post/notch.json\",\"shaders/post/ntsc.json\",\"shaders/post/outline.json\",\"shaders/post/pencil.json\",\"shaders/post/phosphor.json\",\"shaders/post/scan_pincushion.json\",\"shaders/post/sobel.json\",\"shaders/post/spider.json\",\"shaders/post/wobble.json\"]", typeListString);

	private static final File configFile = new File("./config/AqMods/RandomShaders.properties");

	public static void loadOptions() throws IOException {

		if (!configFile.exists() || configFile.length() == 0) saveOptions();
		BufferedReader bufferedreader = new BufferedReader(new FileReader(configFile));

		String s;
		while ((s = bufferedreader.readLine()) != null) {
			String[] astring = s.split(":");

			if (astring[0].equals("Shaders")) shaders = gson.fromJson(s.substring(s.indexOf(58) + 1), typeListString);
		}
	}

	public static void saveOptions() {
		try {
			Files.createDirectories(Paths.get("./config/AqMods/"));

			if (!configFile.exists()) configFile.createNewFile();
			if (configFile.exists()) {
				PrintWriter printwriter = new PrintWriter(new FileWriter(configFile));
				printwriter.println("Shaders:" + gson.toJson(Configuration.shaders));
				printwriter.close();
			}
		} catch (Exception exception) {
			LOGGER.error(logprefix + "Failed to save options", exception);
		}
	}
}
