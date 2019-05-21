package pl.coderslab.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;

@Component
@Transactional
public class BookDao {

	@PersistenceContext
	EntityManager entityManager;

	public void saveBook(Book entity) {
		entityManager.persist(entity);
	}

	public Book findById(long id) {
		return entityManager.find(Book.class, id);
	}

	public void updateBook(Book entity) {
		entityManager.merge(entity);
	}

	public void deleteBook(Book entity) {
		entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
	}

	public List<Book> getAllBooks() {
		Query query = entityManager.createQuery("Select a from Book a");
		return query.getResultList();
	}

	public List<Book> getRatingList(int rating) {
		Query query = entityManager.createQuery("Select b from Book b where rating =:rating");
		query.setParameter("rating", rating);
		return query.getResultList();
	}
}
