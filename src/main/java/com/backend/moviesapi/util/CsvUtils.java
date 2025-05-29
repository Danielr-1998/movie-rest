package com.backend.moviesapi.util;

import com.backend.moviesapi.model.Movie;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class CsvUtils {

    public static List<Movie> loadMoviesFromCSV(String path) throws IOException {
        List<Movie> movies = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(
                Objects.requireNonNull(CsvUtils.class.getResourceAsStream(path))))) {
            br.readLine(); // saltar encabezado
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");

                Movie movie = new Movie(
                        Integer.parseInt(tokens[0].trim()),
                        tokens[1].trim(),
                        tokens[2].trim(),
                        tokens[3].trim(),
                        Integer.parseInt(tokens[4].trim()),
                        Integer.parseInt(tokens[5].trim())
                );
                movies.add(movie);
            }
        }
        return movies;
    }
}
