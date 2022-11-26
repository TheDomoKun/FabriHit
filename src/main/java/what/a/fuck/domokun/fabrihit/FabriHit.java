package what.a.fuck.domokun.fabrihit;

import net.fabricmc.api.ModInitializer;
import net.minecraft.client.MinecraftClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import what.a.fuck.domokun.fabrihit.managers.HitBoxManager;

public class FabriHit implements ModInitializer {
	public static HitBoxManager hitBoxManager = new HitBoxManager();
	public static MinecraftClient mc = MinecraftClient.getInstance();

	@Override
	public void onInitialize() {

	}

	public static void onKey(int action,int keycode){
		if(mc.player != null && mc.world != null) {
			if (action == 1) {
				switch (keycode) {
					case 265 -> hitBoxManager.inc();

					case 264 -> hitBoxManager.reduce();

				}
			}
		}
	}
}
