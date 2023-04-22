package ProjectFilms;

import java.util.ArrayList;
import java.util.List;

public class Actor {
	
	private String name;
	private List<Films> films;
	
	// novy herec
	Actor(String actorName){
		name = actorName;
		films = new ArrayList<Films>();
	}
	
	public String getName() {
		return name;
	}
	
	public void addFilm(Films film) {
		films.add(film);
	}
	
	public void removeFilm(Films film) {
		films.remove(film);
	}
	
	public List<Films> getFilms(){
		return films;
	}
	
	@Override
	public String toString() {
			return name;
	}
	
	public static List<Films> getActorsFilms(String actorName){
		Actor actor = FeatureFilm.findActor(actorName);
		if(actor == null)
			return null;
		return actor.films;
	}
}
