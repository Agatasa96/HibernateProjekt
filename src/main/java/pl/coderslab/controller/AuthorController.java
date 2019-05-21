package pl.coderslab.controller;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

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
import pl.coderslab.entity.Author;
import pl.coderslab.entity.Book;
import pl.coderslab.service.AuthorService;

@Controller
@RequestMapping("/authors")
public class AuthorController {

	private final AuthorService authorService;

	public AuthorController(AuthorService authorService) {
		this.authorService = authorService;
	}

	@GetMapping("/save")
	public String saveAuthor(Model model) {
		// authorService.create();
		model.addAttribute("author", new Author());
		return "authorForm";
	}

	@PostMapping("/save")

	public String saveAuthor(@Valid @ModelAttribute Author author, BindingResult result) {
		if (result.hasErrors()) {
			return "authorForm";
		} else {
			authorService.create(author);
			return "allAuthors";
		}
	}

	@GetMapping("/get/{id}")
	@ResponseBody
	public String findAuthor(@PathVariable Long

	id) {
		Author a = authorService.find(id);
		return "Founded: " + a.getLastName();
	}

	@GetMapping("/update/{id}")

	public String updateAuthor(@PathVariable Long id, Model model) {
		// authorService.update(id);
		model.addAttribute("authorToUpdate", authorService.find(id));
		return "updateAuthorForm";
	}

	@PostMapping("/update/{id}")

	public String updateAuthor(@Valid @ModelAttribute Author authorToUpdate, BindingResult result) {
		if (result.hasErrors()) {
			return "updateAuthorForm";
		} else {
			authorService.update(authorToUpdate);
			return "allAuthors";
		}
	}

	@GetMapping("/delete/{id}")
	@ResponseBody
	public String deleteAuthor(@PathVariable Long id) {
		authorService.delete(id);
		return "Deleted";
	}

	@GetMapping("/all")
	@ResponseBody
	public List<Author> getAllAuthors() {
		return authorService.getAll();
	}

	@ModelAttribute("authors")
	public Collection<Author> authors() {
		return authorService.getAll();
	}
}
