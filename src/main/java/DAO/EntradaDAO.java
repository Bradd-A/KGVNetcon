package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import models.Entradas;
import utils.DatabaseConnection;

public class EntradaDAO {
    private final String INSERT_ENTRADA_QUERY = "INSERT INTO Entradas (idProduct, descProduct, stockAnterior, stockAgregado, stockActual, supplier, dateIn) VALUES (?, ?, ?, ?, ?, ?, ?)";
    private final String GET_ALL_ENTRADAS_QUERY = "SELECT * FROM entradas";

    public void insertEntrada(Entradas entrada) {
        try (Connection conn = DatabaseConnection.getConexion();
             PreparedStatement statement = conn.prepareStatement(INSERT_ENTRADA_QUERY)) {
            
            statement.setString(1, entrada.getIdProduct());
            statement.setString(2, entrada.getDescProduct());
            statement.setInt(3, entrada.getStockAnterior());
            System.out.println("desde dao: "+entrada.getStockAgregado());
            statement.setInt(4, entrada.getStockAgregado());
            statement.setInt(5, entrada.getStockActual());
            statement.setString(6, entrada.getSupplier());
            statement.setDate(7, java.sql.Date.valueOf(entrada.getDateIn()));

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción
        }
    }
    

    public List<Entradas> getAllEntradas() {
        List<Entradas> entradas = new ArrayList<>();

        try (Connection conn = DatabaseConnection.getConexion();
             PreparedStatement statement = conn.prepareStatement(GET_ALL_ENTRADAS_QUERY);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String idProduct = resultSet.getString("idProduct");
                String descProduct = resultSet.getString("descProduct");
                int stockAnterior = resultSet.getInt("stockAnterior");
                int stockAgregado = resultSet.getInt("stockAgregado");
                int stockActual = resultSet.getInt("stockActual");
                String supplier = resultSet.getString("supplier");
                LocalDate dateIn = resultSet.getDate("dateIn").toLocalDate();

                Entradas entrada = new Entradas(idProduct, descProduct, stockAnterior, stockAgregado, stockActual, supplier, dateIn);
                entradas.add(entrada);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Manejar la excepción
        }

        return entradas;
    }
    public List<Entradas> getAllEntradasOrderedById() {
        List<Entradas> entradas = new ArrayList<>();
        String query = "SELECT * FROM entradas ORDER BY idEntry DESC"; // Ordenar en orden descendente por ID
        try (Connection conn = DatabaseConnection.getConexion();
             PreparedStatement statement = conn.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {
        
        while (resultSet.next()) {
            // Obtener los valores de cada columna de la fila actual
            String idProduct = resultSet.getString("idProduct");
            String descProduct = resultSet.getString("descProduct");
            int stockAnterior = resultSet.getInt("stockAnterior");
            int stockAgregado = resultSet.getInt("stockAgregado");
            int stockActual = resultSet.getInt("stockActual");
            String proveedor = resultSet.getString("supplier");
            LocalDate dateIn = resultSet.getDate("dateIn").toLocalDate();
            
            // Crear una instancia de Salidas con los valores obtenidos y agregarla a la lista
            Entradas entrada = new Entradas(idProduct, descProduct, stockAnterior, stockAgregado, stockActual, proveedor, dateIn);
            entradas.add(entrada);
        }
        
        resultSet.close();
        statement.close();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return entradas;
}
}
