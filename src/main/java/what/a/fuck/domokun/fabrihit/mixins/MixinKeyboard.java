package what.a.fuck.domokun.fabrihit.mixins;

import net.minecraft.client.Keyboard;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import what.a.fuck.domokun.fabrihit.FabriHit;

@Mixin(Keyboard.class)
public class MixinKeyboard {
    @Inject(at = @At("HEAD"),method = "onKey",cancellable = true)
    public void onKey(long window, int key, int scancode, int i, int modifiers, CallbackInfo ci){
        FabriHit.onKey(i,key);
    }
}
