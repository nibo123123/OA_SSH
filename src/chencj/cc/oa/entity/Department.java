package chencj.cc.oa.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Department.java
//  @ Date : 2018/11/5
//  @ Author : 
//
//




public class Department implements Serializable{
    private Long de_id;
    private String de_name;
    private String de_description;
    private Department de_parent;
    private Set<Department> de_children = new HashSet<>();
    private Set<User> users = new HashSet<>();
	public Long getDe_id() {
		return de_id;
	}
	public void setDe_id(Long de_id) {
		this.de_id = de_id;
	}
	public String getDe_name() {
		return de_name;
	}
	public void setDe_name(String de_name) {
		this.de_name = de_name;
	}
	public String getDe_description() {
		return de_description;
	}
	public void setDe_description(String de_description) {
		this.de_description = de_description;
	}
	public Department getDe_parent() {
		return de_parent;
	}
	public void setDe_parent(Department de_parent) {
		this.de_parent = de_parent;
	}
	public Set<Department> getDe_children() {
		return de_children;
	}
	public void setDe_children(Set<Department> de_children) {
		this.de_children = de_children;
	}
	public Set<User> getUsers() {
		return users;
	}
	public void setUsers(Set<User> users) {
		this.users = users;
	}
	
	@Override
	public String toString() {
		return "Department [de_id=" + de_id + ", de_name=" + de_name
				+ ", de_description=" + de_description + "]";
	}
    
    
    
}
