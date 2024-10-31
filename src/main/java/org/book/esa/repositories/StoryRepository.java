package org.book.esa.repositories;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.book.esa.models.Story;

import java.util.List;

@Stateless
public class StoryRepository {
    @PersistenceContext
    private EntityManager entityManager;

    public Story findById(Long id) {
        return entityManager.find(Story.class, id);
    }

    public Long save(Story story) {
        entityManager.persist(story);
        return story.getId();
    }

    public void deleteById(Long id) {
        Story story = findById(id);
        if (story != null) {
            entityManager.remove(story);
        }
    }

    public List<Story> findAll() {
        return entityManager.createQuery("select i from Story i", Story.class).getResultList();
    }
}
