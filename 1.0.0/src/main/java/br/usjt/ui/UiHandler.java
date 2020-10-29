package br.usjt.ui;

import br.usjt.factories.domain.GenreInteractorFactory;
import br.usjt.factories.domain.UserInteractorFactory;
import br.usjt.ui.screens.*;

public class UiHandler {

    private LoginUi login;
    private RegisterUi register;
    private DashboardUi dashboard;
    private GenresUi genres;

    public UiHandler() {
        startWindows();
    }

    private void startWindows() {
        this.login = new LoginUi(UserInteractorFactory.get(), false, this);
        this.register = new RegisterUi(UserInteractorFactory.get(), false, this);
        this.dashboard = new DashboardUi(false, this);
        this.genres = new GenresUi(GenreInteractorFactory.get(), false, this);

        this.showWindow("login");
    }

    public void showWindow(String name) {
        this.login.hide();
        this.register.hide();
        this.dashboard.hide();
        this.genres.hide();

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
            case "genres":
                this.genres.show();
                break;
        }
    }

}
