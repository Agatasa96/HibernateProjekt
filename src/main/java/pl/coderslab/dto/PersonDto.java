package pl.coderslab.dto;

import java.util.List;

public class PersonDto {

	private String login;
	private String password;
	private String email;
	private String firstName;
	private String lastName;
	private String gender;
	private String country;
	private String notes;
	private List<String> mailingList;
	private List<String> programmingSkills;
	private List<String> hobbies;

	public PersonDto(String login, String password, String email, String firstName, String lastName, String gender,
			String country, String notes, List<String> mailingList, List<String> programmingSkills,
			List<String> hobbies) {
		super();
		this.login = login;
		this.password = password;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.country = country;
		this.notes = notes;
		this.mailingList = mailingList;
		this.programmingSkills = programmingSkills;
		this.hobbies = hobbies;
	}

	public PersonDto() {
		super();
	}

	@Override
	public String toString() {
		return "PersonDto [login=" + login + ", password=" + password + ", email=" + email + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", gender=" + gender + ", country=" + country + ", notes=" + notes
				+ ", mailingList=" + mailingList + ", programmingSkills=" + programmingSkills + ", hobbies=" + hobbies
				+ "]";
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public List<String> getMailingList() {
		return mailingList;
	}

	public void setMailingList(List<String> mailingList) {
		this.mailingList = mailingList;
	}

	public List<String> getProgrammingSkills() {
		return programmingSkills;
	}

	public void setProgrammingSkills(List<String> programmingSkills) {
		this.programmingSkills = programmingSkills;
	}

	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}

}
