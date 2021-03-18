package net.mcreator.newwm.procedures;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.newwm.NewWmModElements;
import net.mcreator.newwm.NewWmMod;

import java.util.Map;

@NewWmModElements.ModElement.Tag
public class FlyOnProcedure extends NewWmModElements.ModElement {
	public FlyOnProcedure(NewWmModElements instance) {
		super(instance, 34);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NewWmMod.LOGGER.warn("Failed to load dependency entity for procedure FlyOn!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity) {
			((PlayerEntity) entity).abilities.allowFlying = (true);
			((PlayerEntity) entity).sendPlayerAbilities();
		}
	}
}
