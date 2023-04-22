package ProjectFilms;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AnimatedFilm extends Films {
	
	private List<Animator> animators;
	private List<AnimatedRating> ratings;
	private int age;
	private static List<Animator> allAnimators = new ArrayList<Animator>();
	
	AnimatedFilm(String name, String director, int year, int recommendedAge){
		super.name = name;
		super.director = director;
		super.year = year;
		age = recommendedAge;
		animators = new ArrayList<Animator>();
		ratings = new ArrayList<AnimatedRating>();
	}
	
	public static Animator findAnimator(String animatorName) {
		for(Animator animator : allAnimators) {
			if(animator.getName().equals(animatorName))
				return animator;
		}
		return null;
	}
	
	public static void editAge(String filmName, int newAge) {
		Films film = findFilm(filmName);
		((AnimatedFilm)film).age = newAge;
	}
	
	@Override
	public String toString() {
		return "\nFilm: " + name + ", Director: " + director + ", Year: " + year + ", Recommended age: " + age + "\nAnimators: " + animators;
	}
	
	public static List<Animator> getAnimators(String filmName) {
		Films film = findFilm(filmName);
		if(film == null)
			return null;
		return ((AnimatedFilm)film).animators;
	}
	
	public static List<Animator> getAllAnimators(){
		return allAnimators;
	}
	
	public static List<Animator> getAnimatorsWithMoreThanOneFilm(){
		List<Animator> list = new ArrayList<Animator>();
		for(Animator animator : allAnimators) {
			if(animator.getFilms().size() > 1) {
				list.add(animator);
			}
		}
		return list;
	}
	
	public static void addAnimator(String filmName, String animatorName) {
		if(allAnimators.isEmpty()) {
			allAnimators.add(new Animator(animatorName));
		}
		Films film = findFilm(filmName);
		Animator animator = findAnimator(animatorName);
		if(animator != null) {
			((AnimatedFilm)film).animators.add(animator);
			animator.addFilm(film);
		}
		else {
			allAnimators.add(new Animator(animatorName));
			animator = findAnimator(animatorName);
			((AnimatedFilm)film).animators.add(animator);
			animator.addFilm(film);
		}
	}
	
	public static int removeAnimator(String filmName, String animatorName) {
		Films film = findFilm(filmName);
		Animator animator = findAnimator(animatorName);
		if(animator != null) {
			((AnimatedFilm)film).animators.remove(animator);
			animator.removeFilm(film);
			return 1;
		}
		return 0;
	}
	
	public static void addRating(String filmName, int points) {
		Films film = findFilm(filmName);
		if(film == null)
			return;
		((AnimatedFilm)film).ratings.add(new AnimatedRating(points));
	}
	
	public static void addRating(String filmName, int points, String comment) {
		Films film = findFilm(filmName);
		if(film == null)
			return;
		((AnimatedFilm)film).ratings.add(new AnimatedRating(points, comment));
	}
	
	public static List<AnimatedRating> getRatings(String filmName) {
		Films film = findFilm(filmName);
		if(film == null)
			return null;
		Collections.sort(((AnimatedFilm)film).ratings);
		return ((AnimatedFilm)film).ratings;
	}
	
	public void saveToAnimatedFile(String fileName) {
	    try {
	        FileWriter fw = new FileWriter(fileName);
	        BufferedWriter bw = new BufferedWriter(fw);
	        bw.write(name + ";" + director + ";" + year + ";");
	        for (int i = 0; i < animators.size(); i++) {
	            bw.write(animators.get(i).getName());
	            if (i < animators.size() - 1) {
	                bw.write(",");
	            }
	        }
	        bw.write(";");
	        List<AnimatedRating> ratings = getRatings(this.name);
	        for (int i = 0; i < ratings.size(); i++) {
	            bw.write(ratings.get(i).getPoints() + "");
	            if (i < ratings.size() - 1) {
	                bw.write(",");
	            }
	        }
	        bw.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	
}
