package pl.coderslab.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

import pl.coderslab.entity.Book;
import pl.coderslab.entity.Person;

@Component
@Transactional
public class PersonDao {
	@PersistenceContext
	EntityManager entityManager;

	public void savePerson(Person entity) {
		entityManager.persist(entity);
	}

	public Person findById(long id) {
		return entityManager.find(Person.class, id);
	}

	public void updatePerson(Person entity) {
		entityManager.merge(entity);
	}

	public void deletePerson(Person entity) {
		entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
	}
	
	public List<Person> getAllPeople(){
		Query query = entityManager.createQuery("Select a from Person a");
		return query.getResultList();
	}
}
