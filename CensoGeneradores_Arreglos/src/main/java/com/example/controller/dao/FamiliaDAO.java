/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controller.dao;

/**
 *
 * @author Jhonathan Alexander Ludena Cevallos
 */

import com.example.models.Familia;

public class FamiliaDAO {

    private static final Familia[] familias = new Familia[100];
    private static int contador = 0;

    public Familia crear(Familia familia) {
        if (contador < familias.length) {
            familia.setId(contador + 1);
            familias[contador++] = familia;
            return familia;
        }
        return null;
    }

    public Familia[] obtenerTodos() {
        Familia[] resultado = new Familia[contador];
        System.arraycopy(familias, 0, resultado, 0, contador);
        return resultado;
    }

    public Familia obtenerPorId(int id) {
        for (int i = 0; i < contador; i++) {
            if (familias[i].getId() == id) {
                return familias[i];
            }
        }
        return null;
    }

    public boolean actualizar(Familia familia) {
        for (int i = 0; i < contador; i++) {
            if (familias[i].getId() == familia.getId()) {
                familias[i] = familia;
                return true;
            }
        }
        return false;
    }
}
