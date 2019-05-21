package pl.coderslab.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.coderslab.entity.Person;
import pl.coderslab.entity.PersonDetails;

@Component
@Transactional
public class PersonDetailsDao {
	@PersistenceContext
	EntityManager entityManager;

	public void savePersonDetails(PersonDetails entity) {
		entityManager.persist(entity);
	}

	public PersonDetails findById(long id) {
		return entityManager.find(PersonDetails.class, id);
	}

	public void updatePersonDetails(PersonDetails entity) {
		entityManager.merge(entity);
	}

	public void deletePersonDetails(PersonDetails entity) {
		entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
	}
	
	public List<PersonDetails> getAllDetails(){
		Query query = entityManager.createQuery("Select a from PersonDetails a");
		return query.getResultList();
	}
}
