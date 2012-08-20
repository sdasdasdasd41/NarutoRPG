package com.zavcoding.narutorpg.API.Events;

import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

public class ClanSignCreateEvent extends PlayerEvent implements Cancellable {

	Sign s;
	private Boolean isCancelled;
	private static final HandlerList handlers = new HandlerList();
	
	public ClanSignCreateEvent(Player who, Sign s) {
		super(who);
		this.s = s;
	}
	
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}

	@Override
	public boolean isCancelled() {
		return isCancelled;
	}

	@Override
	public void setCancelled(boolean b) {
		isCancelled = b;
		return;
	}
}
