package blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import lib.ModInfo;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import rgmfroads.RGMF_ROADS;

import java.util.List;

/**
 * Created by beringtom on 29-03-14.
 */

public class Block_Road extends Block {

	public Block_Road (int id) {
		super(id, Material.rock);
		setCreativeTab(RGMF_ROADS.rgmfRoadsTab);
		setHardness(2f);
		setStepSound(Block.soundStoneFootstep);
		setUnlocalizedName(BlockInfo.BLOCK_ROAD_UNLOCALIZED_NAME);
	}

	@SideOnly(Side.CLIENT)
	private Icon dotted_stripe_side, double_stripe_middle, left_double_stripe_end, right_double_stripe_end,
				 shark_tooth, solid_stripe_corner, solid_stripe_middle, solid_stripe_side;

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister register){
		dotted_stripe_side = register.registerIcon(ModInfo.TEXTURE_LOCATION + ":" + BlockInfo.BLOCK_ROAD_TEXTURE+"dotted_stripe_side");
		double_stripe_middle = register.registerIcon(ModInfo.TEXTURE_LOCATION + ":" + BlockInfo.BLOCK_ROAD_TEXTURE+"double_stripe_middle");
		left_double_stripe_end = register.registerIcon(ModInfo.TEXTURE_LOCATION + ":" + BlockInfo.BLOCK_ROAD_TEXTURE+"left_double_stripe_end");
		right_double_stripe_end = register.registerIcon(ModInfo.TEXTURE_LOCATION + ":" + BlockInfo.BLOCK_ROAD_TEXTURE+"right_double_stripe_end");
		shark_tooth = register.registerIcon(ModInfo.TEXTURE_LOCATION + ":" + BlockInfo.BLOCK_ROAD_TEXTURE+"shark_tooth");
		solid_stripe_corner = register.registerIcon(ModInfo.TEXTURE_LOCATION + ":" + BlockInfo.BLOCK_ROAD_TEXTURE+"solid_stripe_corner");
		solid_stripe_middle = register.registerIcon(ModInfo.TEXTURE_LOCATION + ":" + BlockInfo.BLOCK_ROAD_TEXTURE+"solid_stripe_middle");
		solid_stripe_side = register.registerIcon(ModInfo.TEXTURE_LOCATION + ":" + BlockInfo.BLOCK_ROAD_TEXTURE+"solid_stripe_side");
	}

	@Override
	@SideOnly(Side.CLIENT)
	public Icon getIcon(int side, int meta)
	{
		switch(meta)
		{
			case 0:
				return solid_stripe_side;
			case 1:
				return solid_stripe_middle;
			case 2:
				return solid_stripe_corner;
			case 3:
				return shark_tooth;
			case 4:
				return right_double_stripe_end;
			case 5:
				return left_double_stripe_end;
			case 6:
				return double_stripe_middle;
			case 7:
				return dotted_stripe_side;
			default:
				return null;
		}
	}

	@Override
	public int damageDropped (int metadata) {
		return metadata;
	}

	@SideOnly(Side.CLIENT)
	public void getSubBlocks(int par1, CreativeTabs tab, List subItems)
	{
		for (int ix = 0; ix < 8; ix++) {
			subItems.add(new ItemStack(this, 1, ix));
		}
	}

	@Override
	public void onBlockAdded(World world, int x, int y, int z) {
		super.onBlockAdded(world, x, y, z);
	}
}
