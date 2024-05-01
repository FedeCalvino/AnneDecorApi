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

    public String LargoCadena;
    public boolean CadenaMetalica;
    public int Tubo;
    private byte trueBite = 1;
    private byte falseBite = 0;

    public Roller(String Alto, String largo, Boolean motorizada, int Idtela, String largoCadena, boolean cadenaMetalica, int tubo) {
        super(Alto, largo, motorizada, Idtela);
        LargoCadena = largoCadena;
        CadenaMetalica = cadenaMetalica;
        Tubo = tubo;
    }

    public String getLargoCadena() {
        return LargoCadena;
    }

    public boolean isCadenaMetalica() {
        return CadenaMetalica;
    }
    public Byte isCadenaMetalicaByte() {
        if(CadenaMetalica) return trueBite;
        return falseBite;
    }


    public int getTubo() {
        return Tubo;
    }

    public void setLargoCadena(String LargoCadena) {
        this.LargoCadena = LargoCadena;
    }

    public void setCadenaMetalica(boolean CadenaMetalica) {
        this.CadenaMetalica = CadenaMetalica;
    }

    public void setTubo(int Tubo) {
        this.Tubo = Tubo;
    }
    
    
    
}
