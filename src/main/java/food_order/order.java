package food_order;

public class order extends product {
	private int order_id;
	private int uid;
	private int pid;
	private int quantity;
	private String date;
	
	public order() {
		
	}

	public order(int id, String title, int price, String description, String image, int order_id, int uid, int pid,
			int quantity, String date) {
		super(id, title, price, description, image);
		this.order_id = order_id;
		this.uid = uid;
		this.pid = pid;
		this.quantity = quantity;
		this.date = date;
	}

	public order(int id, String title, int price, String description, String image, int uid, int pid, int quantity,
			 String date) {
		super(id, title, price, description, image);
		this.uid = uid;
		this.pid = pid;
		this.quantity = quantity;
		
		this.date = date;
	}

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "order [order_id=" + order_id + ", uid=" + uid + ", pid=" + pid + ", quantity=" + quantity
				+ ",  date=" + date + "]";
	}
	
	
	
	
	
}
