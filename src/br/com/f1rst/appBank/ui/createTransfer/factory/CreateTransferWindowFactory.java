package br.com.f1rst.appBank.ui.createTransfer.factory;

import br.com.f1rst.appBank.ui.createTransfer.CreateTransferWindow;
import br.com.f1rst.appBank.ui.createTransfer.impl.ConsoleCreateTransferMenu;
import br.com.f1rst.appBank.ui.menu.factory.MenuType;

import java.util.Map;

public class CreateTransferWindowFactory {
    private Map<MenuType, CreateTransferWindow> createTransferWindowMap = Map.of(
            MenuType.CONSOLE, new ConsoleCreateTransferMenu()
    );

    public ConsoleCreateTransferMenu createTransferMenu(MenuType menuType) {
        return (ConsoleCreateTransferMenu) createTransferWindowMap.get(menuType);
    }
}
