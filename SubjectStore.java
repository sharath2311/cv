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
public class SubjectStore extends HttpServlet {
	
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

		String school = request.getParameter("school");
		String tenth = request.getParameter("10th");
		String plustwo=request.getParameter("12th");
		String board=request.getParameter("board");
		String syllabus=request.getParameter("syllabus");
		String[] subject=request.getParameterValues("sub");
		
		String temp="";
		for(String S:subject)
		{
			System.out.println(S);
			temp+=S+"@";
		}
		String[] marks=request.getParameterValues("marks");
		
		String mms="";
		for(String S1: marks)
		{
			if(S1.length()!=0){
		System.out.println(S1);
		mms+=S1+"@";
			}
		}
		String others=request.getParameter("others");
		
		
		System.out.println("name--"+school);
		
		
		Connection connection=(Connection)getServletContext().getAttribute("connection");
		
		String temp1=temp.substring(0,temp.length()-1);
		String mms1=mms.substring(0,mms.length()-1);
		
		System.out.println("connection success"); 
		 
		  Statement st=connection.createStatement();
          int i=st.executeUpdate("insert into sinfo values('"+school+"','"+tenth+"','"+plustwo+"','"+board+"','"+syllabus+"','"+temp1+"','"+mms1+"','"+others+"')");
			
          request.setAttribute("success","Registerd Successfully");
          RequestDispatcher rd=request.getRequestDispatcher("afterlog.jsp");            
          rd.include(request, response);

       }
		

catch(Exception s)
{
s.printStackTrace();	

}
	}
}
