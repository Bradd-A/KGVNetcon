/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controllers;

import DAO.SalidaDAO;
import java.util.List;
import models.Salidas;

/**
 *
 * @author arteaga
 */
public class SalidaController {
    private SalidaDAO salidaDAO;

    public SalidaController() {
        salidaDAO = new SalidaDAO();
    }

    public void insertSalida(Salidas salida) {
        salidaDAO.insertSalida(salida);
    }

    public List<Salidas> getAllSalidas() {
        return salidaDAO.getAllSalidas();
    }
    
    public List<Salidas> getAllSalidasOrderedById() {
        return salidaDAO.getAllSalidasOrderedById();
    }
}
