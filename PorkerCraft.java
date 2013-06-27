package PorkerCraft;

import java.io.File;

import org.lwjgl.input.Keyboard;

import mod_TFmaterials.mod_TFmaterials;
import mod_TFmaterials.Blocks.BlockFireTF;
import mod_TFmaterials.Blocks.BlockTFportal;
import mod_TFmaterials.Items.ItemFlintAndSteelTF;
import mod_TFmaterials.client.gui.tileentity.TileEntityNuclearFurnace;
import mod_TFmaterials.core.util.WorldProviderTF;
import net.aetherteam.mainmenu_api.MainMenuAPI;
import net.aetherteam.mainmenu_api.MenuBaseMinecraft;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFire;
import net.minecraft.block.BlockSkull;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSkull;
import net.minecraft.item.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.DimensionManager;
import net.minecraftforge.common.MinecraftForge;
import PorkerCraft.core.blocks.BlockFirePorker;
import PorkerCraft.core.blocks.BlockPorkTreeLeaf;
import PorkerCraft.core.blocks.BlockPorkTreeLog;
import PorkerCraft.core.blocks.BlockPorkTreeSapling;
import PorkerCraft.core.blocks.BlockPorkerPortal;
import PorkerCraft.core.blocks.PorkDirt;
import PorkerCraft.core.blocks.PorkGrass;
import PorkerCraft.core.blocks.PorkObsidian;
import PorkerCraft.core.blocks.PorkStone;
import PorkerCraft.core.mainmenu.PorkerMainMenu;
import PorkerCraft.core.proxy.CommonProxy;
import PorkerCraft.core.util.KeybindingHandler;
import cpw.mods.fml.client.registry.KeyBindingRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.IWorldGenerator;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;
import PorkerCraft.core.blocks.*;
import PorkerCraft.core.gen.BiomeGenPorkerLand;
import PorkerCraft.core.gen.MapGenBossTempleAll;
import PorkerCraft.core.gen.PorkerEventClass;
import PorkerCraft.core.gen.WorldGenGlowPig1;
import PorkerCraft.core.gen.WorldGenPorkTree;
import PorkerCraft.core.gen.WorldProviderPorker;
import PorkerCraft.core.items.*;
import PorkerCraft.core.mob.entity.*;
import PorkerCraft.core.mob.render.*;
import PorkerCraft.core.mob.model.*;

