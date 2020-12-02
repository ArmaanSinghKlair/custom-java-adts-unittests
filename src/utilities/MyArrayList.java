package utilities;


import java.lang.reflect.Array;
import java.util.NoSuchElementException;
import adt.Iterator;
import adt.ListADT;

/**
 * This is an implementation of ArrayList using the Array data structure and implementing the ListADT
 * @author Armaan Singh Klair
 * @version 11/19/20
 * @param <E> The is type-to-be-specified-later
 */

public class MyArrayList<E> implements ListADT<E> {
	/**
	 * Private Data Fields
	 */
	private E[] array;
	private int size;
	
	/**
	 * No-arg constructor- creates an array with default size 10
	 */
	public MyArrayList() {
		this(10);
	}
	
	/**
	 * Constructor - creates an arraylist with specified capacity
	 * @param capacity Capacity of arraylist
	 */
	public MyArrayList(int capacity) {
		array = (E[]) new Object[capacity];
		
	}
	
	/**
	 * Returns number of elements in Arraylist
	 */
	@Override
	public int size() {
		return size;
	}

	/**
	 * Clears all elements in ArrayList and sets size to 0
	 */
	@Override
	public void clear() {
		this.size = 0;
		this.array = (E[]) new Object[this.array.length];
	}
	
	/**
	 * Inserts the specified element at the specified position in this list.
	 * Shifts the element currently at that position (if any) and any subsequent
	 * elements to the right (adds one to their indices).
	 * 
	 * @param index
	 * 			The index at which the specified element is to be inserted.
	 * 			The element is inserted before the existing element at [index],
	 * 			or at the end if index is equal to the 
	 * 			size (<code>size()</code>).
	 * @param toAdd
	 * 			The element to be inserted.
	 * @return <code>true</code> if the element is added successfully.
	 * @throws NullPointerException
	 * 			If the specified element is <code>null</code> 
	 * @throws IndexOutOfBoundsException
	 * 			If the index is out of range: 
	 * 			i.e. (<code>index < 0 || index > size()</code>).
	 */
	@Override
	public boolean add(int index, E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if(toAdd == null)
			throw new NullPointerException("Element to be added is null");
		else if(index < 0)
			throw new IndexOutOfBoundsException("Index cannot be less than zero");
		else if(index > size)
			throw new IndexOutOfBoundsException("Index greater than size of ArrayList");

		else {
				if(size == this.array.length) {
					E[] newArr =(E[]) new Object[this.array.length+1];
					newArr[index] = toAdd;
					System.arraycopy(this.array, 0, newArr, 0, index);
					System.arraycopy(this.array, index, newArr, index+1, this.array.length-index);
					this.array = newArr;
					this.size++;
					return true;
				} else {
					System.arraycopy(this.array, index, this.array, index+1, this.size()-index);
					this.array[index] = toAdd;
					this.size++;
					return true;
				}
				
				
		}
	}

	/**
	 * Appends the specified element to the end of this list.
	 * 
	 * @param toAdd
	 * 			Element to be appended to this list.
	 * @return true if element is appended successfully.
	 * @throws NullPointerException
	 * 			If the specified element is <code>null</code>
	 * @throws IndexOutOfBoundsException
	 * 			If the index is out of range: 
	 * 			i.e. (<code>index < 0 || index >= size()</code>).
	 */
	@Override
	public boolean add(E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if(toAdd == null) {
			throw new NullPointerException("Element to be added is null");
		}
		else {
				if(size == array.length) {
					E[] newArr =(E[]) new Object[this.array.length+1];
					newArr[newArr.length-1] = toAdd;
					System.arraycopy(this.array, 0, newArr, 0, this.array.length);
					this.array = newArr;
					this.size++;
					return true;
				} else {
					this.array[size] = toAdd;
					this.size++;
					return true;
				}
				
		}
	}

	/**
	 * Appends all of the elements in the specified 
	 * toAdd arraylist to the end of
	 * this list, in the order that they are returned by the specified
	 * collection's <code>Iterator</code>.
	 * 
	 * @param toAdd
	 * 			The new sub list to be added.
	 * @return true
	 * 			If the operation is successful.
	 * @throws NullPointerException
	 * 			If the specified element is <code>null</code>
	 */
	@Override
	public boolean addAll(ListADT<? extends E> toAdd) throws NullPointerException {
		if(toAdd == null)
			throw new NullPointerException();
		else {
			int totLength = this.size + toAdd.size();
			E[] newArr =(E[]) new Object[totLength];
			System.arraycopy(this.array, 0, newArr, 0, this.size);
			
			Iterator<E> iter = (Iterator<E>) toAdd.iterator();
			
			int index = this.size;
			while(iter.hasNext()) {
				newArr[index++] = iter.next();
			}
			this.array = newArr;
			this.size = this.array.length;
			return true;
		}
	}

