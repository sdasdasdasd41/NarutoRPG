package com.zavcoding.narutorpg.API;

import java.util.List;

import org.bukkit.entity.Player;

import com.zavcoding.narutorpg.NarutoRPG;
import com.zavcoding.narutorpg.Clans.Clan;

public class NarutoRPGAPI {

	final NarutoRPG plugin;
	
	public NarutoRPGAPI(final NarutoRPG plugin) {
		this.plugin = plugin;
	}
	
	public NarutoRPG getPluginInstance() {
		return plugin;
	}
	
	public List<Clan> getClansList() {
		return plugin.clans;
	}
	
	public Clan getClan(Player p) {
		return plugin.getClan(p.getName());
	}
	
	public void addToClan(Clan c, Player p) {
		c.addPlayer(p.getName());
	}
	
	public void removeFromClan(Clan c, Player p) {
		c.removePlayer(p.getName());
	}
}
