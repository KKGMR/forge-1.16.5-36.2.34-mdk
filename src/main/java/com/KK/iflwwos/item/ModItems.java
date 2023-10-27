package com.KK.iflwwos.item;

import com.KK.iflwwos.ItFeelsLikeWereWalkingOnSunshine;
import com.KK.iflwwos.item.custom.PowerGlove;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ItFeelsLikeWereWalkingOnSunshine.MOD_ID);


    public static final RegistryObject<Item> MITHRIUM = ITEMS.register("mithrium",
            () -> new Item(new Item.Properties().group(ModItemGroup.FAITH_ITEMS)));
    public static final RegistryObject<Item> URANIUM_CHUNK = ITEMS.register("uranium_chunk",
            () -> new Item(new Item.Properties().group(ModItemGroup.EXPLOSION_ITEMS)));
    public static final RegistryObject<Item> URANIUM_INGOT = ITEMS.register("uranium_ingot",
            () -> new Item(new Item.Properties().group(ModItemGroup.EXPLOSION_ITEMS)));
    public static final RegistryObject<Item> TITANIUM_INGOT = ITEMS.register("titanium_ingot",
            () -> new Item(new Item.Properties().group(ModItemGroup.BEASTHUNTER_ITEMS)));
    public static final RegistryObject<Item> URANIUM_NUGET = ITEMS.register("uranium_nugget",
            () -> new Item(new Item.Properties().group(ModItemGroup.EXPLOSION_ITEMS)));
    public static final RegistryObject<Item> MITHRIUM_NUGET = ITEMS.register("mithrium_nugget",
            () -> new Item(new Item.Properties().group(ModItemGroup.FAITH_ITEMS)));
    public static final RegistryObject<Item> TITANIUM_NUGET = ITEMS.register("titanium_nugget",
            () -> new Item(new Item.Properties().group(ModItemGroup.BEASTHUNTER_ITEMS)));
    public static final RegistryObject<Item> SMALL_URANIUM_CORE = ITEMS.register("small_uranium_core",
            () -> new Item(new Item.Properties().group(ModItemGroup.EXPLOSION_ITEMS)));

    public static final RegistryObject<Item> POWER_GLOVE = ITEMS.register("power_glove",
            () -> new PowerGlove(new Item.Properties().group(ModItemGroup.EXPLOSION_ITEMS).maxDamage(4)));



    public static void register(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }

}
