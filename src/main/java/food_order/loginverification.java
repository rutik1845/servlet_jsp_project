package food_order;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class loginverification
 */
//@WebServlet("/loginverification")
public class loginverification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginverification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String fname = request.getParameter("fname");
		//String lname = request.getParameter("lname");
		//String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		//int phn_no = Integer.parseInt(request.getParameter("phn_no"));
		//String address = request.getParameter("address");
		
		registerDao rd = new registerDao();
		customer obj = new customer();
		
		obj = rd.verifyuser(fname,pass);
		if(obj.getFname() !="wrong" && obj.getPass() != "wrong") {
			pw.print("correct username and password");
			request.getSession().setAttribute("obj", obj);
			RequestDispatcher red = request.getRequestDispatcher("home.jsp");
			red.forward(request, response);
		}
		else {
			pw.print("Invalid username and password");
			RequestDispatcher red = request.getRequestDispatcher("first.jsp");
			red.include(request, response);
		}
		
		Cookie ck = new Cookie("fname",fname);
		response.addCookie(ck);
		
		
		
		HttpSession sk = request.getSession();
		sk.setAttribute("sname",fname);

	}

	
	

}
