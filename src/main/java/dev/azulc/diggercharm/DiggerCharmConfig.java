package dev.azulc.diggercharm;

import blue.endless.jankson.Comment;

public class ShulkerCharmConfig {
	@Comment("""
			The modifier for the maximum distance from a beacon to keep charging.
			Formula is <beacon level> * <modifier> + 10.
			Vanilla range modifier is 10; set to -1 to disable charge requirement.""")
	public int rangeModifier = 10;

	@Comment("""
			The maximum amount of power a shulker charm can store.
			Charm gains 20 energy per second when in beacon range,
			and loses 20 energy per second when out of it.
			Default value 1200 (60 seconds).""")
	public int maxPower = 1200;
}
