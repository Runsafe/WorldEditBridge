package no.runsafe.worldeditbridge;

import no.runsafe.framework.RunsafePlugin;

public class Plugin extends RunsafePlugin
{
	@Override
	protected void PluginSetup()
	{
		addComponent(WorldEditInterface.class);
	}
}