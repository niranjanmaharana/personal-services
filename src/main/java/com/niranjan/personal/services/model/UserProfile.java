package com.niranjan.personal.services.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user_profile", uniqueConstraints = {
        @UniqueConstraint(
        		columnNames = {"username"},
        		name = "UNIQUE_USERNAME"
        ),
        @UniqueConstraint(
        		columnNames = {"email"},
        		name = "UNIQUE_EMAIL"
        ),
        @UniqueConstraint(
        		columnNames = {"mobile"},
        		name = "UNIQUE_MOBILE"
        )
})
public class UserProfile extends BaseEntity{
    @NotBlank
    @Size(min=3, max = 50)
    private String fullName;

    @NotBlank
    @Size(min=3, max = 50)
    private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    private String email;
    
    @NotBlank
    @Size(max = 10)
    @Pattern(regexp="(^$|[0-9]{10})")
    @Column(name = "mobile", length = 10)
    private String mobile;

    @NotBlank
    @Size(min=6, max = 100)
    private String password;
    
    @Size(max = 200)
    private String profilePic;
    
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority", 
    	joinColumns = @JoinColumn(name = "user_id"), 
    	inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<UserAuthority> authorities = new HashSet<>();

    public UserProfile() {}

    public UserProfile(String fullName, String username, String email, String mobile, String profilePic, String password) {
        this.fullName = fullName;
        this.username = username;
        this.email = email;
        this.mobile = mobile;
        this.profilePic = profilePic;
        this.password = password;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public Set<UserAuthority> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(Set<UserAuthority> authorities) {
		this.authorities = authorities;
	}
}