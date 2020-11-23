package br.usjt.domain.entity;

import lombok.Getter;

@Getter
public class Avaliation {
    private Integer id;
    private Short score;
    private User user;
    private Music music;

    public Avaliation(Integer id, Short score) {
        
    }
}
