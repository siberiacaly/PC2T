package ProjectFilms;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FeatureFilm extends Films{
	
	private List<Actor> actors;
	private List<FeatureRating> ratings;
	private static List<Actor> allActors = new ArrayList<Actor>();
	
	//vytvoreni filmu
	FeatureFilm(String name, String director, int year){
		super.name = name;
		super.director = director;
		super.year = year;
		actors = new ArrayList<Actor>();
		ratings = new ArrayList<FeatureRating>();
	}
	
	public static Actor findActor(String actorName) {
		for(Actor actor : allActors) {
			if(actor.getName().equals(actorName))
				return actor;
		}
		return null;
	}
	
	@Override
	public String toString() {
		return "\nFilm: " + name + ", Director: " + director + ", Year: " + year + "\nActors: " + actors;
	}
	
	public static List<Actor> getActors(String filmName) {
		Films film = findFilm(filmName);
		if(film == null)
			return null;
		return ((FeatureFilm)film).actors;
	}
	
	public static List<Actor> getAllActors(){
		return allActors;
	}
	
	public static List<Actor> getActorsWithMoreThanOneFilm(){
		List<Actor> list = new ArrayList<Actor>();
		for(Actor actor : allActors) {
			if(actor.getFilms().size() > 1) {
				list.add(actor);
			}
		}
		return list;
	}
	
	public static void addActor(String filmName, String actorName) {
		if(allActors.isEmpty()) {
			allActors.add(new Actor(actorName));
		}
		Films film = findFilm(filmName);
		Actor actor = findActor(actorName);
		if(actor != null) {
			((FeatureFilm)film).actors.add(actor);
			actor.addFilm(film);
		}
		else {
			allActors.add(new Actor(actorName));
			actor = findActor(actorName);
			((FeatureFilm)film).actors.add(actor);
			actor.addFilm(film);
		}
	}
	
	public static int removeActor(String filmName, String actorName) {
		Films film = findFilm(filmName);
		Actor actor = findActor(actorName);
		if(actor != null) {
			((FeatureFilm)film).actors.remove(actor);
			actor.removeFilm(film);
			return 1;
		}
		return 0;
	}

	public static void addRating(String filmName, int stars) {
		Films film = findFilm(filmName);
		if(film == null)
			return;
		((FeatureFilm)film).ratings.add(new FeatureRating(stars));
	}
	
	public static void addRating(String filmName, int stars, String comment) {
		Films film = findFilm(filmName);
		if(film == null)
			return;
		((FeatureFilm)film).ratings.add(new FeatureRating(stars, comment));
	}
	
	public static List<FeatureRating> getRatings(String filmName) {
		Films film = findFilm(filmName);
		if(film == null)
			return null;
		Collections.sort(((FeatureFilm)film).ratings);
		return ((FeatureFilm)film).ratings;
	}
	
	
	public void saveToFeatureFile(String fileName) {
	    try {
	        FileWriter fw = new FileWriter(fileName);
	        BufferedWriter bw = new BufferedWriter(fw);
	        bw.write(name + ";" + director + ";" + year + ";");
	        for (int i = 0; i < actors.size(); i++) {
	            bw.write(actors.get(i).getName());
	            if (i < actors.size() - 1) {
	                bw.write(",");
	            }
	        }
	        bw.write(";");
	        List<FeatureRating> ratings = getRatings(this.name);
	        for (int i = 0; i < ratings.size(); i++) {
	            bw.write(ratings.get(i).getStars() + "");
	            if (i < ratings.size() - 1) {
	                bw.write(",");
	            }
	        }
	        bw.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}

	public static FeatureFilm loadFromFeatureFile(String fileName) {
	    FeatureFilm featureFilm = null;
	    try {
	        FileReader fr = new FileReader(fileName);
	        BufferedReader br = new BufferedReader(fr);
	        String line = br.readLine();
	        String[] parts = line.split(";");
	        String name = parts[0];
	        String director = parts[1];
	        int year = Integer.parseInt(parts[2]);
	        featureFilm = new FeatureFilm(name, director, year);
	        String[] actorNames = parts[3].split(",");
	        for (String actorName : actorNames) {
	            Actor actor = FeatureFilm.findActor(actorName);
	            if (actor == null) {
	                actor = new Actor(actorName);
	                FeatureFilm.getAllActors().add(actor);
	            }
	            featureFilm.actors.add(actor);
	            actor.addFilm(featureFilm);
	        }

	        br.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return featureFilm;
	}
	}

	
	
	
	

