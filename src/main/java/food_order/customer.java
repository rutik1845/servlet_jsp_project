package food_order;

public class customer {
	private int id;
	private String fname;
	private String lname;
	private String email;
	private String pass;
	private int phn_no;
	private String address;
	
	public customer(int id, String fname, String lname, String pass, String email, int phn_no, String address) {
		super();
		this.id=id;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.pass = pass;
		this.phn_no = phn_no;
		this.address = address;
	}
	
	

	public customer(String fname, String pass) {
		super();
		this.fname = fname;
		this.pass = pass;
	}



	public customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getPhn_no() {
		return phn_no;
	}

	public void setPhn_no(int phn_no) {
		this.phn_no = phn_no;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
}
