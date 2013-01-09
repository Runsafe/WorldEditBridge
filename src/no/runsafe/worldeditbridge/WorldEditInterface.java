package no.runsafe.worldeditbridge;

import com.sk89q.worldedit.LocalSession;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.WorldEdit;
import com.sk89q.worldedit.bukkit.BukkitWorld;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.bukkit.selections.CuboidSelection;
import com.sk89q.worldedit.regions.RegionSelector;
import no.runsafe.framework.plugin.PluginResolver;
import no.runsafe.framework.server.RunsafeLocation;
import no.runsafe.framework.server.player.RunsafePlayer;

public class WorldEditInterface
{
	public WorldEditInterface(PluginResolver resolver)
	{
		worldEdit = ((WorldEditPlugin) resolver.getPlugin("WorldEdit"));
	}

	public void select(RunsafePlayer player, RunsafeLocation pos1, RunsafeLocation pos2)
	{
		Vector pt1 = new Vector(pos1.getBlockX(), pos1.getBlockY(), pos1.getBlockZ());
		Vector pt2 = new Vector(pos2.getBlockX(), pos2.getBlockY(), pos2.getBlockZ());
		final CuboidSelection selection = new CuboidSelection(player.getWorld().getRaw(), pt1, pt2);
		worldEdit.setSelection(player.getRawPlayer(), selection);
	}

	WorldEditPlugin worldEdit;
}
