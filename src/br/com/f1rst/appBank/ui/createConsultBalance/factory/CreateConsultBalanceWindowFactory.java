package br.com.f1rst.appBank.ui.createConsultBalance.factory;

import br.com.f1rst.appBank.ui.createConsultBalance.CreateConsultBalanceWindow;
import br.com.f1rst.appBank.ui.createConsultBalance.impl.ConsoleCreateConsultBalanceMenu;
import br.com.f1rst.appBank.ui.createInvest.impl.ConsoleCreateInvestMenu;
import br.com.f1rst.appBank.ui.menu.factory.MenuType;

import java.util.Map;

public class CreateConsultBalanceWindowFactory {
    private Map<MenuType, CreateConsultBalanceWindow> consultBalanceWindowMap = Map.of(
            MenuType.CONSOLE, new ConsoleCreateConsultBalanceMenu()
    );

    public ConsoleCreateInvestMenu consoleCreateInvestMenu(MenuType menuType) {
        return (ConsoleCreateInvestMenu) consultBalanceWindowMap.get(menuType);
    }
}
