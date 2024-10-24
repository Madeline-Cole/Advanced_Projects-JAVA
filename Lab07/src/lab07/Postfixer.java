package lab07;

import java.util.*;

//Extension of Chapter 14.4 Case Study: Expression Evaluator

public class Postfixer {
	/**
	* Converts an operator to its precedence priority
	*
	* We expect you to be able to handle +, -, *, /, ^, and (
	* (why don't you need ")" as well? see algorithm in part 4)
	*
	* The order of these is as follows:
	*    ^, * and /, + and -, (
	*
	* @param op a string representing an operator, e.g. "+" or "-"
	* @return an integer value reflecting its precedence
	*/
	private static int opToPrcd(String op) {
		//TODO: Lab Part 2.1
		switch (op) {
        case "^":
            return 3;
        case "*":
        case "/":
            return 2;
        case "+":
        case "-":
            return 1;
        case "(":
            return 0;
        default:
            throw new IllegalArgumentException("Invalid operator: " + op);
		}
	}

	/**
	*  Determines if the first operator has same or greater
    *  precedence than the second
	*
	* @param op1 the first operator
	* @param op2 the second operator
	* @return the boolean result
	*/
	private static boolean hasPrecedence(String op1, String op2) {
		//TODO: Lab Part 2.2
		return opToPrcd(op1) >= opToPrcd(op2);
	}
	/**
	* determines if the input token is an operator
	*
	* @param token the string token to check
	* @return a boolean reflecting the result
	*/
	private static boolean isOperator(String token) {
		//TODO: Lab Part 2.3
		return "+-*/^".contains(token);
	}
	/**
    * Evaluates an expression
    *
    * NOTE Beware the order of pop and evaluation when receiving operand1
    * and operand2 as input.
    *
    * @param operand1 the first operand
    * @param operator the operator to apply
    * @param operand2 the second operand
    * @return a double expressing the result
    * @throws IllegalArgumentException if operator passed is not one of
    *  "+", "-", "*", "/", or "^"
    *
	*/
	private static double evaluate(double operand1, String operator, double operand2){
		//TODO: Lab Part 2.4
		switch (operator) {
        case "+":
            return operand1 + operand2;
        case "-":
            return operand1 - operand2;
        case "*":
            return operand1 * operand2;
        case "/":
            if (operand2 == 0) {
                throw new ArithmeticException("Division by zero");
            }
            return operand1 / operand2;
        case "^":
            return Math.pow(operand1, operand2);
        default:
            throw new IllegalArgumentException("Invalid operator: " + operator);
       }
	}
	/**
	* give a description of the purpose of this method
	* @param line fill in
	* @return fill in
	*/
	public static double infixEvaluator(String line){
		//TODO: Lab Part 3
		//HINT: You must use the algorithm described in Lab Part 4
		StringSplitter data = new StringSplitter(line);
        Stack<String> operators = new Stack<>();
        Stack<Double> operands = new Stack<>();

        while (data.hasNext()) {
            String token = data.next();

            if (isNumber(token)) {
                operands.push(Double.parseDouble(token));
            } else if (isOperator(token)) {
                while (!operators.isEmpty() && hasPrecedence(operators.peek(), token)) {
                    processOperator(operators, operands);
                }
                operators.push(token);
            } else if (token.equals("(")) {
                operators.push(token);
            } else if (token.equals(")")) {
                while (!operators.peek().equals("(")) {
                    processOperator(operators, operands);
                }
                operators.pop(); // Remove the '(' from the stack
            }
        }

        while (!operators.isEmpty()) {
            processOperator(operators, operands);
        }

        return operands.pop();
    }
	
	private static boolean isNumber(String token) {
	    try {
	        Double.parseDouble(token);
	        return true;
	    } catch (NumberFormatException e) {
	        return false;
	    }
	}
	
