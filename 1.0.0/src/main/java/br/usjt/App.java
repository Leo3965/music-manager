package br.usjt;

import br.usjt.factories.domain.UserInteractorFactory;
import br.usjt.ui.LoginUi;
import br.usjt.ui.RegisterUi;

public class App {

    public static void main(String[] args) {
        LoginUi login = new LoginUi(UserInteractorFactory.get());
        RegisterUi register = new RegisterUi(UserInteractorFactory.get());
    }
}
