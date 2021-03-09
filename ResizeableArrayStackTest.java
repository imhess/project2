package stacks;

public class ResizeableArrayStackTest {
	public static void main(String args[]) 
	{ 
		ResizeableArrayStack bob = new ResizeableArrayStack();
		
		// Test 1- Assignment
	    String test1 = "ab*ca-/de*+";
	    System.out.println("Result:");
	    System.out.println(bob.PtoI(test1));
	    System.out.println("Test Case:");
	    System.out.println(33.0);
	    
		// Test 2- Assignment
	    String test2 = "ab^"; 
	    System.out.println("Result:");
	    System.out.println(bob.PtoI(test2));
	    System.out.println("Test Case:");
	    System.out.println(8.0);
	    
		// Test 3- Assignment
	    String test3 = "ab+c*d-"; 
	    System.out.println("Result:");
	    System.out.println(bob.PtoI(test3));
	    System.out.println("Test Case:");
	    System.out.println(15.0);
	    
		// Test 4- Assignment
	    String test4 = "ab+c*b^"; 
	    System.out.println("Result:");
	    System.out.println(bob.PtoI(test4));
	    System.out.println("Test Case:");
	    System.out.println(8000.0);
	    
		// Test 5- Assignment
	    String test5 = "ac-b^d+"; 
	    System.out.println("Result:");
	    System.out.println(bob.PtoI(test5));
	    System.out.println("Test Case:");
	    System.out.println(-3.0);
	    
	    /**

	    

	    

	    

	    */
}
}