	/**
	 * Returns the element at the specified position in this ArrayList.
	 * 
	 * @param index
	 * 			Index of element to return.
	 * @return The element at the specified position in this ArrayList.
	 * @throws IndexOutOfBoundsException
	 * 			If the index is out of range: 
	 * 			i.e. (<code>index < 0 || index >= size()</code>).
	 */
	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if(index < 0)
			throw new IndexOutOfBoundsException("Index cannot be less than zero");
		else if(index >= size)
			throw new IndexOutOfBoundsException("Index greater than size of ArrayList");
		else {
			return this.array[index];
		}
		
	}

	/**
	 * Removes the element at the specified position in this list. Shifts any
	 * subsequent elements to the left.
	 * Returns the element that was removed from the ArrayList.
	 * 
	 * @param index
	 * 			The index of the element to remove.
	 * @return The removed element.
	 * @throws IndexOutOfBoundsException
	 * 			If the index is out of range: 
	 * 			i.e. (<code>index < 0 || index >= size()</code>).
	 */
	@Override
	public E remove(int index) throws IndexOutOfBoundsException {
		if(index < 0)
			throw new IndexOutOfBoundsException("Index cannot be less than zero");
		else if(index >= size)
			throw new IndexOutOfBoundsException("Index greater than size of ArrayList");
		else {
			E toRemove = this.array[index];
			System.arraycopy(this.array, index+1, this.array, index, this.size()-index-1);
			this.array[this.array.length-1]=null;
			this.size--;
			return toRemove;
		}
	}

	/**
	 * Removes the first occurrence in this ArrayList of the specified element. If
	 * this list does not contain the element, it is unchanged. 
	 * 
	 * @param toRemove
	 * 			The element to be removed from this ArrayList.
	 * @return The element which is being removed, or null if the ArrayList does
	 * 			not contain the element.
	 * @throws NullPointerException
	 * 			If the specified element is <code>null</code> 
	 */
	@Override
	public E remove(E toRemove) throws NullPointerException {
		if(toRemove == null)
			throw new NullPointerException("Input to remove method is null");
		else {
			int i=0;
			E actualElement = null;
			while(!this.array[i].equals(toRemove) && i < this.size()) i++;
			actualElement = this.array[i];
			
			if(toRemove.equals(actualElement)) {
				System.arraycopy(this.array, i+1, this.array, i, this.size()-i-1);
				this.array[this.array.length-1]=null;
				this.size--;
				return toRemove;
			} else
				return null;
					
		}
	}

	/**
	 * Replaces the element at the specified position in this ArrayList with the
	 * specified element.
	 * 
	 * @param index
	 * 			The index of the element to replace.
	 * @param toChange
	 * 			Element to be stored at the specified position.
	 * @return The element previously at the specified position.
	 * @throws NullPointerException
	 * 			If the specified element is <code>null</code> 
	 * 
	 * @throws IndexOutOfBoundsException
	 * 			If the index is out of range: 
	 * 			i.e. (<code>index < 0 || index >= size()</code>).
	 */
	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		if(index < 0)
			throw new IndexOutOfBoundsException("Index cannot be less than zero");
		else if(index >= size)
			throw new IndexOutOfBoundsException("Index greater than size of ArrayList");
		else if(toChange == null)
			throw new NullPointerException("Input element to set method is null");
		else {
			this.array[index] = toChange;
			return this.array[index];
		}
	}

	/**
	 * Returns <code>true</code> if this ArrayList contains no elements.
	 * 
	 * @return <code>true</code> if this ArrayList contains no elements.
	 */
	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * Returns true if this ArrayList contains the specified element. 
	 * 
	 * @param toFind
	 * 			The element whose presence in this ArrayList is to be tested.
	 * @return <code>true</code> if this ArrayList contains the specified element.
	 * @throws NullPointerException
	 * 			If the specified element is <code>null</code> 
	 */
	@Override
	public boolean contains(E toFind) throws NullPointerException {
		if(toFind == null)
			throw new NullPointerException("Input element to contains method is null");
		else {
			int i=0;
			E actualElement = null;
			while(this.array[i] != null && !this.array[i].equals(toFind)) i++;
			actualElement = this.array[i];			
			return toFind.equals(actualElement);
			
		}
		

	}

	/**
	 * Returns an array containing all of the elements in this ArrayList in proper
	 * sequence
	 * 
	 * @param toHold
	 *			The array into which the elements of this ArrayList are to be
	 * 			stored, if it is big enough; otherwise, a new array of the
	 * 			same runtime type is allocated for this purpose.
	 * @return An array containing the elements of this ArrayList.
	 * @throws NullPointerException
	 * 			If the specified array is <code>null</code>.
	 */
	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		if(toHold == null)
			throw new NullPointerException("Input element to toArray method is null");
		else {
			if(toHold.length < this.size()) {
				toHold = (E[]) Array.newInstance(toHold.getClass().getComponentType(), this.size());
			} 
			System.arraycopy(this.array, 0, toHold, 0, this.size());
			return toHold;

		}

	}

	/**
	 * Returns an array containing all of the elements in this list in proper
	 * sequence. 
	 * 
	 * @return An array containing all of the elements in this ArrayList in proper
	 * 			sequence.
	 */
	@Override
	public E[] toArray() {
		return (E[]) this.array;
	}

	/**
	 * Returns an iterator over the elements in this Arraylist, in proper sequence.
	 * 
	 * @return An iterator over the elements in this Arraylist, in proper sequence.
	 * 			NB: The return is of type 
	 * 			<code>linearUtilities.Iterator<E></code>,
	 * 			not <code>java.util.Iterator</code>.
	 */
	@Override
	public Iterator<E> iterator() {
		return new ArrayListIterator<E>(this, this.size());
	}
	

        
        

}
