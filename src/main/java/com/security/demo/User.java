package com.security.demo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User
{
	@Id
	private int id;
	private String email;
	private boolean activate;
	private Date c_date;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean isActivate() {
		return activate;
	}
	public void setActivate(boolean activate) {
		this.activate = activate;
	}
	public Date getDate() {
		return c_date;
	}
	public void setDate(Date date) {
		this.c_date = date;
	}
	public User(int id, String email, boolean activate, Date date) {
		super();
		this.id = id;
		this.email = email;
		this.activate = activate;
		this.c_date = date;
	}
	public User() {
		super();
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", activate=" + activate + ", date=" + c_date + "]";
	}
	
	
}