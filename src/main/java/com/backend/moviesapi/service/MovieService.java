package com.backend.moviesapi.service;

import com.backend.moviesapi.exception.MovieNotFoundException;
import com.backend.moviesapi.model.Movie;
import com.backend.moviesapi.util.CsvUtils;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class MovieService {

    private final List<Movie> movies = new ArrayList<>();

    @PostConstruct
    public void init() throws IOException {
        movies.addAll(CsvUtils.loadMoviesFromCSV("/movies.csv"));
    }

    public Movie getMovieById(int id) {
        return movies.stream()
                .filter(m -> m.getId() == id)
                .findFirst()
                .orElseThrow(() -> new MovieNotFoundException(id));
    }

    public List<Movie> getMovies(int total, String order) {
        Comparator<Movie> comparator = Comparator.comparing(Movie::getFilm, String.CASE_INSENSITIVE_ORDER);
        if ("desc".equalsIgnoreCase(order)) comparator = comparator.reversed();

        return movies.stream()
                .sorted(comparator)
                .limit(total)
                .collect(Collectors.toList());
    }

    public void addMovie(Movie movie) {
        movies.add(movie);
    }
}
