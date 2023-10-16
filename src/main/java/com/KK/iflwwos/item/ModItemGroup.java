package com.KK.iflwwos.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {
    public static final ItemGroup FAITH_ITEMS = new ItemGroup("faithTab") {

        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(ModItems.MITHRIUM.get());
        }
    };

    public static final ItemGroup EXPLOSION_ITEMS = new ItemGroup("explosionTab") {

        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(ModItems.URANIUM_INGOT.get());
        }
    };

    public static final ItemGroup BEASTHUNTER_ITEMS = new ItemGroup("beastHunterTab") {

        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(ModItems.TITANIUM_INGOT.get());
        }
    };
}
