package DAO;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import models.Product;
import utils.DatabaseConnection;

public class ProductDAO {
    private Connection connection;

    public ProductDAO() {
        connection = DatabaseConnection.getConexion(); // Obtener la conexión a la base de datos
    }

    public void insert(Product product) {
        try {
            // Preparar la consulta SQL para insertar el producto
            String query = "INSERT INTO product (idProduct, descProduct, stock, dateIn, supplier) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);

            // Establecer los valores de los parámetros en la consulta SQL
            statement.setString(1, product.getIdProduct());
            statement.setString(2, product.getDescProduct());
            statement.setInt(3, product.getStock());
            statement.setDate(4, java.sql.Date.valueOf(product.getDateIn()));
            statement.setString(5, product.getSupplier());

            // Ejecutar la consulta SQL
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();

        try {
            // Preparar la consulta SQL para obtener todos los productos
            String query = "SELECT * FROM product";
            PreparedStatement statement = connection.prepareStatement(query);

            // Ejecutar la consulta SQL y obtener el resultado
            ResultSet resultSet = statement.executeQuery();

            // Recorrer el resultado y crear objetos Product
            while (resultSet.next()) {
                String idProduct = resultSet.getString("idProduct");
                String descProduct = resultSet.getString("descProduct");
                int stock = resultSet.getInt("stock");
                LocalDate dateIn = resultSet.getDate("dateIn").toLocalDate();
                String supplier = resultSet.getString("supplier");

                // Crear instancia de Product y agregarla a la lista
                Product product = new Product(idProduct, descProduct, stock, dateIn, supplier);
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return products;
    }
    public boolean productExists(String productId) {
        String query = "SELECT COUNT(*) FROM product WHERE idProduct = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, productId);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int count = resultSet.getInt(1);
                return count > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public int obtenerStockAnterior(String idProduct) {
        int stockAnterior = 0;
        try {
            // Preparar la consulta SQL para obtener el stock anterior del producto
            String query = "SELECT stock FROM product WHERE idProduct = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, idProduct);

            // Ejecutar la consulta SQL y obtener el resultado
            ResultSet resultSet = statement.executeQuery();

            // Verificar si se encontró el producto en la base de datos
            if (resultSet.next()) {
                stockAnterior = resultSet.getInt("stock");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return stockAnterior;
    }
    
    public void actualizarStock(String idProduct, int cantidad) {
        try {
            // Preparar la consulta SQL para obtener todos los productos
            String query = "UPDATE product set stock = ? where idProduct = ? ";
            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, cantidad);
            statement.setString(2, idProduct);
            // Ejecutar la consulta
            statement.executeUpdate();
            // Cerrar el statement
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
}
