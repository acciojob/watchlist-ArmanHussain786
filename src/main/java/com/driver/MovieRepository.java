package com.driver;
import java.util.*;
import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository {
    private HashMap<String, Movie> movieMap;
    private HashMap<String, Director> directorMap;
    private HashMap<String, List<String>> directorMovieMapping;

    public MovieRepository(HashMap<String, Movie> movieMap, HashMap<String, Director> directorMap, HashMap<String, List<String>> directorMovieMapping) {
        this.movieMap = movieMap;
        this.directorMap = directorMap;
        this.directorMovieMapping = directorMovieMapping;
    }

    public void saveMovie(Movie movie) {
        movieMap.put(movie.getName(), movie);
    }

    public void saveDirector(Director director) {
        directorMap.put(director.getName(), director);
    }

    public void saveMovieDirectorPair(String movie, String director) {
        if (movieMap.containsKey(movie) && directorMap.containsKey(director)) {
            movieMap.put(movie, movieMap.get(movie));
            directorMap.put(director, directorMap.get(director));
            List<String> currentMovie = new ArrayList<String>();
            if (directorMovieMapping.containsKey(director))
                currentMovie = directorMovieMapping.get(director);
            currentMovie.add(movie);
            directorMovieMapping.put(director, currentMovie);
        }
    }

    public Movie findMovie(String movieName) {
        return movieMap.get(movieName);
    }

    public Director findDirector(String Directorname) {
        return directorMap.get(Directorname);
    }

    public List<String> findMoviesByDirectorName(String director) {
        List<String> moviesList = new ArrayList<String>();
        if (directorMovieMapping.containsKey(director))
            moviesList = directorMovieMapping.get(director);
        return moviesList;
    }

    public List<String> findALlMovies() {
        return new ArrayList<>(movieMap.keySet());
    }

    public void deleteDirector(String director) {
        List<String> movies = new ArrayList<String>();
        if (directorMovieMapping.containsKey(director)) {
            movies = directorMovieMapping.get(director);
            for (String movie : movies) {
                if (movieMap.containsKey(movie)) {
                    movieMap.remove(movie);
                }
            }

            directorMovieMapping.remove(director);
        }

        if (directorMap.containsKey(director)) {
            directorMap.remove(director);
        }
    }
    public void deleteAllDirectors(){
        HashSet<String> moviesSet = new HashSet<String>();

        //directorMap = new HashMap<>();

        for(String director: directorMovieMapping.keySet()){
            for(String movie: directorMovieMapping.get(director)){
                moviesSet.add(movie);
            }
        }

        for(String movie: moviesSet){
            if(movieMap.containsKey(movie)){
                movieMap.remove(movie);
            }
        }
    }
}