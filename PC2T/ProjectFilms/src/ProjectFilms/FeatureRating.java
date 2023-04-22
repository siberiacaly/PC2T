package ProjectFilms;

public class FeatureRating implements Comparable<FeatureRating>{

	private int stars;
	private String comment;
	
	FeatureRating(int stars){
		this.stars = stars;
	}
	FeatureRating(int stars, String comment){
		this.stars = stars;
		this.comment = comment;
	}
	
	public int getStars() {
		return stars;
	}
	
	@Override
	public String toString() {
		if(comment == null)
			return "\nStars: " + stars + "/5 , Comment has not been added";
		return "\nStars: " + stars + "/5 , Comment: " + comment;
	}
	@Override
	public int compareTo(FeatureRating o) {
		if(this.stars == o.stars)
			return 0;
		if(this.stars < o.stars)
			return 1;
		return -1;
	}
}
