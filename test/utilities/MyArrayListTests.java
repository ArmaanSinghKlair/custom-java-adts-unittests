/**
 * 
 */
package utilities;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import adt.ListADT;
import exceptions.EmptyStackException;

/**
 * @author 839645
 *
 */
public class MyArrayListTests {
	ListADT<String> list1;
	ListADT<String> list2;
	
	

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		list1 = new MyArrayList<>();
		list2 = new MyArrayList<>(11);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		list1 = null;
		list2 = null;
	}

	/**
	 * Test method for {@link utilities.MyArrayList#MyArrayList()}.
	 */
	@Test
	public void testMyArrayList() {
		assertEquals(0, list1.size());
		assertTrue(list1.isEmpty());	}

	/**
	 * Test method for {@link utilities.MyArrayList#MyArrayList(int)}.
	 */
	@Test
	public void testMyArrayListInt() {
		assertEquals(0, list2.size());
		assertTrue(list2.isEmpty());		}

	/**
	 * Test method for {@link utilities.MyArrayList#size()}.
	 */
	@Test
	public void testSizeEmpty() {
		assertEquals(0, list1.size());
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#size()}.
	 */
	@Test
	public void testSizeNotEmpty() {
		list1.add("V");
		assertFalse(list1.size() == 0);
	
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#clear()}.
	 */
	@Test
	public void testClearEmpty() {
		list1.add("a");
		list1.clear();
		assertEquals(0, list1.size());
		assertTrue(list1.isEmpty());
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#clear()}.
	 */
	@Test
	public void testClearNotEmpty() {
		list1.add("another one");
		list1.clear();
		list1.add("another one");
		assertEquals(1, list1.size());
		assertFalse(list1.isEmpty());

	}

	/**
	 * Test method for {@link utilities.MyArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	public void testAddIntE() {
		list1.add(0,"A");
		assertEquals(1, list1.size());
		assertTrue(list1.contains("A"));
		assertEquals("A",list1.get(0));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	public void testAddIntENotEmpty() {
		list1.add(0,"A");
		assertNotEquals(0, list1.size());
		assertFalse(!list1.contains("A"));
		assertFalse(!list1.get(0).equals("A"));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	public void testAddIntEEmpty() {
		list1.add(0,"A");
		list1.clear();
		assertEquals(0, list1.size());
		assertFalse(list1.contains("A"));
		assertThrows(IndexOutOfBoundsException.class, () -> list1.get(0).equals("A"));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	public void testAddIntENull() {
		assertThrows(NullPointerException.class, () -> list1.add(0,null));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#add(int, java.lang.Object)}.
	 */
	@Test
	public void testAddIntELowerBound() {
		list1.add(0,"A");
		list1.clear();
		assertEquals(0, list1.size());
		assertFalse(list1.contains("A"));
	}

	/**
	 * Test method for {@link utilities.MyArrayList#add(java.lang.Object)}.
	 */
	@Test
	public void testAddNullPointerException() {
		assertThrows(NullPointerException.class, ()-> {
			list1.add(null);
			});
		}
	
	
	/**
	 * Test method for {@link utilities.MyArrayList#add(java.lang.Object)}.
	 */
	@Test
	public void testAddEmpty() {
		list1.add("element");
		list1.add("element2");
		list1.clear();
		assertTrue(list1.isEmpty());
		assertThrows(IndexOutOfBoundsException.class, ()->list1.get(0));
		assertEquals(list1.size(), 0);
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#add(java.lang.Object)}.
	 */
	@Test
	public void testAddNotEmpty() {
		list1.add("element");
		list1.add("element2");
		assertFalse(list1.isEmpty());
		assertEquals(list1.size(), 2);
		assertTrue(list1.get(0).equals("element"));
		assertTrue(list1.get(1).equals("element2"));
		assertThrows(IndexOutOfBoundsException.class, ()->list1.get(2));
	}
	
	

	/**
	 * Test method for {@link utilities.MyArrayList#addAll(adt.ListADT)}.
	 */
	@Test
	public void testAddAll() {
		ListADT<String> toAdd = new MyArrayList<>();
		toAdd.add("newItem1");
		toAdd.add("newItem2");
		list1.add("originalItem1");
		list1.addAll(toAdd);
		assertEquals(list1.size(), 3);
		assertTrue(list1.get(1).equals("newItem1"));
		assertTrue(list1.get(2).equals("newItem2"));

	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#addAll(adt.ListADT)}.
	 */
	@Test
	public void testAddAllNull() {
		ListADT<String> toAdd = new MyArrayList();
		toAdd.add("newItem1");
		toAdd.add("newItem2");
		list1.add("originalItem1");
		assertThrows(NullPointerException.class, () -> list1.addAll(null));

	}

	/**
	 * Test method for {@link utilities.MyArrayList#get(int)}.
	 */
	@Test
	public void testGetExceptionEmpty() {
		assertThrows(IndexOutOfBoundsException.class, ()->list1.get(1));
	}

	/**
	 * Test method for {@link utilities.MyArrayList#get(int)}.
	 */
	@Test
	public void testGet() {
		list1.add("armaan");
		assertTrue("armaan".equals(list1.get(0)));
		assertTrue(!list1.isEmpty());	
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#get(int)}.
	 */
	@Test
	public void testGetInvalidIndex() {
		assertThrows(IndexOutOfBoundsException.class, ()->list1.get(-10));
	}

	/**
	 * Test method for {@link utilities.MyArrayList#remove(int)}.
	 */
	@Test
	public void testRemoveIntEmpty() {
		assertThrows(IndexOutOfBoundsException.class, () -> list1.remove(0));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#remove(int)}.
	 */
	@Test
	public void testRemoveIntInvalidIndex() {
		list1.add("element");
		assertThrows(IndexOutOfBoundsException.class, () -> list1.remove(-10));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#remove(int)}.
	 */
	@Test
	public void testRemoveIntMoreThanSize() {
		list1.add("eleemet");
		assertThrows(IndexOutOfBoundsException.class, () -> list1.remove(1));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#remove(int)}.
	 */
	@Test
	public void testRemoveInt() {
		list1.add("element");
		list1.remove(0);
		assertTrue(list1.isEmpty());
		assertEquals(list1.size(), 0);
		assertThrows(IndexOutOfBoundsException.class, ()->list1.get(0));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#remove(java.lang.Object)}.
	 */
	@Test
	public void testRemoveENull() {
		list1.add("element");
		assertThrows(NullPointerException.class, ()->list1.remove(null));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#remove(java.lang.Object)}.
	 */
	@Test
	public void testRemoveEFirstOccurence() {
		list1.add("A");
		list1.add("B");
		list1.add("A");
		list1.add("D");
		
		list1.remove("A");
		assertTrue(list1.contains("A"));
		assertEquals(list1.get(1).intern(), "A");
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#remove(java.lang.Object)}.
	 */
	@Test
	public void testRemoveE() {
		list1.add("element");
		assertEquals(list1.get(0).intern(), "element");
		list1.remove("element");
		assertTrue(list1.isEmpty());
		assertThrows(IndexOutOfBoundsException.class, ()->list1.get(0));
	}

	/**
	 * Test method for {@link utilities.MyArrayList#set(int, java.lang.Object)}.
	 */
	@Test
	public void testSetNullPointer() {
		list1.add("e");
		assertThrows(NullPointerException.class, ()->list1.set(0, null));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#set(int, java.lang.Object)}.
	 */
	@Test
	public void testSetInvalidIndex() {
		list1.add("e");
		assertThrows(IndexOutOfBoundsException.class, ()->list1.set(-10, "a"));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#set(int, java.lang.Object)}.
	 */
	@Test
	public void testSet() {
		list1.add("e");
		list1.set(0, "new");
		assertEquals(list1.get(0).intern(), "new");
		assertFalse(list1.isEmpty());
	}

	/**
	 * Test method for {@link utilities.MyArrayList#isEmpty()}.
	 */
	@Test
	public void testIsEmptyNotEmpty() {
		list1.add("e");
		assertFalse(list1.isEmpty());		
	}

	/**
	 * Test method for {@link utilities.MyArrayList#isEmpty()}.
	 */
	@Test
	public void testIsEmpty() {
		assertTrue(list1.isEmpty());		
	}

	/**
	 * Test method for {@link utilities.MyArrayList#contains(java.lang.Object)}.
	 */
	@Test
	public void testContainsNullPointerException() {
		list1.add("element");
		assertThrows(NullPointerException.class, ()->list1.contains(null));
	}

	/**
	 * Test method for {@link utilities.MyArrayList#contains(java.lang.Object)}.
	 */
	@Test
	public void testContainsTrue() {
		list1.add("element");
		assertTrue(list1.contains("element"));
	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#contains(java.lang.Object)}.
	 */
	@Test
	public void testContainsFalse() {
		list1.add("element");
		list1.clear();
		assertFalse(list1.contains("element"));
	}

	/**
	 * Test method for {@link utilities.MyArrayList#toArray(E[])}.
	 */
	@Test
	public void testToArrayEArrayNullPointerException() {
		list1.add("A");
		list1.add("B");
		list1.add("A");
		list1.add("D");
		
		String[] toHold = new String[4];
		assertThrows(NullPointerException.class,()->list1.toArray(null));
	}

	/**
	 * Test method for {@link utilities.MyArrayList#toArray(E[])}.
	 */
	@Test
	public void testToArrayEArrayHolderArraySufficient() {
		list1.add("A");
		list1.add("B");
		list1.add("C");
		list1.add("D");
		
		String[] toHold = new String[4];
		toHold = list1.toArray(toHold);
		assertTrue(toHold[0].equals("A"));
		assertTrue(toHold[1].equals("B"));
		assertTrue(toHold[2].equals("C"));
		assertTrue(toHold[3].equals("D"));

	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#toArray(E[])}.
	 */
	@Test
	public void testToArrayEArrayHolderArrayInSufficient() {
		list1.add("A");
		list1.add("B");
		list1.add("C");
		list1.add("D");
		
		String[] toHold = new String[2];
		toHold = (String[]) list1.toArray(toHold);
		assertTrue(toHold[0].equals("A"));
		assertTrue(toHold[1].equals("B"));
		assertTrue(toHold[2].equals("C"));
		assertTrue(toHold[3].equals("D"));

	}
	
	/**
	 * Test method for {@link utilities.MyArrayList#toArray()}.
	 */
	@Test
	public void testToArray() {
		list1.add("A");
		list1.add("B");
		list1.add("C");
		list1.add("D");
		
		Object[] toHold =  list1.toArray();
		assertTrue(toHold[0].equals("A"));
		assertTrue(toHold[1].equals("B"));
		assertTrue(toHold[2].equals("C"));
		assertTrue(toHold[3].equals("D"));
	}

	/**
	 * Test method for {@link utilities.MyArrayList#iterator()}.
	 */
	@Test
	public void testIterator() {
		list1.add("element");
		adt.Iterator<String> iter =  list1.iterator();
		
		assertTrue(iter.hasNext());
		assertEquals(iter.next().intern(), "element");
		assertFalse(iter.hasNext());
		
	}

}
