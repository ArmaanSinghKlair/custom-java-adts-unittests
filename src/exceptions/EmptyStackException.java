package exceptions;

public class EmptyStackException extends Exception{
	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = -929389949886257706L;

	public EmptyStackException(String message) {
		super(message);
	}
	public EmptyStackException() {
		super("Stack is Empty");
	}
}
