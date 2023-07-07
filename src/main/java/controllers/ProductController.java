/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import DAO.ProductDAO;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import models.Product;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

/**
 *
 * @author arteaga
 */
public class ProductController {

    private ProductDAO productDAO;

    public ProductController() {
        productDAO = new ProductDAO(); // Instancia del DAO
    }

    public void insertProduct(Product product) {
        productDAO.insert(product); // Llamada al método del DAO para insertar el producto en la base de datos
    }

    public List<Product> getAllProducts() {
        return productDAO.getAllProducts(); // Llamada al método del DAO para obtener todos los productos de la base de datos
    }

    public boolean productExists(String productId) {
        // Lógica adicional antes de llamar al método productExists en el DAO
        return productDAO.productExists(productId);
    }

    public int obtenerStockAnterior(String idProduct) {
        return productDAO.obtenerStockAnterior(idProduct);
    }

    public void actualizarStock(String idProduct, int cantidad) {
        productDAO.actualizarStock(idProduct, cantidad);
    }


}
