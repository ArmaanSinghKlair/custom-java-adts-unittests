/**
 * 
 */
package utilities;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import adt.StackADT;
import exceptions.*;
/**
 * @author 839645
 *
 */
public class MyStackTests {
	StackADT<String> stack1;
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		stack1 = new MyStack<String>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		stack1 = null;
	}

	/**
	 * Test method for {@link utilities.MyStack#push(java.lang.Object)}.
	 */
	@Test
	public void testPushNullPointerException() {
		assertThrows(NullPointerException.class, () -> stack1.push(null));
	}
	
	/**
	 * Test method for {@link utilities.MyStack#push(java.lang.Object)}.
	 */
	@Test
	public void testPush() {
		stack1.push("a");
		stack1.push("b");
		try {
		assertTrue(stack1.peek().equals("b"));
		assertEquals(stack1.size(), 2);
		} catch(EmptyStackException e) {
			assertTrue(false);
		}
	}

	/**
	 * Test method for {@link utilities.MyStack#pop()}.
	 */
	@Test
	public void testPopEmptyStackException() {
		assertThrows(EmptyStackException.class, () -> stack1.pop());
	}
	
	/**
	 * Test method for {@link utilities.MyStack#pop()}.
	 */
	@Test
	public void testPop() {
		stack1.push("a");
		stack1.push("b");
		try {
		assertTrue(stack1.pop().equals("b"));
		assertTrue(stack1.peek().equals("a"));
		} catch(EmptyStackException e) {
			assertTrue(false);
		}

	}

	/**
	 * Test method for {@link utilities.MyStack#peek()}.
	 */
	@Test
	public void testPeekEmptyStackException() {
		assertThrows(EmptyStackException.class, () -> stack1.peek());
	}
	
	/**
	 * Test method for {@link utilities.MyStack#peek()}.
	 */
	@Test
	public void testPeek() {
		stack1.push("a");
		stack1.push("b");
		try {
		assertTrue(stack1.peek().equals("b"));
		assertEquals(stack1.size(), 2);
		} catch(EmptyStackException e) {
			assertTrue(false);
		}
	}

	/**
	 * Test method for {@link utilities.MyStack#clear()}.
	 */
	@Test
	public void testClear() {
		stack1.push("A");
		stack1.push("B");
		stack1.push("C");
		stack1.push("D");
		assertEquals(stack1.size(), 4);
		stack1.clear();
		assertEquals(stack1.size(), 0);
		assertThrows(EmptyStackException.class, ()->stack1.peek());
	}

	/**
	 * Test method for {@link utilities.MyStack#isEmpty()}.
	 */
	@Test
	public void testIsEmptyTrue() {
		assertTrue(stack1.isEmpty());
	}
	
	/**
	 * Test method for {@link utilities.MyStack#isEmpty()}.
	 */
	@Test
	public void testIsEmptyFalse() {
		stack1.push("A");
		assertFalse(stack1.isEmpty());
	}

	/**
	 * Test method for {@link utilities.MyStack#toArray()}.
	 */
	@Test
	public void testToArray() {
		stack1.push("A");
		stack1.push("B");
		stack1.push("C");
		stack1.push("D");
		
		Object[] toHold = stack1.toArray();
		assertEquals(toHold[0], "A");
		assertEquals(toHold[1], "B");
		assertEquals(toHold[2], "C");
		assertEquals(toHold[3], "D");

	}

	/**
	 * Test method for {@link utilities.MyStack#toArray(E[])}.
	 */
	@Test
	public void testToArrayEArrayNullPointerException() {
		assertThrows(NullPointerException.class, () -> stack1.toArray(null));
	}
	
	/**
	 * Test method for {@link utilities.MyStack#toArray(E[])}.
	 */
	@Test
	public void testToArrayEArray() {
		stack1.push("A");
		stack1.push("B");
		stack1.push("C");
		stack1.push("D");
		
		String[] toHold = new String[4];
		toHold = (String[]) stack1.toArray(toHold);
		assertEquals(toHold[0].intern(), "A");
		assertEquals(toHold[1].intern(), "B");
		assertEquals(toHold[2].intern(), "C");
		assertEquals(toHold[3].intern(), "D");
	}

	/**
	 * Test method for {@link utilities.MyStack#contains(java.lang.Object)}.
	 */
	@Test
	public void testContainsTrue() {
		stack1.push("a");
		stack1.push("b");
		assertTrue(stack1.contains("a"));
	}
	
	/**
	 * Test method for {@link utilities.MyStack#contains(java.lang.Object)}.
	 */
	@Test
	public void testContainsFalse() {
		stack1.push("a");
		stack1.push("b");
		assertFalse(stack1.contains("c"));
	}

	/**
	 * Test method for {@link utilities.MyStack#search(java.lang.Object)}.
	 */
	@Test
	public void testSearchIfPresent() {
		stack1.push("a");
		stack1.push("b");
		stack1.push("c");
		assertEquals(stack1.search("c"),1);
	}
	
	/**
	 * Test method for {@link utilities.MyStack#search(java.lang.Object)}.
	 */
	@Test
	public void testSearchNotPresent() {
		stack1.push("a");
		stack1.push("b");
		stack1.push("c");
		assertEquals(stack1.search("e"),-1);
	}

	/**
	 * Test method for {@link utilities.MyStack#iterator()}.
	 */
	@Test
	public void testIterator() {
		stack1.push("element1");
		stack1.push("element2");
		adt.Iterator<String> iter =  stack1.iterator();
		
		assertTrue(iter.hasNext());
		assertEquals(iter.next().intern(), "element2");
		assertTrue(iter.hasNext());
		assertEquals(iter.next().intern(), "element1");
		assertFalse(iter.hasNext());	
		}

	/**
	 * Test method for {@link utilities.MyStack#equals(adt.StackADT)}.
	 */
	@Test
	public void testEqualsStackADTOfEFalseUnequalLength() {
		StackADT<String> toBeCompared = new MyStack();
		toBeCompared.push("A");
		toBeCompared.push("B");
		
		stack1.push("A");
		stack1.push("B");
		stack1.push("C");
		
		assertFalse(stack1.equals(toBeCompared));

	}
	
	/**
	 * Test method for {@link utilities.MyStack#equals(adt.StackADT)}.
	 */
	@Test
	public void testEqualsStackADTOfEFalseDiffOrder() {
		StackADT<String> toBeCompared = new MyStack();
		toBeCompared.push("A");
		toBeCompared.push("C");
		toBeCompared.push("B");

		stack1.push("A");
		stack1.push("B");
		stack1.push("C");
		
		assertFalse(stack1.equals(toBeCompared));

	}
	
	/**
	 * Test method for {@link utilities.MyStack#equals(adt.StackADT)}.
	 */
	@Test
	public void testEqualsStackADTOfETrue() {
		StackADT<String> toBeCompared = new MyStack();
		toBeCompared.push("A");
		toBeCompared.push("B");
		toBeCompared.push("C");

		stack1.push("A");
		stack1.push("B");
		stack1.push("C");
		
		assertTrue(stack1.equals(toBeCompared));

	}
	
	

	/**
	 * Test method for {@link utilities.MyStack#size()}.
	 */
	@Test
	public void testSizeWhenEmpty() {
		assertEquals(stack1.size(),0);
	}
	
	/**
	 * Test method for {@link utilities.MyStack#size()}.
	 */
	@Test
	public void testSize() {
		stack1.push("A");
		stack1.push("B");

		try {
		stack1.pop();
		assertEquals(stack1.size(),1);
		} catch(EmptyStackException e) {
			assertTrue(false);
		}
	}


}
