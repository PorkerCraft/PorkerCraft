package PorkerCraft.core.proxy;

import java.io.File;
import java.net.URL;

import PorkerCraft.client.sounds.PorkerSounds;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;

public class ClientProxy extends CommonProxy {
        
        @Override
        public void registerRenderers() {
        }
}