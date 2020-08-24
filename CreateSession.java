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
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Akhilesh
 */
public class Session3 extends HttpServlet {

     @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response)  
                    throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();    
        String s1=request.getParameter("uname");  
        String s2=request.getParameter("pwd");  
        try
        {
             String ss="jdbc:mysql://localhost:3306/registerdata";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(ss,"root","");
            Statement s=con.createStatement();
            String query="select * from register where username='"+s1+"' and password='"+s2+"'";
            ResultSet r=s.executeQuery(query);
            while(r.next())
            {
                String u=r.getString("Username");
                String p=r.getString("Password");
                if(p.equals(s2))
                {
                    if(u.equals(s1))
                    {
                        String f=r.getString("First_Name");
                        String l=r.getString("Last_Name");
                        String a=r.getString("Age");
                        String g=r.getString("Gender");
                        String e=r.getString("Email");
                HttpSession se=request.getSession();
                 se.setAttribute("First",f);
                  se.setAttribute("Last",l);
                   se.setAttribute("age1",a);
                    se.setAttribute("gen",g);
                se.setAttribute("uname",s1);
                se.setAttribute("mail",e);
                 response.sendRedirect("welc.jsp");  
                 out.println(r);
        }
                }
                   
            }
            out.print("<body><center><b><font color='red'>Incorrect Username or Password</font></b></center></body>"); // if username and password does not match. 
                    request.getRequestDispatcher("SignIn.jsp").include(request, response);    
        } catch (Exception ex) {
               
         }      
    } 
         }  
