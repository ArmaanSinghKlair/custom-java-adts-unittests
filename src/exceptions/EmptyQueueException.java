package exceptions;

public class EmptyQueueException extends Exception{
	/**
	 * Serial Version ID
	 */
	private static final long serialVersionUID = 4841203106897644399L;

	public EmptyQueueException(String message) {
		super(message);
	}
}
