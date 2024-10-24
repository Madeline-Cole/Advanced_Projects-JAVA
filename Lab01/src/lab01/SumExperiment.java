package lab01;

public class SumExperiment {
	
	/**
	 * This method checks an array for any pair of values that add up to 20.
	 * If such a pair is found, it returns the index of the smallest value in that pair.
	 * If no such pair is found, it returns -1.
	 *
	 * @param array an array of integers to be inspected
	 * @return the index of the smallest value in the pair that sums to 20, or -1 if no such pair exists
	 */
	public static int checkSum(int[] array) {
	    for (int i = 0; i < array.length; i++) {
	        for (int j = i + 1; j < array.length; j++) {
	            if (array[i] + array[j] == 20) {
	                return Math.min(i, j);
	            }
	        }
	    }
	    return -1;
	}
	
	public static void main(String[] args) {
		int[] array1 = new int[]{5, 7, 8, 9, 10, 15, 16};
		if (checkSum(array1) != 0)
			System.err.println("TEST1 FAILED");
		
		int[] array2 = new int[]{3, 5, 8, 9, 10, 15, 16};
		if (checkSum(array2) != 1)
			System.err.println("TEST2 FAILED");

		
		int[] array3 = new int[]{3, 4, 6, 9, 10, 14, 15};
		if (checkSum(array3) != 2)
			System.err.println("TEST3 FAILED");
		
		int[] array4 = new int[]{6, 7, 8, 9, 10, 15, 16};
		if (checkSum(array4) != -1)
			System.err.println("TEST4 FAILED");
		
		System.out.println("Done!!!");
	}
}
