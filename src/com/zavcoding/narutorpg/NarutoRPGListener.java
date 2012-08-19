package com.zavcoding.narutorpg;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import com.zavcoding.narutorpg.Clans.Clan;

public class NarutoRPGListener implements Listener {
	public Clan clan;
	
	public NarutoRPG plugin;
	public NarutoRPGListener(NarutoRPG narutoRPG) {
		plugin = narutoRPG;
		}
	
	@EventHandler
	public void onSignChange(SignChangeEvent event) {
		Player player = event.getPlayer();
		String[] sign = event.getLines();
		if (player.hasPermission("narutorpg.admin") || player.isOp()) {
			if(sign[0].equalsIgnoreCase("[NarutoRPG]") && sign[1].equalsIgnoreCase(clan.getName())) {
				event.setLine(0, ChatColor.RED + "[NarutoRPG]");
				event.setLine(1, ChatColor.GREEN + clan.getName());
				player.sendMessage(plugin.prefix + ChatColor.AQUA + " You successfully created for " + clan.getName() + "!");
			}
		}
	}
}