package no.runsafe.worldeditbridge;

import javafx.geometry.BoundingBox;
import no.runsafe.framework.api.player.IPlayer;
import no.runsafe.framework.minecraft.RunsafeLocation;

public interface WorldEditInterface
{
	void select(IPlayer player, RunsafeLocation pos1, RunsafeLocation pos2);
	BoundingBox getSelection(IPlayer player);
	boolean regenerate(IPlayer runsafePlayer, RunsafeLocation pos1, RunsafeLocation pos2, boolean enableUndo);
}
