package br.usjt.ui;

import br.usjt.factories.domain.UserInteractorFactory;
import br.usjt.ui.screens.*;

public class UiHandler {

    private LoginUi login;
    private RegisterUi register;
    private DashboardUi dashboard;
    private String lastWindow;

    public UiHandler() {
        startWindows();
    }

    private void startWindows() {
        this.login = new LoginUi(UserInteractorFactory.get(), false, this);
        this.register = new RegisterUi(UserInteractorFactory.get(), false, this);
        this.dashboard = new DashboardUi(false, this);

        this.showWindow("login");
    }

    public void showWindow(String name) {
        this.lastWindow = name;
        this.login.hide();
        this.register.hide();

        switch (name) {
            case "login":
                this.login.show();
                break;
            case "register":
                this.register.show();
                break;
            case "dashboard":
                this.dashboard.show();
                break;
        }
    }

}
