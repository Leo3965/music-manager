package br.usjt.services;

import java.util.ArrayList;
import java.util.List;

import br.usjt.entity.Avaliation;
import br.usjt.entity.Genre;
import br.usjt.entity.Music;
import br.usjt.entity.User;
import br.usjt.interfaces.repositories.AvaliationRepository;
import br.usjt.interfaces.repositories.MusicRepository;

public class MusicService {
    private MusicRepository musicRepository;
    private AvaliationRepository avaliationRepository;

    public MusicService(MusicRepository musicRepository, AvaliationRepository avaliationRepository) {
        this.musicRepository = musicRepository;
        this.avaliationRepository = avaliationRepository;
    }
    
    public List<Music> getMusicByGenres(List<Genre> genres) {
        List<Music> musics = new ArrayList<Music>();

        for(Genre genre:genres) {
            List<Music> musicsFromGenre = this.musicRepository.getByGenre(genre);
            musics.addAll(musicsFromGenre);
        }

        return musics;
    }

    public List<Music> getMusicForAvaliations(User user) {
        List<Music> musics = new ArrayList<Music>();

        for(Genre genre:user.getGenres()) {
            List<Music> musicsFromGenre = this.musicRepository.getMusicForAvaliations(genre, user);
            musics.addAll(musicsFromGenre);
        }

        return musics;
    }

	public void addAvaliation(String musicName, Short score, User user) {
        Music music = this.musicRepository.getByKey("name", musicName).get(0);
        Avaliation avaliation = new Avaliation(score, user, music);
        this.avaliationRepository.create(avaliation);
	}
}
