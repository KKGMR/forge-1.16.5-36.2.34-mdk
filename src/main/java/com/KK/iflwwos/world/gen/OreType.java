package com.KK.iflwwos.world.gen;

import com.KK.iflwwos.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraftforge.common.util.Lazy;

public enum OreType {

    MITHRIUM_HIGH(Lazy.of(ModBlocks.MITHRIUM_ORE), 10, 90, 128, 3),
    MITHRIUM_LOW(Lazy.of(ModBlocks.MITHRIUM_ORE), 10, 50, 89, 1),
    MITHRIUM_MOUNTAINS(Lazy.of(ModBlocks.MITHRIUM_ORE), 10, 50, 128, 2),
    URANIUM(Lazy.of(ModBlocks.URANIUM_ORE), 3, 0, 16, 5),
    THERMIUM(Lazy.of(ModBlocks.THERMIUM_ORE), 8, 4, 48, 2),
    HEATED_THERMIUM_IN_ALL(Lazy.of(ModBlocks.HEATED_THERMIUM_ORE), 1, 1, 48, 8),
    HEATED_THERMIUM_IN_HOT(Lazy.of(ModBlocks.HEATED_THERMIUM_ORE), 8, 4, 48, 2),
    HEATED_THERMIUM_IN_NETHER(Lazy.of(ModBlocks.HEATED_THERMIUM_ORE), 8, 0, 128, 8),
    COOLED_THERMIUM_IN_ALL(Lazy.of(ModBlocks.COOLED_THERMIUM_ORE), 1, 48, 128, 8),
    COOLED_THERMIUM_IN_COLD(Lazy.of(ModBlocks.COOLED_THERMIUM_ORE), 8, 4, 48, 2),
    TITANIUM(Lazy.of(ModBlocks.TITANIUM_ORE), 8, 1, 64,3);

    private final Lazy<Block> block;
    private final int maxVeinSize;
    private final int minHeight;
    private final int maxHeight;

    public int getVeinsPerChunk() {
        return veinsPerChunk;
    }

    private final int veinsPerChunk;


    OreType(Lazy<Block> block, int maxVeinSize, int minHeight, int maxHeight, int veinsPerChunk) {
        this.block = block;
        this.maxVeinSize = maxVeinSize;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        this.veinsPerChunk = veinsPerChunk;
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
