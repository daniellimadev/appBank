package br.com.f1rst.appBank.ui.createInvest.factory;

import br.com.f1rst.appBank.ui.createInvest.CreateInvestWindow;
import br.com.f1rst.appBank.ui.createInvest.impl.ConsoleCreateInvestMenu;
import br.com.f1rst.appBank.ui.menu.factory.MenuType;

import java.util.Map;

public class CreateInvestWondowFactory {
    private Map<MenuType, CreateInvestWindow> createInvestWindowMap = Map.of(
            MenuType.CONSOLE, new ConsoleCreateInvestMenu()
    );

    public ConsoleCreateInvestMenu createInvestMenu(MenuType menuType) {
        return (ConsoleCreateInvestMenu) createInvestWindowMap.get(menuType);
    }
}
