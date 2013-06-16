package no.runsafe.worldeditbridge;

import com.sk89q.worldedit.EditSession;
import com.sk89q.worldedit.IncompleteRegionException;
import com.sk89q.worldedit.Vector;
import com.sk89q.worldedit.bukkit.WorldEditPlugin;
import com.sk89q.worldedit.bukkit.selections.CuboidSelection;
import com.sk89q.worldedit.bukkit.selections.Selection;
import com.sk89q.worldedit.masks.Mask;
import com.sk89q.worldedit.regions.Region;
import no.runsafe.framework.api.IOutput;
import no.runsafe.framework.minecraft.RunsafeLocation;
import no.runsafe.framework.minecraft.RunsafeServer;
import no.runsafe.framework.minecraft.player.RunsafePlayer;

public class WorldEditInterface
{
	public WorldEditInterface(IOutput output)
	{
		worldEdit = RunsafeServer.Instance.getPlugin("WorldEdit");
		console = output;
	}

	public void select(RunsafePlayer player, RunsafeLocation pos1, RunsafeLocation pos2)
	{
		Vector pt1 = new Vector(pos1.getBlockX(), pos1.getBlockY(), pos1.getBlockZ());
		Vector pt2 = new Vector(pos2.getBlockX(), pos2.getBlockY(), pos2.getBlockZ());
		final CuboidSelection selection = new CuboidSelection(player.getWorld().getRaw(), pt1, pt2);
		worldEdit.setSelection(player.getRawPlayer(), selection);
	}

	public boolean regenerate(RunsafePlayer runsafePlayer, RunsafeLocation pos1, RunsafeLocation pos2)
	{
		select(runsafePlayer, pos1, pos2);
		Selection selection = worldEdit.getSelection(runsafePlayer.getRawPlayer());
		Region region;
		try
		{
			region = selection.getRegionSelector().getRegion();
			if (region == null)
				return false;
		}
		catch (IncompleteRegionException e)
		{
			console.logException(e);
			return false;
		}

		EditSession editSession = worldEdit.createEditSession(runsafePlayer.getRawPlayer());
//		Mask mask = editSession.getMask();
//		editSession.setMask(null);
		worldEdit.wrapPlayer(runsafePlayer.getRawPlayer()).getWorld().regenerate(region, editSession);
//		editSession.setMask(mask);
		return true;
	}

	private final WorldEditPlugin worldEdit;
	private final IOutput console;
}
