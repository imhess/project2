package stacks;

import org.junit.jupiter.api.Test;

public class LinkedStackTest {
	public static void main(String args[]) 
	{ 
		LinkedStack linked = new LinkedStack();
	    
		// Test 1- Assignment
	    String test1 = "a*b/(c-a)+d*e"; 
	    System.out.println("Result:");
	    System.out.println(linked.ItoP(test1));
	    System.out.println("Test Case:");
	    System.out.println("ab*ca-/de*+");
	    
		// Test 2- Assignment
	    String test2 = "a*b/(c-d)"; 
	    System.out.println("Result:");
	    System.out.println(linked.ItoP(test2));
	    System.out.println("Test Case:");
	    System.out.println("ab*cd-/");
	    
		// Test 3- Assignment
	    String test3 = "(a-b*c)/(d*e*f+g)";
	    System.out.println("Result:");
	    System.out.println(linked.ItoP(test3));
	    System.out.println("Test Case:");
	    System.out.println("abc*-de*f*g+/");
	    
		// Test 4- Assignment
	    String test4 = "a/b*(c+(d-e))";
	    System.out.println("Result:"); 
	    System.out.println(linked.ItoP(test4));
	    System.out.println("Test Case:");
	    System.out.println("ab/cde-+*");
	    
		// Test 5- Assignment
	    String test5 = "(a^b*c-d)^e+f^g^h";
	    System.out.println("Result:"); 
	    System.out.println(linked.ItoP(test5));
	    System.out.println("Test Case:");
	    System.out.println("ab^c*d-e^fg^h^+");
	    /**

	    

	    

	    

	    */
	}


}

