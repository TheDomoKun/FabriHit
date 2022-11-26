package what.a.fuck.domokun.fabrihit.mixins;

import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.Box;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;
import what.a.fuck.domokun.fabrihit.FabriHit;
import what.a.fuck.domokun.fabrihit.interfaces.IHitBox;

@Mixin(EntityRenderDispatcher.class)
public class EntityRenderDispatcherMixin {
    @Inject(method = "renderHitbox",at = @At(value = "INVOKE",target = "Lnet/minecraft/client/render/WorldRenderer;drawBox(Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumer;DDDDDDFFFF)V",ordinal = 0),cancellable = true)
    private static void onRenderHitbox(MatrixStack matrices, VertexConsumer vertices, Entity entity, float tickDelta,CallbackInfo callbackInfo) {
        if(FabriHit.hitBoxManager.size != 0) {
            double v = FabriHit.hitBoxManager.size;
            if (v != 0) {
                ((IHitBox) entity.getBoundingBox()).resize(v);
            }

        }
    }
}
