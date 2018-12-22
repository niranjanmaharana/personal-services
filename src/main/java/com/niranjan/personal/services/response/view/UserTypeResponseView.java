/**
 * 
 */
package com.niranjan.personal.services.response.view;

/**
 * @author Niranjan
 *
 */
public class UserTypeResponseView {
	private Long id;
	private String type;

	/**
	 * 
	 */
	public UserTypeResponseView() {
		super();
	}

	public UserTypeResponseView(Long id, String type) {
		super();
		this.id = id;
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}