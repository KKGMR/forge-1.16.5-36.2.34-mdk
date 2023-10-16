package com.KK.iflwwos.util;

import com.KK.iflwwos.ItFeelsLikeWereWalkingOnSunshine;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

public class iflwwosTags {

    public static class Blocks {

        public static Tags.IOptionalNamedTag<Block> createTag(String name) {
           return BlockTags.createOptional(new ResourceLocation(ItFeelsLikeWereWalkingOnSunshine.MOD_ID, name));
        }

        public static Tags.IOptionalNamedTag<Block> createForgeTag(String name) {
            return BlockTags.createOptional(new ResourceLocation("forge", name));
        }

    }

    public static class Items {


        public static Tags.IOptionalNamedTag<Item> createTag(String name) {
            return ItemTags.createOptional(new ResourceLocation(ItFeelsLikeWereWalkingOnSunshine.MOD_ID, name));
        }

        public static Tags.IOptionalNamedTag<Item> createForgeTag(String name) {
            return ItemTags.createOptional(new ResourceLocation("forge", name));
        }

    }

}
