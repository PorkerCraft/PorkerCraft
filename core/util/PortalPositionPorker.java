package PorkerCraft.core.util;

import net.minecraft.util.ChunkCoordinates;

public class PortalPositionPorker extends ChunkCoordinates
{
public long field_85087_d;
final TeleporterPorker field_85088_e;
public PortalPositionPorker(TeleporterPorker TeleporterPorker, int par2, int par3, int par4, long par5)
{
super(par2, par3, par4);
this.field_85088_e = TeleporterPorker;
this.field_85087_d = par5;
}
}