package what.a.fuck.domokun.fabrihit.mixins;

import net.minecraft.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import what.a.fuck.domokun.fabrihit.FabriHit;
import what.a.fuck.domokun.fabrihit.managers.HitBoxManager;

@Mixin(Entity.class)
public class EntityMixin {
    @Inject(method = "getTargetingMargin", at = @At("HEAD"), cancellable = true)
    private void onGetTargetingMargin(CallbackInfoReturnable<Float> info) {
        if(FabriHit.hitBoxManager.size != 0) {
            double v = FabriHit.hitBoxManager.size;//Modules.get().get(Hitboxes.class).getEntityValue((Entity) (Object) this);
            if (v != 0) info.setReturnValue((float) v);
        }
    }
}
