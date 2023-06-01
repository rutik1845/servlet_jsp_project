package food_order;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ordernowservlet
 */
@WebServlet("/ordernowservlet")
public class ordernowservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ordernowservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try(PrintWriter pw = response.getWriter()){
			
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			
			Date date = new Date();
			
			ArrayList<cart> cart_list = (ArrayList<cart>) request.getSession().getAttribute("cart_list");
			List<cart> cartproduct = null;
			if(cart_list != null){
				productDao pd = new productDao();
				cartproduct = pd.getcart(cart_list);
				int subtotal = pd.subtotalprice(cart_list);
				int total = pd.totalprice(cart_list);
				request.setAttribute("cart_list", cart_list);
				request.setAttribute("subtotal", subtotal);
				request.setAttribute("total", total);
			}
			customer obj = (customer) request.getSession().getAttribute("obj");
			if(obj!=null) {
				String product_id = request.getParameter("id");
				String product_quantity = request.getParameter("quantity");
				String product_price = request.getParameter("price");
				
				
				order ord = new order();
				ord.setId(Integer.parseInt(product_id));
				ord.setUid(obj.getId());
				for(cart i : cartproduct) {
					int quantity = i.getQuantity(); 
					ord.setQuantity(quantity);
					int price = i.getPrice();
					ord.setPrice(price);
				}
								
				ord.setDate(formatter.format(date));
				
				orderDao od = new orderDao();
				int x = od.insertorder(ord);
				
				if(x!=0) {
					ArrayList<cart> cart_list1 = (ArrayList<cart>) request.getSession().getAttribute("cart_list");
					if(cart_list1!=null) {
						for(cart i: cart_list1) {
							if(i.getId() == Integer.parseInt(product_id)){
								cart_list1.remove(cart_list1.indexOf(i));
								break;
							}
						}
					}
						
					response.sendRedirect("cart.jsp");
				}else {
					pw.print("order failed");
				}
			}else {
				response.sendRedirect("login.jsp");
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		}
		
	


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
