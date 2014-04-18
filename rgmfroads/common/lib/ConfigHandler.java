package lib;

import net.minecraftforge.common.Configuration;

import java.io.File;

/**
 * Created by Komoden on 25/03/14.
 */
public class ConfigHandler {

	public static void init(File file)
	{
		Configuration config = new Configuration(file);
		config.load();

		// Items

		// Blocks

		config.save();
	}
}

