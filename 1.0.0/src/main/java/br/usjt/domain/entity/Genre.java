package br.usjt.domain.entity;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;

@Getter
public class Genre {
    private Integer id;
    private String name;
    private List<Music> musics;
    private List<User> users;

    public Genre(Integer id, String name) {
        this.id = id;
        this.name = name;
        this.musics = new ArrayList<Music>();
        this.users = new ArrayList<User>();
    }

    public void addMusic(Music music) {
        this.musics.add(music);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
