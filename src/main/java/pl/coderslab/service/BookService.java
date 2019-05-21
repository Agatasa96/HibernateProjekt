package pl.coderslab.service;

import java.util.List;

import org.springframework.stereotype.Service;

import pl.coderslab.dao.BookDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;
import pl.coderslab.repo.BookRepository;

@Service
public class BookService {

	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public void create(Book book) {
		// Book book = new Book("title", "desc", 3);
		bookRepository.save(book);

	}

	public Book find(Long id) {
		return bookRepository.findOne(id);

	}

	public void update(Book book) {

		bookRepository.save(book);
	}

	public void delete(Long id) {
		Book b = find(id);
		bookRepository.delete(b);
	}

	public List<Book> getAll() {
		return bookRepository.findAll();
	}

	public List<Book> getRatingList(int rating) {
		return bookRepository.findByRating(rating);
	}

	public void resetRating(int rating) {

		bookRepository.resetRating(rating);

	}

}
