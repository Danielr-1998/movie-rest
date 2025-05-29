package com.backend.moviesapi.controller;

import com.backend.moviesapi.model.Movie;
import com.backend.moviesapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService service;

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable int id) {
        return service.getMovieById(id);
    }

    @GetMapping
    public List<Movie> getMovies(@RequestParam int total, @RequestParam String order) {
        return service.getMovies(total, order);
    }

    @PostMapping
    public Map<String, String> addMovie(@RequestBody Movie movie) {
        service.addMovie(movie);
        return Map.of("message", "La película fue creada con éxito");
    }
}
