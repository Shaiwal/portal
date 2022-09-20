package com.shaiwal.login.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
 
@Entity
@Table(name = "users")
public class User {
 
    @Id
    @Column(name = "id")
    @GenericGenerator(name = "sequence_userid", strategy = "com.shaiwal.login.model.UserIdGenerator")
    @GeneratedValue(generator = "sequence_userid") 
    private String id;
 
    @Column(name = "firstname")
    private String firstname;
    
    @Column(name = "lastname")
    private String lastname;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "password")
    private String password;
    
    @Column(name = "roleid")
    private int roleid; 
    
 //   private Role role;
    
    @Column(name = "status")
    private String status; 
    // getters and setters are not shown for brevity
    
//    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//    private Collection < Role > roles;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	
	  public int getRoleid() { return roleid; }
	  
	  public void setRoleid(int roleid) { this.roleid = roleid; }
	 
	
	

	public String getStatus() {
		return status;
	}

	/*
	 * public Role getRole() { return role; }
	 * 
	 * public void setRole(Role role) { this.role = role; }
	 */
	public void setStatus(String status) {
		this.status = status;
	}

//	public Collection<Role> getRoles() {
//		// TODO Auto-generated method stub
//		return roles;
//	}
 
}
