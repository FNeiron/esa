package org.book.esa.repositories;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.book.esa.models.Author;

import java.util.List;

@Stateless
public class AuthorRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public Author findById(Long id) {
        return entityManager.find(Author.class, id);
    }

    public Long save(Author author) {
        entityManager.persist(author);
        return author.getId();
    }

    public void deleteById(Long id) {
        Author author = findById(id);
        if (author != null) {
            entityManager.remove(author);
        }
    }

    public List<Author> findAll() {
        return entityManager.createQuery("select i from Author i", Author.class).getResultList();
    }
}
