package com.KK.iflwwos.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.stream.Stream;

public class SmallUraniumBombBlock extends HorizontalBlock {
    public SmallUraniumBombBlock(Properties builder) {
        super(builder);
    }

    private static final VoxelShape SHAPE = Stream.of(
            Block.makeCuboidShape(3, 0, 12.5, 3.5, 3, 13),
            Block.makeCuboidShape(3, 0, 3, 3.5, 3, 3.5),
            Block.makeCuboidShape(12.5, 0, 12.5, 13, 3, 13),
            Block.makeCuboidShape(12.5, 0, 3, 13, 3, 3.5),
            Block.makeCuboidShape(6, 12, 6, 10, 14, 10),
            Block.makeCuboidShape(2, 6, 2, 14, 10, 14),
            Block.makeCuboidShape(3, 3, 3, 13, 13, 13)
    ).reduce((v1, v2) -> VoxelShapes.combineAndSimplify(v1, v2, IBooleanFunction.OR)).get();

    @Override
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        return SHAPE;
    }

    @Override
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {

        if(!worldIn.isRemote) {
            smallBombExplosion(worldIn, player, pos);
        }
        return super.onBlockActivated(state, worldIn, pos, player, handIn, hit);
    }

    private void smallBombExplosion(World world, Entity player, BlockPos pos) {
        world.createExplosion(player, pos.getX(), pos.getY(), pos.getZ(), 4, true, Explosion.Mode.DESTROY);
        world.removeBlock(pos, false);
    }


    @Override
    public void onExplosionDestroy(World worldIn, BlockPos pos, Explosion explosionIn) {
        super.onExplosionDestroy(worldIn, pos, explosionIn);
    }

    @Override
    public void onBlockExploded(BlockState state, World world, BlockPos pos, Explosion explosion) {;
        Entity entity = explosion.getExplosivePlacedBy();
        smallBombExplosion(world, entity, pos);
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        builder.add(HORIZONTAL_FACING);
    }

    @Nullable
    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        return this.getDefaultState().with(HORIZONTAL_FACING, context.getPlacementHorizontalFacing().getOpposite());
    }
}
