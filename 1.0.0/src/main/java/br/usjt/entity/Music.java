package br.usjt.entity;

import java.util.List;

import lombok.Getter;

@Getter
public class Music {
    private Integer id;

    private String name;

    private List<Genre> genres;

    private List<Avaliation> avaliations;

    public void addGenre(Genre genre) {
        this.genres.add(genre);
    }

    public void removeGenre(Genre genre) {
        this.genres.remove(genre);
    }

    public void addAvaliation(Avaliation avaliation) {
        this.avaliations.add(avaliation);
    }

}
