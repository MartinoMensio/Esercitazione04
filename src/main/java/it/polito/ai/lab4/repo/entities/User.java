package it.polito.ai.lab4.repo.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity(name="users")
public class User {
	@Id
	private Long id;
	@Column
	private String nickname;
	@Column
	private String email;
	@Column
	private String password;
	@Column
	private int status;
	@OneToOne
    @PrimaryKeyJoinColumn
	private UserProfile profile;
	
		
	public User(String nickname, String email, String password, int status) {
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
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}
}
