package PorkerCraft.core.gen;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class MapGenTemplePlatform extends WorldGenerator {

	@Override
	public boolean generate(World world, Random random, int i, int j, int k) {
		for (int x = i; x < i + 27; x++) {
			for (int z = k; z < k + 35; ++z) {
				for (int y = j-1; y > j - 5; --y) {
					if (world.getBlockId(x, y, z) == 0 || Block.blocksList[world.getBlockId(x, y, z)].isBlockReplaceable(world, x, y, z))
						world.setBlock(x, y, z, Block.cobblestone.blockID);
				}
			}
		}
		return true;
	}
}
