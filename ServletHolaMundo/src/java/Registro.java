/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static com.sun.faces.util.RequestStateManager.set;
import static com.sun.javafx.fxml.expression.Expression.set;
import static com.sun.xml.ws.api.streaming.XMLStreamWriterFactory.set;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.reflect.Array.set;
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
import javax.servlet.ServletConfig;

/**
 *
 * @author PCMASTERACE
 */
public class Registro extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request---> peticiones
     * @param response servlet response---> respuesta
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    /*
    el servlet para poderse conectar con la bd, es necesario inicializar sus elementos
    voy a necesitar de 3 objetos que vienen de la clase sql
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
    
    protected void processRequest(HttpServletRequest request, 
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            //manipular los datos del formulario
            String nom, appat, appmat, correo, ip, iph;
            int edad, puerto, puertoh;
            
            ip = request.getLocalAddr();
            puerto = request.getLocalPort();
            
            iph = request.getRemoteAddr();
            puertoh = request.getRemotePort();
            
            
            
            nom = request.getParameter("nombre");
            appat = request.getParameter("appat");
            appmat = request.getParameter("appmat");
            correo = request.getParameter("email");
            
            edad = Integer.parseInt(request.getParameter("edad"));
            
            
            try{
            
                //querry para poder insertar los datos en la bd
                /*
                insert into nombretabla (atributo, atributo, ...)
                values ("valor1", 'valor2', valor3, ...)
                */
                
                String q = "insert into Mregistro "
                        + "(nom_usu, appat_usu, apmat_usu, edad_usu, email_usu) "
                        + "values "
                        + "('"+nom+"', '"+appat+"', '"+appmat+"', "+edad+", '"+correo+"')";
            
                set.executeUpdate(q);
           
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Registro de Usuarios</title>" 
            +"<link rel='stylesheet' href='css/servlet.css'><link href='https://fonts.googleapis.com/icon?family=Material+Icons'rel='stylesheet'><!-- https://material.io/resources/icons/?style=baseline --><link href='https://fonts.googleapis.com/css2?family=Material+Icons'rel='stylesheet'><!-- https://material.io/resources/icons/?style=outline --><link href='https://fonts.googleapis.com/css2?family=Material+Icons+Outlined'rel='stylesheet'><!-- https://material.io/resources/icons/?style=round --><link href='https://fonts.googleapis.com/css2?family=Material+Icons+Round'rel='stylesheet'><!-- https://material.io/resources/icons/?style=sharp --><link href='https://fonts.googleapis.com/css2?family=Material+Icons+Sharp'rel='stylesheet'><!-- https://material.io/resources/icons/?style=twotone --><link href='https://fonts.googleapis.com/css2?family=Material+Icons+Two+Tone'rel='stylesheet'>");          
            out.println("</head>");
            out.println("<body><div class='maincontainer'>"
                    + "<br>Tu nombre es: " + nom);
            out.println("<br>"
                    + "Tu Apellido Paterno es:"+appat
                    + "<br>"
                    + "Tu Apellido Materno es:"+appmat
                    + "<br>"
                    + "Tu Edad es:"+edad
                    + "<br>"
                    + "Tu correo electronico es:"+correo
                    + "<br>");
            out.println("<h1>Registro Exitoso</h1>"
                    + "<br>"
                    + "La IP Local es: "+ip
                    + "<br>"
                    + "La IP del host: "+iph
                    + "<br>"
                    + "Puerto Local: " + puerto
                    + "<br>"
                    + "Puerto Host:" + puertoh
                    + "<br>"
                    + "<a href='index.html'>Regresar al Formulario</a>"
                    + "<br>"
                    + "<a href='Consultar2'>Consultar la Tabla General de Usuarios</a>"
                            + "</div>");
            out.println("</body>");
            out.println("</html>");
            
                System.out.println("Datos registrados en la tabla");
            
            }catch(Exception e){
                
                System.out.println("No se registraron los datos en la tabla");
                System.out.println(e.getMessage());
                System.out.println(e.getStackTrace());
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Registro de Usuarios</title>");            
                out.println("</head>");
                out.println("<body>"
                        + "<h1>No se pudo registrar, hubo un error</h1>"
                        + "<a href='index.html'>Regresar al Formulario</a></div>");
                 
            out.println("</body>");
            out.println("</html>");
            }
            
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
