/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.controller.dao;

/**
 *
 * @author Jhonathan Alexander Ludena Cevallos
 */

import com.example.models.Transaccion;

public class TransaccionDAO {

    private static final Transaccion[] transacciones = new Transaccion[500];
    private static int contador = 0;

    public Transaccion crear(Transaccion transaccion) {
        if (contador < transacciones.length) {
            transaccion.setId(contador + 1);
            transacciones[contador++] = transaccion;
            return transaccion;
        }
        return null;
    }

    public Transaccion[] obtenerTodos() {
        Transaccion[] resultado = new Transaccion[contador];
        System.arraycopy(transacciones, 0, resultado, 0, contador);
        return resultado;
    }

    public Transaccion[] obtenerPorFamiliaId(int familiaId) {
        int count = 0;
        for (int i = 0; i < contador; i++) {
            if (transacciones[i].getFamiliaId() == familiaId) {
                count++;
            }
        }

        Transaccion[] resultado = new Transaccion[count];
        int index = 0;
        for (int i = 0; i < contador; i++) {
            if (transacciones[i].getFamiliaId() == familiaId) {
                resultado[index++] = transacciones[i];
            }
        }
        return resultado;
    }
}
