package com.dh.movieservice.api.controller;

import com.dh.movieservice.api.service.MovieService;
import com.dh.movieservice.domain.model.Movie;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService service;

    public MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping("/{genre}")
    ResponseEntity<List<Movie>> getMovieByGenre(@PathVariable String genre) {
        return ResponseEntity.ok().body(service.findByGenre(genre));
    }



    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> create(@RequestBody Movie movie) {
        service.createMovie(movie);
        return ResponseEntity.ok("Pelicula creada exitosamente");
    }
}
