/**
 * 
 */
package utilities;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import adt.ListADT;
import adt.QueueADT;
import exceptions.EmptyQueueException;

/**
 * @author 839645
 *
 */
public class MyQueueTests {
	QueueADT<String> queue;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		queue = new MyQueue<String>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		queue = null;
	}

	/**
	 * Test method for {@link utilities.MyQueue#enqueue(java.lang.Object)}.
	 */
	@Test
	public void testEnqueueNullPointerException() {
		assertThrows(NullPointerException.class, ()->queue.enqueue(null));
	}
	
	/**
	 * Test method for {@link utilities.MyQueue#enqueue(java.lang.Object)}.
	 */
	@Test
	public void testEnqueue() {
		queue.enqueue("armaan");
		try {
		assertEquals(queue.peek().intern(), "armaan");
		}catch(EmptyQueueException e) {
			assertTrue(false);
		}
	}

	/**
	 * Test method for {@link utilities.MyQueue#dequeue()}.
	 */
	@Test
	public void testDequeueEmptyQueueException() {
		assertThrows(EmptyQueueException.class, ()->queue.dequeue());
	}
	
	/**
	 * Test method for {@link utilities.MyQueue#dequeue()}.
	 */
	@Test
	public void testDequeue() {
		queue.enqueue("armaan");
		queue.enqueue("singh");
		queue.enqueue("klair");
		try {
		queue.dequeue();
		assertTrue(queue.peek().intern().equals("singh"));
		}catch(EmptyQueueException e) {
			assertTrue(false);
		}
		
	}

	/**
	 * Test method for {@link utilities.MyQueue#peek()}.
	 */
	@Test
	public void testPeekEmptyQueueException() {
		assertThrows(EmptyQueueException.class, ()->queue.peek());
	}
	
	/**
	 * Test method for {@link utilities.MyQueue#peek()}.
	 */
	@Test
	public void testPeek() {
		queue.enqueue("armaan");
		queue.enqueue("singh");
		try {
		assertTrue(queue.peek().intern().equals("armaan"));
		} catch(EmptyQueueException e) {
			assertTrue(false);
		}
	}

	/**
	 * Test method for {@link utilities.MyQueue#dequeueAll()}.
	 */
	@Test
	public void testDequeueAlreadyEmpty() {
		queue.dequeueAll();
		assertEquals(queue.size(), 0);
	}

	/**
	 * Test method for {@link utilities.MyQueue#dequeueAll()}.
	 */
	@Test
	public void testDequeueAll() {
		queue.enqueue("armaan");
		queue.enqueue("singh");
		queue.enqueue("klair");
		queue.dequeueAll();
		assertEquals(queue.size(), 0);
	}
	
	/**
	 * Test method for {@link utilities.MyQueue#isEmpty()}.
	 */
	@Test
	public void testIsEmptyTrue() {
		assertTrue(queue.isEmpty());
	}
	
	/**
	 * Test method for {@link utilities.MyQueue#isEmpty()}.
	 */
	@Test
	public void testIsEmptyFalse() {
		queue.enqueue("armaan");
		assertFalse(queue.isEmpty());
	}

	/**
	 * Test method for {@link utilities.MyQueue#iterator()}.
	 */
	@Test
	public void testIterator() {
		queue.enqueue("element1");
		queue.enqueue("element2");
		adt.Iterator<String> iter =  queue.iterator();
		
		assertTrue(iter.hasNext());
		assertEquals(iter.next().intern(), "element1");
		assertTrue(iter.hasNext());
		assertEquals(iter.next().intern(), "element2");
		assertFalse(iter.hasNext());
	}

	/**
	 * Test method for {@link utilities.MyQueue#equals(adt.QueueADT)}.
	 */
	@Test
	public void testEqualsQueueADTOfEUnequalSize() {
		QueueADT<String> queue2 = new MyQueue<>();
		queue2.enqueue("a");
		
		queue.enqueue("a");
		queue.enqueue("b");
		
		assertFalse(queue.equals(queue2));
	}
	
	/**
	 * Test method for {@link utilities.MyQueue#equals(adt.QueueADT)}.
	 */
	@Test
	public void testEqualsQueueADTOfEDiffOrder() {
		QueueADT<String> queue2 = new MyQueue<>();
		queue2.enqueue("b");
		queue2.enqueue("a");
		
		queue.enqueue("a");
		queue.enqueue("b");
		
		assertFalse(queue.equals(queue2));
	}
	
	/**
	 * Test method for {@link utilities.MyQueue#equals(adt.QueueADT)}.
	 */
	@Test
	public void testEqualsQueueADTOfE() {
		QueueADT<String> queue2 = new MyQueue<>();
		queue2.enqueue("a");
		queue2.enqueue("b");
		
		queue.enqueue("a");
		queue.enqueue("b");
		
		assertTrue(queue.equals(queue2));
	}

	/**
	 * Test method for {@link utilities.MyQueue#toArray()}.
	 */
	@Test
	public void testToArray() {
		queue.enqueue("a");
		queue.enqueue("b");
		queue.enqueue("c");
		queue.enqueue("d");
		
		Object[] toHold = queue.toArray();
		
		assertTrue(toHold[0].equals("a"));
		assertTrue(toHold[1].equals("b"));
		assertTrue(toHold[2].equals("c"));
		assertTrue(toHold[3].equals("d"));

	}

	/**
	 * Test method for {@link utilities.MyQueue#toArray(E[])}.
	 */
	@Test
	public void testToArrayEArrayBigEnough() {
		queue.enqueue("a");
		queue.enqueue("b");
		queue.enqueue("c");
		queue.enqueue("d");
		
		String[] toHold = new String[4];
		queue.toArray(toHold);
		
		assertTrue(toHold[0].equals("a"));
		assertTrue(toHold[1].equals("b"));
		assertTrue(toHold[2].equals("c"));
		assertTrue(toHold[3].equals("d"));
	}
	
	/**
	 * Test method for {@link utilities.MyQueue#toArray(E[])}.
	 */
	@Test
	public void testToArrayEArrayNotBigEnough() {
		queue.enqueue("a");
		queue.enqueue("b");
		queue.enqueue("c");
		queue.enqueue("d");
		
		String[] toHold = new String[2];
		toHold = queue.toArray(toHold);
		
		assertTrue(toHold[0].equals("a"));
		assertTrue(toHold[1].equals("b"));
		assertTrue(toHold[2].equals("c"));
		assertTrue(toHold[3].equals("d"));
	}

	

	/**
	 * Test method for {@link utilities.MyQueue#size()}.
	 */
	@Test
	public void testSizeEmpty() {
		assertEquals(queue.size(), 0);
	}
	
	/**
	 * Test method for {@link utilities.MyQueue#size()}.
	 */
	@Test
	public void testSize() {
		queue.enqueue("a");
		queue.enqueue("b");
		try {
		queue.dequeue();
		assertEquals(queue.size(), 1);
		}catch(EmptyQueueException e) {
			assertTrue(false);
		}
		 
	}

}
