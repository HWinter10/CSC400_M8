package application;

import java.util.ArrayList;

public class Queue {
	private ArrayList<Person> peopleQueue = new ArrayList<>(); // List to store people in queue
	
	// Method - Add Person to Queue
	public void enqueue(Person person) {
		peopleQueue.add(person);
	}
	// Method - Display Queue
	public void displayQueue() {
		// loop to display each person object info
		for (Person person : peopleQueue) {
			System.out.println(person);
		}
	}
    // Getter Method - Return size of queue
    public int getQueueSize() {
        return peopleQueue.size();
    }
    // Getter Method - Return person at specified index in queue
    public Person getPersonAt(int index) {
    	// check if index valid
        if (index < 0 || index >= peopleQueue.size()) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + peopleQueue.size());
        }
        return peopleQueue.get(index); // return person at specified index
    }
	// Method - QuickSort by Last Name (Descending)
	public void quickSortByLastName(int low, int high) {
		// check if list needs sorted
		if (low < high) {
			int pi = partitionByLastName(low, high); // partition queue, get pivot index
			// recursively sort elements before & after partition
			quickSortByLastName(low, pi - 1);
			quickSortByLastName(pi + 1, high);
		}
	}
    // Method - Partition Sorting by Last Name (descending)
	private int partitionByLastName(int low, int high) {
	    String pivot = peopleQueue.get(high).getLastName(); // pivot - last name of last person
	    int i = low - 1; // initialize index for smaller elements
	    // iterate over list to place elements on correct side of pivot
	    for (int j = low; j < high; j++) { 
	        // compare last names - if equal, compare first names
	        if (peopleQueue.get(j).getLastName().compareTo(pivot) > 0 ||
	           (peopleQueue.get(j).getLastName().equals(pivot) && 
	            peopleQueue.get(j).getFirstName().compareTo(peopleQueue.get(high).getFirstName()) > 0)) {
	            i++; // move index of smaller element
	            swap(i, j); // swap current with element at index i
	        }
	    }
	    swap(i + 1, high); // place pivot in correct position
	    return i + 1; // return the pivot index
	}
	// Method - QuickSort by Age (descending)
	public void quickSortByAge(int low, int high) {
		// check if list needs sorted
		if (low < high) {
			int pi = partitionByAge(low, high); // partition queue & get pivot index
			// recursively sort before & after partition
			quickSortByAge(low, pi - 1);
			quickSortByAge(pi + 1, high);
		}
	}
    // Method - Partition Sorting by Age (descending)
	private int partitionByAge(int low, int high) {
	    int pivot = peopleQueue.get(high).getAge(); // pivot is age of last person
	    int i = low - 1; // initialize index for smaller elements
	    // iterate over list to place elements on correct side of pivot
	    for (int j = low; j < high; j++) {
	    	// compare ages - if equal, compare last names
	        if (peopleQueue.get(j).getAge() > pivot ||
	           (peopleQueue.get(j).getAge() == pivot &&
	            peopleQueue.get(j).getLastName().compareTo(peopleQueue.get(high).getLastName()) > 0)) {
	            i++; // move index of smaller element
	            swap(i, j); // swap current with element at index i
	        }
	    }
	    swap(i + 1, high); // place pivot element in correct position
	    return i + 1; // return the pivot index
	}
	// Method - Swap two persons in Queue
	private void swap (int i, int j) {
		Person temp = peopleQueue.get(i); // temporarily store person at index i
		peopleQueue.set(i, peopleQueue.get(j)); // move person at index j to index i
		peopleQueue.set(j,  temp); // place person from index i into index j
	}
}









