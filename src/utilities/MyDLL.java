package utilities;
import java.lang.reflect.Array;
import adt.*;

/**
 * Implementation of a Doubly Linked List implementing the ListADT
 * @author Armaan Singh Klair
 *
 * @param <E> type-to-be-specified-later
 */
public class MyDLL<E> implements ListADT<E> {
	/**
	 * Private Data Fields
	 */
	private MyDLLNode first,last;
	private int size;
	
	/**
	 * No-arg constructor
	 */
	public MyDLL() {
		this.first = null;
		this.last = null;
		this.size = 0;
	}
	
	/**
	 * The size method will return the current element count contained 
	 * in the DLL.
	 * 
	 * @return The current element count.
	 */
	@Override
	public int size() {
		return this.size;
	}

	/**
	 * Removes all of the elements from this DLL. This DLL will be empty after
	 * this call returns.
	 */
	@Override
	public void clear() {
		this.first = this.last = null;
		this.size = 0;
	}

	/**
	 * Inserts the specified element at the specified position in this DLL.
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
			throw new NullPointerException();
		else if(index < 0)
			throw new IndexOutOfBoundsException("Index cannot be negative");
		else if(index > size)
			throw new IndexOutOfBoundsException("Index greater than size of DLL");
		else {
			MyDLLNode succ= null;
			MyDLLNode node = null;
			if(index == 0) {
				node = new MyDLLNode(toAdd, this.first, null);
				this.first = node;
				this.size++;
				succ = this.first.getSucc();
			} else {
				MyDLLNode pred = null;
				if(index == this.size)
					pred = this.getNode(index-1);
				else
					pred = this.getNode(index);
				
				node = new MyDLLNode(toAdd, pred.getSucc(), pred);
				pred.setSucc(node);
				this.last = node;
				this.size++;
				succ = node.getSucc();
			}
			
			if(succ != null) {
				succ.setPred(node);
			} else {
				this.last = node;
			}
			return true;
		}
	}

	/**
	 * Appends the specified element to the end of this DLL.
	 * 
	 * @param toAdd
	 * 			Element to be appended to this DLL.
	 * @return true if element is appended successfully.
	 * @throws NullPointerException
	 * 			If the specified element is <code>null</code> 
	 * @throws IndexOutOfBoundsException
	 * 			If the index is out of range: 
	 * 			i.e. (<code>index < 0 || index >= size()</code>).
	 */
	@Override
	public boolean add(E toAdd) throws NullPointerException, IndexOutOfBoundsException {
		if(toAdd == null)
			throw new NullPointerException();
		else {
			if(this.size == 0) {
				MyDLLNode node = new MyDLLNode(toAdd, null, null);
				this.first = this.last = node;
				this.size++;
				return true;
			}
			MyDLLNode node = new MyDLLNode(toAdd, null, this.last);
			this.last.setSucc(node);
			this.last = node;
			this.size++;
			return true;
		}
	}

	/**
	 * Appends all of the elements in the specified 
	 * DLL to the end of
	 * this DLL, in the order that they are returned by the input DLL's
	 *  <code>Iterator</code>. 
	 * @param toAdd
	 * 			The new sub DLL to be added.
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
			Iterator<E> iter = (Iterator<E>) toAdd.iterator();
			while(iter.hasNext()) {
				this.add(iter.next());
			}

			return true;
		}
	}
	
	/**
	 * Returns the element at the specified position in this DLL.
	 * 
	 * @param index
	 * 			Index of element to return.
	 * @return The element at the specified position in this DLL.
	 * @throws IndexOutOfBoundsException
	 * 			If the index is out of range: 
	 * 			i.e. (<code>index < 0 || index >= size()</code>).
	 */
	@Override
	public E get(int index) throws IndexOutOfBoundsException {
		if(index < 0)
			throw new IndexOutOfBoundsException("Index cannot be negative");
		else if(index >= size)
			throw new IndexOutOfBoundsException("Index greater than size of DLL");
		else {
			int i =0;
			E data = null;
			for(MyDLLNode<E> n = this.first; n != null; n = n.getSucc()) {
				if(i++ == index) {
					data = (E) n.getData();
				}		
			}
			return data;
		}
	}
	
	/**
	 * This is NOT AN overriden method and returns the node at specified index
	 * @param index Index at which element is to be returned
	 * @return The DLL Node at index
	 * @throws IndexOutOfBoundsException Thrown when index < 0 or index >= size of DLL
	 */
	public MyDLLNode<E> getNode(int index) throws IndexOutOfBoundsException {
		if(index < 0)
			throw new IndexOutOfBoundsException("Index cannot be negative");
		else if(index >= size)
			throw new IndexOutOfBoundsException("Index greater than size of DLL");
		else {
			int i =0;
			MyDLLNode<E> data = null;
			for(MyDLLNode<E> n = this.first; n != null; n = n.getSucc()) {
				if(i++ == index) {
					data = n;
				}		
			}
			return data;
		}
	}
	
