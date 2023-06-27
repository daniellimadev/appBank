package br.com.f1rst.appBank.ui.reader;

import java.util.Arrays;

public enum MenuAction {
    OPEN_NEW_ACCOOUNT,
    TO_WITHDRAW,
    DEPOSIT,
    TRANSFER,
    INVEST,
    CONSULT_BALANCE,
    EXIT;

    public static MenuAction fromInt(int value) {
        return Arrays.stream(MenuAction.values()).filter(menuAction -> menuAction.ordinal() == value -1).findFirst().get();
    }
}
