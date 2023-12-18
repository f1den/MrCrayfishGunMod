package com.mrcrayfish.guns.item;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

/**
 * An item class that implements {@link IMagazine} to indicate this item is magazine,
 * and making some shit:)
 *
 * Author: f1den (N[i]ghtly)
 */

public class MagazineItem extends Item implements IMagazine {
    private final int maxBullets;

    public MagazineItem(Properties properties, int maxBullets) {
        super(properties);
        this.maxBullets = maxBullets;
    }

    @Override
    public boolean isDamageable(ItemStack stack) {
        return true; // Allow the item to take damage
    }

    @Override
    public int getMaxDamage(ItemStack stack) {
        return this.maxBullets; // Set the maximum durability to 32
    }

    @Override
    public boolean canBeDepleted() {
        return true; // Allow the item to be depleted
    }

    @Override
    public ItemStack getDefaultInstance() {
        ItemStack stack = new ItemStack(this);
        stack.getOrCreateTag().putInt("BulletsStored", this.maxBullets); // Set the initial durability to 32
        return stack;
    }

    @Override
    public boolean shouldCauseBlockBreakReset(ItemStack oldStack, ItemStack newStack) {
        return false; // Prevent the item from breaking if the durability is 0
    }
}
