package com.KK.iflwwos.block;

import com.KK.iflwwos.ItFeelsLikeWereWalkingOnSunshine;
import com.KK.iflwwos.block.custom.SmallUraniumBombBlock;
import com.KK.iflwwos.item.ModItemGroup;
import com.KK.iflwwos.item.ModItems;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ItFeelsLikeWereWalkingOnSunshine.MOD_ID);


    public static final RegistryObject<Block> URANIUM_ORE = registerBlock("uranium_ore",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(3).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(30.0F, 1200.0F).sound(SoundType.ANCIENT_DEBRIS)), ModItemGroup.EXPLOSION_ITEMS );

    public static final RegistryObject<Block> TITANIUM_ORE = registerBlock("titanium_ore",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(1).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(3.0F, 3.0F)), ModItemGroup.BEASTHUNTER_ITEMS );
    public static final RegistryObject<Block> SMALL_URANIUM_BOMB = registerBlock("small_uranium_bomb",
            () -> new SmallUraniumBombBlock(AbstractBlock.Properties.create(Material.IRON)
                    .setRequiresTool().notSolid().hardnessAndResistance(1f)), ModItemGroup.EXPLOSION_ITEMS);

    public static final RegistryObject<Block> BLOCK_OF_URANIUM = registerBlock("block_of_uranium",
            () -> new Block(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestTool(ToolType.PICKAXE).hardnessAndResistance(5f)), ModItemGroup.EXPLOSION_ITEMS);
    public static final RegistryObject<Block> BLOCK_OF_TITANIUM = registerBlock("block_of_titanium",
            () -> new Block(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestTool(ToolType.PICKAXE).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)), ModItemGroup.BEASTHUNTER_ITEMS);
    public static final RegistryObject<Block> BLOCK_OF_THERMIUM = registerBlock("block_of_thermium",
            () -> new Block(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestTool(ToolType.PICKAXE).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.METAL)), ModItemGroup.THERMAL_SLUGGER_ITEMS);
    public static final RegistryObject<Block> MITHRIUM_ORE = registerBlock("mithrium_ore",
        () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                .harvestLevel(0).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(3.0F, 3.0F)), ModItemGroup.FAITH_ITEMS);
    public static final RegistryObject<Block> THERMIUM_ORE = registerBlock("thermium_ore",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(3.0F, 3.0F)), ModItemGroup.THERMAL_SLUGGER_ITEMS);
    public static final RegistryObject<Block> HEATED_THERMIUM_ORE = registerBlock("heated_thermium_ore",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(3.0F, 3.0F).setLightLevel((state) -> (state.getLightValue() + 3))), ModItemGroup.THERMAL_SLUGGER_ITEMS);
    public static final RegistryObject<Block> COOLED_THERMIUM_ORE = registerBlock("cooled_thermium_ore",
            () -> new Block(AbstractBlock.Properties.create(Material.ROCK)
                    .harvestLevel(2).harvestTool(ToolType.PICKAXE).setRequiresTool().hardnessAndResistance(3.0F, 3.0F)), ModItemGroup.THERMAL_SLUGGER_ITEMS);

    public static final RegistryObject<Block> BLOCK_OF_MITHRIUM = registerBlock("block_of_mithrium",
            () -> new Block(AbstractBlock.Properties.create(Material.MISCELLANEOUS)
                    .harvestTool(ToolType.PICKAXE).hardnessAndResistance(5f)), ModItemGroup.FAITH_ITEMS);

    private static <T extends Block>RegistryObject<T> registerBlock(String name, Supplier<T> block, ItemGroup ItemGroup) {
RegistryObject<T> toReturn = BLOCKS.register(name, block);
registerBlockItem(name, toReturn, ItemGroup);
return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block, ItemGroup ItemGroup) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().group(ItemGroup)));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
