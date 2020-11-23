package br.usjt.domain.entity;

import java.util.ArrayList;
import java.util.List;
public class Genre {
    private Integer id;
    private String name;
    private List<Music> musics;
    private List<User> users;

    public Genre() {
        this.musics = new ArrayList<Music>();
    }

    public void addMusic(Music music) {
        this.musics.add(music);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
