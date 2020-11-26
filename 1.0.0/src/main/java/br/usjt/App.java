package br.usjt;

import br.usjt.factories.domain.UserServiceFactory;
import br.usjt.ui.UiHandler;

public class App {
    public static void main(String[] args) {
        new UiHandler(UserServiceFactory.get());
    }
}
