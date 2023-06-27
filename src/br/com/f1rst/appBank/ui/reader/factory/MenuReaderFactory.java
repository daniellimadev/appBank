package br.com.f1rst.appBank.ui.reader.factory;

import br.com.f1rst.appBank.ui.menu.factory.MenuType;
import br.com.f1rst.appBank.ui.reader.MenuReader;
import br.com.f1rst.appBank.ui.reader.impl.ConsoleMenuReader;

import java.util.Map;

public class MenuReaderFactory {
    private Map<MenuType, MenuReader> menuReaderMap = Map.of(
            MenuType.CONSOLE, new ConsoleMenuReader()
    );

    public MenuReader create(MenuType menuType) {
        return menuReaderMap.get(menuType);
    }
}
