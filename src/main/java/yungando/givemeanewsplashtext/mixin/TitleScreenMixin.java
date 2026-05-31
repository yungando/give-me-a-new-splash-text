package yungando.givemeanewsplashtext.mixin;

import net.minecraft.client.gui.components.SplashRenderer;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.client.input.MouseButtonEvent;
import net.minecraft.network.chat.Component;
import org.jspecify.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(TitleScreen.class)
public abstract class TitleScreenMixin extends Screen {
	@Shadow
	private @Nullable SplashRenderer splash;

	protected TitleScreenMixin(Component title) {
		super(title);
	}

	@Inject(method = "mouseClicked", at = @At("RETURN"))
	private void changeSplashText(MouseButtonEvent event, boolean doubleClick, CallbackInfoReturnable<Boolean> cir) {
		this.splash = this.minecraft.getSplashManager().getSplash();
	}
}