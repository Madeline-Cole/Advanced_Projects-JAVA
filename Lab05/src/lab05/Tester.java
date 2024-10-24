package lab05;

public class Tester {

    public static void main(String[] args) {
        testBasicOperations();
        testRemove();
        testContains();
        testContainsAll();
        testConstructorWithArray();
        compareSearchPerformance();
    }

    private static void testBasicOperations() {
        System.out.println("Testing basic operations:");
        SortedBinarySet set = new SortedBinarySet();
        System.out.println("Is empty? " + set.empty());
        System.out.println("Size: " + set.size());

        set.insert(5.0);
        set.insert(3.0);
        set.insert(7.0);
        System.out.println("After insertions: " + set);

        boolean inserted = set.insert(5.0);
        System.out.println("Inserted duplicate 5.0? " + inserted);

        set.clear();
        System.out.println("After clear: " + set);
        System.out.println();
    }

    private static void testRemove() {
        System.out.println("Testing remove operation:");
        SortedBinarySet set = new SortedBinarySet();
        set.insert(1.0);
        set.insert(2.0);
        set.insert(3.0);
        System.out.println("Initial set: " + set);

        boolean removed = set.remove(2.0);
        System.out.println("Removed 2.0? " + removed);
        System.out.println("After removal: " + set);

        removed = set.remove(4.0);
        System.out.println("Removed non-existent 4.0? " + removed);
        System.out.println();
    }

    private static void testContains() {
        System.out.println("Testing contains operation:");
        SortedBinarySet set = new SortedBinarySet();
        set.insert(1.0);
        set.insert(3.0);
        set.insert(5.0);

        System.out.println("Contains 3.0? " + set.contains(3.0));
        System.out.println("Contains 4.0? " + set.contains(4.0));
        System.out.println();
    }

    private static void testContainsAll() {
        System.out.println("Testing containsAll operation:");
        SortedBinarySet set = new SortedBinarySet();
        set.insert(1.0);
        set.insert(3.0);
        set.insert(5.0);

        double[] arr1 = {1.0, 3.0};
        double[] arr2 = {1.0, 4.0};
        System.out.println("Contains all of {1.0, 3.0}? " + set.containsAll(arr1));
        System.out.println("Contains all of {1.0, 4.0}? " + set.containsAll(arr2));
        System.out.println();
    }

    private static void testConstructorWithArray() {
        System.out.println("Testing constructor with array:");
        double[] input = {5.0, 2.0, 8.0, 2.0, 1.0};
        SortedBinarySet set = new SortedBinarySet(input);
        System.out.println("Set created from array: " + set);
        System.out.println();
    }

    private static void compareSearchPerformance() {
        System.out.println("Comparing search performance:");
        SortedBinarySet set = new SortedBinarySet();
        int numElements = 100000;

        // Insert elements
        for (int i = 0; i < numElements; i++) {
            set.insert(i);
        }

        // Test sequential search
        set.usesBinarySearch = false;
        long startTime = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            set.contains(i);
        }
        long sequentialTime = System.nanoTime() - startTime;

        // Test binary search
        set.usesBinarySearch = true;
        startTime = System.nanoTime();
        for (int i = 0; i < numElements; i++) {
            set.contains(i);
        }
        long binaryTime = System.nanoTime() - startTime;

        System.out.println("Sequential search time: " + sequentialTime + " ns");
        System.out.println("Binary search time: " + binaryTime + " ns");

        // Set the flag based on performance
        set.usesBinarySearch = (binaryTime < sequentialTime);
        System.out.println("Binary search is faster: " + set.usesBinarySearch);
    }
}

