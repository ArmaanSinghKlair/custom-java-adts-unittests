package utilities;

import java.util.NoSuchElementException;

import adt.Iterator;

public class QueueIterator<E> implements Iterator<E> {
	private int current;
	private int remaining;
	private E[] list;
	
	public QueueIterator(MyQueue<E> list, int size) {
		this.list = list.toArray();
		this.remaining = size;
		this.current = 0;
	}
	
	@Override
	public boolean hasNext() {
		return this.remaining != 0;
	}

	@Override
	public E next() throws NoSuchElementException {
		if(this.remaining == 0)
			throw new NoSuchElementException();
		else {
			remaining--;
			return (E) this.list[current++];
		}
	}

}
