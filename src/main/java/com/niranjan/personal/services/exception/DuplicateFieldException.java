/**
 * 
 */
package com.niranjan.personal.services.exception;

/**
 * @author Niranjan
 *
 */
public class DuplicateFieldException extends RuntimeException{
	private static final long serialVersionUID = -2912994441810155305L;
	
	/**
	 * 
	 */
	public DuplicateFieldException() {
		super("Duplicate field exception !");
	}
	
	public DuplicateFieldException(String message) {
		super(message);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Throwable#getMessage()
	 */
	@Override
	public String getMessage() {
		return super.getMessage();
	}
}