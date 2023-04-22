package ProjectFilms;

import java.util.ArrayList;
import java.util.List;

public class Animator {
	
	private String name;
	private List<Films> films;
	
	Animator(String animatorName){
		name = animatorName;
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
	
	public static List<Films> getAnimatorsFilms(String animatorName){
		Animator animator = AnimatedFilm.findAnimator(animatorName);
		if(animator == null)
			return null;
		return animator.films;
	}
	
}

