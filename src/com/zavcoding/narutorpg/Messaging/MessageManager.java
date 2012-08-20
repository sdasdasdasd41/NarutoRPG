package com.zavcoding.narutorpg.Messaging;

import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;

import com.zavcoding.narutorpg.NarutoRPG;
import com.zavcoding.narutorpg.Clans.Clan;

public class MessageManager {
	
	public NarutoRPG plugin;
	
	public MessageManager(NarutoRPG instance) {
		plugin = instance;
	}
	
	public void sendMessage(String player, String s) {
		plugin.getServer().getPlayer(player).sendMessage(plugin.prefix + s);
	}
	
	public void sendClanMessage(Clan c, String s) {
		for (OfflinePlayer op : c.getClanPlayers()) {
			if (op.isOnline()) {
				Player p = (Player) op;
				p.sendMessage("[" + c.getName() + "] " + s);
			}
		}
	}
	
	public void broadcastMessage(String s) {
		plugin.getServer().broadcastMessage(plugin.prefix + s);
	}
}
