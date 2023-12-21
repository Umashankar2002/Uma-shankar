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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author student
 */
public class customerDetails extends HttpServlet {

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
            
           String query = "select Name,PhoneNo,Email,latitude,longitude,Problem,quantity,Money from customerTable";
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query);
                
                out.println("<html><head> <style>\n" +
"        table{border-collapse:collapse; width:20%; margin-left:70px;}\n" +
"        th,td{\n" +
"            border: 2px solid brown;\n" +
"            padding:5px;\n" +
"            text-align:center;\n" +
"        }\n" +
"        td{\n" +
"            height: 30px;\n" +
"            vertical-align: super;\n" +
"        }\n" +
"        tr:nth-child(even){\n" +
"            background-color: #fff;\n" +
"        }\n" +
"        tr:nth-child(odd){\n" +
"            background-color: #eee;\n" +
"        }\n" +
"        th{\n" +
"            color: white;\n" +
"            background-color: gray;\n" +
"            height: 50px;\n" +
"            \n" +
"        }\n" +
"        th:hover{\n" +
"            height: 70px;\n" +
"            border-bottom: 2px solid black;\n" +
"            background-color: green;\n" +
"        }\n" +
"        tr:hover{\n" +
"            background-color: gray;\n" +
"        }</style></head><body><h1 align='center' style=\"margin-top:100px\">All Pending Cases</h1><table style=\"margin-left:350px\"><tr>"
                        + "<th>Name</th>"
                        
                        + "<th>Phone Number</th>"
                        + "<th>Email</th>"
                        + "<th>Latitude</th>"
                        + "<th>Longitude</th>"
                        +"<th>Prablem</th>"
                        + "<th>Quantity</th>"
                        + "<th>Amount</th>"
                        + "<th>Accept</th>"
                        +"</tr>");
                        
                int i=1;
                while(rs.next())
                {
                    
                    out.println("<tr><td>"+rs.getString(1)+"</td><td>");
                    out.println(rs.getString(2)+"</td><td>");
                    out.println(rs.getString(3)+"</td><td>");
                    out.println(rs.getString(4)+"</td><td>");
                    out.println(rs.getString(5)+"</td><td>");
                    out.println(rs.getString(6)+"</td><td>");
                    out.println(rs.getString(7)+"</td><td>");
                    out.println(rs.getString(8)+"</td><td>");
                    //String lat_lon =  rs.getString(4)+"_"+rs.getString(5);
                    out.println("<form action=\"mapLocation\" method=\"post\">\n" +
"        <button type=\"submit\" name=\"buttonValue\" value="+rs.getString(4)+">Click me</button>\n" +
"  "
        + "<label>\n" +
"        <input type=\"checkbox\" name=\"checkbox1\" value="+rs.getString(3)+">\n" +
"    </label>"
        + ""
        + ""
        + ""
        + "  </form>");
                    
                    
                   
                    
                    
                    //out.println("<form><button style=\"width: 100px; height: 50px;\" onclick=\"buttonClick()\">Click me</button>");
                    
//                    out.println("<form action=\"mapLocation\" id=\"form\" name=\"form\" method=\"post\">"
//                            + "<input type=\"submit\" value=\"click\" >"
//                            + ""
//                            + "</form>"
//                            + "<script defer>"
//                            + "buttonClick();"
//                            + "function buttonClick(){\n"
//                            + "const form = document.getElementById(\"form\");"
//                            + ""
//                            + "const email = document.createElement(\"input\");"
//                            + "const latitude = document.createElement(\"input\");"
//                            + "const longitude = document.createElement(\"input\");"
//                            + ""
//                            + "email.setAttribute('type','text');"
//                            + "latitude.setAttribute('type','text');"
//                            + "longitude.setAttribute('type','text');"
//                            + ""
//                            + "email.setAttribute('name','email');"
//                            + "latitude.setAttribute('name','latitude');"
//                            + "longitude.setAttribute('name','longitude');"
//                            + ""
//                            + "email.value ="+rs.getString(3)
//                            + "latitude.value = "+rs.getString(4)
//                            + "longitude.value = "+rs.getString(5)
//                            + ""
//                            + "form.append(email);"
//                            + "form.append(latitude);"
//                            + "form.append(longitude)"
//                            + ""
//                            + "}"
//                            + "</script>");
                    out.println("</td></tr>");
                    i++;
                }
                
                out.println("</table></body></html>");
                
//                out.println("<script>\n" +
//"        // Example JavaScript function to handle button click\n" +
//"        function buttonClick() {\n" +
//"            window.location.href = 'mapLocation.html';\n" +
//"            // You can perform additional actions here\n" +
//"        }\n" +
//"    </script>");
                
                
                
                
                
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
            Logger.getLogger(customerDetails.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(customerDetails.class.getName()).log(Level.SEVERE, null, ex);
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
