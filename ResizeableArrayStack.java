package stacks;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.StringJoiner;


public final class ResizeableArrayStack<T> implements StackInterface<T>
{
	private T[] stack;    // Array of stack entries
	private int topIndex; // Index of top entry
    private boolean integrityOK = false;
	private static final int DEFAULT_CAPACITY = 50;
	private static final int MAX_CAPACITY = 10000;
  
   public ResizeableArrayStack()
   {
      this(DEFAULT_CAPACITY);
   } // end default constructor
  
// Throws an exception if this object is not initialized.
private void checkIntegrity()
{
   if (!integrityOK)
      throw new SecurityException("ArrayBag object is corrupt.");
} // end checkIntegrity

   public void checkCapacity(int v) {
	   if (v > MAX_CAPACITY) {
		   throw new StackOverflowError("no");
	   }
   }

   public ResizeableArrayStack(int initialCapacity)
   {
      integrityOK = false;
      checkCapacity(initialCapacity);
      
      // The cast is safe because the new array contains null entries
      @SuppressWarnings("unchecked")
      T[] tempStack = (T[])new Object[initialCapacity];
      stack = tempStack;
	  topIndex = -1;
      integrityOK = true;
  } // end constructor

@Override
public void push(T newEntry)
{
   checkIntegrity();
   ensureCapacity();
   stack[topIndex + 1] = newEntry;
   topIndex++;
} // end push

private void ensureCapacity()
{
   if (topIndex >= stack.length - 1) // If array is full, double its size
   {
      int newLength = 2 * stack.length;
      checkCapacity(newLength);
      stack = Arrays.copyOf(stack, newLength);
   } // end if
} // end ensureCapacity

@Override
public T pop()
{
   checkIntegrity();
   if (isEmpty())
      throw new EmptyStackException();
   else
   {
      T top = stack[topIndex];
      stack[topIndex] = null;
      topIndex--;
      return top;
   } // end if
} // end pop

@Override
public T peek()
{
   checkIntegrity();
   if (isEmpty())
      throw new EmptyStackException();
   else
      return stack[topIndex];
} // end peek

@Override
public boolean isEmpty()
{
   return topIndex < 0;
} // end isEmpty

@Override
public void clear() {
	// TODO Auto-generated method stub
	
}

class GFG 
{ 
      
public boolean isOperand(char x) 
{ 
    return (x >= 'a' && x <= 'z') || 
            (x >= 'A' && x <= 'Z'); 
} 
  
// Get Infix for a given postfix 
// expression 

}

public boolean isOperand(char x) 
{ 
    return (x >= 'a' && x <= 'z') || 
           (x >= 'A' && x <= 'Z'); 
}

public char conversionVar(char y)
{
	if (y == 'a') {
		return '2';
	}
	if (y == 'b') {
		return '3';
	}
	if (y == 'c') {
		return '4';
	}
	if (y == 'd') {
		return '5';
	}
	if (y == 'e') {
		return '6';
	}
	else {
		return 'e';
	}
}


@Override
public double PtoI(String ch) {
    ResizeableArrayStack<String> s = new ResizeableArrayStack<String>(); 
    
    /** First for loop checks the String for the necessary operators and integers and begins
     * to sort them accordingly */
    for (int i = 0; i < ch.length(); i++) 
    { 

        if (isOperand(ch.charAt(i))) 
        { 
        s.push(ch.charAt(i) + ""); 
        } 
  
        else
        { 
            String op1 = s.peek(); 
            s.pop(); 
            String op2 = s.peek(); 
            s.pop(); 
            s.push("(" + op2 + ch.charAt(i) + 
                    op1 + ")"); 
        } 
    }
    
    /** Next loop takes the String stack and converts it to a joined Array, using the conversionVar
     * method to assign each variable a number, and a joiner to parse the String into one digestible
     * chunk */
    String newArray[] = new String[s.peek().length()];
    for (int i = 0; i < s.peek().length(); i++) {
    	char op4 = s.peek().charAt(i);
    	if (isOperand(op4)) {
    		op4 = conversionVar(op4);
    	}
    	newArray[i] = String.valueOf(op4);
    }
    StringJoiner j = new StringJoiner("");
    for (int i = 0; i < newArray.length; i++) {
    	j.add(newArray[i]);
    }
    String str = j.toString();
    
    /** The last part here eats each variable, operand, and parenthesis in order and converts
     * the final answer to a double, just in case. */
    return new Object() {
        int pos = -1, ch;

        void nextChar() {
            ch = (++pos < str.length()) ? str.charAt(pos) : -1;
        }

        boolean eat(int charToEat) {
            while (ch == ' ') nextChar();
            if (ch == charToEat) {
                nextChar();
                return true;
            }
            return false;
        }

        double parse() {
            nextChar();
            double x = parseExpression();
            if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char)ch);
            return x;
        }

        double parseExpression() {
            double x = parseTerm();
            for (;;) {
                if      (eat('+')) x += parseTerm(); // addition
                else if (eat('-')) x -= parseTerm(); // subtraction
                else return x;
            }
        }

        double parseTerm() {
            double x = parseFactor();
            for (;;) {
                if      (eat('*')) x *= parseFactor(); // multiplication
                else if (eat('/')) x /= parseFactor(); // division
                else return x;
            }
        }

        double parseFactor() {
            if (eat('+')) return parseFactor(); // unary plus
            if (eat('-')) return -parseFactor(); // unary minus

            double x;
            int startPos = this.pos;
            if (eat('(')) { // parentheses
                x = parseExpression();
                eat(')');
            } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                x = Double.parseDouble(str.substring(startPos, this.pos));
            } else {
                throw new RuntimeException("Unexpected: " + (char)ch);
            }

            if (eat('^')) x = Math.pow(x, parseFactor()); // exponent

            return x;
        }
    }.parse();
  
}

@Override
public String ItoP(String ch) {
	// TODO Auto-generated method stub
	return null;
}



}  // end ArrayStack
