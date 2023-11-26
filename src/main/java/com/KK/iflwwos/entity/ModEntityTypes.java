package com.KK.iflwwos.entity;

import com.KK.iflwwos.ItFeelsLikeWereWalkingOnSunshine;

import com.KK.iflwwos.entity.custom.SmallUraniumBombEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.ENTITIES, ItFeelsLikeWereWalkingOnSunshine.MOD_ID);

    public static final RegistryObject<EntityType<Entity>> SMALL_URANIUM_BOMB_ENTITY =
            ENTITY_TYPES.register("Small_uranium_bomb_entity", () -> EntityType.Builder.create(SmallUraniumBombEntity::new,
                            EntityClassification.MISC).size(1,1)
                    .build(new ResourceLocation(ItFeelsLikeWereWalkingOnSunshine.MOD_ID, "small_uranium_bomb_entity").toString()));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
