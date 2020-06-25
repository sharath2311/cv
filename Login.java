package logic;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Login extends HttpServlet {
 
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	HttpSession httpSession=request.getSession(true);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        

        try
        {
        	Connection connection=(Connection)getServletContext().getAttribute("connection");
    		System.out.println("connection success"); 
    		Statement st=connection.createStatement();
            ResultSet rs;
        rs = st.executeQuery("select name from reg where email='" + email + "' and password='" + password + "'");
        if (rs.next()) 
        {
        	String name=rs.getString("name");
        	httpSession.setAttribute("username", name);
        	RequestDispatcher rd=request.getRequestDispatcher("afterlog.jsp");            
        	rd.include(request, response);
        } 
        else 
        {
        
        	request.setAttribute("error","Invalid Email or Password");
        	RequestDispatcher rd=request.getRequestDispatcher("index.jsp");            
        	rd.include(request, response);

        	
        	
//         out.println("Username or Password incorrect");
//         RequestDispatcher rss = request.getRequestDispatcher("login.jsp");
//         rss.include(request, response);
        }
    
        }
        catch(Exception e)
        {
        	System.out.println(e);
        }
        
    }  
}
