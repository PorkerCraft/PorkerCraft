package PorkerCraft.core.blocks;

import net.minecraft.block.BlockOreStorage;
import net.minecraft.client.renderer.texture.IconRegister;

public class PigAtyliaBlock extends BlockOreStorage {

	public PigAtyliaBlock(int id) {
		super(id);
		setUnlocalizedName("pigAtyliaBlock").setHardness(5.0F).setResistance(10.0F);
	}
	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		blockIcon = par1IconRegister.registerIcon("PorkerCraft:PigAtyliaBlock");
	}

}
