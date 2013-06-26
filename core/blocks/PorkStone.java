package PorkerCraft.core.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.util.Icon;
import net.minecraft.world.IBlockAccess;

public class PorkStone extends Block{

public PorkStone(int par1, Material par2Material)
{
	super(par1, par2Material);
	this.setCreativeTab(CreativeTabs.tabBlock);
}

public int idDropped(int par1, Random par2Random, int par3)
{
	return this.blockID;
}

public void registerIcons(IconRegister iconRegister)
{
    this.blockIcon = iconRegister.registerIcon("PorkerCraft:PorkStone");
}
}
