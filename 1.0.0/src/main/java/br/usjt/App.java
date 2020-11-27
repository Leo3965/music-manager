package br.usjt;

import br.usjt.factories.services.UserServiceFactory;
import br.usjt.ui.UiHandler;

public class App {
    public static void main(String[] args) {
        new UiHandler(UserServiceFactory.get());
    }
}
