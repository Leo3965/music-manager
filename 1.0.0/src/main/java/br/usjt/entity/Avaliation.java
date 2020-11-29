package br.usjt.entity;

import lombok.Getter;

@Getter
public class Avaliation {
    private Integer id;
    private Short score;
    private User user;
    private Music music;

    public Avaliation(Integer id, Short score) {
        this.id = id;
        this.score = score;
    }

    public Avaliation(Short score, User user, Music music) {
        this.score = score;
        this.user = user;
        this.music = music;
    }
}
