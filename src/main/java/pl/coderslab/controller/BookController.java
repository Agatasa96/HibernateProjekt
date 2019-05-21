package pl.coderslab.controller;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.dao.BookDao;
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.entity.Publisher;
import pl.coderslab.service.AuthorService;
import pl.coderslab.service.BookService;
import pl.coderslab.service.PublisherService;

@Controller
@RequestMapping("/books")
public class BookController {

	private final BookService bookService;
	private final PublisherService publisherService;
	private final AuthorService authorService;

	public BookController(BookService bookService, PublisherService publisherService, AuthorService authorService) {
		this.publisherService = publisherService;
		this.bookService = bookService;
		this.authorService = authorService;
	}

	/*
	 * @PostMapping("/save")
	 * 
	 * @ResponseBody public String saveBook() { bookService.create(); return
	 * "Created"; }
	 */
	@GetMapping("/get/{id}")
	@ResponseBody
	public String findBook(@PathVariable Long id) {
		Book b = bookService.find(id);
		return "Founded: " + b.getTitle();
	}

	@GetMapping("/update/{id}")

	public String updateBook(@PathVariable Long id, Model model) {
		model.addAttribute("bookToUpdate", bookService.find(id));

		return "updateBookForm";
	}

	@PostMapping("/update/{id}")
	public String updateBook(@Valid @ModelAttribute Book bookToUpdate, BindingResult result) {
		if (result.hasErrors()) {
			return "updateBookForm";
		} else {
			bookService.update(bookToUpdate);
			return "allBooks";
		}
	}

	@GetMapping("/delete/{id}")
	@ResponseBody
	public String deleteBook(@PathVariable Long id) {
		bookService.delete(id);
		return "Deleted";
	}

	@GetMapping("/all")
	@ResponseBody
	public List<Book> getAllBooks() {
		return bookService.getAll();
	}

	@GetMapping("/rating/{rating}")
	@ResponseBody
	public List<Book> getRatingList(@PathVariable(name = "rating") int rating) {
		return bookService.getRatingList(rating);
	}

	@GetMapping("/form")
	public String getForm(Model model) {
		model.addAttribute("book", new Book());
		return "bookForm";

	}

	@PostMapping("/form")
	public String saveBook(@Valid @ModelAttribute Book book, BindingResult result) {
		if (result.hasErrors()) {
			return "bookForm";
		} else {
			bookService.create(book);
			return "allBooks";
		}
	}

	@RequestMapping("/sureToDelete/{id}")
	public String sure(@PathVariable Long id, Model model) {
		model.addAttribute("id", id);
		return "sureToDelete";
	}

	@ModelAttribute("publishers")
	public Collection<Publisher> publishers() {
		return publisherService.getAll();
	}

	@ModelAttribute("authors")
	public Collection<Author> authors() {
		return authorService.getAll();
	}

	@ModelAttribute("books")
	public Collection<Book> books() {
		return bookService.getAll();
	}
}
