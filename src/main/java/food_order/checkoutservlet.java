package food_order;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class checkoutservlet
 */
@WebServlet("/checkoutservlet")
public class checkoutservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkoutservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try(PrintWriter pw = response.getWriter()) {
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
			
			if(cart_list!=null) {
				for(cart i:cart_list) {
					order ob = new order();
					ob.setUid(obj.getId());
					ob.setPid(i.getId());
					ob.setQuantity(i.getQuantity());
					ob.setDate(formatter.format(date));
					
					orderDao od = new orderDao();
					int x = od.insertorder(ob);
					if(x!=0) {
						break;
					}
				}
				cart_list.clear();
				response.sendRedirect("order.jsp");
			}else {
				response.sendRedirect("cart.jsp");
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
