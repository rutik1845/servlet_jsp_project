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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class addtocartservlet
 */
@WebServlet("/addtocartservlet")
public class addtocartservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addtocartservlet() {
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
		
		PrintWriter pw = response.getWriter();
		
		ArrayList<cart> cart = new ArrayList<>();
		
		int id = Integer.parseInt(request.getParameter("id"));
		cart cm = new cart();
		cm.setId(id);
		cm.setQuantity(1);
		
		HttpSession session = request.getSession();
		ArrayList<cart> cart_list = (ArrayList<cart>) session.getAttribute("cart_list");
		
		if(cart_list==null) {
			cart.add(cm);
			session.setAttribute("cart_list", cart);
			response.sendRedirect("menu.jsp");
		}
		else {
			cart=cart_list;
			boolean exist = false;
			
			for(cart c: cart_list) {
			if(c.getId() == id) {
				exist=true;
				pw.print("<h3 style='color:crimson; text-align:center'>Item already exist in cart.<a href='cart.jsp'>Go To Cart Page</a></h3>");
			}
		  }
			if(!exist) {
				cart.add(cm);
				response.sendRedirect("menu.jsp");
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
