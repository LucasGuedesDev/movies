package br.com.dio.movie.repository;

import br.com.dio.movie.model.FilmModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<FilmModel, Long> {
}

