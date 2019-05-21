package pl.coderslab.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.coderslab.dao.PublisherDao;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Person;
import pl.coderslab.entity.Publisher;

@Service
public class PublisherService {

	private final PublisherDao publisherDao;

	public PublisherService(PublisherDao publisherDao) {
		this.publisherDao = publisherDao;
	}

	public void create(Publisher publisher) {
		//Publisher publisher = new Publisher("name");
		publisherDao.savePublisher(publisher);
	}

	public Publisher find(Long id) {
		return publisherDao.findById(id);

	}

	public void update(Publisher publisher) {
		//Publisher p = find(id);
		//p.setName("new name");
		publisherDao.updatePublisher(publisher);
	}

	public void delete(Long id) {
		Publisher p = find(id);
		publisherDao.deletePublisher(p);
	}

	public List<Publisher> getAll() {
		return publisherDao.getAllPub();
	}

}
