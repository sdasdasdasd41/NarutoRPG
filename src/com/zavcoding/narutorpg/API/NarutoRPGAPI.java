package com.zavcoding.narutorpg.API;

import java.util.List;

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
	

}
