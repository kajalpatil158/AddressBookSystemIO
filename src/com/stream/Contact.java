package com.stream;

/*Create a class book
There is get and set information of attribute
firstname, lastnane,address,city,state,zip,phonenumber,email all yhat fields
*/
class Contact {
	// Variables declaration
	private String fName;
	private String lName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phoneNumber;
	private String email;

	// To string method for print a data in specific formate
	public String toString() {

		return "Contact [FirstName: " + fName + " LastName: " + lName + " Address: " + address + " City: " + city
				+ " State: " + state + " ZipCode: " + " " + zip + " PhoneNumber: " + phoneNumber + " EmailId: " + email
				+ " ] ";
	}

	// create a constructor
	Contact(String fName, String lName, String address, String city, String state, String zip, String phoneNumber,
			String email) {
		this.fName = fName;
		this.lName = lName;
		this.address = address;
		this.city = city;
		this.state = state;
		this.zip = zip;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public void setfirstName(String fName) {
		this.fName = fName;
	}

	public String getfirstName() {
		return fName;
	}

	public void setlastName(String lName) {
		this.lName = lName;
	}

	public String getlastName() {
		return lName;
	}

	public void setaddress(String address) {
		this.address = address;
	}

	public String getaddress() {
		return address;
	}

	public void setcity(String city) {
		this.city = city;
	}

	public String getcity() {
		return city;
	}

	public void setstate(String state) {
		this.state = state;
	}

	public String getstate() {
		return state;
	}

	public void setzip(String zip) {
		this.zip = zip;
	}

	public String getzip() {
		return zip;
	}

	public void setphoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getphoneNumber() {
		return phoneNumber;
	}

	public void getemail(String email) {
		this.email = email;
	}

	public String getemail() {
		return email;
	}
}
