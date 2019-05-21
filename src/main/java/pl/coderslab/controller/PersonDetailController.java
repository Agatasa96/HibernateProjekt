package pl.coderslab.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.dto.PersonDto;

@Controller
public class PersonDetailController {

	@GetMapping("/form")
	public String show(Model model ) {
		model.addAttribute("personDto", new PersonDto());
		return "detail";
	}
	
	@PostMapping("/form")
	@ResponseBody
	public String showPersonDto(@ModelAttribute PersonDto personDto, Model model ) {
		//model.addAttribute("personDto", new PersonDto());
		return personDto.toString();
	}

	@ModelAttribute("country")
	public Collection<String> countries() {
		List<String> countries = new ArrayList<String>();
		countries.add("Polska");
		countries.add("Niemcy");
		countries.add("Rosja");
		return countries;
	}

	@ModelAttribute("mailing")
	public Collection<String> mailing() {
		List<String> mailing = new ArrayList<String>();
		mailing.add("mail1");
		mailing.add("mail2");
		mailing.add("mail3");
		mailing.add("mail4");
		mailing.add("mail5");
		mailing.add("mail6");
		return mailing;
	}

	@ModelAttribute("programmingSkills")
	public Collection<String> programmingSkills() {
		List<String> programmingSkills = new ArrayList<String>();
		programmingSkills.add("java");
		programmingSkills.add("java ee");
		programmingSkills.add("c++");
		programmingSkills.add("python");

		return programmingSkills;
	}

	@ModelAttribute("hobbies")
	public Collection<String> hobbies() {
		List<String> hobbies = new ArrayList<String>();
		hobbies.add("cooking");
		hobbies.add("dancing");

		return hobbies;
	}
}
