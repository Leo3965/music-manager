package br.usjt;

import br.usjt.factories.domain.UserInteractorFactory;
import br.usjt.ui.UiHandler;

public class App {
    public static void main(String[] args) {
        new UiHandler(UserInteractorFactory.get());
    }
}
