package br.usjt.domain.interactor;

import java.util.List;

import br.usjt.domain.contracts.Hash;
import br.usjt.domain.contracts.repositories.UserRepository;
import br.usjt.domain.entity.Genre;
import br.usjt.domain.entity.User;

public class UserInteractors {
    private UserRepository userRepository;
    private Hash hashDriver;

    public UserInteractors(UserRepository userRepository, Hash hashDriver) {
        this.userRepository = userRepository;
        this.hashDriver = hashDriver;
    }

    public void create(String name, String email, String password) {
        User user = User.fromRaw(name, email, this.hashDriver.hash(password));
        this.userRepository.create(user);
    }

    public boolean authenticate(String email, String password) {
        User user = this.getUserByEmail(email);
        return user.authenticate(password, this.hashDriver);
    }

    public User getUserByEmail(String email) {
        return this.userRepository.getByKey("email", email).get(0);
    }

    public void addFavoriteGenre(User user, Genre genre) {
        user.addGenre(genre);
        this.userRepository.update(user);
    }
}
