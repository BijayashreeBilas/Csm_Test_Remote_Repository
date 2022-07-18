package com.csmtech.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;



@Entity
@Table(name="my_user")
public class MyUser implements Serializable {
	@Id
	@Column(name="user_id")
	@SequenceGenerator(name="user_seq" ,sequenceName="my_user_sequence", initialValue=1 ,allocationSize=1)
	@GeneratedValue(generator="user_seq")
	private Integer userId;
	@Column(name="name")
	private String userName;
	@Column(name="email")
	private String email;
	@Column(name="mobile_no")
	private String 	phone;
	@Column(name="is_active")
	private Boolean isActive;
	
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="my_user_my_role" , joinColumns= @JoinColumn(name="user_id") ,inverseJoinColumns=@JoinColumn(name="role_id"))
	private List<MyRole> myRole;


	public Integer getUserId() {
		return userId;
	}


	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public Boolean getIsActive() {
		return isActive;
	}


	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}


	public List<MyRole> getMyRole() {
		return myRole;
	}


	public void setMyRole(List<MyRole> myRole) {
		this.myRole = myRole;
	}
	

	


	

	
	
	
	
	
	
	
	
	
	
	

}
