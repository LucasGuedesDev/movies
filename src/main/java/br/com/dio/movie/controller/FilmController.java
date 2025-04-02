package br.com.dio.movie.controller;

import br.com.dio.movie.model.FilmModel;
import br.com.dio.movie.service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/filmes")
public class FilmController {
    @Autowired
    private FilmService service;

    @GetMapping
    public List<FilmModel> getAllFilms() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public FilmModel getFilmById(@PathVariable Long id) {
        return service.findById(id).orElseThrow(() -> new RuntimeException("Filme não encontrado"));
    }

    @PostMapping
    public FilmModel createFilm(@RequestBody FilmModel film) {
        return service.save(film);
    }

    @PutMapping("/{id}")
    public FilmModel updateFilm(@PathVariable Long id, @RequestBody FilmModel film) {
        film.setId(id);
        return service.save(film);
    }

    @DeleteMapping("/{id}")
    public void deleteFilm(@PathVariable Long id) {
        service.deleteById(id);
    }
}

