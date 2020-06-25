package logic;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Connection;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;

@SuppressWarnings("serial")
public class Register extends HttpServlet {
	
	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.err.println("Called");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try
		{

		String name = request.getParameter("name");
		String dob = request.getParameter("dob");
		
		
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		String mobile = request.getParameter("mobile");

		
		
		
		System.out.println("name--"+name);
		
		
		Connection connection=(Connection)getServletContext().getAttribute("connection");
		
		
		
		System.out.println("connection success"); 
		 
		  Statement st=connection.createStatement();
          int i=st.executeUpdate("insert into reg values('"+name+"','"+dob+"','"+email+"','"+pass+"','"+mobile+"')");
			
          request.setAttribute("success","Registered Successfully");
          RequestDispatcher rd=request.getRequestDispatcher("index.jsp");            
          rd.include(request, response);

       }
		

catch(Exception s)
{
s.printStackTrace();	

}
	}
}
