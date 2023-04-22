package ProjectFilms;

import java.util.List;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		//nacteni dat z databaze
		Scanner sc = new Scanner(System.in);
		String operation;

		
		while(true) {
			System.out.println("\nChoose operation: ");
			System.out.println("a - Add film");
			System.out.println("b - Edit film");
			System.out.println("c - Delete film");
			System.out.println("d - Add rating to film");
			System.out.println("e - Print all films");
			System.out.println("f - Search for film");
			System.out.println("g - Print all actors / animators with more than 1 film");
			System.out.println("h - Print all films of 1 actor / animator");
			System.out.println("i - Save info about film to file");
			System.out.println("j - Import info about film from file");
			System.out.println("0 - End program");
			operation = sc.next();
			
			switch(operation) {
			case "0":{
				//ulozeni dat do databaze
				return;
			}
			case "a":{	
				boolean run = true;
				String choice;
				while(run) {
					System.out.println("Choose film");
					System.out.println("1 - Feature film");
					System.out.println("2 - Animated film");
					System.out.println("0 - Go back");
					choice = sc.next();
					switch(choice) {
					case "1":{
						System.out.println("Insert name of film");
						sc.nextLine();
						String name = sc.nextLine();
						if(Films.findFilm(name) != null) {
							System.out.println("Film allready exists");
							break;
						}
						System.out.println("Insert director of film");
						String director = sc.nextLine();
						int year = scanIntNumber("Insert year of release");
						Films.Films.add(new FeatureFilm(name, director, year));
						while(true) {
							System.out.println("Would you like to add a actors ?");
							System.out.println("yes / no");
							String actor = sc.nextLine();
							if(actor.equals("yes")) {
								while(true) {
									System.out.println("Insert actors name: ");
									actor = sc.nextLine();
									if(FeatureFilm.findActor(actor) != null) {
										System.out.println("This actor was already added");
										continue;
									}
									FeatureFilm.addActor(name, actor);
									while(true) {
										System.out.println("Want to add another ?");
										System.out.println("yes / no");
										actor = sc.nextLine();
										if(actor.equals("yes") || actor.equals("no"))
											break;
										else
											System.out.println("Wrong input");
									}
									if(actor.equals("no"))
										break;
								}
								break;
							}
							else if(actor.equals("no")) {
								break;
							}
							else
								System.out.println("Wrong input");
						}
						break;
					}
					case "2":{
						System.out.println("Insert name of film");
						sc.nextLine();
						String name = sc.nextLine();
						if(Films.findFilm(name) != null) {
							System.out.println("Film allready exists");
							break;
						}
						System.out.println("Insert director of film");
						String director = sc.nextLine();
						int year = scanIntNumber("Insert year of release");
						int age = scanIntNumber("Insert recommended age for");
						Films.Films.add(new AnimatedFilm(name, director, year, age));
						while(true) {
							System.out.println("Would you like to add a animators ?");
							System.out.println("yes / no");
							String animator = sc.nextLine();
							if(animator.equals("yes")) {
								while(true) {
									System.out.println("Insert animators name: ");
									animator = sc.nextLine();
									if(AnimatedFilm.findAnimator(animator) != null) {
										System.out.println("This animator was already added");
										continue;
									}
									AnimatedFilm.addAnimator(name, animator);
									while(true) {
										System.out.println("Want to add another ?");
										System.out.println("yes / no");
										animator = sc.nextLine();
										if(animator.equals("yes") || animator.equals("no"))
											break;
										else
											System.out.println("Wrong input");
									}
									if(animator.equals("no"))
										break;
								}
								break;
							}
							else if(animator.equals("no")) {
								break;
							}
							else
								System.out.println("Wrong input");
						}
						break;
					}
					case "0":{
						run = false;
						break;
					}
					default:
						System.out.println("Wrong opeartion. Insert operation again.");
						break;
					}
				}
				break;
			}
			case "b":{
				System.out.println("Insert name of film");
				System.out.println("(Insert 0 to go back)");
				sc.nextLine();
				String name = sc.nextLine();
				if(name.equals("0"))
					break;
				Films film = Films.findFilm(name);
				boolean run = true;
				if(film instanceof FeatureFilm) {
					while(run) {
						System.out.println("1 - edit name of film");
						System.out.println("2 - edit director of film");
						System.out.println("3 - edit year of release");
						System.out.println("4 - edit actors");
						System.out.println("0 - go back");
						String choice = sc.nextLine();
						switch(choice) {
							case "1":{
								System.out.println("Insert new name");
								String newName = sc.nextLine();
								FeatureFilm.editName(name, newName);
								name = newName;
								break;
							}
							case "2":{
								System.out.println("Insert new director");
								String newDirector = sc.nextLine();
								FeatureFilm.editDirector(name, newDirector);
								break;
							}
							case "3":{
								int newYear = scanIntNumber("Insert new year of release"); 
								FeatureFilm.editYear(name, newYear);
								break;
							}
							case "4":{
								while(true) {
									System.out.println("Do you want to add or remove actor ?");
									System.out.println("add / remove");
									String actor = sc.nextLine();
									if(actor.equals("add")) {
										System.out.println("Insert actors name");
										actor = sc.nextLine();
										if(FeatureFilm.findActor(actor) != null) {
											System.out.println("This actor was already added");
											break;
										}
										FeatureFilm.addActor(name, actor);
										break;
									}
									if(actor.equals("remove")) {
										System.out.println("Insert actors name");
										actor = sc.nextLine();
										if(FeatureFilm.findActor(actor) == null) {
											System.out.println("This actor was not added");
											break;
										}
										FeatureFilm.removeActor(name, actor);
										break;
									}
									else
										System.out.println("Wrong input");
								}
								break;
							}
							case "0":{
								run = false;
								break;
							}
							default:{
								System.out.println("Wrong input");
								break;
							}
						}
					
					}
					break;
				}
				else if(film instanceof AnimatedFilm) {
					while(run) {
						System.out.println("1 - edit name of film");
						System.out.println("2 - edit director of film");
						System.out.println("3 - edit year of release");
						System.out.println("4 - edit recommende age");
						System.out.println("5 - edit animators");
						System.out.println("0 - go back");
						String choice = sc.nextLine();
						switch(choice) {
							case "1":{
								System.out.println("Insert new name");
								String newName = sc.nextLine();
								AnimatedFilm.editName(name, newName);
								name = newName;
								break;
							}
							case "2":{
								System.out.println("Insert new director");
								String newDirector = sc.nextLine();
								AnimatedFilm.editDirector(name, newDirector);
								break;
							}
							case "3":{
								int newYear = scanIntNumber("Insert new year of release"); 
								AnimatedFilm.editYear(name, newYear);
								break;
							}
							case "4":{
								int newAge = scanIntNumber("Insert new recommended age");
								AnimatedFilm.editAge(name, newAge);
								break;
							}
							case "5":{
								while(true) {
									System.out.println("Do you want to add or remove amimator ?");
									System.out.println("add / remove");
									String animator = sc.nextLine();
									if(animator.equals("add")) {
										System.out.println("Insert animatorss name");
										animator = sc.nextLine();
										if(AnimatedFilm.findAnimator(animator) != null) {
											System.out.println("This animator was already added");
											break;
										}
										AnimatedFilm.addAnimator(name, animator);
										break;
									}
									if(animator.equals("remove")) {
										System.out.println("Insert animators name");
										animator = sc.nextLine();
										if(AnimatedFilm.findAnimator(animator) == null) {
											System.out.println("This animator was not added");
											break;
										}
										AnimatedFilm.removeAnimator(name, animator);
										break;
									}
									else
										System.out.println("Wrong input");
								}
								break;
							}
							case "0":{
								run = false;
								break;
							}
							default:{
								System.out.println("Wrong input");
								break;
							}
						}
					
					}
					break;
				}
				else {
					System.out.println("Film with this name does not exist");
					break;
				}
			}
			case "c":{
				System.out.println("Insert name of film");
				System.out.println("(Insert 0 to go back)");
				String name = sc.nextLine();
				if(name.equals("0"))
					break;
				if(Films.removeFilm(name) > 0) {
					System.out.println(name + " was deleted");
					break;
				}
				else {
					System.out.println("Films with this name does not exists");
					break;
				}		
			}
			case "d":{
				System.out.println("Insert name of film");
				System.out.println("(Insert 0 to go back)");
				sc.nextLine();
				String name = sc.nextLine();
				if(name.equals("0"))
					break;
				Films film = Films.findFilm(name);
				if(film instanceof FeatureFilm) {
					int stars;
					while(true) {
						System.out.println("Insert 1 - 5 stars for film");
						if(sc.hasNextInt()) {
							stars = sc.nextInt();
							if(!(stars < 1 || stars > 5))
								break;
						}
						System.out.println("Wrong input. Insert number between 1 and 5");
						sc.nextLine();
					}
					String comment;
					sc.nextLine();
					while(true) {
						System.out.println("Would you like to add a commentary ?");
						System.out.println("yes / no");
						comment = sc.nextLine();
						if(comment.equals("yes")) {
							System.out.println("Insert commenatary: ");
							comment = sc.nextLine();
							FeatureFilm.addRating(name, stars, comment);
							break;
						}
						else if(comment.equals("no")) {
							FeatureFilm.addRating(name, stars);
							break;
						}
						else
							System.out.println("Wrong input");
					}
					break;
				}
				else if(film instanceof AnimatedFilm) {
					int points;
					while(true) {
						System.out.println("Insert 1 - 10 points for film");
						if(sc.hasNextInt()) {
							points = sc.nextInt();
							if(!(points < 1 || points > 10))
								break;
						}
						System.out.println("Wrong input. Insert number between 1 and 10");
						sc.nextLine();
					}
					String comment;
					sc.nextLine();
					while(true) {
						System.out.println("Would you like to add a commentary ?");
						System.out.println("yes / no");
						comment = sc.nextLine();
						if(comment.equals("yes")) {
							System.out.println("Insert commenatary: ");
							comment = sc.nextLine();
							FeatureFilm.addRating(name, points, comment);
							break;
						}
						else if(comment.equals("no")) {
							FeatureFilm.addRating(name, points);
							break;
						}
						else
							System.out.println("Wrong input");
					}
					break;
				}
				else {
					System.out.println("Film with this name does not exist");
					break;
				}
			}
			case "e":{
				if(Films.Films.isEmpty()) {
					System.out.println("No existing films");
				}
				else {
					for(Films film : Films.Films) 
						System.out.println(film);
				}
				break;
			}
			case "f":{
				System.out.println("Insert name of film");
				System.out.println("(Insert 0 to go back)");
				sc.nextLine();
				String name = sc.nextLine();
				if(name.equals("0"))
					break;
				Films film = Films.findFilm(name);
				if(film instanceof FeatureFilm) {
					System.out.println(Films.findFilm(name) + "\nRatings: " + FeatureFilm.getRatings(name));
					break;
				}
				else if (film instanceof AnimatedFilm) {
					System.out.println(Films.findFilm(name) + "\nRatings: " + FeatureFilm.getRatings(name));
					break;
				}
				else { // pro null => film neexistuje
					System.out.println("Film with this name does not exist");
					break;
				}
			}
			case "g":{
				for(Actor actor : FeatureFilm.getActorsWithMoreThanOneFilm()) {
					System.out.println("\n" + actor);
					System.out.println(actor.getFilms());
				}
				for(Animator animator : AnimatedFilm.getAnimatorsWithMoreThanOneFilm()) {
					System.out.println("\n" + animator);
					System.out.println(animator.getFilms());
				}
				break;
			}
			case "h":{
				System.out.println("Insert name of actor / animator");
				System.out.println("(Insert 0 to go back)");
				sc.nextLine();
				String name = sc.nextLine();
				if(name.equals("0"))
					break;
				Actor actor = FeatureFilm.findActor(name);
				Animator animator = AnimatedFilm.findAnimator(name);
				if(actor == null && animator == null) {
					System.out.println("Actor / animator does not exists");
					break;
				}
				else if(actor != null) {
					List<Films> list = Actor.getActorsFilms(name);
					if(list == null) {
						System.out.println(name + "has not any film");
						break;
					}	
					System.out.println("Films of " + name + ": " + list);
					break;
				}
				else {
					List<Films> list = Animator.getAnimatorsFilms(name);
					if(list == null) {
						System.out.println(name + "has not any film");
						break;
					}
					System.out.println("Films of " + name + ": " + list);
					break;
				}
			}
			
			
			
			
			
			case "i":{
				System.out.println("Insert name of film");
				System.out.println("(Insert 0 to go back)");
				sc.nextLine();
				String name = sc.nextLine();
				if(name.equals("0"))
					break;
				Films film = Films.findFilm(name);
				if(film instanceof FeatureFilm) {
					FeatureFilm featureFilm = (FeatureFilm) film;
			        System.out.println("Insert file name:");
			        String fileName = sc.nextLine();
			        featureFilm.saveToFeatureFile(fileName);
			        break;
				}
				else if (film instanceof AnimatedFilm) {
					AnimatedFilm animatedFilm = (AnimatedFilm) film;
			        System.out.println("Insert file name:");
			        String fileName = sc.nextLine();
			        animatedFilm.saveToAnimatedFile(fileName);
			        break;

				}
				else { // pro null => film neexistuje
					System.out.println("Film with this name does not exist");
					break;
				}
			}
			
			
			case "j":{
				System.out.println("Insert name of file");
				System.out.println("(Insert 0 to go back)");
				sc.nextLine();
				String filename = sc.nextLine();
				if(filename.equals("0"))
					break;
				else
				{
				FeatureFilm.loadFromFeatureFile(filename);
			    break;
				}
			}
			default:{
				System.out.println("Wrong opeartion. Insert operation again.");
				break;
				}
			}
		}
	}



	public static int scanIntNumber(String msg) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println(msg);
			if(sc.hasNextInt()) {
				return sc.nextInt();
			}
			System.out.println("Wrong input. Insert number");
			sc.next();
		}
	}
}
