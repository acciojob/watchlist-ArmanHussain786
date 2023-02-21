package com.driver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MovieController {

    @Autowired
    MovieService movieService;

    //add the movie information
    @PostMapping("/add-movie")
    public ResponseEntity addMovie(@RequestBody Movie movie)
    {
        movieService.addMovie(movie);
        return new ResponseEntity<>("New movie added successfully", HttpStatus.CREATED);
    }

    //add the director information
    @PostMapping("/add-director")
    public ResponseEntity addDirector(@RequestBody Director director)
    {
        movieService.addDirector(director);
        return new ResponseEntity<>("New director added successfully", HttpStatus.CREATED);
    }

    @PutMapping("/add-movie-director-pair")
    public ResponseEntity addMovieDirectorPair(@RequestParam String movie,@RequestParam String director)
    {
        movieService.createdMovieDirectorPair(movie,director);
        return new ResponseEntity<>("New movie-director pair added",HttpStatus.CREATED);
    }

    @GetMapping("get-movie-by-name/{name}")
    public ResponseEntity getMovieByName(@PathVariable String name)
    {
      Movie movie=  movieService.findMovie(name);
        return new ResponseEntity<>(movie,HttpStatus.FOUND);
    }

    @GetMapping("get-director-by-name/{name}")
    public ResponseEntity  getDirectorByName(@PathVariable String name)
    {
        Director director=  movieService.findDirector(name);
        return new ResponseEntity<>(director,HttpStatus.FOUND);
    }

    @GetMapping("get-movies-by-director-name/{director}")
    public ResponseEntity getMoviesByDirectorName(@PathVariable String director )
    {
        List<String> movies = movieService.findMoviesByDirectorName(director);
        return new ResponseEntity<>(movies,HttpStatus.FOUND);
    }
    @GetMapping("/get-all-movies")
    public ResponseEntity  findAllMovies()
    {
        List<String> movies = movieService.findALlMovies();
        return new ResponseEntity<>(movies,HttpStatus.FOUND);
    }
    @DeleteMapping("delete-director-by-name")
    public ResponseEntity deleteDirectorByName(@RequestParam String director)
    {
      movieService.deleteDirector(director);
              return new ResponseEntity<>(director + "removed successfully",HttpStatus.CREATED);
    }
    @DeleteMapping("delete-all-directors")
    public ResponseEntity  deleteAllDirectors()
    {
        movieService.deleteALlDirectors();
        return new ResponseEntity<>("All directors deleted successfully",HttpStatus.CREATED);
    }

}
