package food_order;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class registerDao {
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
	
	public int register(String fname,String lname,String email,String pass,int phn_no,String address)
	{
		register();
		Connection con = getconnection();
		//ResultSet rs=null;
		int n =0;
		try {
			PreparedStatement stm = con.prepareStatement("insert into customer(first_name,last_name,email,pass,phn_no,address) values(?,?,?,?,?,?)");
			//stm.setInt(1, 1);
			stm.setString(1, fname);
			stm.setString(2, lname);
			stm.setString(3, email);
			stm.setString(4, pass);
			stm.setInt(5, phn_no);
			stm.setString(6, address);
			
			n=stm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return n;
		
	}
	public customer verifyuser(String fname, String pass) {
		register();
		Connection con = getconnection();
		ResultSet rs = null;
		Statement stm;
		customer obj = new customer(fname,pass);
		try {
			stm = con.createStatement();
			String query = "select * from customer where first_name='"+fname+"' and pass='"+pass+"'";
			rs = stm.executeQuery(query);
			if(rs.next())
			{
				obj.setId(rs.getInt("id"));
				obj.setFname(rs.getString(1));
				obj.setPass(rs.getString(4));
				
			}
			else {
				obj.setFname("wrong");
				obj.setPass("wrong");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return obj;
		
	}
	
	//Admin Verification
	
	
}

