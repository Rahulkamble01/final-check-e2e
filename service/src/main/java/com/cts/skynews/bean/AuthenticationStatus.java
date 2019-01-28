package com.cts.skynews.bean;

public class AuthenticationStatus {

	private boolean authenticated;
	private boolean isAdmin;
	private boolean accountStatus;

	public boolean isAuthenticated() {
		return authenticated;
	}

	public void setAuthenticated(boolean authenticated) {
		this.authenticated = authenticated;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public boolean isAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(boolean accountStatus) {
		this.accountStatus = accountStatus;
	}

	@Override
	public String toString() {
		return "AuthenticationStatus [authenticated=" + authenticated + ", isAdmin=" + isAdmin + ", accountStatus="
				+ accountStatus + "]";
	}

}
