import java.util.ArrayList;

public class MovieOrdering {
    ArrayList<Movie> movieList = new ArrayList<Movie>();

    public void addMovie(Movie m){
        movieList.add(m);
    }
    public int currentJoyfulness(){
        int joyfulness = movieList.get(0).duration;
        for (int i = 0; i < movieList.size()-1; i++){
            Movie curMovie = movieList.get(i);
            Movie nextMovie = movieList.get(i+1);
            if (!curMovie.genre.equals(nextMovie.genre) && curMovie.rating < nextMovie.rating){
                joyfulness += nextMovie.duration;
            }
        }
        System.out.println(joyfulness);
        return joyfulness;
    }

    public int maxJoyfulness(){
        int maxJoyfullness = 0;
        for (Movie m: movieList ){
            maxJoyfullness += m.duration;
        }
        System.out.println(maxJoyfullness);
        return maxJoyfullness;
    }
    public static void main (String args[]){
        Movie a = new Movie("Squid Game", "Thriller", 7.6, 120);
        Movie b = new Movie("Spider-Man", "Action", 8.5, 110);
        Movie c = new Movie("The Matrix Resurrections", "Action", 6.2, 140);
        MovieOrdering mo = new MovieOrdering();
        mo.addMovie(a);
        mo.addMovie(b);
        mo.addMovie(c);
        mo.currentJoyfulness(); // return 230
        mo.maxJoyfulness(); // return 370

    }
}

class Movie {
    String title;
    String genre;
    double rating;
    int duration;

    public Movie(String title, String genre, double rating, int duration){
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.duration = duration;
    }
}
