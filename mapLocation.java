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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author student
 */
public class mapLocation extends HttpServlet {

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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            
            
            
            
           
            
            
            out.println(""
                    + ""
                    + "<!DOCTYPE html>\n" +
"<html lang=\"en\">\n" +
"<head>\n" +
"    <meta charset=\"UTF-8\">\n" +
"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
"    <title>Current Location Map</title>\n" +
                    "<link rel=\"stylesheet\" href=\"customerHomePage.css\">"+
"    <style>\n" +
"        /* Ensure the map container takes up the full screen */\n" +
"        #map {\n" +
"            height: 100vh;\n" +
"        }\n" +
"    </style>\n" +
"</head>\n" +
"<body>\n" +
""
                    + ""
                    + "<header>\n" +
"        <nav>\n" +
"            <ul>\n" +
"                <li><a href=\"customerDetails\" style=\"margin-left:1400px\">Back</a></li>\n" +
"                \n" +
"            </ul>\n" +
"        </nav>\n" +
"    </header>"
                    + ""
                    + ""
                    + ""
                    + ""
                    + "\n" +
"    <h1>Current Location Map</h1>\n" +
"\n" +
"    <!-- Map container -->\n" +
"    <div id=\"map\"></div>"
                    + ""
                    + ""
                    + ""
                    + ""
                    + "<script>\n" +

        
                    
                    
         "function handleLocation(position) {\n" +
"            var latitude =  14.33489;\n" +
"            var longitude = 78.53542;\n" +
"\n" +
"            // Initialize and display the map with the retrieved coordinates\n" +
"            initMap(latitude, longitude);\n" +
"        }\n" +
"                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    \n" +
"        // Function to handle errors with Geolocation API\n" +
"        function handleError(error) {\n" +
"            console.error('Error getting location:', error.message);\n" +
"        }\n" +
"\n" +
"        // Check if the Geolocation API is supported by the browser\n" +
"        if (navigator.geolocation) {\n" +
"            // Retrieve the user's current location\n" +
"            navigator.geolocation.getCurrentPosition(handleLocation, handleError);\n" +
"        } else {\n" +
"            console.error('Geolocation is not supported by this browser.');\n" +
"        }"
           + "function initMap(latitude, longitude) {\n" +
"            // Create a LatLng object with the retrieved coordinates\n" +
"            var myLatLng = {lat: latitude, lng: longitude};\n" +
"\n" +
"            // Create a map centered at the user's location\n" +
"            var map = new google.maps.Map(document.getElementById('map'), {\n" +
"                center: myLatLng,\n" +
"                zoom: 15 // You can adjust the zoom level as needed\n" +
"            });\n" +
"\n" +
"            // Add a marker at the user's location\n" +
"            var marker = new google.maps.Marker({\n" +
"                position: myLatLng,\n" +
"                map: map,\n" +
"                title: 'Your Location'\n" +
"            });\n" +
"        }"+          
                    
                
                    
"    </script>"
                    + "<script async defer\n" +
"            src=\"https://maps.googleapis.com/maps/api/js?key=AIzaSyBJyNhA1idXOqaR2sDYA3pdFXBKjC-KuFk&callback=initMap\">\n" +
"    </script>"
                    + ""
                    + ""
                    + ""
                    + "</body>\n" +
"</html>");
            
            
//            
         String name="<script>"
                    + "function getParameterByName(name, url) {\n" +
"            if (!url) url = window.location.href;\n" +
"            name = name.replace(/[\\[\\]]/g, \"\\\\$&\");\n" +
"            var regex = new RegExp(\"[?&]\" + name + \"(=([^&#]*)|&|#|$)\"),\n" +
"                results = regex.exec(url);\n" +
"            if (!results) return null;\n" +
"            if (!results[2]) return '';\n" +
"            return decodeURIComponent(results[2].replace(/\\+/g, \" \"));\n" +
"        }\n" +
"\n" +
"        // Get the value of the 'buttonValue' parameter from the URL\n" +
"        var buttonValue = getParameterByName('buttonValue');\n" +
"\n" +
"        // Display the value on the page\n" +
"        document.write(buttonValue);\n" +
                    "</script>";

           
            
           
                   Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/orderPetrol","root","Naren@232");
            
        String checkbox = request.getParameter("checkbox1");
        //String checkbox2Value = request.getParameter("checkbox2");
        
       // out.println(checkbo);
        
       
        
     PreparedStatement ps = con.prepareStatement("delete from customerTable where Email=?");
      ps.setString(1,checkbox);
      
      ps.executeUpdate();
            
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
            Logger.getLogger(mapLocation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(mapLocation.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(mapLocation.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(mapLocation.class.getName()).log(Level.SEVERE, null, ex);
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

    private boolean areEmailsEqual(String string, String temp) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
