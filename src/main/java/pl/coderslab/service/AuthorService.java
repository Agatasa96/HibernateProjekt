package pl.coderslab.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.coderslab.dao.AuthorDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;

@Service
public class AuthorService {

	private final AuthorDao authorDao;

	public AuthorService(AuthorDao authorDao) {
		this.authorDao = authorDao;
	}

	public void create(Author author) {
		//Author author = new Author("firstName", "lastName");
		authorDao.saveAuthor(author);
	}

	public Author find(Long id) {
		return authorDao.findById(id);

	}

	public void update(Author author) {
		authorDao.updateAuthor(author);
	}

	public void delete(Long id) {
		Author a = find(id);
		authorDao.deleteAuthor(a);
	}

	public List<Author> getAll(){
		return authorDao.getAllAuthos();
	}
}
