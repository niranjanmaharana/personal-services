package com.niranjan.personal.services.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "user_type")
public class UserType extends BaseEntity{
	@Column(name = "type")
	private String type;
	
	public UserType() {
		super();
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}