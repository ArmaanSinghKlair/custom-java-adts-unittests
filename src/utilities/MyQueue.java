package utilities;

import adt.Iterator;
import adt.QueueADT;
import exceptions.EmptyQueueException;

/**
 * This is an implementation of the Queue data structure using MyDLL and implementing the QueueADT interface
 * @author Armaan Singh Klair
 * @version 11/19/20
 * @param <E> type-to-be-specified-later
 */
public class MyQueue<E> implements QueueADT<E> {
	/**
	 * Private Data Fields
	 */
	private MyDLL list;
	private int size;
	
	/**
	 * No-arg Constructor
	 */
	public MyQueue() {
		this.list = new MyDLL();
		this.size = 0;
	}

	/**
	 * Enqueue will place the added item at the last position in the
	 * queue.  This method will not allow <code>null</code> values
	 * to be added to the Queue.
	 * 
	 * @param toAdd the item to be added to the Queue.
	 * @throws NullPointerException raised when a <code>null</code> object
	 * is placed in the Queue.
	 */
	@Override
	public void enqueue(E toAdd) throws NullPointerException {
		if(toAdd == null)
			throw new NullPointerException();
		else {
			this.list.add(toAdd);
			this.size++;
		}	
	}

	/**
	 * Dequeue will remove the first item that was placed in the Queue.
	 * @return the first item in the Queue.
	 * @throws EmptyQueueException raised when the queue's length is zero (0).
	 */
	@Override
	public E dequeue() throws EmptyQueueException {
		if(this.isEmpty())
			throw new EmptyQueueException("Queue is empty");
		else {
			this.size--;
			return (E) this.list.remove(0);
		}
	}

	/**
	 * Peek provides a reference to the first item in the queue without
	 * removing from the queue.
	 * 
	 * @return the first item in the queue.
	 * @throws EmptyQueueException raised when the queue's length is zero (0).
	 */
	@Override
	public E peek() throws EmptyQueueException {
		if(this.isEmpty())
			throw new EmptyQueueException("Queue is empty");
		else {
			return (E) this.list.get(0);
		}	}

	/**
	 * dequeueAll removes all items in the queue.
	 */
	@Override
	public void dequeueAll() {
		this.list.clear();
		this.size = 0;
	}

	/**
	 * Returns <code>true</code> when the queue contains no items.
	 * @return <code>true</code> when queue length is zero (0).
	 */
	@Override
	public boolean isEmpty() {
		return this.list.isEmpty();
	}

	/**
	 * Returns an iterator over the elements in this queue in proper sequence.
	 * 
	 * @return an iterator over the elements in this queue in proper sequence.
	 */
	@Override
	public Iterator<E> iterator() {
		return new QueueIterator(this, this.size);
	}

	/**
	 * Used to compare two Queue ADT's. To be equal two queues must contain
	 * equal items appearing in the same order.
	 * 
	 * @param that the Queue ADT to be compared to this queue.
	 * @return <code>true</code> if the queues are equal.
	 */
	@Override
	public boolean equals(QueueADT<E> that) {
		if(this.size != that.size())
			return false;
		else {
			Iterator<E> iter1 = this.iterator();
			Iterator<E> iter2 = that.iterator();
			
			while(iter1.hasNext() && iter2.hasNext()) {
				if(!iter1.next().equals(iter2.next()))
					return false;
			}
			return true;
		}
	}

	/**
	 * Returns an array containing all of the elements in this list in proper
	 * sequence. 
	 * 
	 * @return an array containing all of the elements in this list in proper
	 *         sequence.
	 */
	@Override
	public E[] toArray() {
		return (E[]) this.list.toArray();
	}

	/**
	 * Returns an array containing all of the elements in this list in proper
	 * sequence
	 * 
	 * @param toHold
	 *            the array into which the elements of this queue are to be
	 *            stored, if it is big enough; otherwise, a new array of the
	 *            same runtime type is allocated for this purpose.
	 * @return an array containing the elements of this queue.
	 * @throws NullPointerException
	 *          if the specified array is null.
	 */
	@Override
	public E[] toArray(E[] holder) throws NullPointerException {
		return (E[]) this.list.toArray(holder);
	}

	/**
	 * (Optional Method) Returns true if the number of items in the queue
	 * equals the length.  This operation is only implement when a fixed length
	 * queue is required.
	 * @return <code>true</code> if queue is at capacity.
	 */
	@Override
	public boolean isFull() {		// NOT IMPLEMENTED, since it is OPTIONAL
		return false;
	}

	/**
	 * Returns the length of the current queue as an integer value.
	 * @return the current size to the queue as an integer.
	 */
	@Override
	public int size() {
		return this.size;
	}

}
