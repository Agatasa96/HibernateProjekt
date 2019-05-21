package pl.coderslab.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.coderslab.dao.PersonDetailsDao;
import pl.coderslab.entity.Person;
import pl.coderslab.entity.PersonDetails;

@Service
public class PersonDetailsService {

	private final PersonDetailsDao personDetailsDao;

	public PersonDetailsService(PersonDetailsDao personDetailsDao) {
		this.personDetailsDao = personDetailsDao;
	}

	public void create() {
		PersonDetails personDetails = new PersonDetails("firstName", "lastName", 33, "street", "city");
		personDetailsDao.savePersonDetails(personDetails);
	}

	public PersonDetails find(Long id) {
		return personDetailsDao.findById(id);

	}

	public void update(Long id) {
		PersonDetails p = find(id);
		p.setCity("cicici");
		personDetailsDao.updatePersonDetails(p);
	}

	public void delete(Long id) {
		PersonDetails p = find(id);
		personDetailsDao.deletePersonDetails(p);
	}
	
	public List<PersonDetails> getAll() {
		return personDetailsDao.getAllDetails();
	}

}
