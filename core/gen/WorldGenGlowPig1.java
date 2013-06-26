package PorkerCraft.core.gen;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import PorkerCraft.*;

public class WorldGenGlowPig1 extends WorldGenerator implements IWorldGenerator
{
    /** The ID of the plant block used in this plant generator. */
    private int plantBlockId;

    public WorldGenGlowPig1(int par1)
    {
        this.plantBlockId = par1;
    }

    public boolean generate(World par1World, Random par2Random, int par3, int par4, int par5)
    {
        for (int l = 0; l < 128; ++l)
        {
            int i1 = par3 + par2Random.nextInt(16) - par2Random.nextInt(16);
            int k1 = par5 + par2Random.nextInt(16) - par2Random.nextInt(16);

            if (par1World.isAirBlock(i1, par4 + 1, k1) && (!par1World.provider.hasNoSky || par4 + 1 < 127) && Block.blocksList[this.plantBlockId].canBlockStay(par1World, i1, par4 + 1, k1) && par1World.getBlockId(i1, par4, k1)== PorkerCraft.PorkGrass.blockID )
            {
                par1World.setBlock(i1, par4 + 1, k1, this.plantBlockId, 0, 2);
            }
        }

        return true;
    }

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world,
			IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		// TODO Auto-generated method stub
		
	}
}
