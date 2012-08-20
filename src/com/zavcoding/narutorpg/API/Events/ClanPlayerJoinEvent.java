package com.zavcoding.narutorpg.API.Events;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

import com.zavcoding.narutorpg.Clans.Clan;

public class ClanPlayerJoinEvent extends PlayerEvent implements Cancellable {
	
	private Clan oldClan;
	private Clan newClan;
	private Boolean isCancelled;
	
	public ClanPlayerJoinEvent(Player who, Clan oldClan, Clan newClan) {
		super(who);
		this.oldClan = oldClan;
		this.newClan = newClan;
	}
	
	private static final HandlerList handlers = new HandlerList();
	
	@Override
	public HandlerList getHandlers() {
		return handlers;
	}
	
	public Clan getNewClan() {
		return newClan;
	}
	
	public Clan getOldClan() {
		return oldClan;
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
