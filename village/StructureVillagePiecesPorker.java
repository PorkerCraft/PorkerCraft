package PorkerCraft.village;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import PorkerCraft.core.gen.MapGenPigVillage;

import net.minecraft.util.MathHelper;
import net.minecraft.world.gen.structure.ComponentVillageChurch;
import net.minecraft.world.gen.structure.ComponentVillageField;
import net.minecraft.world.gen.structure.ComponentVillageField2;
import net.minecraft.world.gen.structure.ComponentVillageHall;
import net.minecraft.world.gen.structure.ComponentVillageHouse1;
import net.minecraft.world.gen.structure.ComponentVillageHouse2;
import net.minecraft.world.gen.structure.ComponentVillageHouse3;
import net.minecraft.world.gen.structure.ComponentVillageHouse4_Garden;
import net.minecraft.world.gen.structure.ComponentVillagePathGen;
import net.minecraft.world.gen.structure.ComponentVillageStartPiece;
import net.minecraft.world.gen.structure.ComponentVillageTorch;
import net.minecraft.world.gen.structure.ComponentVillageWoodHut;
import net.minecraft.world.gen.structure.StructureBoundingBox;
import net.minecraft.world.gen.structure.StructureComponent;
import net.minecraft.world.gen.structure.StructureVillagePieceWeight;

public class StructureVillagePiecesPorker
{
    public static ArrayList getStructureVillageWeightedPieceList(Random par0Random, int par1)
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(new StructureVillagePieceWeight(ComponentVillageHouse4_GardenPorker.class, 4, MathHelper.getRandomIntegerInRange(par0Random, 2 + par1, 4 + par1 * 2)));
        arraylist.add(new StructureVillagePieceWeight(ComponentVillageChurchPorker.class, 20, MathHelper.getRandomIntegerInRange(par0Random, 0 + par1, 1 + par1)));
        arraylist.add(new StructureVillagePieceWeight(ComponentVillageHouse1Porker.class, 20, MathHelper.getRandomIntegerInRange(par0Random, 0 + par1, 2 + par1)));
        arraylist.add(new StructureVillagePieceWeight(ComponentVillageWoodHutPorker.class, 3, MathHelper.getRandomIntegerInRange(par0Random, 2 + par1, 5 + par1 * 3)));
        arraylist.add(new StructureVillagePieceWeight(ComponentVillageHallPorker.class, 15, MathHelper.getRandomIntegerInRange(par0Random, 0 + par1, 2 + par1)));
        arraylist.add(new StructureVillagePieceWeight(ComponentVillageFieldPorker.class, 3, MathHelper.getRandomIntegerInRange(par0Random, 1 + par1, 4 + par1)));
        arraylist.add(new StructureVillagePieceWeight(ComponentVillageField2Porker.class, 3, MathHelper.getRandomIntegerInRange(par0Random, 2 + par1, 4 + par1 * 2)));
        arraylist.add(new StructureVillagePieceWeight(ComponentVillageHouse2Porker.class, 15, MathHelper.getRandomIntegerInRange(par0Random, 0, 1 + par1)));
        arraylist.add(new StructureVillagePieceWeight(ComponentVillageHouse3Porker.class, 8, MathHelper.getRandomIntegerInRange(par0Random, 0 + par1, 3 + par1 * 2)));
        VillagerRegistryPorker.addExtraVillageComponents(arraylist, par0Random, par1);

        Iterator iterator = arraylist.iterator();

        while (iterator.hasNext())
        {
            if (((StructureVillagePieceWeight)iterator.next()).villagePiecesLimit == 0)
            {
                iterator.remove();
            }
        }

