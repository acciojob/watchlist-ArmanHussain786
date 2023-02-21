package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieService {
   @Autowired
    MovieRepository movieRepository;


    public void addMovie(Movie movie)
   {
       movieRepository.saveMovie(movie);
   }
   public void addDirector(Director director)
   {
       movieRepository.saveDirector(director);
   }
   public void createdMovieDirectorPair(String movie,String director)
   {
       movieRepository.saveMovieDirectorPair(movie,director);
   }
   public Movie findMovie(String Moviename)
   {
      return movieRepository.findMovie(Moviename);
   }
   public Director findDirector(String Directorname)
   {
      return movieRepository.findDirector(Directorname);
   }
   public List<String> findMoviesByDirectorName(String director)
   {
       return movieRepository.findMoviesByDirectorName(director);
   }
    public List<String> findALlMovies()
    {
        return movieRepository.findALlMovies();
    }
    public void deleteDirector(String director)
    {
        movieRepository.deleteDirector(director);
    }
    public void deleteALlDirectors()
    {
        movieRepository.deleteAllDirectors();
    }
}
