package project03;
/**
 * This is a reference-based queue implementation of the 
 * SetOfSpaces interface. It represents a Queue of SquarePositions,
 * following FIFO procedures for add and remove methods.
 *
 * @author      Nuri Jung
 * @version     10/22/16
 * 
 * Project 3
 * Professor Joanna Klukowska
 * Data Structures, Fall 2016
 */
public class QueueOfSpaces implements SetOfSpaces {
	// Node class
	private class Node {
		private SquarePosition sqposition;
		// the next node it's pointing to
		private Node next;
		// Node constructor
		public Node (SquarePosition sqposition, Node next) {
			this.sqposition = sqposition;
			this.next = next;
		}
	}
	/**
	 * Initializes an empty queue
	 */
	public QueueOfSpaces() {
		first = null;
		tail = null;
		size = 0;
	}
	
	// least recently added element of the queue
	private Node first;	
	// most recently added element of the queue
	private Node tail;	
	// number of objects in the queue
	private int size;	
	
	/**
	 * Adds an element to the queue
	 * @param the element to be added
	 */
	public void add (SquarePosition s) {
		Node newNode = new Node (s, null);
		if (isEmpty()) {
			// set the top of queue to point to a new Node
			first = newNode;	
		}
		else {
			// set the end of queue to point to the new Node
			tail.next = newNode;
		}
		// set the end of queue to a new Node
		tail = newNode;
		size++;	// increase the size by one
	}
	/**
	 * Removes and returns least recently added element from the queue
	 * i.e. follows FIFO
	 * @return s the element that was least recently added to the queue
	 * 		or null if the queue is empty
	 */
	public SquarePosition remove() {
		// if there aren't any elements to remove
		if (isEmpty()) return null;
		// set the element to be returned
		// to the least recently added element of the queue
		SquarePosition oldest = first.sqposition;
		if (tail == first) {
			tail = null;
		}
		// set the oldest to the next node in queue
		first = first.next;
		// reduce the size by 1
		size--;
		// return the original oldest element
		return oldest;
	}
	/**
	 * Checks whether the queue is empty.
	 * @return true if empty, false if not empty
	 */
	public boolean isEmpty() {
		return (first == null);
	}
	/**
	 * Returns the number of elements in the queue.
	 * @return size the number of elements in queue
	 */
	public int size() {
		return size;
	}

}
