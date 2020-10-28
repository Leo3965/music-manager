package br.usjt;

import br.usjt.factories.domain.UserInteractorFactory;
import br.usjt.ui.LoginUi;

public class App {

    public static void main(String[] args) {
        LoginUi login = new LoginUi(UserInteractorFactory.get());
    }
}
