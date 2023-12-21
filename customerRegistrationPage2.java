/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author student
 */
public class customerRegistrationPage2 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       try {
             Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/orderPetrol","root","Naren@232");
      
          
            
            
            PreparedStatement ps = con.prepareStatement("insert into customerTable (Name,Password,PhoneNo,Email) values(?,?,?,?)");
            String Name = request.getParameter("name");
            
            ps.setString(1,Name);
            String Password = request.getParameter("password");
            ps.setString(2,Password);
            String PhoneNo = request.getParameter("phoneNumber");
            ps.setString(3,PhoneNo);
            String Email = request.getParameter("email");
            ps.setString(4,Email);
            
            
            
            
      
            
            int v = ps.executeUpdate();
            
            PreparedStatement psa = con.prepareStatement("insert into customerfixedTable (Name,Password,PhoneNo,Email) values(?,?,?,?)");
            String name = request.getParameter("name");
            
            psa.setString(1,name);
            String password = request.getParameter("password");
            psa.setString(2,password);
            String phoneNo = request.getParameter("phoneNumber");
            psa.setString(3,phoneNo);
            String email = request.getParameter("email");
            psa.setString(4,email);
            
            
            
            psa.executeUpdate();
            HttpSession session = request.getSession();
            session.setAttribute("email", email);
            if(v>0){
                
                
                            
                
               response.sendRedirect("customeHomePage.html");
            }
            else
            {
                out.println("no");
            }
           
        }
        catch(ClassNotFoundException | SQLException e)
        {
            System.out.println(e);
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
