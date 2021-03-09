package stacks;

import java.util.EmptyStackException;

public final class LinkedStack<T> implements StackInterface<T> {
	private Node topNode; // References the first node in the chain

	public LinkedStack() {
		topNode = null;
	} // end default constructor

//  < Implementations of the stack operations go here. >
//  . . .

	private class Node {
		private T data; // Entry in stack
		private Node next; // Link to next node

		private Node(T dataPortion) {
			this(dataPortion, null);
		} // end constructor

		private Node(T dataPortion, Node linkPortion) {
			data = dataPortion;
			next = linkPortion;
		} // end constructor

		private T getData() {
			return data;
		} // end getData

		private void setData(T newData) {
			data = newData;
		} // end setData

		private Node getNextNode() {
			return next;
		} // end getNextNode

		private void setNextNode(Node nextNode) {
			next = nextNode;
		} // end setNextNode
	} // end Node

	@Override
	public void push(T newEntry) {
		Node newNode = new Node(newEntry, topNode);
		topNode = newNode;
	} // end push

	@Override
	public T pop() {
		T top = peek(); // Might throw EmptyStackException

		// Assertion: topNode != null
		topNode = topNode.getNextNode();

		return top;
	} // end pop

	@Override
	public T peek() {
		if (isEmpty())
			throw new EmptyStackException();
		else
			return topNode.getData();
	} // end peek

	@Override
	public boolean isEmpty() {
		return topNode == null;
	} // end isEmpty

	@Override
	public void clear() {
		topNode = null;
	} // end clear

	/** Looks at the character scanned and gives it a value to be used for calculations later.
	 * @param ch
	 * @return a numerical value */
	static int Prec(char ch) {
		switch (ch) {
		case '+':
		case '-':
			return 1;

		case '*':
		case '/':
			return 2;

		case '^':
			return 3;
		}
		return -1;
	}
	
	
	@Override
	public String ItoP(String ch) {
		// String
		String result = new String("");

		// empty stack
		LinkedStack<Character> stack = new LinkedStack<>();

		for (int i = 0; i < ch.length(); ++i) {
			char c = ch.charAt(i);

			/** If the scanned character is an operator, this pushes it to an output. */

			if (Character.isLetterOrDigit(c))
				result += c;

			/** If the scanned character is a left bracket, push it to the stack. */
			else if (c == '(')
				stack.push(c);

			/** If the scanned character is a right bracket, this pops and output from the stack
			* until a left bracket is encountered. */
			else if (c == ')') {
				while (!stack.isEmpty() && stack.peek() != '(')
					result += stack.pop();

				stack.pop();
			} else // an operator is seen
			{
				while (!stack.isEmpty() && Prec(c) <= Prec(stack.peek())) {

					result += stack.pop();
				}
				stack.push(c);
			}

		}

		/** Pop all operators out*/
		while (!stack.isEmpty()) {
			if (stack.peek() == '(')
				return "Invalid Expression";
			result += stack.pop();
		}
		return result;
	}
	
	@Override
	public double PtoI(String exp) {
		// TODO Auto-generated method stub
		return 1;
	}

	
} // end LinkedStack
