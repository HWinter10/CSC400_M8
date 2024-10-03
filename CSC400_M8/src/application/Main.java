package application;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Queue queue = new Queue(); // queue to hold people
		
		try { // adding people to queue
            addPeopleToQueue(queue, scanner);
            displayAndSortQueue(queue);
        } finally {
            scanner.close();
        }
    }
	// Method - Prompt usee to add 5 people
	private static void addPeopleToQueue(Queue queue, Scanner scanner) {
		// Initial prompt
		System.out.println("--Enter the first name, last name, and age of 5 people--");
		// Loop until 5 people added
		for (int personCount = 0; personCount < 5; personCount++) { 
		    String firstName = promptForName(scanner, "First name: "); // first name
		    String lastName = promptForName(scanner, "Last name: ");  // last name
		    int age = promptForAge(scanner); // age
		    queue.enqueue(new Person(firstName, lastName, age)); // add person to queue
		}
	}
	// Validation Method - Name (letters only)
	private static String promptForName(Scanner scanner, String message) {
        String name;
        // Loop until valid name entered
        while (true) { 
            System.out.print(message); // show prompt - first name, last name, etc. 
            name = scanner.nextLine();
            
            // validation - (letters only)
            if (name.matches("^[A-Za-z]+$")) {
                break;
            } else {
                System.out.println("--Invalid input. Letters only--");
            }
        }
        return name; // return valid name
    }
	// Validation Method - Age (0-120)
    private static int promptForAge(Scanner scanner) {
        int age;
        // Loop until valid age entered
        while (true) { 
            System.out.print("Age: "); // show prompt - age
            
            // validation - check if input is integer
            if (scanner.hasNextInt()) {
                age = scanner.nextInt();
                scanner.nextLine(); 
                
                // validation - check if in range (0-120)
                if (age >= 0 && age <= 120) {
                    return age; // return valid age
                } else {
                    System.out.println("--Invalid input. Age from 0-120 only--");
                }
            } else {
                System.out.println("--Invalid input. Numbers only--");
                scanner.nextLine(); 
            }
        }
    }
    // Method - Display & Sort Queue (by last name and age)
    private static void displayAndSortQueue(Queue queue) {
        System.out.println("\nQueue before sorting:");
        queue.displayQueue(); // before sorting
    
			// Sort by last name (descending order)
			queue.quickSortByLastName(0, queue.getQueueSize() - 1);
			System.out.println("\nQueue sorted by last name (Descending):");
			queue.displayQueue(); // sorted by last name
		
			// Sort by age (descending order)
			queue.quickSortByAge(0, queue.getQueueSize() - 1);
			System.out.println("\nQueue sorted by age (Descending):");
			queue.displayQueue(); // sorted by age
		}
}
