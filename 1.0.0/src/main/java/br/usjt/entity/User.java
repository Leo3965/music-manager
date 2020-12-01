package br.usjt.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import br.usjt.interfaces.Hash;
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

    public User(String name, String email, String password) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.avaliations = new ArrayList<Avaliation>();
        this.genres = new ArrayList<Genre>();
    }

    public void addGenre(Genre genre) {
        Boolean exist = false;

        for(Genre genrePersisted : this.genres) {
            if(genrePersisted.getId() == genre.getId()) {
                exist = true;
            }
        }

        if(!exist) {
            this.genres.add(genre);
        }
    }

    public void addAvaliation(Avaliation avaliation) {
        Boolean exist = false;

        for(Avaliation avaliationPersisted : this.avaliations) {
            if(avaliationPersisted.getId() == avaliation.getId()) {
                exist = true;
            }
        }

        if(!exist) {
            this.avaliations.add(avaliation);
        }
    }

	public void removeGenre(Genre genre) {
        Genre genreToBeExcluded = new Genre(0, "");
        Iterator<Genre> genreInteractor = this.genres.iterator();

        while(genreInteractor.hasNext()) {
            Genre genrePersisted = genreInteractor.next();
            if(genrePersisted.getId() == genre.getId()) {
                genreToBeExcluded = genrePersisted;
            }
        }

        this.genres.remove(genreToBeExcluded);
	}
}
