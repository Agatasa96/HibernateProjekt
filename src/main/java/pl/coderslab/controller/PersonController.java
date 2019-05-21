package pl.coderslab.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
import pl.coderslab.entity.Person;
import pl.coderslab.service.PersonService;

@Controller
@RequestMapping("/person")
public class PersonController {

	private final PersonService personService;

	public PersonController(PersonService personService) {
		this.personService = personService;
	}

	/*@PostMapping("/save")
	@ResponseBody
	public String savePerson() {
		personService.create();
		return "Created";
	}*/

	@GetMapping("/get/{id}")
	@ResponseBody
	public String findPerson(@PathVariable Long id) {
		Person p = personService.find(id);
		return "Founded: " + p.getLogin();
	}

	@PutMapping("/update/{id}")
	@ResponseBody
	public String updatePerson(@PathVariable Long id) {
		personService.update(id);
		return "Updated";
	}

	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public String deletePerson(@PathVariable Long id) {
		personService.delete(id);
		return "Deleted";
	}

	@GetMapping("/all")
	@ResponseBody
	public List<Person> getAllPeople(){
		return personService.getAll();
	}
	
	@GetMapping("/form")
	public String showForm(Model model) {
		model.addAttribute("person", new Person());
		return "personForm";
	}
	
	@PostMapping("/form")
	@ResponseBody
	public String showFormPost(@ModelAttribute Person person, Model model) {
		//model.addAttribute("person",person);
		personService.create(person);
		return "person added";
	}
}
