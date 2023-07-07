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
public class Salidas {
    private String idProduct;
    private String descProduct;
    private int stockAnterior;
    private int stockRetirado;
    private int stockActual;
    private String cliente;
    private LocalDate dateOut;

    public Salidas(String idProduct, String descProduct, int stockAnterior, int stockRetirado, int stockActual, String cliente, LocalDate dateOut) {
        this.idProduct = idProduct;
        this.descProduct = descProduct;
        this.stockAnterior = stockAnterior;
        this.stockRetirado = stockRetirado;
        this.stockActual = stockActual;
        this.cliente = cliente;
        this.dateOut = dateOut;
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

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public LocalDate getDateOut() {
        return dateOut;
    }

    public void setDateOut(LocalDate dateOut) {
        this.dateOut = dateOut;
    }

    public int getStockRetirado() {
        return stockRetirado;
    }

    public void setStockRetirado(int stockRetirado) {
        this.stockRetirado = stockRetirado;
    }
    
}
