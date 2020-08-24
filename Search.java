
package Project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Implementing Search functionality in the project

public class Search1 extends HttpServlet {

     @Override
     protected void doPost(HttpServletRequest request, HttpServletResponse response)  
                    throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();    
        String s1=request.getParameter("search");    
        try
        {
             String ss="jdbc:mysql://localhost:3306/registerdata";
            Class.forName("com.mysql.jdbc.Driver");
            Connection con=DriverManager.getConnection(ss,"root","");
            Statement s=con.createStatement();
            String query="select * from search";
            ResultSet r=s.executeQuery(query);
            while(r.next())
            {
                String x1=r.getString("Technology");
                String x2=r.getString("Sports");
                 String x3=r.getString("Health");
                String x4=r.getString("Environment");
                 String x5=r.getString("Engineering");
                String x6=r.getString("Automobiles");
                if(x1.equals(s1))
                {
            RequestDispatcher rd=request.getRequestDispatcher("Tech.jsp");  
            rd.forward(request, response);      
        }
                else if(x2.equals(s1))
                {
            RequestDispatcher rd=request.getRequestDispatcher("Sport.jsp");  
            rd.forward(request, response);      
        }
                  else if(x3.equals(s1))
                {
            RequestDispatcher rd=request.getRequestDispatcher("Health.jsp");  
            rd.forward(request, response);      
        }
                  else if(x4.equals(s1))
                {
            RequestDispatcher rd=request.getRequestDispatcher("Nature.jsp");  
            rd.forward(request, response);      
        }
                  else if(x5.equals(s1))
                {
            RequestDispatcher rd=request.getRequestDispatcher("Engg.jsp");  
            rd.forward(request, response);      
        }
                  else if(x6.equals(s1))
                {
            RequestDispatcher rd=request.getRequestDispatcher("automob.jsp");  
            rd.forward(request, response);      
        }
            }
 
                    RequestDispatcher rd=request.getRequestDispatcher("Home.jsp");  
                    rd.include(request, response);  
                      out.print("<body><center><b><font color='red'>Please choose from topics given in feed</font></b></center></body>");
                    //response.sendRedirect("Login.html");
        } catch (Exception ex) {
               
         }      
    } 
         }  
