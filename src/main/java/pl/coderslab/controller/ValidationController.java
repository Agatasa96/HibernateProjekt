package pl.coderslab.controller;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import pl.coderslab.entity.Book;
import pl.coderslab.validator.TextValidationGroup;
@Controller
public class ValidationController {

	@Autowired
	private Validator validator;

	@RequestMapping("/validate")
	
	public String validateTest(Model model ) {
		Book book = new Book();
		Set<ConstraintViolation<Book>> violations = validator.validate(book, TextValidationGroup.class);
		if (!violations.isEmpty()) {
			for (ConstraintViolation<Book> constraintViolation : violations) {
				System.out.println(constraintViolation.getPropertyPath() + " " + constraintViolation.getMessage());
			}
			model.addAttribute("validations", violations);
		} else {
			// save object }

		}
		return "validateResult";
	}

}
