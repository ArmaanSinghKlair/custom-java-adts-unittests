package utilities;


import adt.Iterator;
import adt.StackADT;
import exceptions.*;

/**
 * This is an implementation of Stack using MyArraylist and implementing StackADT
 * @author Armaan Singh Klair
 *
 * @param <E> type-to-be-specified-later
 */
public class MyStack<E> implements StackADT<E>{
	/**
	 * Private Data Fields
	 */
	private MyArrayList<E> array;
	
	/**
	 * No-arg constructor for Stack
	 */
	public MyStack() {
		this.array = new MyArrayList<>();
	}
	
	/**
	 * Pushes an item onto the top of this stack.
	 * 
	 * @param toAdd
	 *            item to be pushed onto the top of the stack.
	 * @throws NullPointerException when attempting to add a null element to
	 * the stack.
	 */
	@Override
	public void push(E toAdd) throws NullPointerException {
		array.add(toAdd);
	}

	/**
	 * Removes the object at the top of this stack and returns that object as
	 * the value of this function.
	 * 
	 * @return the item popped off the top of the stack.
	 * @throws EmptyStackException
	 *             if there are not items in the stack.
	 */
	@Override
	public E pop() throws EmptyStackException {
		if(array.size() == 0 )
			throw new EmptyStackException();
		else
			return array.remove(array.size()-1);
	}

	/**
	 * Looks at the object at the top of this stack without removing it from the
	 * stack.
	 * 
	 * @return the object at the top of this stack.
	 * @throws EmptyStackException Thrown when Stack is empty
	 */
	@Override
	public E peek() throws EmptyStackException {
		if(array.size() == 0 )
			throw new EmptyStackException();
		else
			return array.get(array.size()-1);
	}

	/**
	 * Clears all the items from this Stack. This method returns, unless there
	 * is an Exception (Runtime) thrown.
	 */
	@Override
	public void clear() {
		array.clear();
	}

	/**
	 * Returns <code>true</code> if this Stack contains no items.
	 * 
	 * @return <code>true</code> if this Stack contains no items.
	 */
	@Override
	public boolean isEmpty() {
		return array.size() == 0;
	}

	/**
	 * Returns an array containing all of the elements in this list in proper
	 * sequence. Obeys the general contract of the Collection.toArray method.
	 * 
	 * @return an array containing all of the elements in this list in proper
	 *         sequence.
	 */
	@Override
	public E[] toArray() {
		return array.toArray();
	}

	/**
	 * Returns an array containing all of the elements in this list in proper
	 * sequence
	 * 
	 * @param toHold
	 *            the array into which the elements of this stack are to be
	 *            stored, if it is big enough; otherwise, a new array of the
	 *            same runtime type is allocated for this purpose.
	 * @return an array containing the elements of this stack.
	 * @throws NullPointerException
	 *             if the specified array is null.
	 */
	@Override
	public E[] toArray(E[] holder) throws NullPointerException {
		if(holder == null)
			throw new NullPointerException();
		else {
			return array.toArray(holder);
		}
	}

	/**
	 * Returns true if this list contains the specified element.
	 * 
	 * @param toFind
	 *            element whose presence in this list is to be tested.
	 * @return true if this list contains the specified element.
	 * @throws NullPointerException
	 *             if the specified element is null and this list does not
	 *             support null elements.
	 */
	@Override
	public boolean contains(E toFind) throws NullPointerException {
		if(toFind == null)
			throw new NullPointerException();
		else {
			return array.contains(toFind);
		}
	}

	/**
	 * Returns the 1-based position where an object is on this stack. If the
	 * object o occurs as an item in this stack, this method returns the
	 * distance from the top of the stack of the occurrence nearest the top of
	 * the stack; the topmost item on the stack is considered to be at distance
	 * 1. The equals method is used to compare o to the items in this stack.
	 * 
	 * @param toFind
	 *            the desired object.
	 * @return the 1-based position from the top of the stack where the object
	 *         is located; the return value -1 indicates that the object is not
	 *         on the stack.
	 */
	@Override
	public int search(E toFind) {
		int index = 0;
		while(index < array.size() && !array.get(index).equals(toFind)) index++;
		return index != array.size() ? array.size() - index  : -1;
	}

	/**
	 * Returns an iterator over the elements in this stack in proper sequence.
	 * 
	 * @return an iterator over the elements in this stack in proper sequence.
	 */
	@Override
	public Iterator<E> iterator() {
		return new StackIterator(this, this.array.size());
	}

	/**
	 * Used to compare two Stack ADT's. To be equal two stacks must contain
	 * equal items appearing in the same order.
	 * 
	 * @param that the Stack to be compared to this stack.
	 * @return <code>true</code> if the stacks are equal.
	 */
	@Override
	public boolean equals(StackADT<E> that) {
		if(this.array.size() == that.size()) {
			Iterator<E> iter1 = this.iterator();
			Iterator<E> iter2 = that.iterator();
			
			while(iter1.hasNext() && iter2.hasNext()) {
				if(!iter1.next().equals(iter2.next()))
					return false;
			}
			return true;
		} else
			return false;
	
	}

	/**
	 * Returns the depth of the current stack as an integer value.
	 * @return the current size to the stack as an integer.
	 */
	@Override
	public int size() {
		return this.array.size();
	}

}
