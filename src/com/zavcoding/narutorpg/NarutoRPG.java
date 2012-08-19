package com.zavcoding.narutorpg;

import java.io.File;
import java.util.List;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import com.zavcoding.narutorpg.Clans.ClanLoader;
import com.zavcoding.narutorpg.Clans.Clan;

import com.zavcoding.narutorpg.commands.NarutoRPGCommands;


public class NarutoRPG extends JavaPlugin {

	// Global Fields
	public Logger logger;
	public List<Clan> clans;
	
	public File clanFolder = new File("./plugins/NarutoRPG/Clans");
	public File clanClassFolder = new File("./plugins/NarutoRPG/Classes");
	
	public String prefix = "[" + ChatColor.DARK_RED + "NarutoRPG" + ChatColor.WHITE + "]";
	
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
		getCommand("narutorpg").setExecutor(new NarutoRPGCommands(this));
		Bukkit.getPluginManager().registerEvents(new NarutoRPGListener(this), this);
		logger.info(this + " is now enabled.");
		logger.info("This plugin is sponsored by BeastNode.com.");
		logger.info("Create. Connect. Grow. Premium Hosting Services.");
		if (clans.size() < 1) {
			logger.severe("No clans are located in the clans folder. This plugin is shutting down");
			setEnabled(false);
			}
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
