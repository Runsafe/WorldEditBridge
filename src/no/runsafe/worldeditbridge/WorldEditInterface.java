package no.runsafe.worldeditbridge;

import no.runsafe.framework.api.ILocation;
import no.runsafe.framework.api.player.IPlayer;

public interface WorldEditInterface
{
	void select(IPlayer player, ILocation pos1, ILocation pos2);

	//	BoundingBox getSelection(IPlayer player);
	boolean regenerate(IPlayer runsafePlayer, ILocation pos1, ILocation pos2, boolean enableUndo);
}
