package com.zavcoding.narutorpg;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

public class NarutoRPG extends JavaPlugin {
	
	// Global Field Declerations
	Logger logger;
	
	// Manager declerations
	
	@Override
	public void onEnable() {
		logger = getServer().getLogger();
		logger.info(this + " is now enabled.");
	}
	
	@Override
	public void onDisable() {
		logger.info(this + " is now disabled.");
	}
	
}
