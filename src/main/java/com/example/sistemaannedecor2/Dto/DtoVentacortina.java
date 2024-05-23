package com.example.sistemaannedecor2.Dto;

import java.text.DecimalFormat;

public class DtoVentacortina {
    int IdCortina;
    String Ambiente;
    String AnchoAfuerAfuera;
    String AnchoCortina;
    String AnchoCaño;
    String cano;
    String AltoCortina;
    String AltoTela;
    String NombreTela;
    String ColorTela;
    public String Cadena;
    String LadoCadena;
    String EstadoCortina;
    String Cantidad;
    String Posicion;
    String Detalle;
    boolean Motorizada;

    private static byte trueByte = 1;
    private static byte falseByte = 0;

    public void setCadena(String cadena) {
        Cadena = cadena;
    }

    public void setIdCortina(int idCortina) {
        IdCortina = idCortina;
    }

    public int getIdCortina() {
        return IdCortina;
    }

    public void setCano(String cano) {
        this.cano = cano;
    }

    public String getCadena() {
        return this.Cadena;
    }

    public String getCano() {
        return cano;
    }

    public DtoVentacortina(){
    }
    public Byte Motorizada(){
        if(Motorizada) return trueByte;
        else return falseByte;
    }

    public String getLadoCadena() {
        return LadoCadena;
    }

    public void setLadoCadena(String ladoCadena) {
        LadoCadena = ladoCadena;
    }

    public String getAmbiente() {
        return Ambiente;
    }

    public String getAltoCortina() {
        return AltoCortina;
    }

    public String getAnchoCortina() {
        return AnchoCortina;
    }

    public boolean isMotorizada() {
        return Motorizada;
    }

    public String getColorTela() {
        return ColorTela;
    }

    public String getNombreTela() {
        return NombreTela;
    }

    public String getEstadoCortina() {
        return EstadoCortina;
    }

    public void setAmbiente(String ambiente) {
        Ambiente = ambiente;
    }

    public void setAltoCortina(String altoCortina) {
        AltoCortina = altoCortina;
        DecimalFormat df = new DecimalFormat("#.####");
        Double AltoTel = Double.parseDouble(altoCortina) + 0.30;
        Double AltoCadena = Double.parseDouble(altoCortina) * 1.80;
        this.AltoTela = df.format(AltoTel);
        this.Cadena = (df.format(AltoCadena));
    }

    public void setAnchoCortina(String anchoAFAF) {
        AnchoAfuerAfuera = anchoAFAF;
        Double anchoCortina = Double.parseDouble(anchoAFAF)-0.035;
        Double anchoCano = Double.parseDouble(anchoAFAF)+0.030;
        DecimalFormat df = new DecimalFormat("#.####"); // Formato sin ceros adicionales en la parte decimal
        this.AnchoCortina = df.format(anchoCortina);
        this.AnchoCaño = df.format(anchoCano);
    }

    public void setMotorizada(Byte motorizada) {
        if(motorizada == trueByte) Motorizada = true;
        else Motorizada = false;
    }

    public void setPosicion(String posicion) {
        Posicion = posicion;
    }

    public void setColorTela(String colorTela) {
        ColorTela = colorTela;
    }

    public void setNombreTela(String nombreTela) {
        NombreTela = nombreTela;
    }

    public void setEstadoCortina(String estadoCortina) {
        EstadoCortina = estadoCortina;
    }

    public String getAnchoAfuerAfuera() {
        return AnchoAfuerAfuera;
    }

    public String getAnchoCaño() {
        return AnchoCaño;
    }

    public String getAltoTela() {
        return AltoTela;
    }

    public String getCantidad() {
        return Cantidad;
    }

    public String getPosicion() {
        return Posicion;
    }
}
