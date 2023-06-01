package food_order;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class adminverificationservlet
 */
@WebServlet("/adminverificationservlet")
public class adminverificationservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminverificationservlet() {
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
		
		String name = request.getParameter("name");
		//String lname = request.getParameter("lname");
		//String email = request.getParameter("email");
		String pass = request.getParameter("pass");
		//int phn_no = Integer.parseInt(request.getParameter("phn_no"));
		//String address = request.getParameter("address");
		
		adminregisterDao rd = new adminregisterDao();
		admin obj = new admin();
		
		obj = rd.verifyadmin(name, pass);
		if(obj.getName() !="wrong" && obj.getPass() != "wrong") {
			pw.print("correct username and password");
			RequestDispatcher red = request.getRequestDispatcher("viewproduct.jsp");
			red.forward(request, response);
		}
		else {
			pw.print("Invalid username and password");
			RequestDispatcher red = request.getRequestDispatcher("admin.jsp");
			red.include(request, response);
		}
	}

}
