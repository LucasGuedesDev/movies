package br.com.dio.movie.service;

import br.com.dio.movie.model.FilmModel;
import br.com.dio.movie.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class FilmService {
    @Autowired
    private FilmRepository repository;

    public List<FilmModel> findAll() {
        return repository.findAll();
    }

    public Optional<FilmModel> findById(Long id) {
        return repository.findById(id);
    }

    public FilmModel save(FilmModel film) {
        return repository.save(film);
    }

    public FilmModel updateFilm(Long id, FilmModel film) {
        return repository.findById(id).map(existingFilm -> {
            existingFilm.setId(film.getId());
            existingFilm.setTitle(film.getTitle());
            existingFilm.setDirector(film.getDirector());
            existingFilm.setCategory(film.getCategory());
            existingFilm.setYear(film.getYear());
            return repository.save(existingFilm);
        }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Filme não encontrado"));
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}

