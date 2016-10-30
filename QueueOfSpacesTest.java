package project03;

import static org.junit.Assert.*;
import org.junit.*;

/**
* This is a test class for the QueueOfSpaces class.
*
* @author      Nuri Jung
* @version     10/22/16
* 
* Project 3
* Professor Joanna Klukowska
* Data Structures, Fall 2016
*/
public class QueueOfSpacesTest {
	// queue to be used in the tests
    protected QueueOfSpaces testqueue;
    // SquarePosition to be used in the tests
    protected SquarePosition sp;
    /**
     * A method to be run before each test
     * Creates a QueueOfSpaces object and assigns it to a reference variable.
     * Creates a SquarePosition object and assigns it to a reference variable.
     */
    @Before
    public void makeQueue() {
    	// create a queue and assign it to a reference variable
    	testqueue = new QueueOfSpaces();
    	// create a SquarePosition and assign it to a ref var
    	sp = new SquarePosition(1,1);
    }
    
    /**
     * Tests whether the constructor works correctly
     */
    @Test
    public void testPointsToNull() {
    	// test if the reference variable points to null or not
    	assertNotNull(testqueue);
    }
    
    /** 
     * Tests whether the constructor and isEmpty method
     * works correctly. The queue should be empty at this point.
     */
    @Test
    public void testNewQueueIsEmpty() {
    	// test if queue is empty
        assertTrue(testqueue.isEmpty());
    }
    
    /**
     * Tests whether the remove method works by attempting to
     * remove an element from the empty queue.
     */
    @Test
    public void removeFromEmptyQueue() {
    	// test if it returns null if you try to remove
    	// an element from an empty queue
        assertNull(testqueue.remove());
    }
    
    /**
     * Tests the add method by checking its size after adding
     * a single element, checking that it is no longer empty,
     * and that it does not return null if you try to remove
     * an element after adding.
     */
    @Test
    public void testAdd() {
    	testqueue.add(sp);
    	// test that the size is now 1 after adding 1 element
    	assertEquals(testqueue.size(), 1);
    	// test that the queue is not empty after adding 1 element
    	assertFalse(testqueue.isEmpty());
    	// test that it doesn't return null if you remove it from the queue
    	assertNotNull(testqueue.remove());
    }
    /**
     * Tests the size method by adding a certain number of elements
     * and removing a certain number of elements.
     */
    @Test
    public void testSize() {
    	int addNum = 8;
    	int removeNum = 3;
    	// add 8 positions to the queue
    	for (int i = 0; i < addNum; i++) {
    		testqueue.add(sp);
    	}
    	// check that the size of queue is now 8
    	assertEquals(testqueue.size(), 8);

    	// remove 3 positions from the queue
    	for (int i = 0; i < removeNum; i++) {
    		testqueue.remove();
    	}
    	// check that the size of queue is now 5
    	assertEquals(testqueue.size(), 5);
    }
    
    /**
     * Tests the remove method by adding and then
     * removing a single element and checking whether
     * it returns the expected size and isEmpty status.
     */
    @Test
    public void testRemove() {
    	// add then remove a single element
    	testqueue.add(sp);
    	testqueue.remove();
    	// test that size is back to 0
    	assertEquals(testqueue.size(), 0);
    	// test that the queue is now empty
    	assertTrue(testqueue.isEmpty());
    }
    
    /**
     * Tests the validity of the add and remove methods
     * and whether the implementation follows FIFO. It should
     * be removing the least recently added element.
     */
    @Test
    public void testFIFO() {
    	// check that it removed the oldest added element
    	// i.e., follows First In, First Out
    	SquarePosition first = new SquarePosition(1,1);
    	SquarePosition last = new SquarePosition(2,2);
    	// add them to the queue
    	testqueue.add(first);
    	testqueue.add(last);
    	// check that removing returns the first added element
    	assertEquals(testqueue.remove(), first);
    }
}
