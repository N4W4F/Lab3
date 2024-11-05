import java.util.ArrayList;
import java.util.List;

public class Movie extends Media {

    private int duration;

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }

    public void watch(User user) {
        user.addToCart(this);
        user.checkOut();
    }

    public ArrayList<Movie> recommendSimilarMovies(List<Movie> movieCatalog) {
        ArrayList<Movie> recommendedMovies = new ArrayList<>();
        for (Movie movie : movieCatalog)
            if (!movie.equals(this) && movie.getAuteur().equals(this.getAuteur()))
                recommendedMovies.add(movie);
        return recommendedMovies;
    }

    @Override
    public String getMediaType() {
        if (duration > 120)
            return "Long Movie";
        return "Movie";
    }

    @Override
    public String toString() {
        return super.toString() + "\nDuration: " + getDuration() + " Minutes" +
                "\nMedia Type: " + getMediaType();
    }

}
