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
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author student
 */
public class locationSave extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/orderPetrol","root","Naren@232");
               
            // Access session variable in a servlet
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
            //out.println(email);
               
//        
            PreparedStatement ps = con.prepareStatement("update customerTable set latitude=?,longitude=?,Problem=?,quantity=?,Money=? where Email=?");
            PreparedStatement psa = con.prepareStatement("update customerfixedTable set latitude=?,longitude=?,Problem=?,quantity=?,Money=? where Email=?");
            //out.println(email);
            
            String latitude = request.getParameter("latitude");
            double lat = Double.parseDouble(latitude);
            ps.setDouble(1,lat);
            psa.setDouble(1, lat);
            
            String longitude = request.getParameter("longitude");
             double lan = Double.parseDouble(longitude);
             
            ps.setDouble(2,lan);
            psa.setDouble(2, lan);
            
            String problem=request.getParameter("serviceType");
            ps.setString(3, problem);
            psa.setString(3, problem);
//                out.println(problem);
            
           String qua=request.getParameter("quantity");
            int quantity = Integer.parseInt(qua);
           ps.setInt(4, quantity);
           psa.setInt(4, quantity);
           
           int q=quantity*110;
           ps.setInt(5, q);
           psa.setInt(5, q);
           
            ps.setString(6,email);
            psa.setString(6,email);
           
            
            
            ps.executeUpdate();
            psa.executeUpdate();
            
            
            
//             PreparedStatement psa = con.prepareStatement("update customerfixedTable set latitude=?,longitude=?,Problem=?,quantity=? where Email=?");
//            
//            //out.println(email);
//            
//            String Latitude = request.getParameter("latitude");
//            double Lat = Double.parseDouble(Latitude);
//            psa.setDouble(1,Lat);
//            
//            String Longitude = request.getParameter("longitude");
//             double Lan = Double.parseDouble(Longitude);
//             
//            psa.setDouble(2,Lan);
//            
//            String Problem=request.getParameter("serviceType");
//            psa.setString(3, Problem);
////                out.println(problem);
//            
//           String quat=request.getParameter("quantity");
//            int quan = Integer.parseInt(quat);
//           psa.setInt(4, quan);
//           
//            psa.setString(5,email);
//           
//            
//            
//            ps.executeUpdate();
            

            // Check the number of rows affected to determine if the update was successful
            
            response.sendRedirect("orderSuccessPage.html");
            
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(locationSave.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(locationSave.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(locationSave.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(locationSave.class.getName()).log(Level.SEVERE, null, ex);
        }
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
