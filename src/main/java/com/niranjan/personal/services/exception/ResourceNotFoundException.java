/**
 * 
 */
package com.niranjan.personal.services.exception;

/**
 * @author Niranjan
 *
 */
public class ResourceNotFoundException extends RuntimeException{
	private static final long serialVersionUID = -2912994441810155305L;
	
	/**
	 * 
	 */
	public ResourceNotFoundException() {
		super("User not found exception !");
	}
	
	public ResourceNotFoundException(String message) {
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