package net.mcreator.newwm.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.Entity;

import net.mcreator.newwm.NewWmModVariables;
import net.mcreator.newwm.NewWmModElements;
import net.mcreator.newwm.NewWmMod;

import java.util.Map;
import java.util.Collections;

@NewWmModElements.ModElement.Tag
public class LtpProcedure extends NewWmModElements.ModElement {
	public LtpProcedure(NewWmModElements instance) {
		super(instance, 39);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				NewWmMod.LOGGER.warn("Failed to load dependency entity for procedure Ltp!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NewWmMod.LOGGER.warn("Failed to load dependency world for procedure Ltp!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		IWorld world = (IWorld) dependencies.get("world");
		{
			Entity _ent = entity;
			_ent.setPositionAndUpdate((NewWmModVariables.WorldVariables.get(world).x), (NewWmModVariables.WorldVariables.get(world).y),
					(NewWmModVariables.WorldVariables.get(world).z));
			if (_ent instanceof ServerPlayerEntity) {
				((ServerPlayerEntity) _ent).connection.setPlayerLocation((NewWmModVariables.WorldVariables.get(world).x),
						(NewWmModVariables.WorldVariables.get(world).y), (NewWmModVariables.WorldVariables.get(world).z), _ent.rotationYaw,
						_ent.rotationPitch, Collections.emptySet());
			}
		}
	}
}
