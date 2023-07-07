/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import models.Entradas;
import models.Salidas;
import utils.DatabaseConnection;

/**
 *
 * @author arteaga
 */
public class SalidaDAO {
    private final String INSERT_SALIDA_QUERY = "INSERT INTO Salidas (idProduct, descProduct, stockAnterior, stockRetirado, stockActual, customer, dateOut) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private final String GET_ALL_SALIDAS_QUERY = "SELECT * FROM salidas";
    public void insertSalida(Salidas salida) {
        try (Connection conn = DatabaseConnection.getConexion();
             PreparedStatement statement = conn.prepareStatement(INSERT_SALIDA_QUERY)) {
            
            statement.setString(1, salida.getIdProduct());
            statement.setString(2, salida.getDescProduct());
            statement.setInt(3, salida.getStockAnterior());
            System.out.println("desde dao: "+salida.getStockRetirado());
            statement.setInt(4, salida.getStockRetirado());
            statement.setInt(5, salida.getStockActual());
            statement.setString(6, salida.getCliente());
            statement.setDate(7, java.sql.Date.valueOf(salida.getDateOut()));

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción
        }
    }
    

    public List<Salidas> getAllSalidas() {
        List<Salidas> salidas = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConexion();
             PreparedStatement statement = conn.prepareStatement(GET_ALL_SALIDAS_QUERY);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String idProduct = resultSet.getString("idProduct");
                String descProduct = resultSet.getString("descProduct");
                int stockAnterior = resultSet.getInt("stockAnterior");
                int stockRetirado = resultSet.getInt("stockRetirado");
                int stockActual = resultSet.getInt("stockActual");
                String customer = resultSet.getString("customer");
                LocalDate dateOut = resultSet.getDate("dateOut").toLocalDate();

                Salidas salida = new Salidas(idProduct, descProduct, stockAnterior, stockRetirado, stockActual, customer, dateOut);
                salidas.add(salida);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción
        }

        return salidas;
    }
    
    public List<Salidas> getAllSalidasOrderedById() {
        List<Salidas> salidas = new ArrayList<>();
        String query = "SELECT * FROM salidas ORDER BY idOut DESC"; // Ordenar en orden descendente por ID
        try (Connection conn = DatabaseConnection.getConexion();
             PreparedStatement statement = conn.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
        
        while (resultSet.next()) {
            // Obtener los valores de cada columna de la fila actual
            String idProduct = resultSet.getString("idProduct");
            String descProduct = resultSet.getString("descProduct");
            int stockAnterior = resultSet.getInt("stockAnterior");
            int stockRetirado = resultSet.getInt("stockRetirado");
            int stockActual = resultSet.getInt("stockActual");
            String cliente = resultSet.getString("customer");
            LocalDate dateOut = resultSet.getDate("dateOut").toLocalDate();
            
            // Crear una instancia de Salidas con los valores obtenidos y agregarla a la lista
            Salidas salida = new Salidas(idProduct, descProduct, stockAnterior, stockRetirado, stockActual, cliente, dateOut);
            salidas.add(salida);
        }
        
        resultSet.close();
        statement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return salidas;
}

}
