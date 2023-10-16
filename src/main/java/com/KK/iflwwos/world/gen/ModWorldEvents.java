package com.KK.iflwwos.world.gen;

import com.KK.iflwwos.ItFeelsLikeWereWalkingOnSunshine;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ItFeelsLikeWereWalkingOnSunshine.MOD_ID)
public class ModWorldEvents {

    @SubscribeEvent
    public static void  biomeLoadingEvent(final BiomeLoadingEvent event) {
ModOreGeneration.generateOres(event);
    }

}
