
package com.userModel;

public class User {
	
	private int id;
	private String name;
	private String fathername;
	private String mothername;
	private String dob;
	private String gender;
	private String city;
	public User(String name, String fathername, String mothername, String dob, String gender, String city) {
		super();
		this.name = name;
		this.fathername = fathername;
		this.mothername = mothername;
		this.dob = dob;
		this.gender = gender;
		this.city = city;
	}
	public User(int id, String name, String fathername, String mothername, String dob, String gender, String city) {
		super();
		this.id = id;
		this.name = name;
		this.fathername = fathername;
		this.mothername = mothername;
		this.dob = dob;
		this.gender = gender;
		this.city = city;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFathername() {
		return fathername;
	}
	public void setFathername(String fathername) {
		this.fathername = fathername;
	}
	public String getMothername() {
		return mothername;
	}
	public void setMothername(String mothername) {
		this.mothername = mothername;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	
	
	
}