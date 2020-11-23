package br.usjt.domain.entity;

import java.util.List;

import br.usjt.domain.contracts.Hash;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private Integer id;
    private String name;
    private String password;
    private String email;
    private List<Avaliation> avaliations;
    private List<Genre> genres;

    public boolean authenticate(String password, Hash hashDriver) {
        return hashDriver.compare(this.password, password);
    }

    public static User fromRaw(String name, String email, String password) {
        User user = new User();
        user.name = name;
        user.password = password;
        user.email = email;
        return user;
    }

    public void addGenre(Genre genre) {
        this.genres.add(genre);
    }
}
