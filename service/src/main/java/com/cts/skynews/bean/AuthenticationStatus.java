package com.cts.skynews.bean;

public class AuthenticationStatus {

	private boolean authenticated;
	
	private User actualUser;
	
	private String token;

	public boolean isAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}

	public User getActualUser() {
		return actualUser;
	}

	public void setActualUser(User actualUser) {
		this.actualUser = actualUser;
	}
	
	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "AuthenticationStatus [authenticated=" + authenticated + ", actualUser=" + actualUser + "]";
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AuthenticationStatus other = (AuthenticationStatus) obj;
		if (actualUser == null) {
			if (other.actualUser != null)
				return false;
		} else if (!actualUser.equals(other.actualUser))
			return false;
		if (authenticated != other.authenticated)
			return false;
		return true;
	}

	
	
}
