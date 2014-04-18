package rgmfroads;

import cpw.mods.fml.common.Loader;
import lib.ConfigHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.LanguageRegistry;
import lib.*;
import blocks.blocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.network.ForgePacketHandler;

import java.util.logging.Level;

@Mod(modid = ModInfo.MOD_ID, name = ModInfo.MOD_NAME, version = ModInfo.MOD_VERSION)
@NetworkMod(channels = {ModInfo.NETWORK_CHANNEL}, clientSideRequired = true, serverSideRequired = false, packetHandler = ForgePacketHandler.class)
public class RGMF_ROADS
{
	public static boolean isRGMFLoaded;

	@Instance(ModInfo.MOD_ID)
	public static RGMF_ROADS instance;

	@SidedProxy(clientSide = "lib.ClientProxy", serverSide = "lib.CommonProxy")
	public static CommonProxy proxy;

	public static CreativeTabs rgmfRoadsTab = new RGMFRoadsTab(CreativeTabs.getNextID(), ModInfo.MOD_NAME);

	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		LogHelper.log(Level.INFO, "Setting up camp, Rød grød med?");
		isRGMFLoaded = Loader.isModLoaded("RGMF");
		if (isRGMFLoaded) {
			LogHelper.log(Level.INFO, "RGMF: Fløde!");
		}else{
			LogHelper.log(Level.INFO, "RGMF: What?");
		}
		proxy.initSounds();
		proxy.initRenderers();
		LogHelper.init();
		ConfigHandler.init(event.getSuggestedConfigurationFile());
		blocks.init();
	}

	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		LogHelper.log(Level.INFO, "Lighting the fire");
		LanguageRegistry.instance().addStringLocalization("itemGroup." + ModInfo.MOD_NAME, "en_US", ModInfo.MOD_NAME);
		LanguageRegistry.instance().addStringLocalization("itemGroup.rgmfRoadsTab", "en_US", "RGMF Roads");
		blocks.registerTileEntities();
		blocks.addNames();
		Recipes.init();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		LogHelper.log(Level.INFO, "Roasting Marshmallows");
	}
}
