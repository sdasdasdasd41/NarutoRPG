package com.zavcoding.narutorpg.Clans;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URLClassLoader;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import com.zavcoding.narutorpg.NarutoRPG;

public class ClanLoader {
	
	NarutoRPG plugin;

	public ClanLoader(NarutoRPG instance) {
		plugin = instance;
		}

	@SuppressWarnings("resource")
	public List<Clan> load() {
		List<Clan> list = new ArrayList<Clan>();

		// Check if folder exists
		if (plugin.clanClassFolder == null) {
			plugin.logger.warning("No clans found in the classes folder. This plugin will only use the default clans.");
			return list;
			}

		// Create Class Loader Instance
		ClassLoader loader;
		try {
			loader = new URLClassLoader(new URL[] { plugin.clanClassFolder.toURI().toURL() }, Clan.class.getClassLoader());
			} catch (MalformedURLException ex) {
				plugin.logger.warning("Clans have failed to load.");
				return list;
				}

		// Load the class files

		for (File f : plugin.clanClassFolder.listFiles()) {
			if (!f.getName().endsWith(".class")) { // Make Sure to only load class files
				continue;
				}

			String name = f.getName().substring(0,
					f.getName().lastIndexOf("."));

			try {
				Class<?> clazz = loader.loadClass(name);
				Object object = clazz.newInstance();
				if (!(object instanceof Clan)) {
					plugin.logger.info("This file is not a valid Clan file: " + clazz.getSimpleName());
					continue;
					}
				Clan clan = (Clan) object;
				clan.onEnable();
				list.add(clan);
				plugin.logger.info("Loaded clan: "+ list.getClass().getSimpleName());

				/*
				 * Used to catch any errors with loading
				 * It will skip the clan
				 */

			} catch (Exception ex) {
				plugin.logger.info("Error loading '" + name + "' clan! Clan disabled.");
				} catch (Error ex) {
					plugin.logger.info("Error loading '" + name + "' clan! Clan disabled.");
					}

		}
		return list;
		}
	}