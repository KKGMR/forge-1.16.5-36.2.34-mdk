package com.KK.iflwwos.item.custom;

import com.KK.iflwwos.item.ModItems;
import com.KK.iflwwos.util.ModSoundEvents;
import com.sun.jna.platform.win32.WinBase;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.Explosion;
import net.minecraft.world.ExplosionContext;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public class PowerGlove extends Item {
    Random rand = new Random();

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return false;
    }


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
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
        World world = entity.getEntityWorld();
        if ((getDamage(stack) < 4)) {particleRing(world, entity);}
        if ((!world.isRemote) && (getDamage(stack) < 4)) {
            ExplosionContext explosionContext = null;
            DamageSource damageSource = DamageSource.causePlayerDamage(player);
            explode(world, player, damageSource, explosionContext, entity);
            setDamage(stack, getDamage(stack) + 1);
        }

        return super.onLeftClickEntity(stack, player, entity);
    }



    @Override
    public ActionResult<ItemStack> onItemRightClick(World world, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getHeldItemMainhand();
        if ((getDamage(stack) < 4)) {
            charge(player);
            player.playSound(ModSoundEvents.SMALL_EXPLOSION.get(), 7, -5);
            setDamage(stack, getDamage(stack) + 1);

        }
        return super.onItemRightClick(world, player, hand);
    }


    private void explode(World world, PlayerEntity player, DamageSource damageSource, ExplosionContext explosionContext, Entity entity) {
        Explosion.Mode blockInteraction = null;
        world.createExplosion(player, damageSource, explosionContext, entity.getPosX(),entity.getPosY(), entity.getPosZ(), 8.0F, false, blockInteraction);
    }

    private void particleRing(World world, Entity entity) {
        for (int i = 0; i < 3600; i++) {
            int choiceX = rand.nextInt(2);
            int choiceZ = rand.nextInt(2);
            int choiceY = rand.nextInt(2);

            if (choiceX == 1) {
                choiceX = -1;
            } else {
                choiceX = 1;
            }
            if (choiceZ == 1) {
                choiceZ = -1;
            } else {
                choiceZ = 1;
            }
            if (choiceY == 1) {
                choiceY = -1;
            } else {
                choiceY = 1;
            }

            double x = Math.random() * choiceX;
            double z = Math.random() * choiceZ;
            double y = Math.random() * choiceY * 0.25;


                world.addParticle(ParticleTypes.CAMPFIRE_COSY_SMOKE, entity.getPosX(), entity.getPosY(), entity.getPosZ(), x, y, z);
            }


        }

    private void charge(PlayerEntity player) {
        float yaw = player.rotationYaw;
        float pitch = player.rotationPitch;
        float f = 5;
        double motionX = (-MathHelper.sin(yaw / 180.0F * (float)Math.PI) * MathHelper.cos(pitch / 180.0F * (float)Math.PI) * f);
        double motionZ = (MathHelper.cos(yaw / 180.0F * (float)Math.PI) * MathHelper.cos(pitch / 180.0F * (float)Math.PI) * f);
        double motionY = (-MathHelper.sin((pitch) / 180.0F * (float)Math.PI) * f);
        player.addVelocity(motionX, motionY, motionZ);
        player.addPotionEffect(new EffectInstance(Effects.SLOW_FALLING, 200, 1, false, false));
    }


}
