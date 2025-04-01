package net.elipsce.tutorialmod.block.entity;

import net.elipsce.tutorialmod.TutorialMod;
import net.elipsce.tutorialmod.block.ModBlocks;
import net.elipsce.tutorialmod.block.entity.custom.PedestalBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<PedestalBlockEntity> PEDESTAL_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(TutorialMod.MOD_ID, "pedestal_be"),
                    FabricBlockEntityTypeBuilder.create(PedestalBlockEntity::new, ModBlocks.PEDESTAL).build());

    public static void registerBlockEntities() {
        TutorialMod.LOGGER.info("Registering Block Entities for " + TutorialMod.MOD_ID);
    }
}
