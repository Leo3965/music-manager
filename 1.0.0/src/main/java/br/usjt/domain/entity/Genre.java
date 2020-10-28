package br.usjt.domain.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "genres")
public class Genre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @ManyToMany
    @JoinTable(name = "music_genres", joinColumns = @JoinColumn(name = "genreId"), inverseJoinColumns = @JoinColumn(name = "musicId"))
    private List<Music> musics;

    public Genre() {
        this.musics = new ArrayList<Music>();
    }

    public void addMusic(Music music) {
        this.musics.add(music);
    }
}
