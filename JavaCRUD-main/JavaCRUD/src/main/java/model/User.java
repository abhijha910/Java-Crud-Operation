package model;

public class User {
	
	private int id;
	private String fname;
	private String lname;
	private String email;
	private String uname;
	private String passwd;
	private String phone;   // New field for phone number
	private String address; // New field for address

	// Getters and setters for id, fname, lname, email, uname, passwd

	public int getId() {
		return id;
	}
	
	public String getFname() {
		return fname;
	}
	
	public String getLname() {
		return lname;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getUname() {
		return uname;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setFname(String fname) {
		this.fname = fname;
	}
	
	public void setLname(String lname) {
		this.lname = lname;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setUname(String uname) {
		this.uname = uname;
	}

	// New getters and setters for phone and address

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	// Overriding toString to include new fields

	@Override
	public String toString() {
		return "User [id=" + id + ", fname=" + fname + ", lname=" + lname + ", email=" + email + ", uname=" + uname
				+ ", passwd=" + passwd + ", phone=" + phone + ", address=" + address + "]";
	}
}
