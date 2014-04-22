package items.itemBlocks;

import blocks.BlockInfo;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

/**
 * Created by Komoden on 03/04/14.
 */
public class RoadItemBlock extends ItemBlock
{
	public RoadItemBlock(int id) {
		super(id);
		setHasSubtypes(true);
	}

	@Override
	public int getMetadata (int damageValue) {
		return damageValue;
	}

	@Override
	public String getUnlocalizedName(ItemStack itemstack) {
		return getUnlocalizedName() + "." + BlockInfo.ROAD_SUBNAMES[itemstack.getItemDamage()];
	}
}
