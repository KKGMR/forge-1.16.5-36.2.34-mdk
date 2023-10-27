package com.KK.iflwwos.effect;

import com.KK.iflwwos.ItFeelsLikeWereWalkingOnSunshine;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEffects {
    public static final DeferredRegister<Effect> MOB_EFFECTS
            = DeferredRegister.create(ForgeRegistries.POTIONS, ItFeelsLikeWereWalkingOnSunshine.MOD_ID);

    public static final RegistryObject<Effect> RADIATION = MOB_EFFECTS.register("radiation", () -> new RadiationEffect(EffectType.HARMFUL, 4390687));

    public static void register(IEventBus eventBus) {
        MOB_EFFECTS.register(eventBus);
    }
}
