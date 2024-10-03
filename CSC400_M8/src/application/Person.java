package application;

public class Person {
	private String firstName; // first name
	private String lastName; // last name
	private int age; // age
	
	// Constructor
	public Person(String firstName, String lastName, int age) {
		validateInput(firstName, lastName, age); // validate input before assigning
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}
	// Method - Validation
	private void validateInput (String firstName, String lastName, int age) {
		// ensure name not null, not empty, and contains only letters
		if (firstName == null || firstName.isEmpty() || !firstName.matches("^[A-Za-z]+$")) {
            throw new IllegalArgumentException("--Invalid first name. Letters only--");
        }
		// ensure name not null, not empty, and contains only letters
        if (lastName == null || lastName.isEmpty() || !lastName.matches("^[A-Za-z]+$")) {
            throw new IllegalArgumentException("--Invalid last name. Letters only--");
        }
        // ensure age range 0-120
        if (age < 0 || age > 120) {
            throw new IllegalArgumentException("--Invalid age. Numbers between 0 and 120 only--");
        }
	}
	// Method - Display Person's Information
	@Override
	public String toString() {
		return lastName + ", " + firstName + " - Age: " + age;
	}
	// Getter Method - First Name
    public String getFirstName() {
        return firstName;
    }
    // Getter Method - Last Name
    public String getLastName() {
        return lastName;
    }
    // Getter Method - Age
    public int getAge() {
        return age;
    }
}
