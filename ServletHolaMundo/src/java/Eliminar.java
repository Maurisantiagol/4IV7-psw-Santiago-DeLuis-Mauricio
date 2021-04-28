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
 * @author PCMASTERACE
 */
public class Eliminar extends HttpServlet {

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
       response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Eliminar</title>"  
            +"<link rel='stylesheet' href='css/servlet.css'><link href='https://fonts.googleapis.com/icon?family=Material+Icons'rel='stylesheet'><!-- https://material.io/resources/icons/?style=baseline --><link href='https://fonts.googleapis.com/css2?family=Material+Icons'rel='stylesheet'><!-- https://material.io/resources/icons/?style=outline --><link href='https://fonts.googleapis.com/css2?family=Material+Icons+Outlined'rel='stylesheet'><!-- https://material.io/resources/icons/?style=round --><link href='https://fonts.googleapis.com/css2?family=Material+Icons+Round'rel='stylesheet'><!-- https://material.io/resources/icons/?style=sharp --><link href='https://fonts.googleapis.com/css2?family=Material+Icons+Sharp'rel='stylesheet'><!-- https://material.io/resources/icons/?style=twotone --><link href='https://fonts.googleapis.com/css2?family=Material+Icons+Two+Tone'rel='stylesheet'>");            
            out.println("</head>");
            out.println("<body>");
            
            int id;
            
            id = Integer.parseInt(request.getParameter("ideliminar"));
            
            /*
            para poder eliminar es 
            delete from nombretabla where atributo (condicion) valor
            */
            String q = "delete from mregistro where id_usu = "+id;
            try{
                
                set.executeUpdate(q);
                System.out.println("Registro eliminado con exito");
                
                out.println("<h1>Registro Eliminado</h1>");
            }catch(Exception e){
                out.println("<h1>Registro No Eliminado, sucedio un error</h1>");
                System.out.println("Error al eliminar el registro");
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
            
            }

            out.println("<a href='index.html'>Regresar al Formulario</a>"
                    + "<br>"
                    + "<a href='Registro'>Registrar un Nuevo Usuario</a>"
                    + "<br>"
                    + "<a href='Consultar2'>Consultar la Tabla General de Usuarios</a><footer><div><h1>Información de contacto</h1></div><p><span class=\"material-icons-outlined\" >phone</span>Telefono: 5583648857</p><p><span class=\"material-icons-outlined\">facebook</span><a href=\"https://www.facebook.com/profile.php?id=100009774423321\">Mauricio Santiagol</a></p><p><span class=\"material-icons-outlined\">email</span>Email:<a href=\"mailto:Santiagodeluismauricio@gmail.com\">Santiagodeluismauricio@gmail.com</a></p></footer>");
            out.println("</body>");
            out.println("</html>");
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
