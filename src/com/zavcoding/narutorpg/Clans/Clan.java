package com.zavcoding.narutorpg.Clans;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.OfflinePlayer;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import com.zavcoding.narutorpg.NarutoRPG;

public abstract class Clan {
	private NarutoRPG plugin;

	private int currentChakra;

	private FileConfiguration config;
	
	public Clan() {
		plugin = null;
		config = null;
		System.out.println(this + " cannot create a valid instance. Null constructor error.");
	}

	public Clan(NarutoRPG instance) {
		plugin = instance;
		config = YamlConfiguration.loadConfiguration(new File(plugin.clanFolder, getName() + File.separator + "yml"));
	}

	public abstract String getName();

	public abstract int getMaxChackra();

	public abstract void onEnable();

	public NarutoRPG getPluginInstance() {
		return plugin;
	}

	public FileConfiguration getConfig() {
		return config;
	}

	public int getCurrentChakra() {
		return currentChakra;
	}
	public void setCurrentChakra(int i) {
		currentChakra = i;
	}

	public void changeCurrentChakraBy(int i) {
		currentChakra += i;
	}
	public void addPlayer(String s) {
		List<OfflinePlayer> list = new ArrayList<OfflinePlayer>();
		OfflinePlayer player = plugin.getServer().getOfflinePlayer(s);
		if (player != null) {
			list.add(plugin.getServer().getOfflinePlayer(s));
		}
		config.set("players", list);
	}
	
	public void removePlayer(String s) {
		List<OfflinePlayer> list = new ArrayList<OfflinePlayer>();
		OfflinePlayer player = plugin.getServer().getOfflinePlayer(s);
		if (list.contains(player.getName())) {
			list.remove(player.getName());
		}
		config.set("players", list);
	}
	
	public List<OfflinePlayer> getClanPlayers() {
		List<OfflinePlayer> list = new ArrayList<OfflinePlayer>();
		for (String s : config.getStringList("players")) {
			OfflinePlayer player = plugin.getServer().getOfflinePlayer(s);
			if (player != null) {
				list.add(plugin.getServer().getOfflinePlayer(s));
			}
		}
		return list;
	}
}
