package food_order;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import food_order.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class quantityservlet
 */
@WebServlet("/quantity")
public class quantityservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public quantityservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		
		try(PrintWriter pw = response.getWriter();){
			String action = request.getParameter("action");
			int id = Integer.parseInt(request.getParameter("id"));
			
			ArrayList<cart> cart_list = (ArrayList<cart>) request.getSession().getAttribute("cart_list");
			
			if(action != null && id>=1) {
				if(action.equals("inc")) {
					for(cart c : cart_list) {
						if(c.getId()==id) {
							int quantity = c.getQuantity();
							quantity++;
							c.setQuantity(quantity);
							response.sendRedirect("cart.jsp");
						}
					}
				}
				if(action.equals("dec")) {
					for(cart c : cart_list) {
						if(c.getId()==id) {
							int quantity = c.getQuantity();
							quantity--;
							c.setQuantity(quantity);
							response.sendRedirect("cart.jsp");
						}
					}
				}
			}
			
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
