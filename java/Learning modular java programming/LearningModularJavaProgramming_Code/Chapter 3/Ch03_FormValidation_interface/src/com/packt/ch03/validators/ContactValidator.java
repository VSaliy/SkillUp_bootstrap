package com.packt.ch03.validators;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.packt.ch03.pojo.Contact;

public class ContactValidator implements Validator {

	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return arg0.equals(Contact.class);
	}

	public void validate(Object object, Errors errors) {
		// TODO Auto-generated method stub
		Contact contact = (Contact) object;
		if (contact.getFirstName().length() < 2
				|| contact.getFirstName().length() > 10) {
			errors.rejectValue("firstName", "name.required",
					"Please Enter First Name");
		}

		if (contact.getLastName().length() < 2
				|| contact.getLastName().length() > 10) {
			errors.rejectValue("lastName", "lname.required",
					"Please Enter Last Name");
		}

		if (contact.getAddress().length() < 4
				|| contact.getAddress().length() > 40) {
			errors.rejectValue("address", "address.required",
					"please enter you full address");
		}

		if ((contact.getPhone_number().length() <= 0)
				|| (contact.getPhone_number().length() != 10)) {
			errors.rejectValue("phone_number", "phone_number.incorrect",
					"Please Enter Phone Number of 10 digits");
		}

		if (contact.getPhone_number().length() > 0) {
			String MOBILE_PATTERN = "[0-9]{10}";
			Pattern pattern = Pattern.compile(MOBILE_PATTERN);
			Matcher matcher = pattern.matcher(contact.getPhone_number());

			if (!matcher.matches()) {
				errors.rejectValue("phone_number", "phone_number.incorrect",
						"Enter a Correct Phone Number");
			}
		}

		if (contact.getEmail().length() == 0) {
			errors.rejectValue("email", "email.required",
					"Please Enter Valid Email ID");
		}

		if (!(contact.getEmail() != null && contact.getEmail().isEmpty())) {
			String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
					+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
			Pattern pattern = Pattern.compile(EMAIL_PATTERN);
			Matcher matcher = pattern.matcher(contact.getEmail());
			if (!matcher.matches()) {
				errors.rejectValue("email", "email.incorrect",
						"Enter a Correct email ID");
			}

		}

	}

}
