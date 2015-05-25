// Copyright (c) 2015, Christopher "blay09" Baker
// Some rights reserved.

package net.blay09.mods.eiramoticons;

import net.minecraft.client.resources.I18n;
import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class EmoticonConfig {

	public static final String GENERAL = "general";
	public static final String TWITCH = "twitch";
	public static final String ADDONS = "addons";
	public static final String TWEAKS = "tweaks";

	public static Configuration config;
	public static File configFile;

	public static boolean enableMCEmotes;

	public static boolean twitchGlobalEmotes;
	public static boolean twitchTurboEmotes;
	public static boolean twitchSubscriberEmotes;
	public static String twitchSubscriberRegex;
	public static boolean bttvEmotes;
	public static boolean twitchSmileys;
	public static int twitchSmileySet;

	public static boolean defaultEmotes;
	public static boolean enableIRCEmotes;

	public static boolean betterKappas;

	public static void loadFromFile(File configFile) {
		EmoticonConfig.configFile = configFile;
		config = new Configuration(configFile);
		loadFromConfig();
	}

	private static void loadFromConfig() {
		enableMCEmotes = config.getBoolean("enableMCEmotes", GENERAL, true, I18n.format("eiramoticons:config.enableMCEmotes.tooltip"), "eiramoticons:config.enableMCEmotes");

		twitchGlobalEmotes = config.getBoolean("twitchGlobalEmotes", TWITCH, true, I18n.format("eiramoticons:config.twitchGlobalEmotes.tooltip"), "eiramoticons:config.twitchGlobalEmotes");
		twitchTurboEmotes = config.getBoolean("twitchTurboEmotes", TWITCH, true, I18n.format("eiramoticons:config.twitchTurboEmotes.tooltip"), "eiramoticons:config.twitchTurboEmotes");
		twitchSubscriberEmotes = config.getBoolean("twitchSubscriberEmotes", TWITCH, true, I18n.format("eiramoticons:config.twitchSubscriberEmotes.tooltip"), "eiramoticons:config.twitchSubscriberEmotes");
		twitchSubscriberRegex = config.getString("twitchSubscriberRegex", TWITCH, "[a-z0-9][a-z0-9]+[A-Z].*", I18n.format("eiramoticons:config.twitchSubscriberRegex.tooltip"), "eiramoticons:config.twitchSubscriberRegex");
		bttvEmotes = config.getBoolean("bttvEmotes", TWITCH, true, I18n.format("eiramoticons:config.bttvEmotes.tooltip"), "eiramoticons:config.bttvEmotes");
		twitchSmileys = config.getBoolean("twitchSmileys", TWITCH, false, I18n.format("eiramoticons:config.twitchSmileys.tooltip"), "eiramoticons:config.twitchSmileys");
		twitchSmileySet = config.getInt("twitchSmileySet", TWITCH, 0, 0, 2, I18n.format("eiramoticons:config.twitchSmileySet.tooltip"), "eiramoticons:config.twitchSmileySet");

		defaultEmotes = config.getBoolean("defaultEmotes", ADDONS, true, I18n.format("eiramoticons:config.defaultEmotes.tooltip"), "eiramoticons:config.defaultEmotes");
		enableIRCEmotes = config.getBoolean("enableIRCEmotes", ADDONS, true, I18n.format("eiramoticons:config.enableIRCEmotes.tooltip"), "eiramoticons:config.enableIRCEmotes");

		betterKappas = config.getBoolean("betterKappas", TWEAKS, false, I18n.format("eiramoticons:config.betterKappas.tooltip"), "eiramoticons:config.betterKappas");

		config.save();
	}

	public static void lightReload() {
		loadFromConfig();
	}

	public static void hardReload() {
		loadFromFile(configFile);
	}
}
