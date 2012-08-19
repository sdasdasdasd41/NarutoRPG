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

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length == 0) {
			sender.sendMessage(plugin.prefix + ChatColor.AQUA + " Try: /narutorpg help =)");
			return false;			
			} else if (args.length == 1) {
				if (args[0].equalsIgnoreCase("reload")) {
					// Reload config
					if (args[0].equalsIgnoreCase("join")) {
						// Join a clan
						if (args[0].equalsIgnoreCase("leave")) {
							// Leave a clan
							if(args[0].equalsIgnoreCase("members")) {
								// Members of a clan
							}
						}
					}
				}
			}
		return false;
	}
}