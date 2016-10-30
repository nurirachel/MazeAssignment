package project03;

/**
* This is a reference-based stack implementation of the 
* SetOfSpaces interface. It represents a Stack of SquarePositions,
* following LIFO procedures for add and remove methods.
* 
* @author      Nuri Jung
* @version     10/22/16
* 
* Project 3
* Professor Joanna Klukowska
* Data Structures, Fall 2016
*/
public class StackOfSpaces implements SetOfSpaces {
	// helper Node class
	private class Node {
		private SquarePosition s;
		private Node next;
		public Node (SquarePosition s, Node next) {
			this.s = s;
			this.next = next;
		}
	}
	
	private Node top;	// the most recently added element in the stack
	private int size;	// number of elements in the stack
	
	/**
	 * Adds an element to the top of the stack
	 */
	public void add (SquarePosition s) {
		top = new Node(s, top);
		size++;	// increase size by one
	}
	/**
	 * Removes and returns the most recently added element in the stack
	 * @return oldtop the most recently added element, null if empty
	 */
	public SquarePosition remove() {
		if (isEmpty()) return null;
		else {
			// get the current top of the stack
			SquarePosition oldtop = top.s;
			// set the top of the stack to the one underneath the current one
			top = top.next;
			size--;	// decrease size by one
			return oldtop;
		}
	}
	
	/**
	 * Checks whether the stack is empty.
	 * @return true if it is empty, false otherwise
	 */
	public boolean isEmpty() {
		return (size() == 0);
	}
	
	/**
	 * Gets the number of elements in the stack.
	 * @return size the number of elements in stack
	 */
	public int size() {
		return size;
	}
}