@Mod(modid="PorkerCraft", name="PorkerCraft", version="0.0.0.1.0")
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class PorkerCraft {

        // The instance of your mod that Forge uses.
        @Instance("PorkerCraft")
        public static PorkerCraft instance;
        
        // Says where the client and server 'proxy' code is loaded.
        @SidedProxy(clientSide="PorkerCraft.core.proxy.ClientProxy", serverSide="PorkerCraft.core.proxy.CommonProxy")
        public static CommonProxy proxy;
        
        @PreInit
        public void preInit(FMLPreInitializationEvent event) {
                // Stub Method
        }
        
        public static int dimension = 560;
        
        public static Block PorkStone;
        public static Block PorkGrass;
        public static Block PorkerPortal;
        public static Block PorkObsidian;
        public static Block PorkDirt;
        public static BlockFirePorker FirePorker;
        public static Item PorkAndGold;
        public static BiomeGenBase PorkerLand;
        public static Block PorkTreeLeaf;
        public static Block PorkTreeLog;
        public static Block PorkTreeSapling;
        
        public KeyBinding keyBindFullBright = new KeyBinding("key.bright", 73);
        
    	static int startEntityId = 300;
    	
    	public PorkerCraft(){
    		EntityRegistry.registerGlobalEntityID(EntityPigGod.class, "Pig God", 1);
    		EntityRegistry.addSpawn(EntityPigGod.class, 10, 1, 2, EnumCreatureType.creature);
    		EntityRegistry.findGlobalUniqueEntityId();
    		registerEntityEgg(EntityPigGod.class, 0xFAAFBE, 0x000000);
    		RenderingRegistry.registerEntityRenderingHandler(EntityPigGod.class, new RenderPigGod(new ModelPigGod(), 0.3F));
    		
    		EntityRegistry.registerGlobalEntityID(EntityFlyingPig.class, "Flying Pig", 2);
    		EntityRegistry.addSpawn(EntityFlyingPig.class, 10, 1, 2, EnumCreatureType.creature);
    		EntityRegistry.findGlobalUniqueEntityId();
    		registerEntityEgg(EntityFlyingPig.class, 0xFAAFBE, 0x000000);
    		RenderingRegistry.registerEntityRenderingHandler(EntityFlyingPig.class, new RenderFlyingPig(new ModelFlyingPig(), 0.3F));
    	}
    	
    	public static void registerEntityEgg(Class<? extends Entity> entity, int primaryColor, int secondaryColor){
    			int id = getUniqueEntityId();
    			EntityList.IDtoClassMapping.put(id, entity);
    			EntityList.entityEggs.put(id, new EntityEggInfo(id, primaryColor, secondaryColor));
    	}	
    	
    	public static int getUniqueEntityId() {
    			do{
    				startEntityId++;
    			}
    			while(EntityList.getStringFromID(startEntityId)!= null);
    			return startEntityId++;
    	}
        
        @Init
        public void load(FMLInitializationEvent event) {
                proxy.registerRenderers();
                
                PorkerPortal = (new BlockPorkerPortal(3398).setUnlocalizedName("PorkerPortal"));
                FirePorker = (BlockFirePorker)(new BlockFirePorker(3397)).setHardness(0.0F).setLightValue(1.0F).setUnlocalizedName("main:FirePorker"); 
                PorkStone = (new PorkStone(249, Material.rock).setCreativeTab(CreativeTabs.tabBlock).setHardness(3.0F)).setUnlocalizedName("Stone O' Pork");
                PorkObsidian = (new PorkObsidian(3395, Material.rock).setCreativeTab(CreativeTabs.tabBlock).setHardness(5.0F)).setUnlocalizedName("Obsidian O' Pork");
                PorkGrass = (new PorkGrass(241, Material.grass).setCreativeTab(CreativeTabs.tabBlock).setHardness(1.0F)).setUnlocalizedName("Bacon Grass");
                PorkDirt = (new PorkDirt(242, Material.ground).setCreativeTab(CreativeTabs.tabBlock).setHardness(1.0F)).setUnlocalizedName("Dirt O' Pork");
                
                PorkTreeLeaf = new BlockPorkTreeLeaf(3394).setUnlocalizedName("PorkTreeLeaf").setCreativeTab(CreativeTabs.tabBlock);
                PorkTreeLog = new BlockPorkTreeLog(3393).setUnlocalizedName("PorkerCraft:PorkTreeLogSide").setCreativeTab(CreativeTabs.tabBlock);
                PorkTreeSapling = new BlockPorkTreeSapling(3392, 5, Material.leaves).setUnlocalizedName("PorkerCraft:PorkTreeSapling").setCreativeTab(CreativeTabs.tabBlock);
                
                PorkerLand = (new BiomeGenPorkerLand(24));
                
                PorkAndGold = (new ItemPorkAndGold(3396)).setUnlocalizedName("Pork And Gold").setCreativeTab(CreativeTabs.tabTools);
        
                /** Event's **/
                MinecraftForge.EVENT_BUS.register(new PorkerEventClass());
                
                LanguageRegistry.addName(PorkerPortal, "Pork Land Portal");
                LanguageRegistry.addName(FirePorker, "Piggy Fire");
                LanguageRegistry.addName(PorkStone, "Stone O' Pork");
                LanguageRegistry.addName(PorkObsidian, "Obsidian O' Pork");
                LanguageRegistry.addName(PorkGrass, "Bacon Grass");
                LanguageRegistry.addName(PorkDirt, "Dirt O' Pork");
                LanguageRegistry.addName(PorkTreeSapling, "Pork Oak Sapling");
                LanguageRegistry.addName(PorkTreeLeaf, "Pork Oak Leaf");
                LanguageRegistry.addName(PorkTreeLog, "Pork Oak Log");
                LanguageRegistry.addName(PorkAndGold, "Pork And Gold");
                
                GameRegistry.registerBlock(PorkStone);
                //GameRegistry.registerBlock(PorkDirt);
                GameRegistry.registerBlock(PorkGrass);
                GameRegistry.registerBlock(FirePorker);
                GameRegistry.registerBlock(PorkObsidian);
                GameRegistry.registerBlock(PorkTreeLeaf);
                GameRegistry.registerBlock(PorkTreeLog);
                GameRegistry.registerBlock(PorkTreeSapling);
                
          	    DimensionManager.registerProviderType(dimension, WorldProviderPorker.class, true);
          	    DimensionManager.registerDimension(dimension, dimension);
          	    
          	    MainMenuAPI.registerMenu("PorkerCraft", PorkerMainMenu.class);
          	    
          	    GameRegistry.registerWorldGenerator(new WorldGenPorkTree(false));
          	    GameRegistry.registerWorldGenerator(new WorldGenGlowPig1(89));
          	    GameRegistry.registerWorldGenerator(new MapGenBossTempleAll());
          	    
          	    KeyBindingRegistry.registerKeyBinding(new KeybindingHandler());
          	    
          	    MinecraftForge.setBlockHarvestLevel(PorkGrass, "shovel", 1);
          	    MinecraftForge.setBlockHarvestLevel(PorkDirt, "shovel", 1);
          	    MinecraftForge.setBlockHarvestLevel(PorkStone, "pickaxe", 1);
          	    MinecraftForge.setBlockHarvestLevel(PorkObsidian, "pickaxe", 3); 
          	    MinecraftForge.setBlockHarvestLevel(PorkTreeLog, "axe", 0); 
          	    
    		    GameRegistry.addRecipe(new ItemStack(this.PorkObsidian, 1), new Object[]{
    				"XXX", "X1X", "XXX", '1', Block.obsidian, 'X', Item.porkRaw
    			});
    		    GameRegistry.addRecipe(new ItemStack(this.PorkAndGold, 1), new Object[]{
    				"XXX", "X1X", "XXX", '1', Item.porkRaw, 'X', Item.goldNugget
    			});
        }
        
        @PostInit
        public void postInit(FMLPostInitializationEvent event) {
                // Stub Method
        }
}