	/**
	 * Removes the element at the specified position in this DLL. 
	 * Returns the element that was removed from the DLL.
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
			throw new IndexOutOfBoundsException("Index cannot be negative");
		else if(index > size)
			throw new IndexOutOfBoundsException("Index greater than size of DLL");
		else {
			MyDLLNode<E> node = this.getNode(index);
			if(node == this.first) {
				this.first = this.first.getSucc();
			} else {
				MyDLLNode<E> pred = node.getPred();
				MyDLLNode<E> succ = node.getSucc();
				pred.setSucc(succ);
				succ.setPred(pred);
			}
			this.size--;
			return (E) node.getData();
		}
	}

	/**
	 * Removes the first occurrence in this DLL of the specified element. If
	 * this DLL does not contain the element, it is unchanged. 
	 * 
	 * @param toRemove
	 * 			The element to be removed from this DLL.
	 * @return The element which is being removed, or null if the DLL does
	 * 			not contain the element.
	 * @throws NullPointerException
	 * 			If the specified element is <code>null</code>
	 */
	@Override
	public E remove(E toRemove) throws NullPointerException {
		if(toRemove == null)
			throw new NullPointerException();
		else {
			MyDLLNode<E> node=null;
			for(MyDLLNode<E> n = this.first; n != null; n = n.getSucc()) {
				if(n.getData().equals(toRemove)){
					node = n;
					System.out.println("GOT HERE :"+node.getData()+" and tofind is "+toRemove);
					break;
				}
			}
			
			if(node != null) {
				if(node == this.first) {
					this.first = this.first.getSucc();
				} else {
					MyDLLNode<E> pred = node.getPred();
					MyDLLNode<E> succ = node.getSucc();
					System.out.println("PRED IS "+pred.getData());
					pred.setSucc(succ);
					
					if(succ != null)		// handling tail case where succ is null
						succ.setPred(pred);
				}
				this.size--;
				return (E) node.getData();

			} else {
				return null;
			}
			
			
		}
	}

	/**
	 * Replaces the element at the specified position in this DLL with the
	 * specified element.
	 * 
	 * @param index
	 * 			The index of the element to replace.
	 * @param toChange
	 * 			Element to be stored at the specified position.
	 * @return The element previously at the specified position.
	 * @throws NullPointerException
	 * 			If the specified element is <code>null</code> 
	 * @throws IndexOutOfBoundsException
	 * 			If the index is out of range: 
	 * 			i.e. (<code>index < 0 || index >= size()</code>).
	 */
	@Override
	public E set(int index, E toChange) throws NullPointerException, IndexOutOfBoundsException {
		if(index < 0)
			throw new IndexOutOfBoundsException("Index cannot be negative");
		else if(index >= size)
			throw new IndexOutOfBoundsException("Index greater than size of DLL");
		else if(toChange == null)
			throw new NullPointerException("Input to set method of DLL is null");

		else {
			MyDLLNode<E> node = this.getNode(index);
			E prevData = node.getData();
			node.setData(toChange);
			return prevData;
		}
	}
	
	/**
	 * Returns <code>true</code> if this list contains no elements.
	 * 
	 * @return <code>true</code> if this list contains no elements.
	 */
	@Override
	public boolean isEmpty() {
		return this.size == 0;
	}

	/**
	 * Returns true if this DLL contains the specified element. 
	 * 
	 * @param toFind
	 * 			The element whose presence in this DLL is to be tested.
	 * @return <code>true</code> if this DLL contains the specified element.
	 * @throws NullPointerException
	 * 			If the specified element is <code>null</code>
	 */
	@Override
	public boolean contains(E toFind) throws NullPointerException {
		if(toFind == null)
			throw new NullPointerException();
		for(MyDLLNode<E> n = this.first; n != null; n = n.getSucc()) {
			if(n.getData().equals(toFind)){
				return true;
			}
		}
		return false;
		
}

	/**
	 * Returns an array containing all of the elements in this DLL in proper
	 * sequence
	 * 
	 * @param toHold
	 *			The array into which the elements of this DLL are to be
	 * 			stored, if it is big enough; otherwise, a new array of the
	 * 			same runtime type is allocated for this purpose.
	 * @return An array containing the elements of this DLL.
	 * @throws NullPointerException
	 * 			If the specified array is <code>null</code>.
	 */
	@Override
	public E[] toArray(E[] toHold) throws NullPointerException {
		if(toHold == null)
			throw new NullPointerException();
		else {
			if(toHold.length < this.size) {
				toHold = (E[]) Array.newInstance(toHold.getClass().getComponentType(), this.size());
			}
			int i=0;
			for(MyDLLNode<E> n = this.first; n != null; n = n.getSucc(), i++) {
				toHold[i] = (E) n.getData();
			}
					return toHold;
			
		}
	}

	/**
	 * Returns an array containing all of the elements in this DLL in proper
	 * sequence.
	 * 
	 * @return An array containing all of the elements in this DLL in proper
	 * 			sequence.
	 */
	@Override
	public E[] toArray() {
		E[] arr =  (E[]) new Object[this.size];
		int i=0;
		for(MyDLLNode<E> n = this.first; n != null; n = n.getSucc(), i++) {
			arr[i] = (E) n.getData();
		}
		
		return arr;
	}

	/**
	 * Returns an iterator over the elements in this DLL, in proper sequence.
	 * 
	 * @return An iterator over the elements in this DLL, in proper sequence.
	 * 			NB: The return is of type 
	 * 			<code>linearUtilities.Iterator<E></code>,
	 * 			not <code>java.util.Iterator</code>.
	 */
	@Override
	public Iterator<E> iterator() {
		return new DLLIterator<E>(this, this.size());
	}

}
