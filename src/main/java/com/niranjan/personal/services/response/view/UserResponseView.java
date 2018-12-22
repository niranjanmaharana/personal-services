/**
 * 
 */
package com.niranjan.personal.services.response.view;

import java.util.Date;
import java.util.Set;

import com.niranjan.personal.services.model.UserAuthority;

/**
 * @author Niranjan
 *
 */
public class UserResponseView {
	private Long id;
	private Date createdDate;
	private String createdBy;
	private Date lastModifiedDate;
	private String lastModifiedBy;
	private String username;
	private String email;
	private String mobile;
	private String profilePic;
	private Set<UserAuthority> roles;
	private Date validFrom;
	private Date validTo;
	private boolean active;

	/**
	 * 
	 */
	public UserResponseView() {
		// Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(Date lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Date getValidFrom() {
		return validFrom;
	}

	public void setValidFrom(Date validFrom) {
		this.validFrom = validFrom;
	}

	public Date getValidTo() {
		return validTo;
	}

	public void setValidTo(Date validTo) {
		this.validTo = validTo;
	}

	public Set<UserAuthority> getRoles() {
		return roles;
	}

	public void setRoles(Set<UserAuthority> roles) {
		this.roles = roles;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public boolean isActive() {
		return active;
	}
}