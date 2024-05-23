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
    public String Posicion;
    public String LadoCadena;
    private byte trueBite = 1;
    private byte falseBite = 0;

    public Roller(String Ambiente,String Alto, String Ancho, Boolean motorizada, int Idtela, String largoCadena, boolean cadenaMetalica, int Tubo, String Posicion, String LadoCadena) {
        super(Alto, Ancho, motorizada, Idtela,Ambiente);
        LargoCadena = largoCadena;
        CadenaMetalica = cadenaMetalica;
        this.Tubo = Tubo;
        this.Posicion = Posicion;
        this.LadoCadena = LadoCadena;
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

    public String getPosicion() {
        return Posicion;
    }

    public void setPosicion(String posicion) {
        Posicion = posicion;
    }

    public void setLadoCadena(String ladoCadena) {
        LadoCadena = ladoCadena;
    }

    public String getLadoCadena() {
        return LadoCadena;
    }
}
