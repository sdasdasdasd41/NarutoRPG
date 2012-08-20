package com.zavcoding.narutorpg.Messaging;

import com.zavcoding.narutorpg.NarutoRPG;

public class MessageManager {
	
	public NarutoRPG plugin;
	
	public MessageManager(NarutoRPG instance) {
		plugin = instance;
	}
	
	public void sendMessage(String player, String s) {
		plugin.getServer().getPlayer(player).sendMessage(plugin.prefix + s);
	}
	
	public void broadcastMessage(String s) {
		plugin.getServer().broadcastMessage(plugin.prefix + s);
	}
}
