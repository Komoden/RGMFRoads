package blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import items.itemBlocks.RoadItemBlock;
import lib.Recipes;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by beringtom on 04-03-14.
 */

public class blocks {

	public static Block blockRoad;

	public static void init() {
		blockRoad = new Block_Road(BlockInfo.BLOCK_ROAD_ID);

		GameRegistry.registerBlock(blockRoad, RoadItemBlock.class, BlockInfo.BLOCK_ROAD_KEY);
	}

	public static void addNames() {
		for (int ix = 0; ix < 8; ix++) {
			//coloredStone
			ItemStack colStoneStack = new ItemStack(blockRoad, 8, ix);
			LanguageRegistry.addName(colStoneStack, BlockInfo.BLOCK_ROAD_NAMES[colStoneStack.getItemDamage()]);
		}
	}

	public static void registerTileEntities()
	{

	}
}
