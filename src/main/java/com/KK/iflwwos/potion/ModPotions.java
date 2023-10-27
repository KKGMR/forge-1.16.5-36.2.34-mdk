package com.KK.iflwwos.potion;

import com.KK.iflwwos.ItFeelsLikeWereWalkingOnSunshine;
import com.KK.iflwwos.effect.ModEffects;
import net.minecraft.advancements.criterion.MobEffectsPredicate;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.potion.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModPotions {

    public static final DeferredRegister<Potion> POTIONS = DeferredRegister.create(ForgeRegistries.POTION_TYPES, ItFeelsLikeWereWalkingOnSunshine.MOD_ID);

public static final RegistryObject<Potion> RADIATION_POTION = POTIONS.register("radiation_potion", ()-> new Potion(new EffectInstance(ModEffects.RADIATION.get(), 600, 1)));

    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
