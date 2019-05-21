package pl.coderslab.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.coderslab.entity.Author;

@Component
@Transactional
public class AuthorDao {

	@PersistenceContext
	EntityManager entityManager;

	public void saveAuthor(Author entity) {
		entityManager.persist(entity);
	}

	public Author findById(long id) {
		return entityManager.find(Author.class, id);
	}

	public void updateAuthor(Author entity) {
		entityManager.merge(entity);
	}

	public void deleteAuthor(Author entity) {
		entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
	}
	
	public List<Author> getAllAuthos(){
		Query query = entityManager.createQuery("Select a from Author a");
		return query.getResultList();
	}
}
