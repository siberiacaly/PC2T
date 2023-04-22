package ProjectFilms;

public class AnimatedRating implements Comparable<AnimatedRating>{
	
	private int points;
	private String comment;
	
	AnimatedRating(int points){
		this.points = points;
	}
	AnimatedRating(int points, String comment){
		this.points = points;
		this.comment = comment;
	}
	
	public int getPoints() {
		return points;
	}
	
	@Override
	public String toString() {
		if(comment == null)
			return "\nPoints: " + points + "/10 , Comment has not been added";
		return "\nPoints: " + points + "/10 , Comment: " + comment;
	}
	@Override
	public int compareTo(AnimatedRating o) {
		if(this.points == o.points)
			return 0;
		if(this.points < o.points)
			return 1;
		return -1;
	}
}
