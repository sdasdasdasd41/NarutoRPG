package com.zavcoding.narutorpg;

import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

public class NarutoRPG extends JavaPlugin {

	// Global Fields
	Logger logger;
	
	// Global Managers
	
	@Override
	public void onEnable() {
		logger = getServer().getLogger();
		logger.info(this + " is now enabled.");
		logger.info("This plugin is sponsored by BeastNode.com.");
		logger.info("Create. Connect. Grow. Premium Hosting Services.");
	}
	
	@Override
	public void onDisable() {
		logger.info(this + " is now disabled.");
		logger.info("This plugin is sponsored by BeastNode.com.");
		logger.info("Create. Connect. Grow. Premium Hosting Services.");
	}
}
