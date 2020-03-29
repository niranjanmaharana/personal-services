/**
 * 
 */
package com.niranjan.personal.services.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niranjan.personal.services.enums.UserRoleEnum;
import com.niranjan.personal.services.exception.DuplicateFieldException;
import com.niranjan.personal.services.exception.InvalidFormatException;
import com.niranjan.personal.services.exception.ResourceNotFoundException;
import com.niranjan.personal.services.model.UserAuthority;
import com.niranjan.personal.services.model.UserProfile;
import com.niranjan.personal.services.repository.RoleRepository;
import com.niranjan.personal.services.repository.UserRepository;
import com.niranjan.personal.services.request.view.UserRequestView;
import com.niranjan.personal.services.response.view.UserResponseView;
import com.niranjan.personal.services.service.PasswordValidator;
import com.niranjan.personal.services.service.UserService;

/**
 * @author Niranjan
 *
 */

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder encoder;
	
	@Autowired
	private PasswordValidator passwordValidator;
	
	@Value("${password.invalid.message}")
	private String invalidPasswordMessage;

	private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Override
	@Transactional
	public List<UserResponseView> findAll(){
		List<UserProfile> users = userRepository.findAll();
		List<UserResponseView> userViews = new ArrayList<>();
		users.forEach(user -> userViews.add(getResponseView(user)));
		return userViews;
	}
	
	@Override
	@Transactional
	public UserProfile save(UserRequestView request) {
		if (userRepository.existsByUsername(request.getUsername())) {
			logger.error("Duplicate username found !");
			throw new DuplicateFieldException("Username already exists !");
		}
		if (userRepository.existsByEmail(request.getEmail())) {
			logger.error("Duplicate email found !");
			throw new DuplicateFieldException("Email already exists !");
		}
		
		if (userRepository.existsByMobile(request.getMobile())) {
			logger.error("Duplicate mobile number found !");
			throw new DuplicateFieldException("Mobile number already registered !");
		}
		
		if (!passwordValidator.isValid(request.getPassword())) {
			logger.error("Invalid password format !");
			throw new InvalidFormatException(invalidPasswordMessage);
		}

		UserProfile user = new UserProfile(request.getName(), request.getUsername(), request.getEmail(),
				request.getMobile(), request.getProfilePic(), encoder.encode(request.getPassword()));

		Set<String> strRoles = new HashSet<>();
		if(request.getRole() == null) strRoles.add(UserRoleEnum.ROLE_USER.getName());
		else strRoles = request.getRole();
		Set<UserAuthority> roles = new HashSet<>();

		strRoles.forEach(role -> {
			switch (role) {
			case "1":
				UserAuthority adminRole = roleRepository.findByName(UserRoleEnum.ROLE_SUPERADMIN)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(adminRole);

				break;
			case "2":
				UserAuthority pmRole = roleRepository.findByName(UserRoleEnum.ROLE_ADMIN)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(pmRole);

				break;
			default:
				UserAuthority userRole = roleRepository.findByName(UserRoleEnum.ROLE_USER)
						.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
				roles.add(userRole);
			}
		});

		user.setAuthorities(roles);
		return userRepository.save(user);
	}
	
	@Override
	@Transactional
	public UserProfile update(UserRequestView request) {
		UserProfile user = userRepository.findById(request.getId()).orElse(null);
		
		if (user == null) throw new ResourceNotFoundException("User not found with id : " + request.getId());
		
		if (userRepository.existsByEmailExceptUser(request.getId(), request.getEmail())) {
			logger.error("Duplicate email found !");
			throw new DuplicateFieldException("Email already registered !");
		}
		
		if (userRepository.existsByMobileExceptUser(request.getId(), request.getMobile())) {
			logger.error("Duplicate mobile number found !");
			throw new DuplicateFieldException("Mobile number already registered !");
		}
		user.setFullName(request.getName());
		user.setEmail(request.getEmail());
		user.setMobile(request.getMobile());
		Set<String> strRoles = request.getRole();
		Set<UserAuthority> roles = new HashSet<>();
		
		strRoles.forEach(role -> {
			switch (role) {
			case "1":
				UserAuthority adminRole = roleRepository.findByName(UserRoleEnum.ROLE_SUPERADMIN)
						.orElseThrow(() -> new ResourceNotFoundException("Fail! -> Cause: User Role not find."));
				roles.add(adminRole);
				break;
			case "2":
				UserAuthority pmRole = roleRepository.findByName(UserRoleEnum.ROLE_ADMIN)
						.orElseThrow(() -> new ResourceNotFoundException("Fail! -> Cause: User Role not find."));
				roles.add(pmRole);
				break;
			default:
				UserAuthority userRole = roleRepository.findByName(UserRoleEnum.ROLE_USER)
						.orElseThrow(() -> new ResourceNotFoundException("Fail! -> Cause: User Role not find."));
				roles.add(userRole);
			}
		});
		user.setAuthorities(roles);
		return userRepository.save(user);
	}
	
	@Override
	public UserResponseView getResponseView(UserProfile user) {
		UserResponseView userResponse = new UserResponseView();
		userResponse.setId(user.getId());
		userResponse.setCreatedDate(user.getCreateDateTime());
		userResponse.setCreatedBy(user.getCreatedBy());
		userResponse.setLastModifiedDate(user.getUpdateDateTime());
		userResponse.setLastModifiedBy(user.getUpdatedBy());
		userResponse.setEmail(user.getEmail());
		userResponse.setMobile(user.getMobile());
		userResponse.setRoles(user.getAuthorities());
		userResponse.setUsername(user.getUsername());
		userResponse.setActive(user.isActive());
		userResponse.setProfilePic(user.getProfilePic());
		return userResponse;
	}
}