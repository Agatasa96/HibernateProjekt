package pl.coderslab.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import pl.coderslab.entity.Book;

@Repository
public class BookRepositoryImpl implements Book2Repository{

	@PersistenceUnit
    private EntityManager emFactory;
	
	@Override
	public void resetRating(int rating) {
		Query query = emFactory.createQuery("Select a from Book a");
		List<Book> books =  query.getResultList();
		for (Book b: books) {
			b.setRating(rating);
		}
		
	}

}
