package com.csmtech.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="my_role")
public class MyRole implements Serializable {
	@Id
	@Column(name="role_id")
	private Integer roleId;
	@Column(name="role_name")
	private String roleName;
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	@Override
	public String toString() {
		return "MyRole [roleId=" + roleId + ", roleName=" + roleName + "]";
	}
	

}
