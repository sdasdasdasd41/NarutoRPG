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
import com.zavcoding.narutorpg.Messaging.MessageManager;



public class NarutoRPG extends JavaPlugin {

	// Global Managers
	MessageManager MM = new MessageManager(this);
	ClanLoader clanLoader = new ClanLoader(this);
	
	// Global Fields
	public Logger logger;
	public List<Clan> clans;
	public Clan clan;
	
	public File mainFolder = new File("./plugins/NarutoRPG");
	public File clanFolder = new File(mainFolder + "/Clans");
	public File clanClassFolder = new File(mainFolder + "/Classes");
	
	public String prefix = "[" + ChatColor.DARK_RED + "NarutoRPG" + ChatColor.WHITE + "] ";
	
	@Override
	public void onEnable() {
		logger = getServer().getLogger();
		checkFolders();
		try {
		clans = clanLoader.load(); // Add clans to the list
		} catch (Exception e) {
			logger.severe("Can't load the classes!");
			e.printStackTrace();
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

	public Clan getClan(String s) {
		for (Clan c : clans) {
			if (c.getClanPlayers().contains(s)) {
				return c;
			}
		}
		return null;
	}
}