	private static void processOperator(Stack<String> operators, Stack<Double> operands) {
        String operator = operators.pop();
        double operand2 = operands.pop();
        double operand1 = operands.pop();
        double result = evaluate(operand1, operator, operand2);
        operands.push(result);
    }
	/**
	* give a description of the purpose of this method
	* @param line fill in
	* @return fill in
	*/
	public static String toPostfix(String line) {
	    StringSplitter data = new StringSplitter(line);
	    Stack<String> operators = new Stack<>();
	    StringBuilder postfix = new StringBuilder();

	    while (data.hasNext()) {
	        String token = data.next();
	        if (isNumber(token)) {
	            postfix.append(token);
	        } else if (token.equals("(")) {
	            operators.push(token);
	        } else if (token.equals(")")) {
	            while (!operators.isEmpty() && !operators.peek().equals("(")) {
	                postfix.append(operators.pop());
	            }
	            if (!operators.isEmpty() && operators.peek().equals("(")) {
	                operators.pop(); // Discard the left parenthesis
	            }
	        } else if (isOperator(token)) {
	            while (!operators.isEmpty() && !operators.peek().equals("(") && hasPrecedence(operators.peek(), token)) {
	                postfix.append(operators.pop());
	            }
	            operators.push(token);
	        }
	    }

	    while (!operators.isEmpty()) {
	        if (!operators.peek().equals("(")) {
	            postfix.append(operators.pop());
	        } else {
	            operators.pop();
	        }
	    }

	    return postfix.toString();
	}

	public static void main(String[] args){
		/*
		 // Test opToPrcd
	    System.out.println(opToPrcd("+")); // Should print 1
	    System.out.println(opToPrcd("^")); // Should print 3

	    // Test hasPrecedence
	    System.out.println(hasPrecedence("*", "+")); // Should print true
	    System.out.println(hasPrecedence("-", "^")); // Should print false

	    // Test isOperator
	    System.out.println(isOperator("+")); // Should print true
	    System.out.println(isOperator("a")); // Should print false

	    // Test evaluate
	    System.out.println(evaluate(2, "+", 3)); // Should print 5.0
	    System.out.println(evaluate(2, "^", 3)); // Should print 8.0

		 //Uncomment when you are ready to test Lab Part 3
        if (infixEvaluator("10 + 2") != 12)
            System.err.println("test1 failed --> your answer should have been 12");

        if (infixEvaluator("10 - 2 * 2 + 1") != 7)
            System.err.println("test1 failed --> your answer should have been 7");

        if (infixEvaluator("100 * 2 + 12") != 212)
            System.err.println("test2 failed --> your answer should have been 212");

        if (infixEvaluator("100 * ( 2 + 12 )") != 1400)
            System.err.println("test3 failed --> your answer should have been 1400");

        if (infixEvaluator("100 * ( 2 + 12 ) / 14") != 100)
            System.err.println("test4 failed --> your answer should have been 100");
		
     // Test cases for toPostfix
        System.out.println(toPostfix("10 + 2")); // Should print "10 2 +"
        System.out.println(toPostfix("10 - 2 * 2 + 1")); // Should print "10 2 2 * - 1 +"
        System.out.println(toPostfix("100 * 2 + 12")); // Should print "100 2 * 12 +"
        System.out.println(toPostfix("100 * ( 2 + 12 )")); // Should print "100 2 12 + *"
        System.out.println(toPostfix("100 * ( 2 + 12 ) / 14")); // Should print "100 2 12 + * 14 /"

        System.out.println("Lab Testing Done!!!");

        /* uncomment the below lines for assignmemt */ 
		 if (!toPostfix(new String("(4+5)")).equals("45+"))
		    System.err.println("test1 failed --> should have been 45+");

		if (!toPostfix(new String("((4+5)*6)")).equals("45+6*"))
		     System.err.println("test2 failed --> should have been 45+6*");

		 if (!toPostfix(new String("((4+((5*6)/7))-8)")).equals("456*7/+8-"))
		     System.err.println("test3 failed --> should have been 456*7/+8-");

		 if (!toPostfix(new String("((4+5*(6-7))/8)")).equals("4567-*+8/"))
		     System.err.println("test4 failed --> should have been 4567-*+8/");

		 if (!toPostfix(new String("(9+(8*7-(6/5^4)*3)*2)")).equals("987*654^/3*-2*+"))
		     System.err.println("test5 failed --> should have been 987*654^/3*-2*+");


         System.out.println("Assignment Testing Done!!!");


	}
}


