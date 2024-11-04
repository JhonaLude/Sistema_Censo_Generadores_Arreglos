/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controller.dao;

import com.example.models.Estadistica;

/**
 *
 * @author Jhonathan Alexander Ludena Cevallos
 */

public class EstadisticaDAO {
    private static final int MAX_ESTADISTICAS = 100;
    private Estadistica[] estadisticas;
    private int cantidadActual;

    public EstadisticaDAO() {
        this.estadisticas = new Estadistica[MAX_ESTADISTICAS];
        this.cantidadActual = 0;
        agregarEstadistica(new Estadistica(1, "2024-Q1", 75.5, "Ventas", "Primer trimestre"));
        agregarEstadistica(new Estadistica(2, "2024-Q1", 82.3, "Satisfacción", "Primer trimestre"));
    }

    public boolean agregarEstadistica(Estadistica estadistica) {
        if (cantidadActual >= MAX_ESTADISTICAS) {
            return false;
        }
        estadisticas[cantidadActual] = estadistica;
        cantidadActual++;
        return true;
    }

    public Estadistica[] obtenerTodas() {
        Estadistica[] resultado = new Estadistica[cantidadActual];
        System.arraycopy(estadisticas, 0, resultado, 0, cantidadActual);
        return resultado;
    }

    public Estadistica obtenerPorId(int id) {
        for (int i = 0; i < cantidadActual; i++) {
            if (estadisticas[i].getId() == id) {
                return estadisticas[i];
            }
        }
        return null;
    }

    public boolean actualizarEstadistica(Estadistica estadistica) {
        for (int i = 0; i < cantidadActual; i++) {
            if (estadisticas[i].getId() == estadistica.getId()) {
                estadisticas[i] = estadistica;
                return true;
            }
        }
        return false;
    }

    public boolean eliminarEstadistica(int id) {
        for (int i = 0; i < cantidadActual; i++) {
            if (estadisticas[i].getId() == id) {
                System.arraycopy(estadisticas, i + 1, estadisticas, i, cantidadActual - i - 1);
                cantidadActual--;
                return true;
            }
        }
        return false;
    }
}
