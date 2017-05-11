package it.polito.ai.lab4.repo.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity(name="users")
public class User {
	@Id
	private long id;
	private String email;
	private String nickname;
	private String password;
	@ManyToOne
	@JoinColumn(name="status_id")
	private Status status;
	@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	private UserProfile profile;
	
		
	public User(String nickname, String email, String password, Status status) {
		this.nickname = nickname;
		this.email = email;
		this.password = password;
		this.status = status;
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
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
	
	public Status getStatus() {
		return status;
	}
	
	public void setStatus(Status status) {
		this.status = status;
	}
}
