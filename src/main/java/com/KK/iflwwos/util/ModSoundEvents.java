package com.KK.iflwwos.util;

import com.KK.iflwwos.ItFeelsLikeWereWalkingOnSunshine;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModSoundEvents {

public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, ItFeelsLikeWereWalkingOnSunshine.MOD_ID);

public static final RegistryObject<SoundEvent> SMALL_EXPLOSION =
        registerSoundEvent("small_explosion");

private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
    return SOUND_EVENTS.register(name, () -> new SoundEvent(new ResourceLocation(ItFeelsLikeWereWalkingOnSunshine.MOD_ID, name)));
}

public static void register(IEventBus eventBus) {
    SOUND_EVENTS.register(eventBus);
}

}
