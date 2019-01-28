package com.cts.skynews.bean;

public class SignUpStatus {

	private boolean signedUp;
	private boolean emailExists;

	public SignUpStatus() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SignUpStatus(boolean signedUp, boolean emailExists) {
		super();
		this.signedUp = signedUp;
		this.emailExists = emailExists;
	}

	public boolean isSignedUp() {
		return signedUp;
	}

	public void setSignedUp(boolean signedUp) {
		this.signedUp = signedUp;
	}

	public boolean isEmailExists() {
		return emailExists;
	}

	public void setEmailExists(boolean emailExists) {
		this.emailExists = emailExists;
	}

	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SignUpStatus other = (SignUpStatus) obj;
		if (emailExists != other.emailExists)
			return false;
		if (signedUp != other.signedUp)
			return false;
		return true;
	}

}
