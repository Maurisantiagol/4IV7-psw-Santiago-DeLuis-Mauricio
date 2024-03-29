/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//de poder realizar la conexion con la bd
import java.sql.Connection;
import java.sql.DriverManager;
//de poder realizar las sentencias sql, create, insert, delete, drop, update, alter
import java.sql.Statement;
//de poder realizar las consultas a la bd
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletConfig;


/**
 *
 * @author EMOA1
 */
public class Consultar2 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private Connection con;
    private Statement set;
    private ResultSet rs;
    
    //vamos a crear el metodo constructor
    
    public void init(ServletConfig cfg) throws ServletException{
        //para conectarnos con la bd
        String url = "jdbc:mysql:3306//localhost/registro4iv7";
                    //driver:gestorbd:puerto//IP/nombrebd
                    
        String userName = "root";
        String password = "maika";
        
        try{
            
            Class.forName("com.mysql.jdbc.Driver");
            /*
            a veces el driver ya maneja por defecto el puerto de comunicacion
            es por ello que pueden mandar un error, en ese caso
            url = "jdbc:mysql://localhost/registro4iv7";
            */
            url = "jdbc:mysql://localhost/registro4iv7";
            con = DriverManager.getConnection(url, userName, password);
            set = con.createStatement();
            
            System.out.println("Se ha conectado a la BD");
        
        }catch(Exception e ){
            System.out.println("No se ha conectado a la BD");
            System.out.println(e.getMessage());
            System.out.println(e.getStackTrace());
        
        }
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Consultar</title>"
                    + "<link rel='stylesheet' href='css/servlet.css'><link href='https://fonts.googleapis.com/icon?family=Material+Icons'rel='stylesheet'><!-- https://material.io/resources/icons/?style=baseline --><link href='https://fonts.googleapis.com/css2?family=Material+Icons'rel='stylesheet'><!-- https://material.io/resources/icons/?style=outline --><link href='https://fonts.googleapis.com/css2?family=Material+Icons+Outlined'rel='stylesheet'><!-- https://material.io/resources/icons/?style=round --><link href='https://fonts.googleapis.com/css2?family=Material+Icons+Round'rel='stylesheet'><!-- https://material.io/resources/icons/?style=sharp --><link href='https://fonts.googleapis.com/css2?family=Material+Icons+Sharp'rel='stylesheet'><!-- https://material.io/resources/icons/?style=twotone --><link href='https://fonts.googleapis.com/css2?family=Material+Icons+Two+Tone'rel='stylesheet'>");            
            
                    out.println("</head>");
            out.println("<body>"
            +"<div class='maincontainer'>");
            out.println("<h1>Tabla General De Usuarios</h1>");
            out.println("<table border='2'>"
                    + "<thead>"
                    + "<tr>"
                    + "<th>ID</th>"
                    + "<th>Nombre Completo</th>"
                    + "<th>Edad</th>"
                    + "<th>Correo</th>"
                    + "</tr>"
                    + "</thead>"
                    + "<tbody>");
            try{
                
                String nom, appat, appmat, correo, q;
                int edad, id;
                
                q = "select * from mregistro";
                
                set = con.createStatement();
                rs = set.executeQuery(q);
                while(rs.next()){
                    id = rs.getInt("id_usu");
                    nom = rs.getString("nom_usu");
                    appat = rs.getString("appat_usu");
                    appmat = rs.getString("apmat_usu");
                    edad = rs.getInt("edad_usu");
                    correo = rs.getString("email_usu");
                    out.println("<tr>"
                            + "<td>"+id+"</td>"
                            + "<td>"+nom+" "+appat+" "+appmat+"</td>"
                            + "<td>"+edad+"</td>"
                            + "<td>"+correo+"</td>"
                            + "</tr>");
                }
                
                System.out.println("Consulta exitosa");
                rs.close();
                set.close();
            
            }catch(Exception e){
                System.out.println("Error al consultar la tabla");
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
                
            
            }
            
            
            out.println("</tbody>"
                    + "</table>"
                    + "<br>"
                    + "<a href='index.html'>Regresar al Formulario</a>"
                    + "</div> <footer><div><h1>Información de contacto</h1></div><p><span class=\"material-icons-outlined\" >phone</span>Telefono: 5583648857</p><p><span class=\"material-icons-outlined\">facebook</span><a href=\"https://www.facebook.com/profile.php?id=100009774423321\">Mauricio Santiagol</a></p><p><span class=\"material-icons-outlined\">email</span>Email:<a href=\"mailto:Santiagodeluismauricio@gmail.com\">Santiagodeluismauricio@gmail.com</a></p></footer>");
            out.println("</body>");
            out.println("</html>");
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    
     public void destroy(){
        try{
            con.close();
        
        }catch(Exception e){
            super.destroy();
        
        }
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
