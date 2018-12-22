package com.niranjan.personal.services.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.NaturalId;

import com.niranjan.personal.services.enums.UserRoleEnum;

@Entity
@Table(name = "authority", uniqueConstraints = {
    @UniqueConstraint(
		columnNames = {"name"},
		name = "UNIQUE_ROLENAME"
    )}
)
public class UserAuthority extends BaseEntity {
	@Enumerated(EnumType.STRING)
	@NaturalId
    @Column(length = 60)
	private UserRoleEnum name;

	public UserAuthority() {
	}

	public UserAuthority(UserRoleEnum name) {
		this.name = name;
	}

	public UserRoleEnum getName() {
		return name;
	}

	public void setName(UserRoleEnum name) {
		this.name = name;
	}
}