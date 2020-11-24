package br.usjt.ui;

import java.util.HashMap;
import br.usjt.domain.entity.User;
import br.usjt.domain.interactor.UserInteractors;
import br.usjt.factories.domain.GenreInteractorFactory;
import br.usjt.factories.domain.UserInteractorFactory;
import br.usjt.ui.screens.*;

public class UiHandler {
    private String userEmail;

    private HashMap<String, BaseUi> screens;
    private UserInteractors userInteractor;

    public UiHandler(UserInteractors userInteractor) {
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
