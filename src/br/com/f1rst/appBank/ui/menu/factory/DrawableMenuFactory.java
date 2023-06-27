package br.com.f1rst.appBank.ui.menu.factory;

import br.com.f1rst.appBank.ui.menu.ConsoleMenu;
import br.com.f1rst.appBank.ui.menu.DrawableMenu;
import br.com.f1rst.appBank.ui.menu.WebMenu;

import java.util.Map;

public class DrawableMenuFactory {
    private final Map<MenuType, DrawableMenu> drawableMenuMap = Map.of(
            MenuType.CONSOLE, new ConsoleMenu(),
            MenuType.WEB, new WebMenu()
    );

    public DrawableMenu create(MenuType menuType) {
        return drawableMenuMap.get(menuType);
    }
}
