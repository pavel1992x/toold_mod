
package net.mcreator.newwm.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.item.crafting.Ingredient;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.IItemTier;
import net.minecraft.item.HoeItem;

import net.mcreator.newwm.NewWmModElements;

@NewWmModElements.ModElement.Tag
public class StillHoeItem extends NewWmModElements.ModElement {
	@ObjectHolder("new_wm:still_hoe")
	public static final Item block = null;
	public StillHoeItem(NewWmModElements instance) {
		super(instance, 11);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new HoeItem(new IItemTier() {
			public int getMaxUses() {
				return 100000;
			}

			public float getEfficiency() {
				return 11f;
			}

			public float getAttackDamage() {
				return 78f;
			}

			public int getHarvestLevel() {
				return 8;
			}

			public int getEnchantability() {
				return 50;
			}

			public Ingredient getRepairMaterial() {
				return Ingredient.fromStacks(new ItemStack(StillIngotItem.block, (int) (1)));
			}
		}, 0, -4f, new Item.Properties().group(ItemGroup.TOOLS)) {
		}.setRegistryName("still_hoe"));
	}
}
