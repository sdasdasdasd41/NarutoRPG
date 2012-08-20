package com.zavcoding.narutorpg;

import org.bukkit.ChatColor;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

import com.zavcoding.narutorpg.API.Events.ClanSignCreateEvent;
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
			if(sign[0].equalsIgnoreCase("[NarutoRPG]") && plugin.clans.contains(sign[1])) {
				
				// Clan sign create event call and handling
				ClanSignCreateEvent csce = new ClanSignCreateEvent(event.getPlayer(), (Sign) event.getBlock().getState());
				plugin.getServer().getPluginManager().callEvent(csce);
				if (csce.isCancelled()) {
					return;
				}
				
				event.setLine(0, ChatColor.RED + "[NarutoRPG]");
				event.setLine(1, ChatColor.GREEN + clan.getName());
				plugin.MM.sendMessage(player.getName(), ChatColor.AQUA + "You successfully created a join sgn for the clan " + clan.getName() + "!");
			} else if (sign[0].equalsIgnoreCase("[NarutoRPG]")) {
				plugin.MM.sendMessage(player.getName(), ChatColor.RED + "The clan name you entered is invalid or does not exist");
				event.setCancelled(true);
			}
		}
	}
}