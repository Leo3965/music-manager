package br.usjt.interfaces.repositories;

import java.util.List;

import br.usjt.entity.Genre;
import br.usjt.entity.Music;
import br.usjt.entity.User;

public interface MusicRepository extends BaseRepository<Music> {
	List<Music> getByGenre(Genre genre);
	public List<Music> getMusicForAvaliations(Genre genre, User user);
	List<Music> getMusicsWithScore(User user);
}
