package PorkerCraft.core.blocks;

import java.util.List;
import java.util.Random;

import PorkerCraft.PorkerCraft;
import PorkerCraft.core.gen.WorldGenPorkTree;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenBigTree;
import net.minecraft.world.gen.feature.WorldGenForest;
import net.minecraft.world.gen.feature.WorldGenHugeTrees;
import net.minecraft.world.gen.feature.WorldGenTaiga2;
import net.minecraft.world.gen.feature.WorldGenTrees;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.event.terraingen.TerrainGen;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockPorkTreeSapling extends BlockFlower
{
/** change the name to your sapling name **/
public static final String[] WOOD_TYPES = new String[] {"Pork"};
public BlockPorkTreeSapling(int i, int j, Material par2Material)
{
super(i, par2Material);
float var3 = 0.4F;
this.setBlockBounds(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, var3 * 2.0F, 0.5F + var3);
this.setCreativeTab(CreativeTabs.tabDecorations);
}
/**
* Ticks the block if it's been scheduled
*/
public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
{
if (!par1World.isRemote)
{
super.updateTick(par1World, par2, par3, par4, par5Random);
if (par1World.getBlockLightValue(par2, par3 + 1, par4) >= 9 && par5Random.nextInt(7) == 0)
{
this.func_96477_c(par1World, par2, par3, par4, par5Random);
}
}
}
public void func_96477_c(World par1World, int par2, int par3, int par4, Random par5Random)
{
int l = par1World.getBlockMetadata(par2, par3, par4);
/** change this block to your custom grass block **/
if ((l & 8) == PorkerCraft.PorkGrass.blockID)
{
par1World.setBlockMetadataWithNotify(par2, par3, par4, l | 8, 4);
}
else
{
this.growTree(par1World, par2, par3, par4, par5Random);
}
}
/**
* Attempts to grow a sapling into a tree
*/
public void growTree(World par1World, int par2, int par3, int par4, Random par5Random)
{
if (!TerrainGen.saplingGrowTree(par1World, par5Random, par2, par3, par4)) return;
int l = par1World.getBlockMetadata(par2, par3, par4) & 3;
Object object = null;
int i1 = 0;
int j1 = 0;
boolean flag = false;
if (l == 1)
{
object = new WorldGenTaiga2(true);
}
else if (l == 2)
{
object = new WorldGenForest(true);
}
else if (l == 3)
{
for (i1 = 0; i1 >= -1; --i1)
{
for (j1 = 0; j1 >= -1; --j1)
{
if (this.isSameSapling(par1World, par2 + i1, par3, par4 + j1, 3) && this.isSameSapling(par1World, par2 + i1 + 1, par3, par4 + j1, 3) && this.isSameSapling(par1World, par2 + i1, par3, par4 + j1 + 1, 3) && this.isSameSapling(par1World, par2 + i1 + 1, par3, par4 + j1 + 1, 3))
{
/** Change this to your WorldGenNAMETree **/
object = new WorldGenPorkTree(true, 10 + par5Random.nextInt(20), 3, 3, false);
flag = true;
break;
}
}
if (object != null)
{
break;
}
}
if (object == null)
{
j1 = 0;
i1 = 0;
/** Change this to your WorldGenNAMETree **/
object = new WorldGenPorkTree(true, 4 + par5Random.nextInt(7), 3, 3, false);
}
}
else
{
/** Change this to your WorldGenNAMETree **/
object = new WorldGenPorkTree(true); // Changed //
if (par5Random.nextInt(10) == 0)
{
object = new WorldGenPorkTree(true);
}
}
if (flag)
{
par1World.setBlock(par2 + i1, par3, par4 + j1, 0, 0, 4);
par1World.setBlock(par2 + i1 + 1, par3, par4 + j1, 0, 0, 4);
par1World.setBlock(par2 + i1, par3, par4 + j1 + 1, 0, 0, 4);
par1World.setBlock(par2 + i1 + 1, par3, par4 + j1 + 1, 0, 0, 4);
}
else
{
par1World.setBlock(par2, par3, par4, 0, 0, 4);
}
if (!((WorldGenerator)object).generate(par1World, par5Random, par2 + i1, par3, par4 + j1))
{
if (flag)
{
par1World.setBlock(par2 + i1, par3, par4 + j1, this.blockID, l, 4);
par1World.setBlock(par2 + i1 + 1, par3, par4 + j1, this.blockID, l, 4);
par1World.setBlock(par2 + i1, par3, par4 + j1 + 1, this.blockID, l, 4);
par1World.setBlock(par2 + i1 + 1, par3, par4 + j1 + 1, this.blockID, l, 4);
}
else
{
par1World.setBlock(par2, par3, par4, this.blockID, l, 4);
}
}
}
/**
* Determines if the same sapling is present at the given location.
*/
public boolean isSameSapling(World par1World, int par2, int par3, int par4, int par5)
{
return par1World.getBlockId(par2, par3, par4) == this.blockID && (par1World.getBlockMetadata(par2, par3, par4) & 3) == par5;
}
/**
* Gets passed in the blockID of the block below and supposed to return true if its allowed to grow on the type of
* blockID passed in. Args: blockID
*/
@Override
protected boolean canThisPlantGrowOnThisBlockID(int par1)
{
/** Change this to your custom grass **/
return par1 == PorkerCraft.PorkGrass.blockID || par1 == Block.dirt.blockID;
}
}