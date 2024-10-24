package lab02;

public class Matrix {
	int numRows;
	int numColumns;
	int data[][];
	
	// default constructor
	public Matrix(){}
	
	// constructor 1 - Constructor for new zero matrix
	public Matrix(int rowDim, int colDim){
		// TODO: Lab Part 1
			// write a constructor that would create a matrix of correct size and initialize it to 0. 
		    this.numRows = rowDim;
		    this.numColumns = colDim;
		    this.data = new int[rowDim][colDim];
		} //end of constructor 1

	
	
	// constructor 2 - Constructor with data for new matrix (automatically determines dimensions)
	public Matrix(int d[][])
	{
		/*  TODO: Lab Experiment 1.3
			*  1) put the numRows to be the number of 1D arrays in the 2D array
			*  2) specify the numColumns and set it
			*  3) be careful of special cases you are supposed to handle them properly
			*  4) create a new matrix to hold the data
			*  5) copy the data over
		*/
		this.numRows = d.length;
		this.numColumns = d[0].length;
		
		if (numRows == 0 || numColumns == 0) {
	        this.data = new int[0][0];
	    } else {
	        // 4) Create a new matrix to hold the data
	        this.data = new int[numRows][numColumns];
	        
	        // 5) Copy the data over
	        for (int i = 0; i < numRows; i++) {
	            for (int j = 0; j < numColumns; j++) {
	                this.data[i][j] = d[i][j];
	            }
	        }
	    }
	} //end of constructor 2	
	
	@Override // instruct the compiler that we do indeed intend for this method to override the superclass' (Object) version
	public String toString()
	{
		
		/* TODO: Lab part 1
		 	* replace the below return statement with the correct code, 
			* you must return a String that represents this matrix, as 
			* specified in the instruction for M1
			* anything else IS NOT acceptable
		 */
		//return ""; // placeholder		
		
		StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < numRows; i++) {
	        for (int j = 0; j < numColumns; j++) {
	            sb.append(data[i][j]);
	            if (j < numColumns - 1) {
	                sb.append(" ");
	            }
	        }
	        sb.append("\n");
	    }
	    return sb.toString();
	}// end of toString method
	
	/**
	 * @Override
	 * This method overrides the `equals` method of the `Object` class.
	 * 
	 * Compares this Matrix to another Object for equality. If the Object 
	 * is not an instance of the Matrix class, the method returns false. 
	 * If it is a Matrix, the method checks whether the two matrices have 
	 * the same dimensions and elements in the same order.
	 *
	 * @param o The Object to compare to this Matrix.
	 * @return true if the input Object is a Matrix with the same dimensions 
	 *         and elements as this Matrix; false otherwise.
	 */
	@Override
	public boolean equals(Object o) {
	    if (!(o instanceof Matrix)) {
	        return false;
	    }
	    Matrix m = (Matrix) o;
	    
	    // Check if the dimensions are the same
	    if (this.numRows != m.numRows || this.numColumns != m.numColumns) {
	        return false;
	    }
	    
	    // Check if all elements are the same
	    for (int i = 0; i < this.numRows; i++) {
	        for (int j = 0; j < this.numColumns; j++) {
	            if (this.data[i][j] != m.data[i][j]) {
	                return false;
	            }
	        }
	    }
	    
	    return true;
	} //end of equals method

	/**
	 * Computes the transpose of this Matrix.
	 * 
	 * This method creates a new Matrix that is the transpose of this Matrix.
	 * The transpose of a matrix is obtained by flipping the matrix over its diagonal, 
	 * switching the row and column indices of the matrix.
	 *
	 * @return A new Matrix that is the transpose of this Matrix.
	 */
	public Matrix transpose() {
	    // Create a new matrix with swapped dimensions
	    Matrix transposedMatrix = new Matrix(this.numColumns, this.numRows);
	    
	    // Fill the new matrix with transposed values
	    for (int i = 0; i < this.numRows; i++) {
	        for (int j = 0; j < this.numColumns; j++) {
	            transposedMatrix.data[j][i] = this.data[i][j];
	        }
	    }
	    
	    return transposedMatrix;
	} //end of transpose method

	/**
	 * Adds this Matrix to another Matrix.
	 * 
	 * This method checks if the two matrices are compatible for addition, i.e., 
	 * they have the same dimensions. If they are not compatible, the method returns null. 
	 * If they are compatible, the method computes the sum of the two matrices and returns 
	 * the resulting Matrix.
	 *
	 * @param m The Matrix to add to this Matrix.
	 * @return A new Matrix that is the sum of this Matrix and the input Matrix, or 
	 *         null if the matrices are not compatible for addition.
	 */
	public Matrix add(Matrix m) {
	    // Check if the matrices have the same dimensions
	    if (this.numRows != m.numRows || this.numColumns != m.numColumns) {
	        return null; // Matrices are not compatible for addition
	    }
	    
	    // Create a new matrix to hold the result
	    Matrix result = new Matrix(this.numRows, this.numColumns);
	    
	    // Add corresponding elements
	    for (int i = 0; i < this.numRows; i++) {
	        for (int j = 0; j < this.numColumns; j++) {
	            result.data[i][j] = this.data[i][j] + m.data[i][j];
	        }
	    }
	    
	    return result;
	}// end of add method

	/**
	 * Multiplies this Matrix by another Matrix.
	 * 
	 * This method checks if the two matrices are compatible for multiplication, i.e., 
	 * the number of columns in this matrix is equal to the number of rows in the input Matrix.
	 * If they are not compatible, the method returns null. If they are compatible, the method 
	 * computes the product of the two matrices and returns the resulting Matrix.
	 *
	 * @param m The Matrix to multiply with this Matrix.
	 * @return A new Matrix that is the product of this Matrix and the input Matrix, or 
	 *         null if the matrices are not compatible for multiplication.
	 */
	public Matrix mult(Matrix m) {
	    // Check if the matrices are compatible for multiplication
	    if (this.numColumns != m.numRows) {
	        return null; // Matrices are not compatible for multiplication
	    }
	    
	    // Create a new matrix to hold the result
	    Matrix result = new Matrix(this.numRows, m.numColumns);
	    
	    // Multiply the matrices
	    for (int i = 0; i < this.numRows; i++) {
	        for (int j = 0; j < m.numColumns; j++) {
	            for (int k = 0; k < this.numColumns; k++) {
	                result.data[i][j] += this.data[i][k] * m.data[k][j];
	            }
	        }
	    }
	    
	    return result;
	} //end of mult method
}//end of matrix class