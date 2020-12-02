package utilities;
import java.io.Serializable;

public class MyDLLNode<E> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private E data;
	private MyDLLNode<E> pred, succ;
	
	public MyDLLNode(E data, MyDLLNode<E> succ, MyDLLNode<E> pred) {
		this.data = data;
		this.pred = pred;
		this.succ = succ;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public MyDLLNode<E> getPred() {
		return pred;
	}

	public void setPred(MyDLLNode<E> pred) {
		this.pred = pred;
	}

	public MyDLLNode<E> getSucc() {
		return succ;
	}

	public void setSucc(MyDLLNode<E> succ) {
		this.succ = succ;
	}
	
	

}
