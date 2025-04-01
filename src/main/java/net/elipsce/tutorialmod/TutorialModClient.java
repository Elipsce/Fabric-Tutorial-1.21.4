package net.elipsce.tutorialmod;

import net.elipsce.tutorialmod.block.entity.ModBlockEntities;
import net.elipsce.tutorialmod.block.entity.renderer.PedestalBlockEntityRenderer;
import net.elipsce.tutorialmod.screen.ModScreenHandlers;
import net.elipsce.tutorialmod.screen.custom.PedestalScreen;
import net.fabricmc.api.ClientModInitializer;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;

public class TutorialModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockEntityRendererFactories.register(ModBlockEntities.PEDESTAL_BE, PedestalBlockEntityRenderer::new);
        HandledScreens.register(ModScreenHandlers.PEDESTAL_SCREEN_HANDLER, PedestalScreen::new);
    }
}
