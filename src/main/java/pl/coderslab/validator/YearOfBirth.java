package pl.coderslab.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class YearOfBirth implements ConstraintValidator<YearValiator, Integer> {

	@Override
	public void initialize(YearValiator constraintAnnotation) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isValid(Integer value, ConstraintValidatorContext context) {
		return value.intValue()<=2000;
	}

}
