package utilities;

import java.util.NoSuchElementException;

import adt.*;

public class StackIterator<E> implements Iterator<E> {
	private int remaining;
	private int current;
	private E[] list;
	
	public StackIterator(MyStack<E> list, int size) {
		this.list = (E[]) list.toArray();
		this.remaining = size;
		this.current = size-1;
	}
    @Override
	public boolean hasNext() {
		if(remaining == 0)
			return false;
		else
			return true;
	}

	@Override
	public E next() throws NoSuchElementException {
		if(current < 0 )
			throw new NoSuchElementException("End of Stack Reached");
		this.remaining--;
		return list[current--];
	}
}
