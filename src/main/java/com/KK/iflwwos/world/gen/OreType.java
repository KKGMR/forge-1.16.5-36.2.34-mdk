package com.KK.iflwwos.world.gen;

import com.KK.iflwwos.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraftforge.common.util.Lazy;

public enum OreType {

    MITHRIUM(Lazy.of(ModBlocks.MITHRIUM_ORE), 10, 50, 128),
    URANIUM(Lazy.of(ModBlocks.URANIUM_ORE), 3, 0, 16);

    private final Lazy<Block> block;
    private final int maxVeinSize;
    private final int minHeight;
    private final int maxHeight;


    OreType(Lazy<Block> block, int maxVeinSize, int minHeight, int maxHeight) {
        this.block = block;
        this.maxVeinSize = maxVeinSize;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
    }

    public Lazy<Block> getBlock() {
        return block;
    }

    public int getMaxVeinSize() {
        return maxVeinSize;
    }

    public int getMinHeight() {
        return minHeight;
    }

    public int getMaxHeight() {
        return maxHeight;
    }
    public static OreType get(Block block) {
        for (OreType ore : values()) {
            if (block == ore.block){
                return ore;
            }
        }

        return null;

    }

}
