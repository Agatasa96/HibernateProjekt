package pl.coderslab.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.coderslab.entity.PersonDetails;
import pl.coderslab.entity.Publisher;

@Component
@Transactional
public class PublisherDao {

	@PersistenceContext
	EntityManager entityManager;

	public void savePublisher(Publisher entity) {
		entityManager.persist(entity);
	}

	public Publisher findById(long id) {
		return entityManager.find(Publisher.class, id);
	}

	public void updatePublisher(Publisher entity) {
		entityManager.merge(entity);
	}

	public void deletePublisher(Publisher entity) {
		entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
	}
	
	public List<Publisher> getAllPub(){
		Query query = entityManager.createQuery("Select a from Publisher a");
		return query.getResultList();
	}

}
