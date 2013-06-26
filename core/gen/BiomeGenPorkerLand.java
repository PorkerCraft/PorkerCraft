package PorkerCraft.core.gen;

import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.DUNGEON;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.ICE;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.LAKE;
import static net.minecraftforge.event.terraingen.PopulateChunkEvent.Populate.EventType.LAVA;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSand;
import net.minecraft.block.material.Material;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.SpawnerAnimals;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.biome.SpawnListEntry;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.NoiseGeneratorOctaves;
import net.minecraft.world.gen.feature.WorldGenDungeons;
import net.minecraft.world.gen.feature.WorldGenLakes;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.terraingen.PopulateChunkEvent;
import net.minecraftforge.event.terraingen.TerrainGen;
import PorkerCraft.*;

public class BiomeGenPorkerLand extends BiomeGenBase
{	
private WorldGenerator WorldGenPorkTrees;
private Object worldGeneratorPorkBigTree;
public final Material blockMaterial;
private Random rand;
private World worldObj;

public BiomeGenPorkerLand(int par1)
{
super(par1);
this.blockMaterial = Material.water;
this.minHeight = 0.1F;
this.maxHeight = 2.2F;
this.spawnableMonsterList.clear();
this.spawnableCreatureList.clear();
this.spawnableWaterCreatureList.clear();
this.spawnableCaveCreatureList.clear();
this.theBiomeDecorator.treesPerChunk = 25;
this.WorldGenPorkTrees = new WorldGenPorkTree(false);
this.topBlock = ((byte)PorkerCraft.PorkGrass.blockID);
this.fillerBlock = ((byte)PorkerCraft.PorkStone.blockID);
this.setBiomeName("The Land Of The Piggys");
this.spawnableMonsterList.add(new SpawnListEntry(EntityPig.class, 100, 4, 4));
this.theBiomeDecorator.generateLakes = true;

/** this changes the water colour, its set to red now but google the java colours **/
this.waterColorMultiplier = 0xE42D17;
}

public WorldGenerator getRandomWorldGenForTrees(Random par1Random)
{
return (WorldGenerator)(par1Random.nextInt(5) == 0 ? this.worldGeneratorForest : (par1Random.nextInt(10) == 0 ? this.WorldGenPorkTrees : this.worldGeneratorTrees));
}
}