package com.zavcoding.narutorpg.Clans;

import java.util.ArrayList;
import java.util.List;

import com.zavcoding.narutorpg.NarutoRPG;

public class ClanLoader {
	
	NarutoRPG plugin;
	
	ClanLoader(NarutoRPG instance) {
		plugin = instance;
	}
	
	public List<Clan> load() {
		List<Clan> list = new ArrayList<Clan>();
		return list;
	}
}
