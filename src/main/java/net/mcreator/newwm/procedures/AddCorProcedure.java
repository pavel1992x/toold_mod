package net.mcreator.newwm.procedures;

import net.minecraftforge.fml.server.ServerLifecycleHooks;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.Util;
import net.minecraft.server.MinecraftServer;

import net.mcreator.newwm.NewWmModVariables;
import net.mcreator.newwm.NewWmModElements;
import net.mcreator.newwm.NewWmMod;

import java.util.Map;

@NewWmModElements.ModElement.Tag
public class AddCorProcedure extends NewWmModElements.ModElement {
	public AddCorProcedure(NewWmModElements instance) {
		super(instance, 38);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				NewWmMod.LOGGER.warn("Failed to load dependency x for procedure AddCor!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				NewWmMod.LOGGER.warn("Failed to load dependency y for procedure AddCor!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				NewWmMod.LOGGER.warn("Failed to load dependency z for procedure AddCor!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				NewWmMod.LOGGER.warn("Failed to load dependency world for procedure AddCor!");
			return;
		}
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		NewWmModVariables.WorldVariables.get(world).x = (double) x;
		NewWmModVariables.WorldVariables.get(world).syncData(world);
		NewWmModVariables.WorldVariables.get(world).y = (double) y;
		NewWmModVariables.WorldVariables.get(world).syncData(world);
		NewWmModVariables.WorldVariables.get(world).z = (double) z;
		NewWmModVariables.WorldVariables.get(world).syncData(world);
		if (!world.isRemote()) {
			MinecraftServer mcserv = ServerLifecycleHooks.getCurrentServer();
			if (mcserv != null)
				mcserv.getPlayerList().func_232641_a_(new StringTextComponent(
						(("\u043B\u043E\u043A\u0430\u043B\u044C\u043D\u044B\u0439 \u0442\u0435\u043B\u0435\u043F\u043E\u0440\u0442 \u0441\u043E\u0437\u0434\u0430\u043D ")
								+ "" + ("x ") + "" + ((NewWmModVariables.WorldVariables.get(world).x)) + "" + (" y ") + ""
								+ ((NewWmModVariables.WorldVariables.get(world).y)) + "" + (" z ") + ""
								+ ((NewWmModVariables.WorldVariables.get(world).z)) + ""
								+ (". \u0412\u043D\u0438\u043C\u0430\u043D\u0438\u0435 \u0442\u043E\u0447\u043A\u0443 \u043B\u043E\u043A\u0430\u043B\u044C\u043D\u043E\u0433\u043E \u0442\u0435\u043B\u0435\u043F\u043E\u0440\u0442\u0430 \u043C\u043E\u0436\u043D\u043E \u0438\u0437\u043F\u043E\u043B\u044C\u0437\u043E\u0432\u0430\u0442\u044C \u0442\u043E\u043B\u044C\u043A\u043E \u0432 \u043F\u0440\u0438\u0434\u0435\u043B\u0430\u0445 \u043E\u0434\u043D\u043E\u0433\u043E \u043C\u0438\u0440\u0430."))),
						ChatType.SYSTEM, Util.DUMMY_UUID);
		}
	}
}
