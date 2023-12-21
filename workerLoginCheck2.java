/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author student
 */
public class workerLoginCheck2 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException, ClassNotFoundException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
          
         Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/orderPetrol","root","Naren@232");
            String Password = request.getParameter("password");
            String email = request.getParameter("email");
            
           String query = "select Password,Email from workerTable";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query);
                
                while(rs.next())
                {
                    if(rs.getString(1).equals(Password))
                    {
                        if(rs.getString(2).equals(email))
                        {
                             response.sendRedirect("customerDetails");
                        }
                       
                       // break;
                    }
             
                    
                }
                //response.sendRedirect("customerLoginPage.html");
                out.println("<!DOCTYPE html>\n" +
"<html lang=\"en\">\n" +
"\n" +
"<head>\n" +
"    <meta charset=\"UTF-8\">\n" +
"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"    <title>Customer Login - Online Petrol Ordering</title>\n" +
"    <link rel=\"stylesheet\" href=\"workerLoginPage.css\">\n" +
"    <link rel=\"stylesheet\" href=\"customerLoginPage.css\" type=\"text/css\"/>\n" +
"    <link rel=\"stylesheet\" href=\"customerLoginPage.css\" type=\"text/css\">\n" +
"\n" +
"\n" +
"</head>\n" +
"\n" +
"\n" +
"    <main class=\"login-container\">\n" +
"        <h1>Worker Login</h1>\n" +
"        <form id=\"loginForm\" action=\"workerLoginCheck2\" method=\"post\">\n" +
"            <label for=\"email\">Email:</label>\n" +
"            <input type=\"email\" id=\"email\" name=\"email\" required>\n" +
"\n" +
"            <label for=\"password\">Password:</label>\n" +
"            <input type=\"password\" id=\"password\" name=\"password\" required>\n" +
"\n" +
"            <button type=\"submit\">Login</button>\n" +
"        </form>\n" +
"        <p class=\"register-link\">Not registered? <a href=\"workerRegistrationPage.html\">Register here</a></p>\n" +
                         "<h3 style='color:red'>Need to Register</h3>"+
"    </main>\n" +
"\n" +
"    <script src=\"script.js\"></script>\n" +
"\n" +
"\n" +
"</html>\n" +

"");
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
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(workerLoginCheck2.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(workerLoginCheck2.class.getName()).log(Level.SEVERE, null, ex);
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
