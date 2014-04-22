package lib;

import blocks.blocks;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

/**
 * Created by Komoden on 05/03/14.
 */
public class Recipes {

	public static void init()
	{
		GameRegistry.addRecipe(new ItemStack(blocks.blockRoad, 1),
				new Object[]
						{
								"SSS",
								"SIS",
								"SSS",
								'S', Block.stone,
								'I', Item.dyePowder,
						});
	}
}
