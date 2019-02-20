import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.sql.*;

public class Register extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String name=request.getParameter("userName");
		String mail=request.getParameter("userMail");
		String mobile=request.getParameter("userMobile");
		String gender=request.getParameter("userGender");
		String addr=request.getParameter("userAddr");
		String country=request.getParameter("userCountry");
		
		try{
			 final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
		     final String DB_URL="jdbc:mysql://localhost:3306/pooja";
		  
		Class.forName(JDBC_DRIVER);
		Connection con=DriverManager.getConnection(DB_URL,"mysql","pooja");
		System.out.println("connection established");
		Statement stmt=con.createStatement();
		
		
		
		String operation=request.getParameter("action");
		if(operation.equals("register"))
		{
			int i=stmt.executeUpdate("insert into stud263 values('"+name+"','"+mail+"','"+mobile+"','"+gender+"','"+addr+"','"+country+"');");

			if(i>0)
			out.print("You are successfully registered...");
		}
		
		}catch (Exception e2) {System.out.println(e2);}
		
		out.close();
	}

}
