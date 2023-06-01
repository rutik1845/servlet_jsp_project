package food_order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class orderDao {
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
	
	public int insertorder(order model) {
		int n=0;
		register();
		Connection con = getconnection();
		ResultSet rs;
		try {
			PreparedStatement stm = con.prepareStatement("insert into orders(uid,pid,quantity,o_date)values(?,?,?,?)");
			stm.setInt(1,model.getUid());
			stm.setInt(2,model.getId());
			stm.setInt(3,model.getQuantity());
			
			stm.setString(4,model.getDate());
			n=stm.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return n;
					
	}
	
	public List<order> userOrders(int id) {
        List<order> list = new ArrayList<>();
		register();
		Connection con = getconnection();
		ResultSet rs;
		try {
			PreparedStatement stm = con.prepareStatement("select * from orders where uid=?");
            stm.setInt(1, id);
            rs = stm.executeQuery();
            while (rs.next()) {
                order order = new order();
                productDao pd = new productDao();
                int pId = rs.getInt("pid");
                product product = pd.getSingleProduct(pId);
                
                order.setId(pId);
                order.setTitle(product.getTitle());
                order.setPrice(product.getPrice()*rs.getInt("quantity"));
                order.setDescription(product.getDescription());
                order.setQuantity(rs.getInt("quantity"));
                order.setDate(rs.getString("o_date"));
                list.add(order);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        return list;
    }
	
    public void cancelOrder(int id) {
        //boolean result = false;
		register();
		Connection con = getconnection();
		ResultSet rs;
        try {
        	PreparedStatement stm = con.prepareStatement("delete from orders where order_id=?");
            stm.setInt(1, id);
            rs = stm.executeQuery();
            //result = true;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.print(e.getMessage());
        }
        //return result;
    }
	
}
