package utilities;

import java.util.NoSuchElementException;

import adt.Iterator;
import adt.ListADT;

public class ArrayListIterator<E> implements Iterator<E>{
	private int total;
	private int current = 0;
	private ListADT<E> list;
	public ArrayListIterator(MyArrayList<E> list, int size) {
		this.list = list;
		this.total = size;
	}
    @Override
	public boolean hasNext() {
		if(current >= total)
			return false;
		else
			return true;
	}

	@Override
	public E next() throws NoSuchElementException {
		if(current >= total )
			throw new NoSuchElementException("End of List Reached");
		return list.get(current++);
	}
    
}
