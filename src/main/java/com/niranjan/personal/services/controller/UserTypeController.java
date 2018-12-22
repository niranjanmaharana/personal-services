/**
 * 
 */
package com.niranjan.personal.services.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niranjan.personal.services.model.UserType;
import com.niranjan.personal.services.repository.UserTypeRepository;
import com.niranjan.personal.services.request.view.UserTypeRequestView;
import com.niranjan.personal.services.response.view.SimpleResponseEntity;
import com.niranjan.personal.services.response.view.UserTypeResponseView;
import com.niranjan.personal.services.service.impl.UserTypeService;

/**
 * @author Niranjan
 *
 */

@Controller
@RequestMapping("/usertype")
@PreAuthorize("hasRole('ADMIN')")
public class UserTypeController {
	@Autowired
	private UserTypeService userTypeService;
	@Autowired
	private UserTypeRepository userTypeRepository;

	private static final Logger logger = LoggerFactory.getLogger(UserTypeController.class);

	@GetMapping
	public ResponseEntity<SimpleResponseEntity> getAllUserType() {
		logger.info("User trying to fetch all user types ...");
		List<UserType> userTypes = userTypeService.getAllUserType();
		List<UserTypeResponseView> userTypeResponseViews = new ArrayList<>();
		if (userTypes.size() > 0) {
			userTypes.forEach(userType -> {
				userTypeResponseViews.add(new UserTypeResponseView(userType.getId(), userType.getType()));
			});
		}
		return new ResponseEntity<SimpleResponseEntity>(new SimpleResponseEntity(HttpStatus.OK.value(),
				"Successfully fetched all user types.", userTypeResponseViews), HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<SimpleResponseEntity> getUserTypeById(@PathVariable("id") Long id) {
		UserType userType = userTypeService.getUserTypeById(id);
		UserTypeResponseView responseView = null;
		if (userType != null) {
			responseView = new UserTypeResponseView(userType.getId(), userType.getType());
			return new ResponseEntity<SimpleResponseEntity>(new SimpleResponseEntity(HttpStatus.OK.value(),
					"Successfully fetched user type by id : " + id + ".", responseView), HttpStatus.OK);
		} else {
			return new ResponseEntity<SimpleResponseEntity>(
					new SimpleResponseEntity(HttpStatus.NOT_FOUND.value(), "Record not found !", responseView),
					HttpStatus.OK);
		}
	}

	@PostMapping
	public ResponseEntity<SimpleResponseEntity> addUserType(@Valid @RequestBody UserTypeRequestView requestView) {
		if (userTypeRepository.existsByType(requestView.getType())) {
			logger.error("Duplicate type found !");
			return new ResponseEntity<SimpleResponseEntity>(
					new SimpleResponseEntity(HttpStatus.BAD_REQUEST.value(),
							"User type already available with name " + requestView.getType() + " !", ""),
					HttpStatus.BAD_REQUEST);
		}
		UserType userType = new UserType();
		userType.setType(requestView.getType());
		userTypeRepository.save(userType);
		return new ResponseEntity<SimpleResponseEntity>(
				new SimpleResponseEntity(HttpStatus.OK.value(), "User type added successfylly.", ""), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<SimpleResponseEntity> updateUserType(@Valid @RequestBody UserTypeRequestView requestView) {
		UserType userType = userTypeRepository.findById(requestView.getId()).orElse(null);
		if (userType == null) {
			logger.error("Duplicate type found !");
			return new ResponseEntity<SimpleResponseEntity>(new SimpleResponseEntity(HttpStatus.NOT_FOUND.value(),
					"User type not found with " + requestView.getId() + " !", ""), HttpStatus.NOT_FOUND);
		}
		userType.setType(requestView.getType());
		userTypeRepository.save(userType);
		return new ResponseEntity<SimpleResponseEntity>(
				new SimpleResponseEntity(HttpStatus.OK.value(), "User type updated.", ""), HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<SimpleResponseEntity> deleteUserType(@PathVariable("id") Long id) {
		UserType userType = userTypeRepository.findById(id).orElse(null);
		if (userType == null) {
			logger.error("User type not found !");
			return new ResponseEntity<SimpleResponseEntity>(
					new SimpleResponseEntity(HttpStatus.NOT_FOUND.value(), "User type not found with " + id + " !", ""),
					HttpStatus.NOT_FOUND);
		}
		userTypeRepository.delete(userType);
		return new ResponseEntity<SimpleResponseEntity>(
				new SimpleResponseEntity(HttpStatus.OK.value(), "User type removed.", ""), HttpStatus.OK);
	}
}