package com.niranjan.personal.services.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Version;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.context.SecurityContextHolder;

@MappedSuperclass
public class BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "create_date_time")
	@CreationTimestamp
	private Date createDateTime;

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "update_date_time")
	@UpdateTimestamp
	private Date updateDateTime;

	@Column(name = "updated_by")
	private String updatedBy;

	@Version
	private Integer version = 1;
	
	@Column(columnDefinition="bit default true")
    private boolean active = true;

	@Column(name = "valid_from")
	@CreationTimestamp
	private Date validFrom;

	@Column(name = "valid_to")
	private Date validTo;

	public BaseEntity() {
		super();
	}

	@PrePersist
	public void prePersist() {
		if(validFrom == null) {
			validFrom = new Date();
		}
		if (validTo == null) {
			Calendar calendar = Calendar.getInstance();
			calendar.set(8888, 11, 31, 0, 0, 0);
			validTo = calendar.getTime();
		}
		if(createdBy == null || createdBy.isEmpty()) {
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			createdBy = username;
		}
	}

	@PreUpdate
	public void preUpdate() {
		if(validFrom == null) {
			validFrom = new Date();
		}
		if (validTo == null) {
			Calendar calendar = Calendar.getInstance();
			calendar.set(8888, 11, 31, 0, 0, 0);
			validTo = calendar.getTime();
		}
		if(updatedBy == null || updatedBy.isEmpty()) {
			String username = SecurityContextHolder.getContext().getAuthentication().getName();
			updatedBy = username;
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
	
	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
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
}