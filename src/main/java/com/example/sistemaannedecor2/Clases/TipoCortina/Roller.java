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
public class Roller extends Cortina {
    
    public double LargoCadena;
    public boolean CadenaMetalica;
    public int Tubo;
    
    public Roller(double Alto, double largo, Boolean motorizada, TipoTela tela, double largoCadena, boolean cadenaMetalica, int tubo, int precio) {
        super(Alto, largo, motorizada, tela, precio);
        this.CadenaMetalica=cadenaMetalica;
        this.LargoCadena=largoCadena;
        this.Tubo=tubo;
    }

    public double getLargoCadena() {
        return LargoCadena;
    }

    public boolean isCadenaMetalica() {
        return CadenaMetalica;
    }

    public int getTubo() {
        return Tubo;
    }

    public void setLargoCadena(double LargoCadena) {
        this.LargoCadena = LargoCadena;
    }

    public void setCadenaMetalica(boolean CadenaMetalica) {
        this.CadenaMetalica = CadenaMetalica;
    }

    public void setTubo(int Tubo) {
        this.Tubo = Tubo;
    }
    
    
    
}
