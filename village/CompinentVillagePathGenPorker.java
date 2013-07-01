package PorkerCraft.village;

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.ComponentVillageRoadPiece;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;

public class CompinentVillagePathGenPorker extends ComponentVillageRoadPiecePorker
{
    private int averageGroundLevel;

    public CompinentVillagePathGenPorker(ComponentVillageStartPiecePorker par1ComponentVillageStartPiece, int par2, Random par3Random, StructureBoundingBox par4StructureBoundingBox, int par5)
    {
        super(par1ComponentVillageStartPiece, par2);
        this.coordBaseMode = par5;
        this.boundingBox = par4StructureBoundingBox;
        this.averageGroundLevel = Math.max(par4StructureBoundingBox.getXSize(), par4StructureBoundingBox.getZSize());
    }

    /**
     * Initiates construction of the Structure Component picked, at the current Location of StructGen
     */
    public void buildComponent(StructureComponent par1StructureComponent, List par2List, Random par3Random)
    {
        boolean flag = false;
        int i;
        StructureComponent structurecomponent1;

        for (i = par3Random.nextInt(5); i < this.averageGroundLevel - 8; i += 2 + par3Random.nextInt(5))
        {
            structurecomponent1 = this.getNextComponentNN((ComponentVillageStartPiecePorker)par1StructureComponent, par2List, par3Random, 0, i);

            if (structurecomponent1 != null)
            {
                i += Math.max(structurecomponent1.getBoundingBox().getXSize(), structurecomponent1.getBoundingBox().getZSize());
                flag = true;
            }
        }

        for (i = par3Random.nextInt(5); i < this.averageGroundLevel - 8; i += 2 + par3Random.nextInt(5))
        {
            structurecomponent1 = this.getNextComponentPP((ComponentVillageStartPiecePorker)par1StructureComponent, par2List, par3Random, 0, i);

            if (structurecomponent1 != null)
            {
                i += Math.max(structurecomponent1.getBoundingBox().getXSize(), structurecomponent1.getBoundingBox().getZSize());
                flag = true;
            }
        }

        if (flag && par3Random.nextInt(3) > 0)
        {
            switch (this.coordBaseMode)
            {
                case 0:
                    StructureVillagePiecesPorker.getNextStructureComponentPorkerVillagePath((ComponentVillageStartPiecePorker)par1StructureComponent, par2List, par3Random, this.getBoundingBox().minX - 1, this.getBoundingBox().minY, this.getBoundingBox().maxZ - 2, 1, this.getComponentType());
                    break;
                case 1:
                    StructureVillagePiecesPorker.getNextStructureComponentPorkerVillagePath((ComponentVillageStartPiecePorker)par1StructureComponent, par2List, par3Random, this.getBoundingBox().minX, this.getBoundingBox().minY, this.getBoundingBox().minZ - 1, 2, this.getComponentType());
                    break;
                case 2:
                    StructureVillagePiecesPorker.getNextStructureComponentPorkerVillagePath((ComponentVillageStartPiecePorker)par1StructureComponent, par2List, par3Random, this.getBoundingBox().minX - 1, this.getBoundingBox().minY, this.getBoundingBox().minZ, 1, this.getComponentType());
                    break;
                case 3:
                    StructureVillagePiecesPorker.getNextStructureComponentPorkerVillagePath((ComponentVillageStartPiecePorker)par1StructureComponent, par2List, par3Random, this.getBoundingBox().maxX - 2, this.getBoundingBox().minY, this.getBoundingBox().minZ - 1, 2, this.getComponentType());
            }
        }

        if (flag && par3Random.nextInt(3) > 0)
        {
            switch (this.coordBaseMode)
            {
                case 0:
                    StructureVillagePiecesPorker.getNextStructureComponentPorkerVillagePath((ComponentVillageStartPiecePorker)par1StructureComponent, par2List, par3Random, this.getBoundingBox().maxX + 1, this.getBoundingBox().minY, this.getBoundingBox().maxZ - 2, 3, this.getComponentType());
                    break;
                case 1:
                    StructureVillagePiecesPorker.getNextStructureComponentPorkerVillagePath((ComponentVillageStartPiecePorker)par1StructureComponent, par2List, par3Random, this.getBoundingBox().minX, this.getBoundingBox().minY, this.getBoundingBox().maxZ + 1, 0, this.getComponentType());
                    break;
                case 2:
                    StructureVillagePiecesPorker.getNextStructureComponentPorkerVillagePath((ComponentVillageStartPiecePorker)par1StructureComponent, par2List, par3Random, this.getBoundingBox().maxX + 1, this.getBoundingBox().minY, this.getBoundingBox().minZ, 3, this.getComponentType());
                    break;
                case 3:
                    StructureVillagePiecesPorker.getNextStructureComponentPorkerVillagePath((ComponentVillageStartPiecePorker)par1StructureComponent, par2List, par3Random, this.getBoundingBox().maxX - 2, this.getBoundingBox().minY, this.getBoundingBox().maxZ + 1, 0, this.getComponentType());
            }
        }
    }

    public static StructureBoundingBox func_74933_a(ComponentVillageStartPiecePorker par0ComponentVillageStartPiece, List par1List, Random par2Random, int par3, int par4, int par5, int par6)
    {
        for (int i1 = 7 * MathHelper.getRandomIntegerInRange(par2Random, 3, 5); i1 >= 7; i1 -= 7)
        {
            StructureBoundingBox structureboundingbox = StructureBoundingBox.getComponentToAddBoundingBox(par3, par4, par5, 0, 0, 0, 3, 3, i1, par6);

            if (StructureComponent.findIntersecting(par1List, structureboundingbox) == null)
            {
                return structureboundingbox;
            }
        }

        return null;
    }

    /**
     * second Part of Structure generating, this for example places Spiderwebs, Mob Spawners, it closes Mineshafts at
     * the end, it adds Fences...
     */
    public boolean addComponentParts(World par1World, Random par2Random, StructureBoundingBox par3StructureBoundingBox)
    {
        int i = this.getBiomeSpecificBlock(Block.gravel.blockID, 0);

        for (int j = this.getBoundingBox().minX; j <= this.getBoundingBox().maxX; ++j)
        {
            for (int k = this.getBoundingBox().minZ; k <= this.getBoundingBox().maxZ; ++k)
            {
                if (par3StructureBoundingBox.isVecInside(j, 64, k))
                {
                    int l = par1World.getTopSolidOrLiquidBlock(j, k) - 1;
                    par1World.setBlock(j, l, k, i, 0, 2);
                }
            }
        }

        return true;
    }
}
