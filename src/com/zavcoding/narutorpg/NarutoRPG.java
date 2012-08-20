package com.zavcoding.narutorpg;

import java.io.File;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;

import com.zavcoding.narutorpg.Clans.ClanLoader;
import com.zavcoding.narutorpg.Clans.Clan;

public class NarutoRPG extends JavaPlugin {

	// Global Fields
	public Logger logger;
	public List<Clan> clans;
	public File clanFolder = new File(getDataFolder() + File.pathSeparator + "clans");
	public File clanClassFolder = new File(clanFolder + File.pathSeparator + "classes");
	
	// Global Managers
	ClanLoader clanLoader = new ClanLoader(this);
	
	@Override
	public void onEnable() {
		logger = getServer().getLogger();
		checkFolders();
		clans = clanLoader.load(); // Add clans to the list
		if (clans.size() < 1) {
			logger.severe("No clans are located in the clans folder. This plugin is shutting down");
			setEnabled(false);
		}
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
