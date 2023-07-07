/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.time.LocalDate;

/**
 *
 * @author arteaga
 */
public class Entradas {
    private String idProduct;
    private String descProduct;
    private int stockAnterior;
    private int stockAgregado;
    private int stockActual;
    private String supplier;
    private LocalDate dateIn;

    public Entradas(String idProduct, String descProduct, int stockAnterior, int stockAgregado, int stockActual, String supplier, LocalDate dateIn) {
        this.idProduct = idProduct;
        this.descProduct = descProduct;
        this.stockAnterior = stockAnterior;
        this.stockAgregado = stockAgregado;
        this.stockActual = stockActual;
        this.supplier = supplier;
        this.dateIn = dateIn;
    }
    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getDescProduct() {
        return descProduct;
    }

    public void setDescProduct(String descProduct) {
        this.descProduct = descProduct;
    }

    public int getStockAnterior() {
        return stockAnterior;
    }

    public void setStockAnterior(int stockAnterior) {
        this.stockAnterior = stockAnterior;
    }

    public int getStockActual() {
        return stockActual;
    }

    public void setStockActual(int stockActual) {
        this.stockActual = stockActual;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public LocalDate getDateIn() {
        return dateIn;
    }

    public void setDateIn(LocalDate dateIn) {
        this.dateIn = dateIn;
    }

    public int getStockAgregado() {
        return stockAgregado;
    }

    public void setStockAgregado(int stockAgregado) {
        this.stockAgregado = stockAgregado;
    }
    
}
