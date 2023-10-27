package com.KK.iflwwos.effect;


import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.FoodStats;

import java.util.Random;


public class RadiationEffect extends Effect {

    Random random = new Random();
    protected RadiationEffect(EffectType typeIn, int liquidColorIn) {
        super(typeIn, liquidColorIn);
    }

    @Override
    public void performEffect(LivingEntity entityLivingBaseIn, int amplifier) {
        if (entityLivingBaseIn instanceof PlayerEntity) {
            int PoisonCounter = random.nextInt(150);
            if (PoisonCounter == 149) {
                FoodStats food = ((PlayerEntity) entityLivingBaseIn).getFoodStats();
                food.setFoodLevel(food.getFoodLevel() - amplifier*2);
                if (food.getFoodLevel() > 0){
                    if (entityLivingBaseIn.getHealth() > 2) {
                        entityLivingBaseIn.attackEntityFrom(DamageSource.MAGIC, amplifier * 2);
                    } else if (entityLivingBaseIn.getHealth() > 1){
                        entityLivingBaseIn.attackEntityFrom(DamageSource.MAGIC, amplifier);
                    } else {
                        food.setFoodLevel(food.getFoodLevel() - amplifier*2);
                    }
                }else {
                entityLivingBaseIn.attackEntityFrom(DamageSource.MAGIC, amplifier * 2);
            }
            }
        }
        else {
            radiationDamage(entityLivingBaseIn, amplifier);
        }
    }

    private void radiationDamage(LivingEntity entityLivingBaseIn, int amplifier) {
        int PoisonCounter = random.nextInt(150);
        if (PoisonCounter == 149) {
            entityLivingBaseIn.attackEntityFrom(DamageSource.MAGIC, amplifier * 2);
        }
    }


    @Override
    public boolean isReady(int duration, int amplifier) {
        return true;
    }
}
