/**
 * 
 */
package com.niranjan.personal.services.service;

/**
 * @author Niranjan
 *
 */
public interface PasswordValidator {

	/**
	 * @param password
	 * @return
	 */
	boolean isValid(String password);
}