package com.jacaranda.apiRestfull.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="userdb")
public class User {

	@Id
	private String username;
	private String password;
	private String email;
	private String realusername;
	private String surname;
	private String birthdate;
	private boolean admin;
	private String verification_code;
	private String profile;
	private boolean enable;
	@OneToMany(mappedBy="userObj")
	private List<Study> study;
	
//	constructores
	public User(String username, String password, String email, String realusername, String surname, String birthdate,
			boolean admin, String verification_code, String profile, boolean enable, List<Study> study) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.realusername = realusername;
		this.surname = surname;
		this.birthdate = birthdate;
		this.admin = admin;
		this.verification_code = verification_code;
		this.profile = profile;
		this.enable = enable;
		this.study = study;
	}

	public User() {
		super();
	}

//	getter and setter
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRealusername() {
		return realusername;
	}

	public void setRealusername(String realusername) {
		this.realusername = realusername;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public String getVerification_code() {
		return verification_code;
	}

	public void setVerification_code(String verification_code) {
		this.verification_code = verification_code;
	}

	public String getProfile() {
		return profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public List<Study> getStudy() {
		return study;
	}

	public void setStudy(List<Study> study) {
		this.study = study;
	}

	
//	hashCode and equals
	@Override
	public int hashCode() {
		return Objects.hash(username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(username, other.username);
	}
	
	
	
	
}
