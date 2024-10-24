package lab05;

import java.util.Arrays;

/**
 * Represents a sorted set of doubles backed by a simple array. 
 * The set remains sorted at all times and does not allow duplicates.
 */
public class SortedBinarySet {
	/** The array that holds the list of values */
	public double[] theData;
	/** The capacity of the storage array */
	private int capacity;
	/** The current number of elements in the list */
	private int size;

	/** Constant for the initial storage array capacity */
	private static final int INITIAL_STORAGE_CAPACITY = 11;

	/** A flag to toggle between binary search and sequential search. */
	public boolean usesBinarySearch = true; //Keep as false for the Lab. You will need this in the assignment.

	/**
     * Default constructor that initializes the set with the default capacity.
     */
    public SortedBinarySet() {
        // Initialize theData array with INITIAL_STORAGE_CAPACITY
        this.theData = new double[INITIAL_STORAGE_CAPACITY];
        
        // Set the capacity to the initial storage capacity
        this.capacity = INITIAL_STORAGE_CAPACITY;
        
        // Initialize size to 0 as the set is empty at creation
        this.size = 0;
    }


	/**
	 * Constructor that initializes the set with an input array.
	 * This is for the assignment, not for the lab.
	 * @param input The array to initialize the set with.
	 */
    public SortedBinarySet(double[] input) {
        this(); // Call the default constructor to initialize the set
        for (double value : input) {
            insert(value); // This will handle duplicates and sorting
        }
    }

	/**
	 * Checks if the set is empty.
	 * @return true if the set is empty, false otherwise.
	 */
	public boolean empty() {
        // The set is empty if size is 0
        return size == 0;
    }

	/**
	 * Returns the number of elements in the set.
	 * @return The number of elements in the set.
	 */
	public int size(){
		// TODO: Lab Part 2.3 - Return the size of the SortedBinarySet
		return size; // placeholder
	}

	/**
	 * Grows the storage array by doubling its capacity.
	 */
	public void grow() {
	    // Double the size of theData
	    int newCapacity = capacity * 2;
	    double[] newData = new double[newCapacity];
	    
	    // Copy existing elements to the new array
	    System.arraycopy(theData, 0, newData, 0, size);
	    
	    // Update theData and capacity
	    theData = newData;
	    capacity = newCapacity;
	}

	/**
	 * Converts the set to a string that includes its elements, capacity, and size.
	 * This is primarily used for testing purposes.
	 * @return A string representing the set.
	 */
	public String toString(){
		// TODO: Lab Part 2.5 - Return the list of elements, current capacity, and size as a string
		return "Elements: " + Arrays.toString(Arrays.copyOf(theData, size)) +
	               ", Capacity: " + capacity +
	               ", Size: " + size;
	}

	/**
	 * Clears all elements from the set.
	 * After this method is called, the set should be empty.
	 */
	public void clear() {
		// TODO: Lab Part 2.6 - Remove all elements from the SortedBinarySet and update class variables
		size = 0;
		theData = new double[INITIAL_STORAGE_CAPACITY];
        capacity = INITIAL_STORAGE_CAPACITY;
    }
	

	/**
	 * Inserts a new value into the set in the correct position.
	 * The value is inserted only if it's not already in the set.
	 * @param newVal The value to insert.
	 * @return true if the value was successfully inserted, false if it already exists.
	 */
	public boolean insert(double newVal){
		// TODO: Lab Part 2.7 - Insert newVal in sorted order if it does not exist
		// Check if there's enough room, if not, grow the array
        if (size == capacity) {
            grow();
        }

        // Find the index where newVal should be inserted
        int index = findIndex(newVal);

        // If newVal already exists, return false
        if (index >= 0) {
            return false;
        }

        // Convert the negative index to its actual insertion position
        index = -index - 1;

        // Shift elements to make room for the new value
        System.arraycopy(theData, index, theData, index + 1, size - index);

        // Insert the new value
        theData[index] = newVal;
        size++;

        return true;
	}

	/**
	 * Sequentially searches for a target in the set.
	 * @param target The target value to search for.
	 * @return The index where the target is found, or -index - 1 if not found.
	 */
	private int sequentialFind(double target) {
		// TODO: Lab Part 2.8 - Implement sequential search for the target
		for (int i = 0; i < size; i++) {
            if (theData[i] == target) {
                return i; // target found
            }
            if (theData[i] > target) {
                return -i - 1; // target should be inserted at index i
            }
        }
        return -size - 1; // target should be inserted at the end
	}

	//*********************************************************************
	// * you will implement the rest of the methods for your assignment    *
	// * don't touch them before finishing the lab portion                 *
	// *********************************************************************
	
	/**
	 * Removes a specified element from the set.
	 * @param element The element to remove.
	 * @return true if the element was removed, false if it did not exist.
	 */
	public boolean remove(double value) {
        int index = findIndex(value);
        if (index < 0) {
            return false; // Element not found
        }
        
        // Shift elements to remove the value
        System.arraycopy(theData, index + 1, theData, index, size - index - 1);
        size--;
        return true;
    }

	/**
	 * Uses binary search to find the target in the set (only if enabled).
	 * @param target The target value to search for.
	 * @return The index where the target is found, or -index - 1 if not found.
	 */
	private int binaryFind(double target) {
        int low = 0;
        int high = size - 1;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            double midVal = theData[mid];

            if (midVal < target)
                low = mid + 1;
            else if (midVal > target)
                high = mid - 1;
            else
                return mid; // target found
        }
        return -(low + 1);  // target not found, return insertion point
    }



	/**
	 * Checks if the set contains a specific element.
	 * @param element The element to check.
	 * @return true if the element is found, false otherwise.
	 */
	public boolean contains(double element){
		// TODO: Assigment Part 1.3
		return findIndex(element) >= 0;
	}

	/**
	 * Checks if the set contains all the elements of an input array.
	 * @param elements The array of elements to check.
	 * @return true if all elements are found in the set, false otherwise.
	 */
	public boolean containsAll(double[] elements) {
        for (double element : elements) {
            if (!contains(element)) {
                return false;
            }
        }
        return true;
    }

	/**
	 * Finds the index of a target value using either sequential or binary search.
	 * @param target The target value to search for.
	 * @return The index where the target is found, or -index - 1 if not found.
	 */
	// Update the findIndex method to use binaryFind
    public int findIndex(double target) {
        if (usesBinarySearch) {
            return binaryFind(target);
        } else {
            return sequentialFind(target);
        }
    }
}


	

