package br.com.dio.movie.model;
import jakarta.persistence.*;

@Entity
@Table(name = "filmes")
public class FilmModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String director;
    private String category;
    private int year;

    public FilmModel() {}

    public FilmModel(String title, String director, String category, int Year) {
        this.title = title;
        this.director = director;
        this.category = category;
        this.year = Year;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDirector() { return director; }
    public void setDirector(String director) { this.director = director; }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

