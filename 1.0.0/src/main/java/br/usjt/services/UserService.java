package br.usjt.services;

import br.usjt.entity.Genre;
import br.usjt.entity.User;
import br.usjt.interfaces.Hash;
import br.usjt.interfaces.repositories.UserRepository;

public class UserService {
    private UserRepository userRepository;
    private Hash hashDriver;

    public UserService(UserRepository userRepository, Hash hashDriver) {
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

	public void removeFavoriteGenre(User user, Genre genre) {
        user.removeGenre(genre);
        this.userRepository.update(user);
	}
}
