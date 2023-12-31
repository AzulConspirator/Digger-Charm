package dev.azulc.diggercharm;

import io.github.ladysnake.pal.AbilitySource;
import io.github.ladysnake.pal.Pal;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;

public class ShulkerCharm implements ModInitializer {
	public static final String MODID = "diggercharm";

	public static final Identifier CHARM_FLIGHT_ID = new Identifier(MODID, "shulker_charm_flight");

	public static final AbilitySource CHARM_FLIGHT = Pal.getAbilitySource(CHARM_FLIGHT_ID);

	public static final Item SHULKER_CHARM = Registry.register(Registries.ITEM, new Identifier(MODID, "digger_charm"), new ShulkerCharmItem(new Item.Settings().maxCount(1).rarity(Rarity.RARE)));

	public static ShulkerCharmConfig config;

	@Override
	public void onInitialize() {
		AutoConfig.register(ShulkerCharmConfig.class, JanksonConfigSerializer::new);

		ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(content -> {
			content.add(SHULKER_CHARM);
		});

		config = AutoConfig.getConfigHolder(ShulkerCharmConfig.class).getConfig();
		if (config.maxEnergy != -1) {
			config.maxPower = config.maxEnergy;
			config.maxEnergy = -1;
		}
	}

}
