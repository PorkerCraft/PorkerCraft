package PorkerCraft.core.util;

import java.util.Random;

import PorkerCraft.core.gen.ChunkProviderPorker;
import PorkerCraft.core.gen.MapGenPigVillage;

import mod_TFmaterials.mod_TFmaterials;
import mod_TFmaterials.Blocks.BlockAmethystOre;
import mod_TFmaterials.Blocks.BlockAquamarineOre;
import mod_TFmaterials.Blocks.BlockBronzeOre;
import mod_TFmaterials.Blocks.BlockChrystalOre;
import mod_TFmaterials.Blocks.BlockCopperOre;
import mod_TFmaterials.Blocks.BlockItadtalOre;
import mod_TFmaterials.Blocks.BlockPlatinumOre;
import mod_TFmaterials.Blocks.BlockPlutoniumOre;
import mod_TFmaterials.Blocks.BlockRubyOre;
import mod_TFmaterials.Blocks.BlockSapphireOre;
import mod_TFmaterials.Blocks.BlockSilverOre;
import mod_TFmaterials.Blocks.BlockSteelOre;
import mod_TFmaterials.Blocks.BlockTinOre;
import mod_TFmaterials.Blocks.BlockUraniumOre;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import cpw.mods.fml.common.IWorldGenerator;

public class PorkerWorldGenerator implements IWorldGenerator {
	
	MapGenPigVillage mapGenVillage = new MapGenPigVillage();
	public ChunkProviderPorker getChunkProvider;
	
	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,IChunkProvider chunkGenerator, IChunkProvider chunkProvider){
		
		switch(world.provider.dimensionId){
            case 1:
                generateNether(world, random, chunkX * 16, chunkZ * 16);
            case 0:
                generateSurface(world, random, chunkX * 16, chunkZ * 16);
            case -1:
                generateEnd(world, random, chunkX * 16, chunkZ * 16); 
            case 300:
                generatePigLand(world, random, chunkX * 16, chunkZ * 16);
                break;
		}
		
	}

	private void generateEnd(World world, Random rand, int chunkX, int chunkZ) 
	{
		
	}
	
	private void generatePigLand(World world, Random rand, int chunkX, int chunkZ)
	{
		mapGenVillage.generate(this.getChunkProvider, world, chunkX, chunkZ, new byte[32768]);
	}

	private void generateSurface(World world, Random rand, int chunkX, int chunkZ) 
	{

	}
	
	public void generateNether(World world, Random random, int chunkX, int chunkZ)
	{

	}
}