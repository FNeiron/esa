package org.book.esa.repositories;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.book.esa.models.Genre;

import java.util.List;

@Stateless
public class GenreRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public Long save(Genre genre) {
        entityManager.persist(genre);
        return genre.getId();
    }

    public Genre findById(Long id) {
        return entityManager.find(Genre.class, id);
    }

    public void deleteById(Long id) {
        Genre genre = findById(id);
        if (genre != null) {
            entityManager.remove(genre);
        }
    }

    public List<Genre> findAll() {
        return entityManager.createQuery("SELECT g FROM Genre g", Genre.class).getResultList();
    }
}
