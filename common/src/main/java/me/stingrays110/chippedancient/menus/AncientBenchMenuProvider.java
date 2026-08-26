package me.stingrays110.chippedancient.menus;

import net.minecraft.network.chat.Component;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;

public record AncientBenchMenuProvider(Component name) implements MenuProvider {
    @Override
    public Component getDisplayName() {
        return name;
    }

    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
        return new AncientBenchMenu(id, inventory);
    }
}