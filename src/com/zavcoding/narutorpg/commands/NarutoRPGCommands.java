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
					sender.sendMessage(ChatColor.GREEN + "----------" + plugin.prefix + "----------");
					sender.sendMessage(ChatColor.GREEN + "1. /narutorpg help");
					sender.sendMessage(ChatColor.GREEN + "2. /narutorpg join <clan>");
					sender.sendMessage(ChatColor.GREEN + "3. /narutorpg leave");
					sender.sendMessage(ChatColor.GREEN + "4. /narutorpg info <clan>");
					sender.sendMessage(ChatColor.GREEN + "5. /narutorpg members <clan>");
					sender.sendMessage(ChatColor.GREEN + "6. /narutorpg clans");
					return true;
					}else{
						sender.sendMessage(plugin.prefix + ChatColor.RED + "Don't have permission!");
					}
			}
			if (args[0].equalsIgnoreCase("reload")) {
				if(sender.hasPermission("narutorpg.reload")) {
					// Reload config
					plugin.reloadConfig();				
					return true;
					}else{
						sender.sendMessage(plugin.prefix + ChatColor.RED + "Don't have permission!");
					}
				}
			if (args[0].equalsIgnoreCase("join")) {
				if(sender.hasPermission("narutorpg.join")) {
					// Join a clan
					if(args[1].equalsIgnoreCase(clan.getName())) {
						clan.addPlayer(sender.getName());
						sender.sendMessage(plugin.prefix + "You joined " + clan.getName() + "!");
					return true;
					}else{
						sender.sendMessage(plugin.prefix + ChatColor.RED + "Don't have permission!");
					}
				}
			if (args[0].equalsIgnoreCase("leave")) {
				if(sender.hasPermission("narutorpg.leave")) {			
				// Leave a clan
					clan.removePlayer(sender.getName());
					sender.sendMessage(plugin.prefix + "You left " + clan.getName() + "!");
					return true;
					}else{
						sender.sendMessage(plugin.prefix + ChatColor.RED + "Don't have permission!");
					}
				}
			if(args[0].equalsIgnoreCase("members")) {
				if(sender.hasPermission("narutorpg.members")) {
					// Members of a clan
					if(args[1].equalsIgnoreCase(clan.getName())) {
						sender.sendMessage(clan.getName() + ":" + clan.getClanPlayers());
						return true;
						}else{
							sender.sendMessage(plugin.prefix + ChatColor.RED + "Don't have permission!");
							}
					}
			if(args[0].equalsIgnoreCase("info")) {
				if(sender.hasPermission("narutorpg.info")) {
					// Info about clan
					if(args[1].equalsIgnoreCase(clan.getName())) {
						sender.sendMessage(plugin.prefix + "----------" + clan.getName() + "----------");
						sender.sendMessage("Chakra: " + clan.getCurrentChakra() + "/" + clan.getMaxChackra());
					return true;
					}else{
						sender.sendMessage(plugin.prefix + ChatColor.RED + "Don't have permission!");
					}
				}
			if(args[0].equalsIgnoreCase("clans")) {
				if(sender.hasPermission("narutorpg.clans")) {
					// Clans available
					sender.sendMessage("Clans: " + plugin.clans);
					return true;
					}else{
						sender.sendMessage(plugin.prefix + ChatColor.RED + "Don't have permission!");
					}}}}
			    }
			}
		return false;
		}
	}