        return arraylist;
    }

    private static int func_75079_a(List par0List)
    {
        boolean flag = false;
        int i = 0;
        StructureVillagePieceWeight structurevillagepieceweight;

        for (Iterator iterator = par0List.iterator(); iterator.hasNext(); i += structurevillagepieceweight.villagePieceWeight)
        {
            structurevillagepieceweight = (StructureVillagePieceWeight)iterator.next();

            if (structurevillagepieceweight.villagePiecesLimit > 0 && structurevillagepieceweight.villagePiecesSpawned < structurevillagepieceweight.villagePiecesLimit)
            {
                flag = true;
            }
        }

        return flag ? i : -1;
    }

    private static ComponentVillagePorker func_75083_a(ComponentVillageStartPiecePorker par0ComponentVillageStartPiece, StructureVillagePieceWeight par1StructureVillagePieceWeight, List par2List, Random par3Random, int par4, int par5, int par6, int par7, int par8)
    {
        Class oclass = par1StructureVillagePieceWeight.villagePieceClass;
        Object object = null;

        if (oclass == ComponentVillageHouse4_GardenPorker.class)
        {
            object = ComponentVillageHouse4_GardenPorker.func_74912_a(par0ComponentVillageStartPiece, par2List, par3Random, par4, par5, par6, par7, par8);
        }
        else if (oclass == ComponentVillageChurchPorker.class)
        {
            object = ComponentVillageChurchPorker.func_74919_a(par0ComponentVillageStartPiece, par2List, par3Random, par4, par5, par6, par7, par8);
        }
        else if (oclass == ComponentVillageHouse1Porker.class)
        {
            object = ComponentVillageHouse1Porker.func_74898_a(par0ComponentVillageStartPiece, par2List, par3Random, par4, par5, par6, par7, par8);
        }
        else if (oclass == ComponentVillageWoodHutPorker.class)
        {
            object = ComponentVillageWoodHutPorker.func_74908_a(par0ComponentVillageStartPiece, par2List, par3Random, par4, par5, par6, par7, par8);
        }
        else if (oclass == ComponentVillageHallPorker.class)
        {
            object = ComponentVillageHallPorker.func_74906_a(par0ComponentVillageStartPiece, par2List, par3Random, par4, par5, par6, par7, par8);
        }
        else if (oclass == ComponentVillageFieldPorker.class)
        {
            object = ComponentVillageFieldPorker.func_74900_a(par0ComponentVillageStartPiece, par2List, par3Random, par4, par5, par6, par7, par8);
        }
        else if (oclass == ComponentVillageField2Porker.class)
        {
            object = ComponentVillageField2Porker.func_74902_a(par0ComponentVillageStartPiece, par2List, par3Random, par4, par5, par6, par7, par8);
        }
        else if (oclass == ComponentVillageHouse2Porker.class)
        {
            object = ComponentVillageHouse2Porker.func_74915_a(par0ComponentVillageStartPiece, par2List, par3Random, par4, par5, par6, par7, par8);
        }
        else if (oclass == ComponentVillageHouse3Porker.class)
        {
            object = ComponentVillageHouse3Porker.func_74921_a(par0ComponentVillageStartPiece, par2List, par3Random, par4, par5, par6, par7, par8);
        }
        else
        {
            object = VillagerRegistryPorker.getVillageComponent(par1StructureVillagePieceWeight, par0ComponentVillageStartPiece , par2List, par3Random, par4, par5, par6, par7, par8);
        }

        return (ComponentVillagePorker)object;
    }

    /**
     * attempts to find a next Village Component to be spawned
     */
    private static ComponentVillagePorker getNextVillageComponent(ComponentVillageStartPiecePorker par0ComponentVillageStartPiece, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7)
    {
        int j1 = func_75079_a(par0ComponentVillageStartPiece.structureVillageWeightedPieceList);

        if (j1 <= 0)
        {
            return null;
        }
        else
        {
            int k1 = 0;

            while (k1 < 5)
            {
                ++k1;
                int l1 = par2Random.nextInt(j1);
                Iterator iterator = par0ComponentVillageStartPiece.structureVillageWeightedPieceList.iterator();

                while (iterator.hasNext())
                {
                    StructureVillagePieceWeight structurevillagepieceweight = (StructureVillagePieceWeight)iterator.next();
                    l1 -= structurevillagepieceweight.villagePieceWeight;

                    if (l1 < 0)
                    {
                        if (!structurevillagepieceweight.canSpawnMoreVillagePiecesOfType(par7) || structurevillagepieceweight == par0ComponentVillageStartPiece.structVillagePieceWeight && par0ComponentVillageStartPiece.structureVillageWeightedPieceList.size() > 1)
                        {
                            break;
                        }

                        ComponentVillagePorker componentvillage = func_75083_a(par0ComponentVillageStartPiece, structurevillagepieceweight, par1List, par2Random, par3, par4, par5, par6, par7);

                        if (componentvillage != null)
                        {
                            ++structurevillagepieceweight.villagePiecesSpawned;
                            par0ComponentVillageStartPiece.structVillagePieceWeight = structurevillagepieceweight;

                            if (!structurevillagepieceweight.canSpawnMoreVillagePieces())
                            {
                                par0ComponentVillageStartPiece.structureVillageWeightedPieceList.remove(structurevillagepieceweight);
                            }

                            return componentvillage;
                        }
                    }
                }
            }

            StructureBoundingBox structureboundingbox = ComponentVillageTorchPorker.func_74904_a(par0ComponentVillageStartPiece, par1List, par2Random, par3, par4, par5, par6);

            if (structureboundingbox != null)
            {
                return new ComponentVillageTorchPorker(par0ComponentVillageStartPiece, par7, par2Random, structureboundingbox, par6);
            }
            else
            {
                return null;
            }
        }
    }

    /**
     * attempts to find a next Structure Component to be spawned, private Village function
     */
    private static ComponentVillagePorker getNextVillageStructureComponentPorker(ComponentVillageStartPiecePorker par0ComponentVillageStartPiece, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7)
    {
        if (par7 > 50)
        {
            return null;
        }
        else if (Math.abs(par3 - par0ComponentVillageStartPiece.getBoundingBox().minX) <= 112 && Math.abs(par5 - par0ComponentVillageStartPiece.getBoundingBox().minZ) <= 112)
        {
            ComponentVillagePorker componentvillageporker = getNextVillageComponent(par0ComponentVillageStartPiece, par1List, par2Random, par3, par4, par5, par6, par7 + 1);

            if (componentvillageporker != null)
            {
                int j1 = (componentvillageporker.getBoundingBox().minX + componentvillageporker.getBoundingBox().maxX) / 2;
                int k1 = (componentvillageporker.getBoundingBox().minZ + componentvillageporker.getBoundingBox().maxZ) / 2;
                int l1 = componentvillageporker.getBoundingBox().maxX - componentvillageporker.getBoundingBox().minX;
                int i2 = componentvillageporker.getBoundingBox().maxZ - componentvillageporker.getBoundingBox().minZ;
                int j2 = l1 > i2 ? l1 : i2;

                if (par0ComponentVillageStartPiece.getWorldChunkManager().areBiomesViable(j1, k1, j2 / 2 + 4, MapGenPigVillage.villageSpawnBiomes))
                {
                    par1List.add(componentvillageporker);
                    par0ComponentVillageStartPiece.field_74932_i.add(componentvillageporker);
                    return componentvillageporker;
                }
            }

            return null;
        }
        else
        {
            return null;
        }
    }

    static ComponentVillagePathGenPorker getNextComponentVillagePath(ComponentVillageStartPiecePorker par0ComponentVillageStartPiece, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7)
    {
        if (par7 > 3 + par0ComponentVillageStartPiece.terrainType)
        {
            return null;
        }
        else if (Math.abs(par3 - par0ComponentVillageStartPiece.getBoundingBox().minX) <= 112 && Math.abs(par5 - par0ComponentVillageStartPiece.getBoundingBox().minZ) <= 112)
        {
            StructureBoundingBox structureboundingbox = ComponentVillagePathGenPorker.func_74933_a(par0ComponentVillageStartPiece, par1List, par2Random, par3, par4, par5, par6);

            if (structureboundingbox != null && structureboundingbox.minY > 10)
            {
                ComponentVillagePathGenPorker componentvillagepathgen = new ComponentVillagePathGenPorker(par0ComponentVillageStartPiece, par7, par2Random, structureboundingbox, par6);
                int j1 = (componentvillagepathgen.getBoundingBox().minX + componentvillagepathgen.getBoundingBox().maxX) / 2;
                int k1 = (componentvillagepathgen.getBoundingBox().minZ + componentvillagepathgen.getBoundingBox().maxZ) / 2;
                int l1 = componentvillagepathgen.getBoundingBox().maxX - componentvillagepathgen.getBoundingBox().minX;
                int i2 = componentvillagepathgen.getBoundingBox().maxZ - componentvillagepathgen.getBoundingBox().minZ;
                int j2 = l1 > i2 ? l1 : i2;

                if (par0ComponentVillageStartPiece.getWorldChunkManager().areBiomesViable(j1, k1, j2 / 2 + 4, MapGenPigVillage.villageSpawnBiomes))
                {
                    par1List.add(componentvillagepathgen);
                    par0ComponentVillageStartPiece.field_74930_j.add(componentvillagepathgen);
                    return componentvillagepathgen;
                }
            }

            return null;
        }
        else
        {
            return null;
        }
    }

    /**
     * attempts to find a next Structure Component to be spawned
     */
    static StructureComponent getNextStructureComponentPorker(ComponentVillageStartPiecePorker par1StructureComponent, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7)
    {
        return getNextVillageStructureComponentPorker(par1StructureComponent, par1List, par2Random, par3, par4, par5, par6, par7);
    }

    static ComponentVillagePathGenPorker getNextStructureComponentPorkerVillagePath(ComponentVillageStartPiecePorker par0ComponentVillageStartPiece, List par1List, Random par2Random, int par3, int par4, int par5, int par6, int par7)
    {
        return getNextComponentVillagePath(par0ComponentVillageStartPiece, par1List, par2Random, par3, par4, par5, par6, par7);
    }
}
