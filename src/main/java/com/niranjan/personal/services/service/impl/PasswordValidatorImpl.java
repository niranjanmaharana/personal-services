/**
 * 
 */
package com.niranjan.personal.services.service.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.niranjan.personal.services.service.PasswordValidator;

/**
 * @author Niranjan
 *
 */

@Service
public class PasswordValidatorImpl implements PasswordValidator{
	@Value("${password.pattern}")
	private String passwordPattern;

	private Pattern pattern;
	private Matcher matcher;

	public PasswordValidatorImpl() {
		//default constructor
	}

	/**
	 * Validate password with regular expression
	 * 
	 * @param password
	 *            password for validation
	 * @return true valid password, false invalid password
	 */
	@Override
	public boolean isValid(final String password) {
		pattern = Pattern.compile(passwordPattern);
		matcher = pattern.matcher(password);
		return matcher.matches();
	}
}