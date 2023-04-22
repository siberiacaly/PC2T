package ProjectFilms;

import java.util.ArrayList;
import java.util.List;

public abstract class Films{
	
	protected String name;
	protected String director;
	protected int year;
	public static List<Films> Films = new ArrayList<Films>();
	
	public static void editName(String filmName, String newName) {
		Films film = findFilm(filmName);
		if(film == null)
			return;
		film.name = newName;
	}
	
	public static void editDirector(String filmName, String newDirector) {
		Films film = findFilm(filmName);
		if(film == null)
			return;
		film.director = newDirector;
	}
	
	public static void editYear(String filmName, int newYear) {
		Films film = findFilm(filmName);
		if(film == null)
			return;
		film.year = newYear;
	}
	
	public static Films findFilm(String filmName) {
		for(Films film : Films) {
			if(film.name.equals(filmName))
				return film;
		}
		return null;
	}
	
	public static int removeFilm(String filmName) {
		Films film = findFilm(filmName);
		if(film instanceof FeatureFilm) {
			for(Actor actor : FeatureFilm.getActors(filmName)) {
				actor.removeFilm(film);
			}
			Films.remove(film);
			return 1;
		}
		else if(film instanceof AnimatedFilm) {
			for(Animator animator : AnimatedFilm.getAnimators(filmName)) {
				animator.removeFilm(film);
			}
			Films.remove(film);
			return 1;
		}
		else
			return 0;
	}
	
}
