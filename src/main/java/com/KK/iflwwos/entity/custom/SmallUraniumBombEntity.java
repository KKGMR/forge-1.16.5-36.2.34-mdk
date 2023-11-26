package com.KK.iflwwos.entity.custom;

import com.KK.iflwwos.entity.ModEntityTypes;
import com.KK.iflwwos.potion.ModPotions;
import net.minecraft.entity.*;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.play.server.SSpawnObjectPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import javax.annotation.Nullable;


public class SmallUraniumBombEntity extends Entity {
    @Nullable
    private LivingEntity igniter;


    public SmallUraniumBombEntity(EntityType<? extends Entity> type, World world, double x, double y, double z, @Nullable LivingEntity igniter) {
        super(type, world);
        this.setPosition(x, y, z);
        double d0 = world.rand.nextDouble() * (double)((float)Math.PI * 2F);
        this.setMotion(-Math.sin(d0) * 0.02D, (double)0.2F, -Math.cos(d0) * 0.02D);
        this.prevPosX = x;
        this.prevPosY = y;
        this.prevPosZ = z;
        this.igniter = igniter;
    }

    public SmallUraniumBombEntity(EntityType<?> entityTypeIn, World worldIn) {
        super(entityTypeIn, worldIn);
        this.preventEntitySpawning = true;
    }


    protected boolean canTriggerWalking() {
        return false;
    }

    /**
     * Returns true if other Entities should be prevented from moving through this Entity.
     */
    public boolean canBeCollidedWith() {
        return !this.removed;
    }

    @Override
    protected void readAdditional(CompoundNBT compound) {

    }

    @Override
    protected void writeAdditional(CompoundNBT compound) {

    }

    @Override
    protected void registerData() {

    }

    /**
     * Called to update the entity's position/logic.
     */
    public void tick() {
        if (!this.hasNoGravity()) {
            this.setMotion(this.getMotion().add(0.0D, -0.04D, 0.0D));
        }

        this.move(MoverType.SELF, this.getMotion());
        this.setMotion(this.getMotion().scale(0.98D));
        if (this.onGround) {
            this.setMotion(this.getMotion().mul(0.7D, -0.5D, 0.7D));
        }

        if (this.onGround) {
            this.remove();
            if (!this.world.isRemote) {
                this.explode();
            }
        } else {
            this.func_233566_aG_();
            if (this.world.isRemote) {
                this.world.addParticle(ParticleTypes.SMOKE, this.getPosX(), this.getPosY() + 0.5D, this.getPosZ(), 0.0D, 0.0D, 0.0D);
            }
        }

    }

    private void makeAreaOfEffectCloud() {
        AreaEffectCloudEntity areaeffectcloudentity = new AreaEffectCloudEntity(this.world, this.getPosX(), this.getPosY(), this.getPosZ());
        Entity entity = this.igniter;
        if (entity instanceof LivingEntity) {
            areaeffectcloudentity.setOwner((LivingEntity) entity);
        }

        areaeffectcloudentity.setRadius(8.0F);
        areaeffectcloudentity.setRadiusOnUse(-0.5F);
        areaeffectcloudentity.setWaitTime(30);
        areaeffectcloudentity.setRadiusPerTick(-areaeffectcloudentity.getRadius() / (float) areaeffectcloudentity.getDuration());
        areaeffectcloudentity.setPotion(ModPotions.RADIATION_POTION.get());
    }

    protected void explode() {
        float f = 8.0F;
        this.world.createExplosion(this, this.getPosX(), this.getPosYHeight(0.0625D), this.getPosZ(), 4.0F, Explosion.Mode.BREAK);
        this.makeAreaOfEffectCloud();
    }



    @Nullable
    public LivingEntity getIgniter() {
        return this.igniter;
    }

    protected float getEyeHeight(Pose poseIn, EntitySize sizeIn) {
        return 0.15F;
    }


    /**
     * Gets the fuse from the data manager
     */
    public IPacket<?> createSpawnPacket() {
        return new SSpawnObjectPacket(this);
    }

}
