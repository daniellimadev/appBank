package br.com.f1rst.appBank.ui.window;

import br.com.f1rst.appBank.ui.menu.DrawableMenu;
import br.com.f1rst.appBank.ui.menu.factory.DrawableMenuFactory;
import br.com.f1rst.appBank.ui.menu.factory.MenuType;
import br.com.f1rst.appBank.ui.reader.MenuAction;
import br.com.f1rst.appBank.ui.reader.MenuReader;
import br.com.f1rst.appBank.ui.reader.factory.MenuReaderFactory;

public class MenuWindow {
    private MenuType menuType;
    private DrawableMenu drawableMenu;
    private MenuReader menuReader;

    public MenuWindow(MenuType menuType) {
        this.menuType = menuType;
        drawableMenu = new DrawableMenuFactory().create(menuType);
        menuReader = new MenuReaderFactory().create(menuType);
    }

    public MenuAction getAction() {
        drawableMenu.drawMenu();
        return menuReader.readOption();
    }
}
