package src.main.models;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Store {
    ArrayList<Movie> movies;

    public Store() {
        this.movies = new ArrayList<Movie>();
    }

    public Movie getMovie(int index) {
        return new Movie(this.movies.get(index));
    }

    public void setMovie(int index, Movie movie) {
        this.movies.set(index, new Movie(movie));
    }

    public void addMovie(Movie movie){
        this.movies.add(new Movie(movie));
    }

    public boolean contains(Movie movie){
        return this.movies.contains(movie);
       
    }

    public void sellMovie(String name){
        if (!(this.movies.get(getMovieIndex(name)).isAvailable())){
            throw new IllegalStateException("This movie is already rented");
        }
        this.movies.removeIf((movie) ->{
            return movie.getName().equals(name);
        });
     
    }


    public int getMovieIndex(String name){
        return IntStream.range(0, this.movies.size())
            .filter((i) -> {
                return this.movies.get(i).getName().equals(name);
            })
            .findFirst()
            .orElse(-1000);
    }
    

    public void rentMove(String name){
        this.movies.get(getMovieIndex(name)).setAvailable(false);

    }

    

    public String toString() {
        String temp = "";
        for (int i = 0; i < this.movies.size(); i++) {
            temp += this.movies.get(i).toString();
            temp += "\n\n";
        }
        return temp;
    }

}
