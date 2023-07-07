/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import DAO.EntradaDAO;
import java.util.List;
import models.Entradas;

/**
 *
 * @author arteaga
 */
public class EntradaController {
    private EntradaDAO entradaDAO;

    public EntradaController() {
        entradaDAO = new EntradaDAO();
    }

    public void insertEntrada(Entradas entrada) {
        entradaDAO.insertEntrada(entrada);
    }

    public List<Entradas> getAllEntradas() {
        return entradaDAO.getAllEntradas();
    }
    
    public List<Entradas> getAllEntradasOrderedById() {
        return entradaDAO.getAllEntradasOrderedById();
    }
}
