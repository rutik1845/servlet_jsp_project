package food_order;

public class admin {
	private String name;
	private String pass;
	
	public admin(String name, String pass) {
		super();
		this.name = name;
		this.pass = pass;
	}

	public admin() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "admin [name=" + name + ", pass=" + pass + "]";
	}
	
	
	
	
}
