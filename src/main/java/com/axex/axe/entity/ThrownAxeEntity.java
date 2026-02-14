package com.axex.axe.entity;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.projectile.ThrownItemProjectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ThrownAxeEntity extends ThrownItemProjectile {

    private float baseDamage = 10F;

    public ThrownAxeEntity(EntityType<? extends ThrownAxeEntity> type, Level level) {
        super(type, level);
    }

    public ThrownAxeEntity(Level level, LivingEntity thrower) {
        super(EntityType.SNOWBALL, thrower, level); // reuse simple projectile type
    }

    public void setBaseDamage(float damage) {
        this.baseDamage = damage;
    }

    @Override
    protected ItemStack getDefaultItem() {
        return ItemStack.EMPTY;
    }

    @Override
    protected void onHitEntity(EntityHitResult result) {
        Entity entity = result.getEntity();
        entity.hurt(damageSources().thrown(this, this.getOwner()), baseDamage);
        discard();
    }

    @Override
    protected void onHitBlock(BlockHitResult result) {
        discard();
    }

    @Override
    public void addAdditionalSaveData(CompoundTag tag) {
        tag.putFloat("Damage", baseDamage);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag tag) {
        baseDamage = tag.getFloat("Damage");
    }
}
