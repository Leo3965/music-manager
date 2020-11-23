package br.usjt.domain.entity;

import java.util.ArrayList;
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

    public User(Integer id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.avaliations = new ArrayList<Avaliation>();
        this.genres = new ArrayList<Genre>();
    }

    public static User fromRaw(String name, String email, String password) {
        return new User(-1, name, password, email);
    }

    public void addGenre(Genre genre) {
        this.genres.add(genre);
    }
}
