/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Tables.Bus;
import Tables.Driver;
import Tables.MainTable;
import Tables.Route;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;


/**
 *
 * @author Akhilesh
 */
 //This program gets all the rows from all the tables using criteria in hibernate and displays it on the webpage.
 
public class ViewServlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

     Configuration cf = new Configuration();
    cf.configure("CFG/hibernate.cfg.xml");
    SessionFactory sf= cf.buildSessionFactory();
    Session s=sf.openSession();
    Transaction tx = s.beginTransaction();
    
    Criteria c1 = s.createCriteria(MainTable.class);
    List<MainTable>l=null;
    l=c1.list();  
    request.setAttribute("list1",l);
     
    Criteria c2 = s.createCriteria(Bus.class);
    List<Bus>l2=null;
    l2=c2.list();
    request.setAttribute("list2",l2);
    
    Criteria c3 = s.createCriteria(Route.class);
    List<Route>l3=null;
    l3=c3.list();
    request.setAttribute("list3",l3);
    
    Criteria c4 = s.createCriteria(Driver.class);
    List<Driver>l4=null;
    l4=c4.list();
    request.setAttribute("list4",l4);
    
    RequestDispatcher rd = request.getRequestDispatcher("View1.jsp");
    rd.forward(request,response);
    
     tx.commit();
     s.close();
     sf.close();     
    
                                                
         }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

          
}
