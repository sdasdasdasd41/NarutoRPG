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
