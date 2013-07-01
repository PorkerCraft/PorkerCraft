package PorkerCraft.core.blocks;

import java.util.Random;

import PorkerCraft.PorkerCraft;

import net.minecraft.block.BlockOre;
import net.minecraft.client.renderer.texture.IconRegister;

public class BlockPigAtyliaOre extends BlockOre {

	public BlockPigAtyliaOre(int id) {
		super(id);
		setUnlocalizedName("pigAtyliaOre");
		setLightValue(1f/15);
	}

	@Override
	public void registerIcons(IconRegister par1IconRegister) {
		par1IconRegister.registerIcon("PorkerCraft:PigAtyliaOre");
	}

	@Override
	public int idDropped(int par1, Random par2Random, int par3) {
		return PorkerCraft.PigAtyliaGem.itemID;
	}
	@Override
	public int quantityDropped(int meta, int fortune, Random random) {
		return 1+random.nextInt((int) (1.23620987f*fortune));
	}
}
