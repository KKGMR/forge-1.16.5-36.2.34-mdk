package com.KK.iflwwos.item.custom;

import com.KK.iflwwos.item.ModItems;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.Explosion;
import net.minecraft.world.ExplosionContext;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.UUID;

public class PowerGlove extends Item {
    private static final UUID funny = null;

    @Override
    public boolean showDurabilityBar(ItemStack stack) {
        return false;
    }

    public PowerGlove(Properties properties) {
        super(properties);
    }

    @Override
    public boolean getIsRepairable(ItemStack par1ItemStack, ItemStack par2ItemStack)
    {
        return par2ItemStack.isItemEqual(new ItemStack(ModItems.URANIUM_INGOT.get(), 1)) || super.getIsRepairable(par1ItemStack, par2ItemStack);
    }

    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        tooltip.add(new TranslationTextComponent("tooltip.iflwwos.power_glove"));
    }

    @Override
    public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
        PlayerEntity player = context.getPlayer();
        World world = context.getWorld();

        if ((!world.isRemote) && (getDamage(stack) < 4)) {
            charge(player, context, world);
        }

        return super.onItemUseFirst(stack, context);
    }

    private void charge(PlayerEntity player, ItemUseContext context, World world) {
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
        World world = entity.getEntityWorld();

        if ((!world.isRemote) && (getDamage(stack) < 4)) {
            ExplosionContext explosionContext = null;
            DamageSource damageSource = DamageSource.causePlayerDamage(player);
            explode(world, player, damageSource, explosionContext, entity);
            setDamage(stack, getDamage(stack) + 1);
        }

        return super.onLeftClickEntity(stack, player, entity);
    }

    private Object nothing() {
        return null;
    }




    private void explode(World world, PlayerEntity player, DamageSource damageSource, ExplosionContext explosionContext, Entity entity) {
        Explosion.Mode blockInteraction = null;
        world.createExplosion(player, damageSource, explosionContext, entity.getPosX(),entity.getPosY(), entity.getPosZ(), 8.0F, false, blockInteraction);
    }


}
