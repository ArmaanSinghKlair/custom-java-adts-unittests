/**
 * 
 */
package utilities;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import adt.*;

/**
 * @author 839645
 *
 */
public class MyDLLTests {
	ListADT<String> Dll1;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		Dll1 = new MyDLL<>();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		Dll1 = null;
	}

	/**
	 * Test method for {@link utilities.MyDLL#size()}.
	 */
	@Test
	public void testSizeEmpty() {
		assertEquals(Dll1.size(),0);
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#size()}.
	 */
	@Test
	public void testSizeNotEmpty() {
		Dll1.add("element");
		Dll1.add("element2");
		assertEquals(Dll1.size(),2);
	}

	/**
	 * Test method for {@link utilities.MyDLL#clear()}.
	 */
	@Test
	public void testClear() {
		Dll1.add("element");
		Dll1.add("element2");
		assertEquals(Dll1.size(),2);
		Dll1.clear();
		assertEquals(Dll1.size(),0);
	}

	/**
	 * Test method for {@link utilities.MyDLL#add(int, java.lang.Object)}.
	 */
	@Test
	public void testAddIntENullPointerException() {
		assertThrows(NullPointerException.class, ()-> Dll1.add(0,null));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#add(int, java.lang.Object)}.
	 */
	@Test
	public void testAddIntEIndexOutOfBoundsExceptionNegative() {
		assertThrows(IndexOutOfBoundsException.class, ()-> Dll1.add(-1,"armaan"));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#add(int, java.lang.Object)}.
	 */
	@Test
	public void testAddIntEIndexOutOfBoundsExceptionSize() {
		Dll1.add(0,"armaan");
		assertThrows(IndexOutOfBoundsException.class, ()-> Dll1.add(2,"singh"));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#add(int, java.lang.Object)}.
	 */
	@Test
	public void testAddIntE() {
		Dll1.add(0,"armaan");
		assertTrue(Dll1.get(0).equals("armaan"));
		Dll1.add("singh");
		assertEquals(Dll1.size(),2);
		Dll1.add(2,"klair");
		assertTrue(Dll1.get(Dll1.size()-1).equals("klair"));
	}
	

	
	
	/**
	 * Test method for {@link utilities.MyDLL#add(java.lang.Object)}.
	 */
	@Test
	public void testAddENullPointerException() {
		assertThrows(NullPointerException.class, ()-> Dll1.add(null));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#add(java.lang.Object)}.
	 */
	@Test
	public void testAddE() {
		Dll1.add("a");
		Dll1.add("b");
		assertEquals(Dll1.get(0).intern(),"a");
		assertEquals(Dll1.get(1).intern(), "b");
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#addAll(adt.ListADT)}.
	 */
	@Test
	public void testAddAllNullPointerException() {
		assertThrows(NullPointerException.class, ()-> Dll1.addAll(null));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#addAll(adt.ListADT)}.
	 */
	@Test
	public void testAddAll() {
		ListADT<String> Dll2 = new MyDLL();
		Dll2.add("c");
		Dll2.add("d");
		Dll1.add("a");
		Dll1.add("b");
		Dll1.addAll(Dll2);
		assertTrue(Dll1.get(0).equals("a"));
		assertTrue(Dll1.get(1).equals("b"));
		assertTrue(Dll1.get(2).equals("c"));
		assertTrue(Dll1.get(3).equals("d"));

	}

	/**
	 * Test method for {@link utilities.MyDLL#get(int)}.
	 */
	@Test
	public void testGetIndexOutOfBoundsExceptionNegative() {
		assertThrows(IndexOutOfBoundsException.class, ()->Dll1.get(-10));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#get(int)}.
	 */
	@Test
	public void testGetIndexOutOfBoundsExceptionSize() {
		Dll1.add("a");
		Dll1.add("b");
		assertThrows(IndexOutOfBoundsException.class, ()->Dll1.get(10));
	}

	/**
	 * Test method for {@link utilities.MyDLL#remove(int)}.
	 */
	@Test
	public void testRemoveIntIndexOutOfBoundsExceptionNegative() {
		assertThrows(IndexOutOfBoundsException.class, ()->Dll1.remove(-10));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#remove(int)}.
	 */
	@Test
	public void testRemoveIntIndexOutOfBoundsExceptionSize() {
		Dll1.add("a");
		Dll1.add("b");
		assertThrows(IndexOutOfBoundsException.class, ()->Dll1.remove(10));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#remove(int)}.
	 */
	@Test
	public void testRemoveInt() {
		Dll1.add("a");
		Dll1.add("b");
		Dll1.add("c");
		Dll1.remove(1);
		assertEquals(Dll1.size(),2);
		assertTrue(Dll1.get(0).equals("a"));
		assertTrue(Dll1.get(1).equals("c"));
	}
	
	

	/**
	 * Test method for {@link utilities.MyDLL#remove(java.lang.Object)}.
	 */
	@Test
	public void testRemoveENullPointerException() {
		assertThrows(NullPointerException.class,()-> Dll1.remove(null));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#remove(java.lang.Object)}.
	 */
	@Test
	public void testRemoveEDuplicateCase() {
		Dll1.add("a");
		Dll1.add("a");
		Dll1.add("b");
		Dll1.remove("a");
		assertEquals(Dll1.size(), 2);
		assertTrue(Dll1.get(0).equals("a"));
		assertTrue(Dll1.get(1).equals("b"));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#remove(java.lang.Object)}.
	 */
	@Test
	public void testRemoveETailCase() {
		Dll1.add("a");
		Dll1.add("a");
		Dll1.add("b");
		Dll1.remove("b");
		assertEquals(Dll1.size(), 2);
		assertTrue(Dll1.get(0).equals("a"));
		assertTrue(Dll1.get(1).equals("a"));
	}

	/**
	 * Test method for {@link utilities.MyDLL#set(int, java.lang.Object)}.
	 */
	@Test
	public void testSetNullPointerException() {
		Dll1.add("test");
		assertThrows(NullPointerException.class, ()->Dll1.set(0, null));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#set(int, java.lang.Object)}.
	 */
	@Test
	public void testSetIndexOutOfBoundsExceptionNegative() {
		assertThrows(IndexOutOfBoundsException.class, ()->Dll1.set(-10, "a"));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#set(int, java.lang.Object)}.
	 */
	@Test
	public void testSetIndexOutOfBoundsExceptionSize() {
		Dll1.add("a");
		assertThrows(IndexOutOfBoundsException.class, ()->Dll1.set(1, "b"));
	}

	/**
	 * Test method for {@link utilities.MyDLL#isEmpty()}.
	 */
	@Test
	public void testIsEmptyFalse() {
		Dll1.add("A");
		assertFalse(Dll1.isEmpty());
	}
	/**
	 * Test method for {@link utilities.MyDLL#isEmpty()}.
	 */
	@Test
	public void testIsEmptyTrue() {
		assertTrue(Dll1.isEmpty());
	}

	/**
	 * Test method for {@link utilities.MyDLL#contains(java.lang.Object)}.
	 */
	@Test
	public void testContainsNullPointerException() {
		assertThrows(NullPointerException.class, ()->Dll1.contains(null));
	}

	/**
	 * Test method for {@link utilities.MyDLL#contains(java.lang.Object)}.
	 */
	@Test
	public void testContainsTrue() {
		Dll1.add("A");
		assertTrue(Dll1.contains("A"));
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#contains(java.lang.Object)}.
	 */
	@Test
	public void testContainsFalse() {
		Dll1.add("A");
		assertFalse(Dll1.contains("B"));
	}

	/**
	 * Test method for {@link utilities.MyDLL#toArray(E[])}.
	 */
	@Test
	public void testToArrayEArraySufficient() {
		Dll1.add("A");
		Dll1.add("B");
		Dll1.add("C");
		Dll1.add("D");
		
		String[] toHold = new String[4];
		toHold = Dll1.toArray(toHold);
		assertEquals(toHold[0].intern(), "A");
		assertEquals(toHold[1].intern(), "B");
		assertEquals(toHold[2].intern(), "C");
		assertEquals(toHold[3].intern(), "D");
	}
	
	/**
	 * Test method for {@link utilities.MyDLL#toArray(E[])}.
	 */
	@Test
	public void testToArrayEArrayInSufficient() {
		Dll1.add("A");
		Dll1.add("B");
		Dll1.add("C");
		Dll1.add("D");
		
		String[] toHold = new String[2];		// 2 < 4
		toHold = Dll1.toArray(toHold);
		assertEquals(toHold[0].intern(), "A");
		assertEquals(toHold[1].intern(), "B");
		assertEquals(toHold[2].intern(), "C");
		assertEquals(toHold[3].intern(), "D");
	}

	/**
	 * Test method for {@link utilities.MyDLL#toArray()}.
	 */
	@Test
	public void testToArray() {
		Dll1.add("A");
		Dll1.add("B");
		Dll1.add("C");
		Dll1.add("D");
		
		Object[] toHold =  Dll1.toArray();
		assertEquals(toHold[0], "A");
		assertEquals(toHold[1], "B");
		assertEquals(toHold[2], "C");
		assertEquals(toHold[3], "D");
	}

	/**
	 * Test method for {@link utilities.MyDLL#iterator()}.
	 */
	@Test
	public void testIterator() {
		Dll1.add("element1");
		Dll1.add("element2");
		adt.Iterator<String> iter =  Dll1.iterator();
		
		assertTrue(iter.hasNext());
		assertEquals(iter.next().intern(), "element1");
		assertTrue(iter.hasNext());
		assertEquals(iter.next().intern(), "element2");

		assertFalse(iter.hasNext());	
	}

}
