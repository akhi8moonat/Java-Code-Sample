/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Akhilesh
 */
//Registering the user by taking the values from the form and inserting into the database using JDBC.

public class RegisterServlet extends HttpServlet {
    
    @Override
    public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException
    {
        PrintWriter out=res.getWriter();
        String firstname = req.getParameter("fname");
        String lastname = req.getParameter("lname");
        int age = Integer.parseInt(req.getParameter("age"));
        String gender = req.getParameter("gen");
        String username= req.getParameter("uname");
        String password= req.getParameter("pwd");
        String email= req.getParameter("eml");
        String question= req.getParameter("que");
        String answer= req.getParameter("ans");
        try {
            String ss="jdbc:mysql://localhost:3306/registerdata";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(ss,"root","");
            Statement s=con.createStatement();
                  String query="insert into register values('"+firstname+"','"+lastname+"',"+age+",'"+gender+"','"+username+"','"+password+"','"+email+"','"+question+"','"+answer+"')";             
                    int count=s.executeUpdate(query);
                    RequestDispatcher rd=req.getRequestDispatcher("Home.jsp");  
                    rd.include(req, res); 
                     out.print("<body><center><b><font color='blue'>Registered Successfully</font></b></center></body>");                 
        } catch (Exception ex ) {
            ex.getMessage();
        }
    }
}
