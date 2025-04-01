package net.elipsce.tutorialmod;

import net.elipsce.tutorialmod.block.ModBlocks;
import net.elipsce.tutorialmod.block.entity.ModBlockEntities;
import net.elipsce.tutorialmod.item.ModItemGroups;
import net.elipsce.tutorialmod.item.ModItems;
import net.elipsce.tutorialmod.screen.ModScreenHandlers;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TutorialMod implements ModInitializer {
	public static final String MOD_ID = "tutorialmod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();
		ModBlockEntities.registerBlockEntities();
		ModScreenHandlers.registerScreenHandlers();
	}
}