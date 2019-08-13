package lykrast.glassential.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.GlassBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;

public class EtherealGlassBlock extends GlassBlock {

    private final boolean collideOnSneaking;

    public EtherealGlassBlock(Block.Properties properties, boolean collideOnSneaking) {
        super(properties);
        this.collideOnSneaking = collideOnSneaking;
    }

    @Override
    public VoxelShape getCollisionShape(BlockState state, IBlockReader world, BlockPos pos, ISelectionContext context) {
        return context.isSneaking() == collideOnSneaking ? state.getShape(world, pos) : VoxelShapes.empty();
    }
}