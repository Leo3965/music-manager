package br.usjt.ui;

import java.util.HashMap;
import br.usjt.entity.User;
import br.usjt.services.UserService;
import br.usjt.factories.services.GenreServiceFactory;
import br.usjt.factories.services.MusicServiceFactory;
import br.usjt.factories.services.UserServiceFactory;
import br.usjt.ui.screens.*;

public class UiHandler {
    private String userEmail;

    private HashMap<String, BaseUi> screens;
    private UserService userService;

    public UiHandler(UserService userInteractor) {
        this.screens = new HashMap<String, BaseUi>();
        this.userService = userInteractor;
        startWindows();
    }

    public void setUser(User user) {
        this.userEmail = user.getEmail();
    }

    public User getUser() {
        return this.userService.getUserByEmail(this.userEmail);
    }

    public void Logoff() {
        this.userEmail = null;
    }

    private void startWindows() {
        this.screens.put("login", new LoginUi(UserServiceFactory.get(), false, this));
        this.screens.put("register", new RegisterUi(UserServiceFactory.get(), false, this));
        this.screens.put("dashboard", new DashboardUi(false, this));
        this.screens.put("genres",
                new GenresUi(GenreServiceFactory.get(), UserServiceFactory.get(), false, this));
        this.screens.put("avaliations", new AvaliationsUi(false, this, MusicServiceFactory.get()));
        this.screens.put("recommendations", new RecommedationUI(false, this, MusicServiceFactory.get()));

        this.showWindow("login");
    }

    public void showWindow(String name) {
        for (BaseUi screen : this.screens.values()) {
            screen.hide();
        }

        this.screens.get(name).show();
    }

}
