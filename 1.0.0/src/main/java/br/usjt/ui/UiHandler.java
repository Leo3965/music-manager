package br.usjt.ui;

import java.util.HashMap;

import br.usjt.domain.entity.User;
import br.usjt.factories.domain.GenreInteractorFactory;
import br.usjt.factories.domain.UserInteractorFactory;
import br.usjt.ui.screens.*;

public class UiHandler {

    private LoginUi login;
    private RegisterUi register;
    private DashboardUi dashboard;
    private GenresUi genres;
    private User user;

    private HashMap<String, BaseUi> screens;

    public UiHandler() {
        this.screens = new HashMap<String, BaseUi>();
        startWindows();
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return this.user;
    }

    private void startWindows() {
        this.screens.put("login", new LoginUi(UserInteractorFactory.get(), false, this));
        this.screens.put("register", new RegisterUi(UserInteractorFactory.get(), false, this));
        this.screens.put("dashboard", new DashboardUi(false, this));
        this.screens.put("genres",
                new GenresUi(GenreInteractorFactory.get(), UserInteractorFactory.get(), false, this));

        this.showWindow("login");
    }

    public void showWindow(String name) {
        for (BaseUi screen : this.screens.values()) {
            screen.hide();
        }

        this.screens.get(name).show();
    }

}
