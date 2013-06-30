package PorkerCraft.core.gen;

import java.util.Random;

import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.registry.GameRegistry;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;

public class MapGenBossTempleAll implements IWorldGenerator {
	private static final float TEMPLE_PLATFORM_AREA = 26.0f * 35.0f;
	private static final float TEMPLE_VOLUME = TEMPLE_PLATFORM_AREA * 15.0f;

	private final MapGenBossTempleExterior ext;
	private final MapGenTempleStatue statue;
	private final MapGenTemplePlatform platform;

	public MapGenBossTempleAll() {
		ext = new MapGenBossTempleExterior();
		statue = new MapGenTempleStatue();
		platform = new MapGenTemplePlatform();
	}

	public boolean checkSpawn(World world, int x, int y, int z) {
		int solidBlocksInPlatform = 0, freeBlocksInSpace = 0;
		for (int i = 0; i < 26; ++i)
			for (int k = 0; k < 35; ++k) {
				// this is platform check
				if (world.getBlockId(x + i, y - 1, z + k) != 0 && !Block.blocksList[world.getBlockId(x + i, y - 1, z + k)].isBlockReplaceable(world, x + i, y - 1, z + k))
					solidBlocksInPlatform++;
				for (int j = 0; j < 15; ++j) {
					// this is space check
					if (world.isAirBlock(x + i, y + j, z + k) || Block.blocksList[world.getBlockId(x + i, y + j, z + k)].isBlockReplaceable(world, x + i, y + j, z + k))
						freeBlocksInSpace++;
				}
			}
		// To build a temple, there has to be at least 60% of solid blocks
		// underneath it
		// Plus 60% blocks in the location where the temple should be must be
		// non-solid
		return Math.round((freeBlocksInSpace / (TEMPLE_VOLUME)) * 100.0f) > 80 && Math.round((solidBlocksInPlatform / TEMPLE_PLATFORM_AREA) * 100.0f) > 60;
	}

	public void clear(World world, int x, int y, int z) {
		for (int i = 0; i < 26; ++i)
			for (int j = 0; j < 15; ++j)
				for (int k = 0; k < 35; ++k)
					world.setBlock(x + i, y + j, z + k, 0);

	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkProvider chunkGenerator, IChunkProvider chunkProvider) {
		int x = 16 * chunkX + 8;
		int z = 16 * chunkX + 8;
		int y = 64;
		if (random.nextInt(1000) < 9) {
			for (; y < 100; ++y) {
				if (checkSpawn(world, x, y, z)) {
					break;
				}
			}
			if (y == 100)
				return;
			System.out.println("Generating temple at " + x + ";" + y + ";" + z);

	    		int dumb = 70;
	    		int smart = 110;
	    		int Weasel = dumb;
	    		
	    		for(Weasel = dumb; smart < dumb; ++Weasel ){
	    			System.out.println("Weasel IQ:" + Weasel);
	    		}
	    		
	    		if(Weasel < 70){
	    			System.out.println("Dumb");
	    		}else
	    		if(Weasel > 100){
	    			System.out.println("Smart");
	    		}

			clear(world, x, y, z);
			ext.generate(world, random, x, y, z);
			statue.generate(world, random, x + 7, y + 3, z + 30);
			platform.generate(world, random, x, y, z);
		}
	}

}
