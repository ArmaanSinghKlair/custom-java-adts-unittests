package utilities;

import java.util.NoSuchElementException;

import adt.*;

public class DLLIterator<E> implements Iterator<E>{
	private int current;
	private int remaining;
	private MyDLL<E> list;
	
	public DLLIterator(MyDLL<E> list, int size) {
		this.list = list;
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
			return (E) this.list.getNode(current++).getData();
		}
	}

}
