/**
 * 
 */
package com.niranjan.personal.services.service;

import java.util.List;

import com.niranjan.personal.services.model.UserProfile;
import com.niranjan.personal.services.request.view.UserRequestView;
import com.niranjan.personal.services.response.view.UserResponseView;

/**
 * @author Niranjan
 *
 */
public interface UserService {
	/**
	 * @param user
	 * @return
	 */
	public UserResponseView getResponseView(UserProfile user);

	/**
	 * @param signUpRequest
	 * @return
	 */
	UserProfile save(UserRequestView request);

	/**
	 * @return
	 */
	List<UserResponseView> findAll();

	/**
	 * @param signUpRequest
	 * @return
	 */
	UserProfile update(UserRequestView request);
}