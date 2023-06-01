package food_order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import food_order.product;

public class productDao {
	private String drname="com.mysql.jdbc.Driver";
	private String dbname="online_food_order";
	private String dbuser="root";
	private String dbpass="";
	
	void register()
	{
		try {
			Class.forName(drname);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	Connection getconnection() {
		Connection con=null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+dbname,dbuser,dbpass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public ArrayList<product> viewproduct(){
		register();
		Connection con = getconnection();
		product obj[] = new product[1];
		ArrayList<product> arl = new ArrayList<product>();
		
		Statement stm;
		try {
			stm = con.createStatement();
			ResultSet rs = stm.executeQuery("select * from food_items");
			
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
	
	public List<cart> getcart(ArrayList<cart> cartlist)
	{
		register();
		Connection con = getconnection();
		
		
		List<cart> arl = new ArrayList<>();
		
		ResultSet rs;;
		try {
			if(cartlist.size()>0) {
				for(cart i:cartlist) {
					PreparedStatement stm = con.prepareStatement("select * from food_items where id=?");
					stm.setInt(1,i.getId());
					rs = stm.executeQuery();
					while(rs.next()) {
						cart ob = new cart();
						
						ob.setId(rs.getInt(1));
						ob.setTitle(rs.getString(2));
						ob.setPrice(rs.getInt(3)*i.getQuantity());
						ob.setDescription(rs.getString(4));
						ob.setImage(rs.getString(5));
						ob.setQuantity(i.getQuantity());
						arl.add(ob);
					}
				}
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return arl;

	}
	
	public int subtotalprice(ArrayList<cart> cartlist) {
		int sum = 0;
		
		register();
		Connection con = getconnection();
		ResultSet rs;
		try {
			if(cartlist.size()>0) {
				for(cart i:cartlist) {
					PreparedStatement stm = con.prepareStatement("select price from food_items where id=?");
					stm.setInt(1,i.getId());
					rs = stm.executeQuery();
					while(rs.next()) {
						sum+=rs.getInt("price")*i.getQuantity();
					}
				}
			}
		
		
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return sum;	
	}
	
	public int totalprice(ArrayList<cart> cartlist) {
		int sum = 0;
		
		register();
		Connection con = getconnection();
		ResultSet rs;
		try {
			if(cartlist.size()>0) {
				for(cart i:cartlist) {
					PreparedStatement stm = con.prepareStatement("select price from food_items where id=?");
					stm.setInt(1,i.getId());
					rs = stm.executeQuery();
					while(rs.next()) {
						sum+=rs.getInt("price")*i.getQuantity()+25;
					}
				}
			}
		
		
	}catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return sum;	
	}
	
	
	public product getSingleProduct(int id) {
		product row = null;
		
		register();
		Connection con = getconnection();
		
		
		List<cart> arl = new ArrayList<>();
		
		ResultSet rs;;
		try {
			PreparedStatement stm = con.prepareStatement("select * from food_items where id=?");
			stm.setInt(1,id);
			rs = stm.executeQuery();
			while(rs.next()) {
				row = new product();
				row.setId(rs.getInt(1));
				row.setTitle(rs.getString(2));
				row.setPrice(rs.getInt(3));
				row.setDescription(rs.getString(4));
				row.setImage(rs.getString(5));
				
				
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return row;
		
	}
	
		
		
}

