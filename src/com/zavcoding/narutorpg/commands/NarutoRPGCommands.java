package com.zavcoding.narutorpg.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.zavcoding.narutorpg.NarutoRPG;
import com.zavcoding.narutorpg.Clans.Clan;

public class NarutoRPGCommands implements CommandExecutor {
	public Clan clan;
	
	public NarutoRPG plugin;
	public NarutoRPGCommands(NarutoRPG narutoRPG) {
		plugin = narutoRPG;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length == 0) {
			sender.sendMessage(plugin.prefix + ChatColor.AQUA + " Try: /narutorpg help =)");
			return true;
		}
		if (args.length == 1) {
			if (args[0].equalsIgnoreCase("help")) {
				if(sender.hasPermission("narutorpg.help")) {
					// Help command
					return true;
					}else{
						sender.sendMessage(plugin.prefix + ChatColor.RED + "Don't have permission!");
					}
			}
			if (args[0].equalsIgnoreCase("reload")) {
				if(sender.hasPermission("narutorpg.reload")) {
					// Reload config
					return true;
					}else{
						sender.sendMessage(plugin.prefix + ChatColor.RED + "Don't have permission!");
					}
				}
			if (args[0].equalsIgnoreCase("join")) {
				if(sender.hasPermission("narutorpg.join")) {
					// Join a clan
					return true;
					}else{
						sender.sendMessage(plugin.prefix + ChatColor.RED + "Don't have permission!");
					}
				}
			if (args[0].equalsIgnoreCase("leave")) {
				if(sender.hasPermission("narutorpg.leave")) {			
				// Leave a clan
					return true;
					}else{
						sender.sendMessage(plugin.prefix + ChatColor.RED + "Don't have permission!");
					}
				}
			if(args[0].equalsIgnoreCase("members")) {
				if(sender.hasPermission("narutorpg.members")) {
					// Members of a clan
					return true;
					}else{
						sender.sendMessage(plugin.prefix + ChatColor.RED + "Don't have permission!");
					}
			}
		}
		return false;
	}
}