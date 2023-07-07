package controllers;

import java.io.IOException;
import java.util.List;
import models.Product;
import models.Entradas;
import models.Salidas;
import utils.ExcelGenerator;

public class ExcelController {
    private ProductController productController;
    private EntradaController entradaController;
    private SalidaController salidaController;

    public ExcelController() {
        productController = new ProductController();
        entradaController = new EntradaController();
        salidaController = new SalidaController();
    }
    public void exportToExcel() {
        try {
            List<Product> products = productController.getAllProducts();
            List<Entradas> entradas = entradaController.getAllEntradas();
            List<Salidas> salidas = salidaController.getAllSalidas();
            String filePath = "datos.xlsx";
            ExcelGenerator.generateExcel(products, entradas, salidas, filePath);
            System.out.println("Exportación a Excel exitosa");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al exportar a Excel");
        }
    }

}
