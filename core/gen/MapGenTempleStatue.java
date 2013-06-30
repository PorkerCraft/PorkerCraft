package PorkerCraft.core.gen;

/*
 *** MADE BY MITHION'S .SCHEMATIC TO JAVA CONVERTING TOOL v1.6 + Tomsik68 ***
 */

import java.util.Random;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityChest;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class MapGenTempleStatue extends WorldGenerator {
	public boolean generate(World world, Random rand, int i, int j, int k) {
		world.setBlock(i + 0, j + 4, k + 0, 35, 6, 3);
		world.setBlock(i + 0, j + 5, k + 0, 35, 6, 3);
		world.setBlock(i + 0, j + 6, k + 0, 35, 6, 3);
		world.setBlock(i + 1, j + 7, k + 0, 35, 6, 3);
		world.setBlock(i + 2, j + 2, k + 0, 35, 6, 3);
		world.setBlock(i + 2, j + 3, k + 0, 35, 6, 3);
		world.setBlock(i + 2, j + 4, k + 0, 35, 6, 3);
		world.setBlock(i + 2, j + 5, k + 0, 35, 6, 3);
		world.setBlock(i + 2, j + 6, k + 0, 35, 6, 3);
		world.setBlock(i + 2, j + 7, k + 0, 35, 6, 3);
		world.setBlock(i + 3, j + 0, k + 0, 35, 12, 3);
		world.setBlock(i + 3, j + 1, k + 0, 35, 6, 3);
		world.setBlock(i + 3, j + 2, k + 0, 35, 6, 3);
		world.setBlock(i + 3, j + 3, k + 0, 35, 6, 3);
		world.setBlock(i + 3, j + 4, k + 0, 35, 6, 3);
		world.setBlock(i + 3, j + 5, k + 0, 35, 6, 3);
		world.setBlock(i + 3, j + 6, k + 0, 35, 6, 3);
		world.setBlock(i + 3, j + 7, k + 0, 35, 6, 3);
		world.setBlock(i + 3, j + 9, k + 0, 35, 6, 3);
		world.setBlock(i + 3, j + 10, k + 0, 35, 6, 3);
		world.setBlock(i + 4, j + 2, k + 0, 35, 6, 3);
		world.setBlock(i + 4, j + 3, k + 0, 35, 6, 3);
		world.setBlock(i + 4, j + 4, k + 0, 35, 6, 3);
		world.setBlock(i + 4, j + 5, k + 0, 35, 6, 3);
		world.setBlock(i + 4, j + 6, k + 0, 35, 6, 3);
		world.setBlock(i + 4, j + 7, k + 0, 35, 6, 3);
		world.setBlock(i + 4, j + 8, k + 0, 35, 6, 3);
		world.setBlock(i + 4, j + 9, k + 0, 35, 6, 3);
		world.setBlock(i + 4, j + 10, k + 0, 41, 0, 4);
		world.setBlock(i + 4, j + 11, k + 0, 35, 6, 3);
		world.setBlock(i + 5, j + 2, k + 0, 35, 6, 3);
		world.setBlock(i + 5, j + 3, k + 0, 35, 6, 3);
		world.setBlock(i + 5, j + 4, k + 0, 35, 6, 3);
		world.setBlock(i + 5, j + 5, k + 0, 35, 6, 3);
		world.setBlock(i + 5, j + 6, k + 0, 35, 6, 3);
		world.setBlock(i + 5, j + 7, k + 0, 35, 6, 3);
		world.setBlock(i + 5, j + 8, k + 0, 35, 6, 3);
		
		world.setBlock(i + 5, j + 9, k + 0, 54, 0, 3);
		
		TileEntityChest chest = (TileEntityChest)world.getBlockTileEntity(i + 5, j + 9, k + 0);
		addLoot(chest);
		//world.setBlockTileEntity(i + 5, j + 9, k + 0, chest);
		
		world.setBlock(i + 5, j + 9, k - 1, 35, 6, 3);
		world.setBlock(i + 5, j + 10, k + 0, 35, 6, 3);
		world.setBlock(i + 5, j + 11, k + 0, 35, 6, 3);
		world.setBlock(i + 6, j + 2, k + 0, 35, 6, 3);
		world.setBlock(i + 6, j + 3, k + 0, 35, 6, 3);
		world.setBlock(i + 6, j + 4, k + 0, 35, 6, 3);
		world.setBlock(i + 6, j + 5, k + 0, 35, 6, 3);
		world.setBlock(i + 6, j + 6, k + 0, 35, 6, 3);
		world.setBlock(i + 6, j + 7, k + 0, 35, 6, 3);
		world.setBlock(i + 6, j + 8, k + 0, 35, 6, 3);
		world.setBlock(i + 6, j + 9, k + 0, 35, 6, 3);
		world.setBlock(i + 6, j + 10, k + 0, 41, 0, 4);
		world.setBlock(i + 6, j + 11, k + 0, 35, 6, 3);
		world.setBlock(i + 7, j + 0, k + 0, 35, 12, 3);
		world.setBlock(i + 7, j + 1, k + 0, 35, 6, 3);
		world.setBlock(i + 7, j + 2, k + 0, 35, 6, 3);
		world.setBlock(i + 7, j + 3, k + 0, 35, 6, 3);
		world.setBlock(i + 7, j + 4, k + 0, 35, 6, 3);
		world.setBlock(i + 7, j + 5, k + 0, 35, 6, 3);
		world.setBlock(i + 7, j + 6, k + 0, 35, 6, 3);
		world.setBlock(i + 7, j + 7, k + 0, 35, 6, 3);
		world.setBlock(i + 7, j + 9, k + 0, 35, 6, 3);
		world.setBlock(i + 7, j + 10, k + 0, 35, 6, 3);
		world.setBlock(i + 8, j + 2, k + 0, 35, 6, 3);
		world.setBlock(i + 8, j + 3, k + 0, 35, 6, 3);
		world.setBlock(i + 8, j + 4, k + 0, 35, 6, 3);
		world.setBlock(i + 8, j + 5, k + 0, 35, 6, 3);
		world.setBlock(i + 8, j + 6, k + 0, 35, 6, 3);
		world.setBlock(i + 8, j + 7, k + 0, 35, 6, 3);
		world.setBlock(i + 9, j + 7, k + 0, 35, 6, 3);
		world.setBlock(i + 10, j + 4, k + 0, 35, 6, 3);
		world.setBlock(i + 10, j + 5, k + 0, 35, 6, 3);
		world.setBlock(i + 10, j + 6, k + 0, 35, 6, 3);

		return true;
	}
	private static final Random lootRandom = new Random();
	private static final WeightedRandomChestContent[] loot = new WeightedRandomChestContent[]{new WeightedRandomChestContent(new ItemStack(Item.goldenCarrot), 1, 1, 12),new WeightedRandomChestContent(new ItemStack(Item.carrot,2), 1, 4, 84),new WeightedRandomChestContent(new ItemStack(Item.ingotIron), 1, 4, 44),new WeightedRandomChestContent(new ItemStack(Item.diamond), 1, 1, 7),new WeightedRandomChestContent(new ItemStack(Item.saddle), 1, 2, 80),new WeightedRandomChestContent(new ItemStack(Item.ingotGold), 1, 9, 47)};
	
	private void addLoot(IInventory chest) {
		WeightedRandomChestContent.generateChestContents(lootRandom, loot, chest, 4+lootRandom.nextInt(3));
	}
}