package no.runsafe.worldeditbridge;

import no.runsafe.framework.RunsafePlugin;

public class Plugin extends RunsafePlugin
{
	@Override
	protected void PluginSetup()
	{
		exportAPI(getInstance(WorldEditCommands.class));
	}
}
