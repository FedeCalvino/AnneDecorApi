/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.sistemaannedecor2.Clases.TipoCortina;


import com.example.sistemaannedecor2.Clases.Cortina;
import com.example.sistemaannedecor2.Clases.TipoTela;

/**
 *
 * @author calvi
 */
public class Tradicional extends Cortina {
    
    public int CantidadPaños;


    public Tradicional(String Alto, String largo, Boolean motorizada, int Idtela, int cantidadPaños) {
        super(Alto, largo, motorizada, Idtela);
        CantidadPaños = cantidadPaños;
    }
}
