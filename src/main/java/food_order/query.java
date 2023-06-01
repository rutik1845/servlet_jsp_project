package food_order;

public class query {
	private String name;
	private String email;
	private String querys;
	
	public query(String name, String email, String querys) {
		super();
		this.name = name;
		this.email = email;
		this.querys = querys;
	}

	public query() {
		super();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQuerys() {
		return querys;
	}

	public void setQuerys(String querys) {
		this.querys = querys;
	}

	@Override
	public String toString() {
		return "query [name=" + name + ", email=" + email + ", querys=" + querys + "]";
	}
	
	
	
}
