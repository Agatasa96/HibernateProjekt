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
import pl.coderslab.entity.PersonDetails;
import pl.coderslab.entity.Publisher;
import pl.coderslab.service.PublisherService;

@Controller
@RequestMapping("/publishers")
public class PublisherController {

	private final PublisherService publisherService;

	public PublisherController(PublisherService publisherService) {

		this.publisherService = publisherService;
	}

	@GetMapping("/save")

	public String savePublisher(Model model) {
		model.addAttribute("publisher", new Publisher());
		// publisherService.create();
		return "publisherForm";
	}

	@PostMapping("/save")

	public String savePublisher(@Valid @ModelAttribute Publisher publisher, BindingResult result) {
		if (result.hasErrors()) {
			return "publisherForm";
		} else {
			publisherService.create(publisher);
			return "allPublishers";
		}
	}

	@GetMapping("/get/{id}")
	@ResponseBody
	public String findPublisher(@PathVariable Long id) {
		Publisher p = publisherService.find(id);
		return "Founded: " + p.getName();
	}

	@GetMapping("/update/{id}")

	public String updatePublisher(@PathVariable Long id, Model model) {
		// publisherService.update(id);
		model.addAttribute("publisherToUpdate", publisherService.find(id));
		return "updatePublisherForm";
	}

	@PostMapping("/update/{id}")

	public String updatePublisher(@Valid @ModelAttribute Publisher publisherToUpdate, BindingResult result) {
		if (result.hasErrors()) {
			return "updatePublisherForm";
		} else {
			publisherService.update(publisherToUpdate);
			return "allPublishers";
		}
	}

	@GetMapping("/delete/{id}")
	@ResponseBody
	public String deletePublisher(@PathVariable Long id) {
		publisherService.delete(id);
		return "Deleted";
	}

	@GetMapping("/all")
	@ResponseBody
	public List<Publisher> getAllPublisher() {
		return publisherService.getAll();
	}

	@ModelAttribute("publishers")
	public Collection<Publisher> publishers() {
		return publisherService.getAll();
	}

}
