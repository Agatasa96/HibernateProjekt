package pl.coderslab.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.entity.Person;
import pl.coderslab.entity.PersonDetails;
import pl.coderslab.service.PersonDetailsService;

@Controller
@RequestMapping("/personDetails")
public class PersonDetailsController {

	private final PersonDetailsService personDetailsService;

	public PersonDetailsController(PersonDetailsService personDetailsService) {
		this.personDetailsService = personDetailsService;
	}

	@PostMapping("/save")
	@ResponseBody
	public String savePersonDetails() {
		personDetailsService.create();
		return "Created";
	}

	@GetMapping("/get/{id}")
	@ResponseBody
	public String findPersonDetails(@PathVariable Long id) {
		PersonDetails p = personDetailsService.find(id);
		return "Founded: " + p.getLastName();
	}

	@PutMapping("/update/{id}")
	@ResponseBody
	public String updatePersonDetails(@PathVariable Long id) {
		personDetailsService.update(id);
		return "Updated";
	}

	@DeleteMapping("/delete/{id}")
	@ResponseBody
	public String deletePersonDetails(@PathVariable Long id) {
		personDetailsService.delete(id);
		return "Deleted";
	}

	@GetMapping("/all")
	@ResponseBody
	public List<PersonDetails> getAllDetails(){
		return personDetailsService.getAll();
	}
}
