package me.stingrays110.chippedancient.mixin;

import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(AbstractContainerMenu.class)
public interface AbstractContainerMenuAccessor {

    @Mutable
    @Accessor("menuType")
    void chippedAncient$setMenuType(MenuType<?> menuType);
}
