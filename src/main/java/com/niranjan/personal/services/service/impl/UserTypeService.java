/**
 * 
 */
package com.niranjan.personal.services.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.niranjan.personal.services.model.UserType;
import com.niranjan.personal.services.repository.UserTypeRepository;

/**
 * @author Niranjan
 *
 */

@Service
public class UserTypeService {
	@Autowired
	private UserTypeRepository userTypeRepository;
	
	public List<UserType> getAllUserType() {
		return userTypeRepository.findAll();
	}

	public UserType getUserTypeById(Long id) {
		return userTypeRepository.findById(id).orElse(null);
	}
}