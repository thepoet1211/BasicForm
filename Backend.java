package servlet;
import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Backend
 */
public class Backend extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Backend() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stubString name = request.getParameter("name");
        String Year = request.getParameter("Year");
        String name = request.getParameter("name");
        String rollnumber=request.getParameter("rollnumber");
        String email=request.getParameter("email");
        String payment=request.getParameter("payment");
        String branch=request.getParameter("branch");
        PrintWriter writer = response.getWriter();
        String html = "<html>\r\n"
        		+ "<head>\r\n"
        		+ "<meta charset=\"ISO-8859-1\">\r\n <body style=\"background-color:yellow;\">"
        		+"<style>\r\n"
        		+ "table, th, td {\r\n"
        		+ "  border: 1px solid black;\r\n"
        		+ "  border-collapse: collapse;\r\n"
        		+ "}\r\n"
        		+ "</style>"
        		+ "<title>Submitted Succesfully</title>\r\n"
        		+ "</head>\r\n"
        		+ "<body>\r\n"
        		+"<center><h1>Your Form has been Submitted, Our team will get back to you soon</h1></center>"
        		+ "<center><b>You will be notified within 24 hours of the close of registration.</b><br></center>\r\n"
        		+ "<br><center><table>\r\n"
        		+ "    <tr>\r\n"
        		+ "        <th>Name: "+name+"</th>\r\n"
        		+"<tr>\r\n"
        		+ "         <th>Year: "+Year+"</th>\r\n"
        		+ "    </tr>\r\n"
        		+ "       \r\n"
        		+ "       \r\n"
        		+ "    </tr>\r\n"
        		+ "    <tr>\r\n"
        		+ "         <th>Roll Number: "+rollnumber+"</th>\r\n"
        		+ "    </tr>\r\n"
        		+ "    <tr>\r\n"
        		+ "         <th>Email: "+email+"</th>\r\n"
        		+ "    </tr>\r\n"
        		+ "    <tr>\r\n"
        		+ "         <th>Branch: "+branch+"</th>\r\n"
        		+ "    </tr>\r\n"
        		+"<tr>\r\n"
        		+ "         <th>Did you pay the fees: "+payment+"</th>\r\n"
        		+ "    </tr>\r\n"
        		+ "</table> </center>\r\n"
        		+ "</body>\r\n"
        		+ "</html>";
         
        // return response
        writer.println(html);
		response.getWriter().append("Served at: ").append(request.getContextPath());
		try{
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	Connection con =DriverManager.getConnection("Jdbc:mysql:///form","root","P@rth$00d");
        	Statement stmt = con.createStatement();
        	String query = "insert into form.form(Name,Email,Branch,Year,FeeStatus,Rollnumber) values('"+name+"','"+email+"','"+branch+"','"+Year+"','"+payment+"',"+rollnumber+")";
        	int i = stmt.executeUpdate(query);
        	if(i>0)
        	{
        	System.out.println("Record inserted");
        	}
        	else{
        	System.out.println("Error");
        	}
        	 }
        	 catch(Exception e)
        	 {
        	System.out.println("Exception has occurred "+e);
        	 }}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");
        String Year = request.getParameter("Year");
        String rollnumber=request.getParameter("rollnumber");
        String email=request.getParameter("email");
        String payment=request.getParameter("payment");
        String branch=request.getParameter("branch");
        PrintWriter writer = response.getWriter();
        String html = "<html>\r\n"
        		+ "<head>\r\n"
        		+ "<meta charset=\"ISO-8859-1\">\r\n <body style=\"background-color:yellow;\">"
        		+"<style>\r\n"
        		+ "table, th, td {\r\n"
        		+ "  border: 1px solid black;\r\n"
        		+ "  border-collapse: collapse;\r\n"
        		+ "}\r\n"
        		+ "</style>"
        		+ "<title>Submitted Succesfully</title>\r\n"
        		+ "</head>\r\n"
        		+ "<body>\r\n"
        		+"<center><h1>Your Form has been Submitted, Our team will get back to you soon</h1></center>"
        		+ "<center><b>Your bid is active now.If your bid is succesful,you will be notified within 24 hours of the close of bidding.</b><br></center>\r\n"
        		+ "<br><center><table>\r\n"
        		+ "    <tr>\r\n"
        		+ "        <th>Name: "+name+"</th>\r\n"
        		+"<tr>\r\n"
        		+ "         <th>Year: "+Year+"</th>\r\n"
        		+ "    </tr>\r\n"
        		+ "       \r\n"
        		+ "       \r\n"
        		+ "    </tr>\r\n"
        		+ "    <tr>\r\n"
        		+ "         <th>Roll Number: "+rollnumber+"</th>\r\n"
        		+ "    </tr>\r\n"
        		+ "    <tr>\r\n"
        		+ "         <th>Email: "+email+"</th>\r\n"
        		+ "    </tr>\r\n"
        		+ "    <tr>\r\n"
        		+ "         <th>Branch: "+branch+"</th>\r\n"
        		+ "    </tr>\r\n"
        		+"<tr>\r\n"
        		+ "         <th>Did you pay the fees: "+payment+"</th>\r\n"
        		+ "    </tr>\r\n"
        		+ "</table> </center>\r\n"
        		+ "</body>\r\n"
        		+ "</html>";
         
        // return response
        writer.println(html);

        doGet(request, response);
	}

}
