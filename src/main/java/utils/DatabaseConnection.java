/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author arteaga
 */
public class DatabaseConnection {

    /**
     * @param args the command line arguments
     */
    public static Connection getConexion(){
        Connection con = null;
        String cadena = "jdbc:mysql://localhost/kgvnetcon?user=root&password=";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(cadena);
            System.out.println("Conexion Satisfactoria");
        } catch (Exception e) {
            System.out.println("Error: " +e);
        }
        return con;
    } 
    public static void main(String[] args) {
        // TODO code application logic here
        getConexion();
    }
    
}
