package br.usjt.ui;

import java.util.HashMap;
import br.usjt.domain.entity.User;
import br.usjt.domain.services.UserService;
import br.usjt.factories.domain.GenreServiceFactory;
import br.usjt.factories.domain.UserServiceFactory;
import br.usjt.ui.screens.*;

public class UiHandler {
    private String userEmail;

    private HashMap<String, BaseUi> screens;
    private UserService userInteractor;

    public UiHandler(UserService userInteractor) {
        this.screens = new HashMap<String, BaseUi>();
        this.userInteractor = userInteractor;
        startWindows();
    }

    public void setUser(User user) {
        this.userEmail = user.getEmail();
    }

    public User getUser() {
        return this.userInteractor.getUserByEmail(this.userEmail);
    }

    private void startWindows() {
        this.screens.put("login", new LoginUi(UserServiceFactory.get(), false, this));
        this.screens.put("register", new RegisterUi(UserServiceFactory.get(), false, this));
        this.screens.put("dashboard", new DashboardUi(false, this));
        this.screens.put("genres",
                new GenresUi(GenreServiceFactory.get(), UserServiceFactory.get(), false, this));

        this.showWindow("login");
    }

    public void showWindow(String name) {
        for (BaseUi screen : this.screens.values()) {
            screen.hide();
        }

        this.screens.get(name).show();
    }

}
