package PorkerCraft.core.gen;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

import cpw.mods.fml.common.IWorldGenerator;
import net.minecraft.block.Block;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.structure.MapGenStructure;
import net.minecraft.world.gen.structure.StructureStart;
import PorkerCraft.village.*;
import PorkerCraft.core.gen.*;

public class MapGenPigVillage extends MapGenStructure {
	/** A list of all the biomes villages can spawn in. */
	public static List villageSpawnBiomes = Arrays.asList(new BiomeGenBase[] { PorkerCraft.PorkerCraft.PorkerLand, PorkerCraft.PorkerCraft.PigPlains });

	/** World terrain type, 0 for normal, 1 for flat map */
	private int terrainType;
	private int field_82665_g;
	private int field_82666_h;

	public MapGenPigVillage() {
		this.terrainType = 0;
		this.field_82665_g = 32;
		this.field_82666_h = 8;
	}

	public MapGenPigVillage(Map par1Map) {
		this();
		Iterator iterator = par1Map.entrySet().iterator();

		while (iterator.hasNext()) {
			Entry entry = (Entry) iterator.next();

			if (((String) entry.getKey()).equals("size")) {
				this.terrainType = MathHelper.parseIntWithDefaultAndMax((String) entry.getValue(), this.terrainType, 0);
			} else if (((String) entry.getKey()).equals("distance")) {
				this.field_82665_g = MathHelper.parseIntWithDefaultAndMax((String) entry.getValue(), this.field_82665_g, this.field_82666_h + 1);
			}
		}
	}

	protected boolean canSpawnStructureAtCoords(int par1, int par2) {
		// This can be changed...
			return rand.nextInt(1000) < 9 &&  this.worldObj.getWorldChunkManager().areBiomesViable(par1 * 16 + 8, par2 * 16 + 8, 0, villageSpawnBiomes);
		/*
		int k = par1;
		int l = par2;

		if (par1 < 0) {
			par1 -= this.field_82665_g - 1;
		}

		if (par2 < 0) {
			par2 -= this.field_82665_g - 1;
		}

		int i1 = par1 / this.field_82665_g;
		int j1 = par2 / this.field_82665_g;
		Random random = this.worldObj.setRandomSeed(i1, j1, 10387312);
		i1 *= this.field_82665_g;
		j1 *= this.field_82665_g;
		i1 += random.nextInt(this.field_82665_g - this.field_82666_h);
		j1 += random.nextInt(this.field_82665_g - this.field_82666_h);

		if (k == i1 && l == j1) {
			boolean flag = this.worldObj.getWorldChunkManager().areBiomesViable(k * 16 + 8, l * 16 + 8, 0, villageSpawnBiomes);
			System.out.println("CanSpawnVillage - " + flag);
			return flag;
		}
		return false;*/
	}

	protected StructureStart getStructureStart(int par1, int par2) {
		return new StructureVillageStartPorker(this.worldObj, this.rand, par1, par2, this.terrainType);
	}
}
