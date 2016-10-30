package project03;

import static org.junit.Assert.*;
import org.junit.*;
/**
* This is a test class for the StackOfSpaces class.
*
* @author      Nuri Jung
* @version     10/22/16
* 
* Project 3
* Professor Joanna Klukowska
* Data Structures, Fall 2016
*/
public class StackOfSpacesTest {
	// the stack to be used in the tests
	protected StackOfSpaces teststack;
	// the SquarePosition object to be used in tests
	protected SquarePosition sqposition;
	
	/**
	 * This is a method to be run before every test.
	 * Creates a stack object and assigns it to a reference variable
	 * Creates a SquarePosition object and assigns it to a reference variable
	 */
	@Before
    public void makeStackOfSpaces() {
        teststack = new StackOfSpaces();
        sqposition = new SquarePosition (1, 1);
    }
	
	/**
	 * Tests whether the reference variable for the StackOfSpaces object
	 * points to null or not. It should NOT by this point.
	 */
	@Test
	public void testRefPointsToNull() {
		// test if the reference variable points to null or not
	    assertNotNull(teststack);
	}
	
	/**
	 * Tests whether the isEmpty method is correctly implemented
	 * by seeing whether the stack is empty or not.
	 * It should return true/that it is empty by this point.
	 */
	@Test
	public void testNewStackIsEmpty() {
		// test whether stack is empty
		assertTrue(teststack.isEmpty());
	}
	
	/**
	 * Tests whether the remove method is correctly implemented
	 * by seeing whether an attempt to remove an element from the
	 * empty stack returns null. It should return null by this point.
	 */
	@Test
	public void removeFromEmptyStack() {
		// test if it returns null if you try to remove
		// an element from an empty stack
		assertNull(teststack.remove());
	}
	
	/**
	 * Tests whether the add method is correctly implemented
	 * by adding a single element and checking that the size is now
	 * 1, stack is no longer empty, and removing an element does not
	 * return null.
	 */
	@Test
	public void testAdd() {
		teststack.add(sqposition);
		// test that the size is no longer zero
		assertEquals(teststack.size(), 1);
		// test that the stack is no longer empty
		assertFalse(teststack.isEmpty());
		// test that removing the top does not return null
		assertNotNull(teststack.remove());
	}
	
	/**
	 * Tests if the remove method is implemented correctly
	 * by adding and then removing a single element and seeing
	 * whether the size returns to 0 and stack is also empty.
	 */
	@Test
	public void testRemove() {
		// add and then remove a single element
		teststack.add(sqposition);
		teststack.remove();
		// test if the size is back to 0
		assertEquals(teststack.size(), 0);
		// test if stack is now empty
		assertTrue(teststack.isEmpty());
	}
	
	/**
	 * Tests if the size method is correct by adding and removing
	 * a certain number of elements and checking the size against
	 * the expected numbers.
	 */
	@Test
	public void testSize() {
		int numAdd = 7;
		int numRemove = 2;
		// add 7 positions to the stack
		for (int i = 0; i < numAdd; i++) {
			teststack.add(sqposition);
		}
		// check that the size of the stack is now 7
		assertEquals(teststack.size(), 7);
		
		// remove 2 positions from stack
		for (int i = 0; i < numRemove; i++) {
			teststack.remove();
		}
		// check that size is now 5
		assertEquals(teststack.size(), 5);
	}
	
	/**
	 * Tests whether StackOfSpaces follows the Last In, First Out
	 * order in its add and remove methods.
	 */
	@Test
	public void testLIFO() {
		// check that removing returns the most recently added element
		// i.e., follows Last In, First Out
		SquarePosition first = new SquarePosition(1,1);
		SquarePosition last = new SquarePosition(2,2);
		// add them to the queue
		teststack.add(first);
		teststack.add(last);
		// test that removing once returns the last added element
		assertEquals(teststack.remove(), last);
	}
}
