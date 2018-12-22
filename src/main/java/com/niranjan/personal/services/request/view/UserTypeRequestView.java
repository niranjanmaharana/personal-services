/**
 * 
 */
package com.niranjan.personal.services.request.view;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author Niranjan
 *
 */
public class UserTypeRequestView {
	private Long id;
	
	@NotBlank
    @Size(min = 3, max = 50)
    private String type;

	/**
	 * defalut constructor
	 */
	public UserTypeRequestView() {
		//default constructor
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}