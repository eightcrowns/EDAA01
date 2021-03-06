package testqueue;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import queue.FifoQueue;


public class TestAppendFifoQueue {
	private FifoQueue<Integer> myIntQueue1, myIntQueue2;

	@Before
	public void setUp() throws Exception {
		myIntQueue1 = new FifoQueue<Integer>();
		myIntQueue2 = new FifoQueue<Integer>();
	}

	@After
	public void tearDown() throws Exception {
		myIntQueue1 = null;
		myIntQueue2 = null;
	}
	
	@Test
	public final void testEmptyToEmpty() {
		myIntQueue1.append(myIntQueue2);
		assertTrue("new queue not empty", myIntQueue1.peek() == null);
		assertTrue("new size not 0", myIntQueue1.size() == 0);
	}
	
	@Test
	public final void testEmptyToQueue() {
		myIntQueue1.offer(1);
		myIntQueue1.append(myIntQueue2);
		assertTrue("wrong element in new queue", myIntQueue1.peek() == 1);
		assertTrue("new size not 1", myIntQueue1.size() == 1);
	}
	
	@Test
	public final void testQueueToEmpty() {
		myIntQueue2.offer(1);
		myIntQueue1.append(myIntQueue2);
		assertTrue("wrong element in new queue", myIntQueue1.peek() == 1);
		assertTrue("new size not 1", myIntQueue1.size() == 1);
	}
	
	@Test
	public final void testQueueToQueue() {
		myIntQueue1.offer(1);
		myIntQueue1.offer(2);
		myIntQueue2.offer(3);
		myIntQueue2.offer(4);
		myIntQueue1.append(myIntQueue2);
		assertTrue("wrong element 1 in new queue", myIntQueue1.poll() == 1);
		assertTrue("wrong element 2 in new queue", myIntQueue1.poll() == 2);
		assertTrue("new size not 2", myIntQueue1.size() == 2);
		
		Iterator<Integer> itr = myIntQueue2.iterator();
		assertFalse("queue 2 not empty", itr.hasNext());
	}
}
