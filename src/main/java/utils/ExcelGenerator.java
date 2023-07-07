/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import models.Entradas;
import models.Product;
import models.Salidas;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author arteaga
 */
public class ExcelGenerator {

    public static void generateExcel(List<Product> products, List<Entradas> entradas, List<Salidas> salidas, String filePath) throws IOException {
        Workbook workbook = new XSSFWorkbook();

        // Generar la hoja de productos
        generateProductSheet(workbook, products);

        // Generar la hoja de entradas
        generateEntradaSheet(workbook, entradas);

        // Generar la hoja de salidas
        generateSalidaSheet(workbook, salidas);

        // Guardar el archivo Excel en disco
        FileOutputStream fileOut = new FileOutputStream(filePath);
        workbook.write(fileOut);
        fileOut.close();
        workbook.close();
    }

    private static void generateProductSheet(Workbook workbook, List<Product> products) {
        Sheet sheet = workbook.createSheet("Productos");

        // Crear una fila para las cabeceras
        Row headerRow = sheet.createRow(0);
        
        // Crear estilo de celda para los encabezados
        CellStyle headerCellStyle = workbook.createCellStyle();
        Font headerFont = workbook.createFont();
        headerFont.setBold(true); // Aplicar negrita al encabezado
        headerCellStyle.setFont(headerFont);
        
        headerRow.createCell(0).setCellValue("ID Producto");
        headerRow.createCell(1).setCellValue("Descripción");
        headerRow.createCell(2).setCellValue("Stock");
        headerRow.createCell(3).setCellValue("Fecha de Entrada");
        headerRow.createCell(4).setCellValue("Proveedor");

        // Aplicar estilo de celda a los encabezados
        for (int i = 0; i < headerRow.getLastCellNum(); i++) {
            Cell headerCell = headerRow.getCell(i);
            headerCell.setCellStyle(headerCellStyle);
        }
        
        // Recorrer los productos y escribir los datos en las filas
        int rowNum = 1;
        for (Product product : products) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(product.getIdProduct());
            row.createCell(1).setCellValue(product.getDescProduct());
            row.createCell(2).setCellValue(product.getStock());
            row.createCell(3).setCellValue(product.getDateIn().toString());
            row.createCell(4).setCellValue(product.getSupplier());
        }
        // Ajustar el tamaño de las columnas automáticamente
        for (int i = 0; i < 5; i++) {
            sheet.autoSizeColumn(i);
        }
    }

    private static void generateEntradaSheet(Workbook workbook, List<Entradas> entradas) {
        Sheet sheet = workbook.createSheet("Entradas");

        // Crear una fila para las cabeceras
        Row headerRow = sheet.createRow(0);
        
        // Crear estilo de celda para los encabezados
        CellStyle headerCellStyle = workbook.createCellStyle();
        Font headerFont = workbook.createFont();
        headerFont.setBold(true); // Aplicar negrita al encabezado
        headerCellStyle.setFont(headerFont);
        
        headerRow.createCell(0).setCellValue("ID Producto");
        headerRow.createCell(1).setCellValue("Descripción");
        headerRow.createCell(2).setCellValue("Stock Anterior");
        headerRow.createCell(3).setCellValue("Stock Agregado");
        headerRow.createCell(4).setCellValue("Stock Actual");
        headerRow.createCell(5).setCellValue("Proveedor");
        headerRow.createCell(6).setCellValue("Fecha de Entrada");

        // Aplicar estilo de celda a los encabezados
        for (int i = 0; i < headerRow.getLastCellNum(); i++) {
            Cell headerCell = headerRow.getCell(i);
            headerCell.setCellStyle(headerCellStyle);
        }
        
        // Recorrer las entradas y escribir los datos en las filas
        int rowNum = 1;
        for (Entradas entrada : entradas) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(entrada.getIdProduct());
            row.createCell(1).setCellValue(entrada.getDescProduct());
            row.createCell(2).setCellValue(entrada.getStockAnterior());
            row.createCell(3).setCellValue(entrada.getStockAgregado());
            row.createCell(4).setCellValue(entrada.getStockActual());
            row.createCell(5).setCellValue(entrada.getSupplier());
            row.createCell(6).setCellValue(entrada.getDateIn().toString());
        }

        // Ajustar el tamaño de las columnas automáticamente
        for (int i = 0; i < 7; i++) {
            sheet.autoSizeColumn(i);
        }
    }

    private static void generateSalidaSheet(Workbook workbook, List<Salidas> salidas) {
        Sheet sheet = workbook.createSheet("Salidas");

        // Crear una fila para las cabeceras
        Row headerRow = sheet.createRow(0);
        
        // Crear estilo de celda para los encabezados
        CellStyle headerCellStyle = workbook.createCellStyle();
        Font headerFont = workbook.createFont();
        headerFont.setBold(true); // Aplicar negrita al encabezado
        headerCellStyle.setFont(headerFont);
        
        headerRow.createCell(0).setCellValue("ID Producto");
        headerRow.createCell(1).setCellValue("Descripción");
        headerRow.createCell(2).setCellValue("Stock Anterior");
        headerRow.createCell(3).setCellValue("Stock Retirado");
        headerRow.createCell(4).setCellValue("Stock Actual");
        headerRow.createCell(5).setCellValue("Cliente");
        headerRow.createCell(6).setCellValue("Fecha de Salida");

        // Aplicar estilo de celda a los encabezados
        for (int i = 0; i < headerRow.getLastCellNum(); i++) {
            Cell headerCell = headerRow.getCell(i);
            headerCell.setCellStyle(headerCellStyle);
        }
        
        // Recorrer las salidas y escribir los datos en las filas
        int rowNum = 1;
        for (Salidas salida : salidas) {
            Row row = sheet.createRow(rowNum++);
            row.createCell(0).setCellValue(salida.getIdProduct());
            row.createCell(1).setCellValue(salida.getDescProduct());
            row.createCell(2).setCellValue(salida.getStockAnterior());
            row.createCell(3).setCellValue(salida.getStockRetirado());
            row.createCell(4).setCellValue(salida.getStockActual());
            row.createCell(5).setCellValue(salida.getCliente());
            row.createCell(6).setCellValue(salida.getDateOut().toString());
        }
        

        // Ajustar el tamaño de las columnas automáticamente
        for (int i = 0; i < 7; i++) {
            sheet.autoSizeColumn(i);
        }
    }

}
