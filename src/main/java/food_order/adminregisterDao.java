package food_order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;







public class adminregisterDao {
	private String drivername="com.mysql.jdbc.Driver";
	private String databasename="online_food_order";
	private String databaseuser="root";
	private String databasepass="";
	
	void register() {
		try {
			Class.forName(drivername);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	Connection getconnection() {
		Connection con=null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+databasename,databaseuser,databasepass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public admin verifyadmin(String name, String pass) {
		register();
		Connection con = getconnection();
		ResultSet rs = null;
		Statement stm;
		admin obj = new admin(name,pass);
		try {
			stm = con.createStatement();
			String query = "select * from admin where username='"+name+"' and pass='"+pass+"'";
			rs = stm.executeQuery(query);
			if(rs.next())
			{
				
				obj.setName(rs.getString(1));
				obj.setPass(rs.getString(2));
				
			}
			else {
				obj.setName("wrong");
				obj.setPass("wrong");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return obj;
		
	}
	
	public ArrayList<product> viewproduct()
	{
		register();
		Connection con = getconnection();
		product obj[] = new product[1];
		ArrayList<product> arl = new ArrayList<product>();
		
		Statement stm;
		try {
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from food_items ");
			
			
			while(rs.next()) {
				obj[0] = new product();
				obj[0].setId(rs.getInt(1));
				obj[0].setTitle(rs.getString(2));
				obj[0].setPrice(rs.getInt(3));
				obj[0].setDescription(rs.getString(4));
				obj[0].setImage(rs.getString(5));
				arl.add(obj[0]);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return arl;

	}
	
	
	public ArrayList<product> view(int a)
	{
		register();
		Connection con = getconnection();
		product obj[] = new product[1];
		ArrayList<product> arl = new ArrayList<product>();
		
		Statement stm;
		try {
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from food_items where id="+a);
			
			
			while(rs.next()) {
				obj[0] = new product();
				obj[0].setId(rs.getInt(1));
				obj[0].setTitle(rs.getString(2));
				obj[0].setPrice(rs.getInt(3));
				obj[0].setDescription(rs.getString(4));
				obj[0].setImage(rs.getString(5));
				arl.add(obj[0]);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return arl;

	}
	
	
	
	public int addproduct(int id, String title, int price, String description, String image) {
		register();
		Connection con = getconnection();
		product obj = new product();
		int n=0;
		
		try {
			//Statement stm = con.createStatement();
			PreparedStatement stm = con.prepareStatement("insert into food_items values(?,?,?,?,?)");
			stm.setInt(1, id);
			stm.setString(2, title);
			stm.setInt(3, price);
			stm.setString(4, description);
			stm.setString(5, image);
			
			n=stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
	}
	
	public int updateproduct(int id,String title,int price, String description, String image) {
		register();
		Connection con = getconnection();
		product obj = new product();
		int n = 0;
		try {
			Statement stm = con.createStatement();
			String q = "update food_items set title='"+title+"',price='"+price+"',description='"+description+"',image='"+image+"' where id='"+id+"'";
		
		n = stm.executeUpdate(q);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
		
	}
	
	public void deleteproduct(String id) {
		register();
		Connection con = getconnection();
		//product obj = new product(id);
		try {
			Statement stm = con.createStatement();
			int id1 = Integer.parseInt(id);
			stm.executeUpdate("delete from food_items where id="+id1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public int addquery(String name,String email,String querys) {
		register();
		Connection con = getconnection();
		query obj = new query();
		int n=0;
		
		try {
			//Statement stm = con.createStatement();
			PreparedStatement stm = con.prepareStatement("insert into query values(?,?,?)");
			stm.setString(1, name);
			stm.setString(2, email);
			stm.setString(3, querys);
			
			
			n=stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
	}
}
