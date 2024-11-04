/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controller.dao;

/**
 *
 * @author Jhonathan Alexander Ludena Cevallos
 */

import com.example.models.Generador;

public class GeneradorDAO {

    private static final Generador[] generadores = new Generador[100];
    private static int contador = 0;

    public Generador crear(Generador generador) {
        if (contador < generadores.length) {
            generador.setId(contador + 1);
            generadores[contador++] = generador;
            return generador;
        }
        return null;
    }

    public Generador[] obtenerTodos() {
        Generador[] resultado = new Generador[contador];
        System.arraycopy(generadores, 0, resultado, 0, contador);
        return resultado;
    }

    public Generador obtenerPorId(int id) {
        for (int i = 0; i < contador; i++) {
            if (generadores[i].getId() == id) {
                return generadores[i];
            }
        }
        return null;
    }

    public boolean actualizar(Generador generador) {
        for (int i = 0; i < contador; i++) {
            if (generadores[i].getId() == generador.getId()) {
                generadores[i] = generador;
                return true;
            }
        }
        return false;
    }
}
