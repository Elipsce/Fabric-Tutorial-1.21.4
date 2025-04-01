package net.elipsce.tutorialmod.block;

import net.elipsce.tutorialmod.TutorialMod;
import net.elipsce.tutorialmod.block.custom.MagicBlock;
import net.elipsce.tutorialmod.block.custom.PedestalBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

import java.util.function.Function;

public class ModBlocks {

    public static final Block PINK_GARNET_BLOCK = register("pink_garnet_block", Block::new, Block.Settings.create().strength(4f)
            .requiresTool()
            .sounds(BlockSoundGroup.AMETHYST_BLOCK));
    public static final Block RAW_PINK_GARNET_BLOCK = register("raw_pink_garnet_block", Block::new, Block.Settings.create().strength(3f)
            .requiresTool()
            .sounds(BlockSoundGroup.AMETHYST_BLOCK));
    public static final Block PINK_GARNET_ORE = register("pink_garnet_ore", settings -> new ExperienceDroppingBlock(UniformIntProvider.create(2, 5), settings), Block.Settings.create().strength(3f).requiresTool());
    public static final Block PINK_GARNET_DEEPSLATE_ORE = register("pink_garnet_deepslate_ore", settings -> new ExperienceDroppingBlock(UniformIntProvider.create(3, 6), settings), Block.Settings.create().strength(4f).requiresTool().sounds(BlockSoundGroup.DEEPSLATE));
    public static final Block MAGIC_BLOCK = register("magic_block", MagicBlock::new, Block.Settings.create().strength(3f).requiresTool());


    public static final Block PEDESTAL = register("pedestal", PedestalBlock::new, Block.Settings.create().nonOpaque());


    private static Block register(String path, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        final Identifier identifier = Identifier.of("tutorialmod", path);
        final RegistryKey<Block> registryKey = RegistryKey.of(RegistryKeys.BLOCK, identifier);

        final Block block = Blocks.register(registryKey, factory, settings);
        registerBlockItem(path, block);
        return block;
    }

    private static Block registerExperienceBlock(String name, AbstractBlock.Settings blockSettings, int min, int max) {
        RegistryKey<Block> key = RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(TutorialMod.MOD_ID, name));
        Block block = new ExperienceDroppingBlock(UniformIntProvider.create(min, max), blockSettings.registryKey(key));
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, key, block);
    }

    private static void registerBlockItem(String name, Block block) {
        RegistryKey<Item> key = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(TutorialMod.MOD_ID, name));
        BlockItem item = new BlockItem(block, new Item.Settings().registryKey(key));
        Registry.register(Registries.ITEM, key, item);
    }

    public static void registerModBlocks() {
        TutorialMod.LOGGER.info("Registering Mod Blocks for " + TutorialMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlocks.PINK_GARNET_BLOCK);
            fabricItemGroupEntries.add(ModBlocks.RAW_PINK_GARNET_BLOCK);
        });
    }
}
