package com.zavcoding.narutorpg;

import java.io.File;
import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

public class NarutoRPG extends JavaPlugin {

	// Global Fields
	public Logger logger;
	public File clanFolder = new File(getDataFolder() + File.pathSeparator + "clans");
	public File clanClassFolder = new File(clanFolder + File.pathSeparator + "classes");
	
	// Global Managers
	
	@Override
	public void onEnable() {
		logger = getServer().getLogger();
		checkFolders();
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
	
	public void checkFolders() {
		if (!getDataFolder().exists()) {
			getDataFolder().mkdir();
		}
		if (!clanFolder.exists()) {
			clanFolder.mkdir();
		}
		if (!clanClassFolder.exists()) {
			clanClassFolder.mkdir();
		}
	}
}
