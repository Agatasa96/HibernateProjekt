package pl.coderslab.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.coderslab.dao.PersonDao;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Person;

@Service
public class PersonService {

	private final PersonDao personDao;

	public PersonService(PersonDao personDao) {
		this.personDao = personDao;
	}

	public void create(Person person) {
		//Person person = new Person("login", "password", "email");
		personDao.savePerson(person);
	}

	public Person find(Long id) {
		return personDao.findById(id);

	}

	public void update(Long id) {
		Person p = find(id);
		p.setEmail("@@@");
		personDao.updatePerson(p);
	}

	public void delete(Long id) {
		Person p = find(id);
		personDao.deletePerson(p);
	}

	public List<Person> getAll() {
		return personDao.getAllPeople();
	}

}
